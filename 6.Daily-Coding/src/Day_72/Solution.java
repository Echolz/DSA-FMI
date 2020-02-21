package Day_72;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

  public static void main(String[] args) {

  }

  public static double solution(String[] aircraftEmissions, String[] flightItineraries, String origin, String destination) {
    Map<String, Double> map = new HashMap<>();

    Arrays.stream(aircraftEmissions).forEach(s -> {
      String[] str = s.split("-");
      map.put(str[0], Double.parseDouble(str[1]));
    });

    boolean flightFound = false;
    Double min = Double.MAX_VALUE;

    for (String s : flightItineraries) {
      String[] str = s.split("-");

      boolean flag = false;

      for (String s1 : str) {
        if (s1.equals("")) {
          flag = true;
        }
      }

      if (flag) {
        continue;
      }

      if (str[0].compareTo(origin) == 0 && str[1].compareTo(destination) == 0) {
        flightFound = true;


        if (!map.containsKey(str[3])) {
          continue;
        }

        Double currentEmissions = map.get(str[3]) * Double.parseDouble(str[2]);
        if (currentEmissions < min) {
          min = currentEmissions;
        }

      }
    }

    if (flightFound) {
      return Double.parseDouble(String.format("%.2f", min));
    }
    return 0;
  }

}
