package comparators;

import java.util.Comparator;

public class MonsterHPComparator implements Comparator<Monster> {

  @Override
  public int compare(Monster o1, Monster o2) {
    return o1.getHitPoints() - o2.getHitPoints();
  }
}
