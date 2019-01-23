package EX_7_2;

import java.util.*;

class Solution {
    static Map<Integer, List<Path>> graph = new HashMap<>();
    static Set<Integer> memorization = new HashSet<>();
    static Integer k = -1;
    static Map<Integer, Integer> answers = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer v = scanner.nextInt();
        Integer e = scanner.nextInt();

        for (int i = 0; i < e; i++) {
            Integer from = scanner.nextInt();
            Integer to = scanner.nextInt();
            Integer w = scanner.nextInt();

            addToGraph(from, to, w);
        }
        k = scanner.nextInt();

        for (Integer sN : graph.keySet()) {
            if (memorization.contains(sN)) {
                continue;
            }

            dfs(sN, new HashSet<>(), 0, 0);
        }
//        System.out.println(answers);

        int answer = findAnswer();

        System.out.println(answer);
    }

    private static int findAnswer() {
        int maxPath = -1;
        int maxRep = -1;

        for (Integer currPath : answers.keySet()) {
            if (maxPath == -1 && maxRep == -1) {
                maxPath = currPath;
                maxRep = answers.get(currPath);
                continue;
            }

            int currRep = answers.get(currPath);

            if (currRep > maxRep) {
                maxRep = currRep;
                maxPath = currPath;
                continue;
            }

            if (maxRep == currRep) {
                if (maxPath > currPath) {
                    continue;
                }

                maxPath = currPath;
            }
        }

        return maxPath;
    }

    static void dfs(Integer cN, Set<Integer> visited, Integer distance, Integer weight) {
        visited.add(cN);

//        System.out.println("to: " + cN + " steps: " + distance + " cost: " + weight);


        if (distance.equals(k)) {
            addToAnswers(weight);
            memorization.add(cN);
            distance = 0;
            weight = 0;
        }

        List<Path> neighbours = graph.get(cN);

        if (neighbours == null) {
            return;
        }

        for (Path n : neighbours) {
            if (visited.contains(n.to)) {
                continue;
            }

            dfs(n.to, visited, distance + 1, weight + n.weight);

            visited.remove(n.to);
        }
    }

    private static void addToAnswers(Integer weight) {
        if (!answers.containsKey(weight)) {
            answers.put(weight, 0);
        }

        answers.put(weight, answers.get(weight) + 1);
    }

    static void addToGraph(Integer from, Integer to, Integer weight) {
        if (!graph.containsKey(from)) {
            graph.put(from, new ArrayList<>());
        }

        graph.get(from).add(new Path(to, weight));
    }
}

class Path {
    Integer to;
    Integer weight;

    public Path(Integer to, Integer weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Path path = (Path) o;
        return Objects.equals(to, path.to) &&
                Objects.equals(weight, path.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(to, weight);
    }
}