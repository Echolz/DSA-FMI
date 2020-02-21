package Day_71;

import java.util.*;

class Solution {

  public static void main(String[] args) {
    String[] arr = {"s1", "h1", "h2"};

    String[] sol = solution(arr, 705);

    for (String s : sol) {
      System.out.println(s);
    }
  }

  public static String[] solution(String[] availableProgrammes, long carbonToOffset) {
    if (availableProgrammes.length == 0) {
      return new String[0];
    }

    Map<String, Double> map = new HashMap<>();

    for (String availableProgramme : availableProgrammes) {
      map.put(availableProgramme, calculateProgramme(availableProgramme, carbonToOffset));
    }


    List<String> list = new ArrayList<>();
    Set<Character> usedProgrammes = new HashSet<>();

    for (int i = 0; i < 2; i++) {
      if (map.keySet().size() == 0) {
        break;
      }


      String minProgramme = findMinProgramme(map);
      map.remove(minProgramme);
      Character programmeClass = minProgramme.charAt(0);

      if (usedProgrammes.contains(programmeClass)) {
        continue;
      }

      usedProgrammes.add(programmeClass);
      list.add(minProgramme);
    }

    return list.toArray(String[]::new);
  }

  private static String findMinProgramme(Map<String, Double> map) {
    String minProgramme = "";
    Double min = Double.MAX_VALUE;

    for (String s : map.keySet()) {
      if (map.get(s) < min) {
        minProgramme = s;
        min = map.get(s);
      }
    }

    return minProgramme;
  }

  private static double calculateProgramme(String availableProgramme, long carbonToOffset) {
    switch (availableProgramme) {
      case "s1":
        return calculateS1(carbonToOffset);
      case "s2":
        return calculateS2(carbonToOffset);
      case "b1":
        return calculateB1(carbonToOffset);
      case "h1":
        return calculateH1(carbonToOffset);
      case "h2":
        return calculateH2(carbonToOffset);
    }
    return -1;
  }

  public static double calculateS1(long carbonToOffset) {
    if (carbonToOffset < 500) {
      return carbonToOffset * 1.25;
    }

    return carbonToOffset;
  }

  public static double calculateS2(long carbonToOffset) {
    double answer = 0;

    if (carbonToOffset <= 300) {
      return carbonToOffset * 1.5;
    }

    answer = 300 * 1.5;

    carbonToOffset -= 300;

    answer += carbonToOffset * 0.5;

    return answer;
  }

  public static double calculateB1(long carbonToOffset) {
    return 0.8 * carbonToOffset;
  }

  public static double calculateH1(long carbonToOffset) {
    return 100 + 0.5 * carbonToOffset;
  }

  public static double calculateH2(long carbonToOffset) {
    long bundlesToBuy = carbonToOffset / 10;

    if (carbonToOffset % 10 == 0) {
      return bundlesToBuy * 9.9;
    }

    bundlesToBuy++;
    return bundlesToBuy * 9.9;
  }
}



