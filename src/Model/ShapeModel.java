package Model;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Shape.Color;
import Shape.IShape;
import Shape.Oval;
import Shape.Position;
import Shape.Rectangle;

/**
 * This is a ShapeModel class.
 */
public class ShapeModel implements IShapeModel {
  private List<IShape> shapeList;
  private Map<String, String> desMap;
  private Map<String, List<IShape>> shapeMap;
  private static final SimpleDateFormat timeStampFormat
      = new SimpleDateFormat("dd-MM-yyyy");

  /**
   * This is a constructor for shape model.
   */
  public ShapeModel() {
    shapeMap = new HashMap<>();
    desMap = new HashMap<>();
    shapeList = new ArrayList<>();
  }


  /**
   * SnapShot the current timestamp and save the description and shape list to the album.
   * @param Description description of the snapshot.
   */
  @Override
  public void SnapShot(String Description) {
    Instant now = Instant.now();
    Date date = new Date();
    // key is timestamp, value is list of shape.
    shapeMap.put(now.toString(), new ArrayList<>(shapeList));

    String SnapInfo = "\nSnapShot ID: " + now
        + "\n" + "TimeStamp: " + timeStampFormat.format(date)
        + "\n" + "Description: " + Description + "\n"
        + "Shape Information:";
    // key is timestamp, value is Information
    desMap.put(now.toString(), SnapInfo);
  }

  /**
   * Print list of all shape.
   * @return string format
   */
  @Override
  public String printShapeList() {
    StringBuilder shapeListInfo = new StringBuilder();
    for (IShape shape : shapeList) {
      shapeListInfo.append(shape.toString()).append("\n");
    }
    return shapeListInfo.toString();
  }

  /**
   * Print Shape List of all snapshots.
   * @return String of concatenating shape information.
   */
  @Override
  public String printSnapShapeList() {
    StringBuilder ShapeListInfo = new StringBuilder();
    for (String time: desMap.keySet()) {
      ShapeListInfo.append(desMap.get(time)).append("\n");
      List<IShape> shapes = shapeMap.get(time);
      for (IShape shape: shapes) {
        ShapeListInfo.append(shape.toString()).append("\n\n");
      }
    }
    return ShapeListInfo.toString();
  }

  /**
   * all Print SnapShot timestamps.
   * @return list of all snapshots.
   */
  @Override
  public String printSnapShotList() {
    return "List of SnapShot taken before reset: \n" + desMap.keySet();
  }

  /**
   * Create new IShape object and add it to the shape list.
   *
   * @param name Shape name
   * @param type Shape type
   * @param size1 shape width/x-radius
   * @param size2 shape height/y-radius
   * @param XPosition shape position for x-coordinate
   * @param YPosition shape position for y-coordinate
   * @param ColorR shape Color R value
   * @param ColorG shape Color G value
   * @param ColorB shape Color B value
   * @throws IllegalArgumentException " "
   */
  @Override
  public void CreateShape(String name, String type, double size1, double size2, double XPosition,
      double YPosition, double ColorR, double ColorG, double ColorB)
      throws IllegalArgumentException {
    if (name == null || type == null) {
      throw new IllegalArgumentException("Add Shape null");
    }

    if (!type.equalsIgnoreCase("oval")
        && !type.equalsIgnoreCase("rectangle")) {
      throw new IllegalArgumentException("Type nonexistent");
    }

    for (IShape each: shapeList) {
      if (each.getName().equals(name)) {
        return;
      }
    }

    Color ShapeColor = new Color(ColorR, ColorG, ColorB);
    Position ShapePos = new Position(XPosition, YPosition);
    IShape shape = null;
    if (type.equalsIgnoreCase("rectangle")) {
      shape = new Rectangle(name, ShapeColor, ShapePos, size1, size2);
    }
    else if (type.equalsIgnoreCase("oval")) {
      shape = new Oval(name, ShapeColor, ShapePos, size1, size2);
    }
    shapeList.add(shape);
  }

  /**
   * Remove existing Shape object.
   * @param name String name
   */
  @Override
  public void removeShape(String name) {
    if (name == null) {
      throw new IllegalArgumentException("Remove shape is null");
    }
    for (IShape each: shapeList) {
      if (name.equals(each.getName())) {
        shapeList.remove(each);
        return;
      }
    }
  }

  @Override
  public void ChangeColor(String name, double newR, double newG, double newB) {
    if (name == null) {
      throw new IllegalArgumentException("Change Shape is null");
    }
    for (IShape each: shapeList) {
      if (name.equals(each.getName())) {
        Color newColor = new Color(newR, newG, newB);
        each = each.changeColor(newColor);
        return;
      }
    }
  }

  @Override
  public void ChangePos(String name, double newX, double newY) {
    if (name == null) {
      throw new IllegalArgumentException("Change shape is null");
    }
    for (IShape each: shapeList) {
      if (name.equals(each.getName())) {
        Position newPos = new Position(newX, newY);
        each = each.move(newPos);
        return;
      }
    }
  }

  @Override
  public void Resize(String name, double newSize1, double newSize2) {
    if (name == null) {
      throw new IllegalArgumentException("Change shape is null");
    }
    for (IShape each: shapeList) {
      if (name.equals(each.getName())) {
        each = each.changeSize(newSize1, newSize2);
        return;
      }
    }
  }

  @Override
  public void reset() {
    shapeList.clear();
    desMap.clear();
    shapeMap.clear();
  }

  @Override
  public boolean checkRepeatName(String s) {
    for (IShape shape: shapeList) {
      if (s.equals(shape.getName())) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    return "This is your Photo Album. \n"
        + "Enter a move: (Remove/Add/Move/Resize/Color/SnapShot/Reset/Print/Quit)";
  }
}
