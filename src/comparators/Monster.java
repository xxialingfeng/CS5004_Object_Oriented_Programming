package comparators;

public class Monster {
  private String name;
  private int hitPoints;
  private int id;

  public Monster(String name, int hitPoints, int id) {
    this.name = name;
    this.id = id;
    this.hitPoints = hitPoints;
  }

  public String getName() {
    return this.name;
  }

  public int getHitPoints() {
    return this.hitPoints;
  }

  public int getId() {
    return this.id;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (other.getClass() != this.getClass()) return false;
    return this.name.equalsIgnoreCase(((Monster) other).name)
        && (this.id == ((Monster) other).id);
  }
}
