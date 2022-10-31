import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda {
  List<String> words =
      Arrays.asList("straw man", "Straw hat", "last straw", "drinking straw", "Straw", "strah brah");

  public List<String> lambdaFilter(String filterString) {
    // write any supporting code you need here
    return words.stream()
        .filter(s -> s.substring(0, filterString.length()).equalsIgnoreCase(filterString))
        .collect(Collectors.toList());
  }

  public static void main(String [] args) {
    Lambda lambda = new Lambda();
    List<String> strawsLuv = lambda.lambdaFilter("Straw");
    System.out.println(strawsLuv);
  }
}
