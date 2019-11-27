package Day_46;

public class Solution {
    public static void main(String[] args) {
        System.out.println(lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        System.out.println(lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
        System.out.println(lengthLongestPath("dir\n    file.txt"));
    }


    public static int lengthLongestPath(String input) {
        Dir root = null;
        Dir currentNode = null;
        Dir prevNode = null;

        Integer maxLength = 0;

        StringBuilder currentName = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            Character currentCharacter = input.charAt(i);
            while (currentCharacter != '\n') {
                currentName.append(currentCharacter);
                i++;
                if (i < input.length()) {
                    currentCharacter = input.charAt(i);
                } else {
                    break;
                }

            }


            if (root == null) {
                root = new Dir(currentName.toString());
                prevNode = root;
                if (root.isFile) {
                    maxLength = Integer.max(maxLength, root.calculateDistance());
                }
                currentName = new StringBuilder();
                continue;
            }


            currentNode = new Dir(currentName.toString());
            Dir node = prevNode;
            while (node != null && node.levelOfTabulation != currentNode.levelOfTabulation - 1) {
                node = node.parent;
            }

            if (node != null) {
                currentNode.parent = node;
            } else {
                currentNode.parent = prevNode;
            }

            if (currentNode.isFile) {
                maxLength = Integer.max(maxLength, currentNode.calculateDistance());
            }
            prevNode = currentNode;
            currentName = new StringBuilder();
        }
        return maxLength;
    }

    public static int calculateLevels(StringBuilder currentName) {
        int i = 0;
        Character ch = currentName.charAt(i);
        while (ch == '\t') {
            i++;
            ch = currentName.charAt(i);
        }

        boolean flag = false;

        while (ch == ' ') {
            flag = true;
            i++;
            ch = currentName.charAt(i);
        }

        if (flag) {
            return i / 4;
        }

        return i;

    }
}

class Dir {
    String name;
    int levelOfTabulation;
    boolean isFile;
    Dir parent;

    public Dir(String name) {
        this.levelOfTabulation = this.calculateLevels(name);
        this.isFile = name.contains(".");
    }

    public int calculateDistance() {
        Dir currentDir = parent;
        int distance = name.length();

        int i = 0;

        while (currentDir != null) {
            distance += currentDir.name.length();
            currentDir = currentDir.parent;
            i++;
        }

        return distance + i;
    }

    public int calculateLevels(String currentName) {
        int i = 0;
        char ch = currentName.charAt(i);
        while (ch == '\t') {
            i++;
            ch = currentName.charAt(i);
        }

        boolean flag = false;

        while (ch == ' ') {
            flag = true;
            i++;
            ch = currentName.charAt(i);
        }

        if (flag) {
            this.name = currentName.substring(i);
            return i / 4;
        }

        this.name = currentName.substring(i);
        return i;
    }
}
