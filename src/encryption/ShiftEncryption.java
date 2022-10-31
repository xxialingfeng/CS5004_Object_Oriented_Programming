package encryption;

public class ShiftEncryption extends AbstractEncryption {
  private final int UpperBound = 10;
  private final int LowerBound = -10;

  public ShiftEncryption(String msg) {
    super(msg);
  }

  @Override
  public String encode(int encoding) {
    this.encodeMsg = cipher(msg, encoding);
    return this.encodeMsg;
  }

  public String cipher(String msg, int shift) throws IllegalArgumentException {
    StringBuilder resultStr = new StringBuilder();
    if (shift > UpperBound || shift < LowerBound) {
      throw new IllegalArgumentException();
    }
    for (char ch: msg.toCharArray()) {
      if (ch < 58 && ch > 48) {
        int withRotetionFactor = ch + shift;
        if (withRotetionFactor < 57) {
          resultStr.append((char) withRotetionFactor);
        } else {
          int looprotation =  withRotetionFactor - 10;
          resultStr.append((char) looprotation);
        }
      } else if (ch < 91 && ch > 63) {
        int withRotetionFactor = ch + shift;
        if (withRotetionFactor < 91) {
          resultStr.append((char) withRotetionFactor);
        } else {
          int looprotation =  withRotetionFactor - 26;
          resultStr.append((char) looprotation);
        }
      } else if (ch < 123 && ch > 96) {
        int withRotetionFactor = ch + shift;
        if (withRotetionFactor < 123) {
          resultStr.append((char) withRotetionFactor);
        } else {
          int looprotation =  withRotetionFactor - 26;
          resultStr.append((char) looprotation);
        }
      } else {
        resultStr.append(ch);
      }
    }
    return resultStr.toString();
  }

}
