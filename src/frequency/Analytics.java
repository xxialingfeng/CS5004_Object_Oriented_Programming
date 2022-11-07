package frequency;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This is a class that implements a method called wordFrequency.
 */
public class Analytics {

  /**
   * returns a frequency count of the words in the message.
   * @param message String format
   * @return frequency count
   */
  public static Map<String, Double> wordFrequency(String message) {
    if (message == null || message.length() == 0) {
      return null;
    }
    message = message.replaceAll("[\\pP\\p{Punct}]", " ");
    message = message.replaceAll("\\s+", " ");
    String[] word = message.split(" ");
    List<String> mapList = Arrays.stream(word).map(String::toUpperCase)
        .collect(Collectors.toList());
    Map<String, Double> map = new HashMap<>();
    for (String str : mapList) {
      int frequency = Collections.frequency(mapList, str);
      if (!map.containsKey(str)) {
        map.put(str, ((double) frequency / word.length));
      }
    }
    return map;
  }
}
