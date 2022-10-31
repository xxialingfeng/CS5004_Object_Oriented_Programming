package comparators;

import java.util.Comparator;

public class MonsterComparator implements Comparator<Monster> {

  @Override
  public int compare(Monster o1, Monster o2) {
    return o1.getName().compareToIgnoreCase(o2.getName());
  }
}
