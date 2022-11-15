package Shape;

public class Oval extends AbstractShape {
  private double XRadius;
  private double YRadius;

  public Oval(String name, Color color, Position pos, double XRadius, double YRadius)
      throws IllegalArgumentException {
    super(name, color, pos);
    this.XRadius = XRadius;
    this.YRadius = YRadius;
  }

  public double getXRadius() {
    return XRadius;
  }

  public double getYRadius() {
    return YRadius;
  }

  @Override
  public IShape move(Position newPos) {
    return new Oval(name, color, newPos, this.XRadius, this.YRadius);
  }

  @Override
  public IShape changeColor(Color newColor) {
    return new Oval(name, newColor, pos, this.XRadius, this.YRadius);
  }

  @Override
  public IShape changeSize(double size1, double size2) {
    return new Oval(name, color, pos, size1, size2);
  }


  /**
   * ToString method.
   * @return Oval Information method.
   */
  @Override
  public String toString() {
    return "Name: " + this.name + "\n"
        + "Type: oval" + "\n"
        + "Center: " + this.getPosition().toString()
        + ", " + "X radius: " + String.format("%.1f", this.getXRadius())
        + ", " + "Y radius: " + String.format("%.1f", this.getYRadius())
        + ", " + "Color: " + this.color.toString();
  }
}
