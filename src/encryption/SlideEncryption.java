package encryption;

public class SlideEncryption extends AbstractEncryption {

  public SlideEncryption(String msg) {
    super(msg);
  }

  @Override
  public String encode(int encoding) {
    int n = msg.length();
    StringBuilder sb = new StringBuilder();
    while (encoding < 0) {
      encoding += n;
    }
    int startIndex = encoding % n;
    for (int i = n - startIndex; i < n; i++) {
      sb.append(msg.charAt(i));
    }
    for (int i = 0; i < n - startIndex; i++) {
      sb.append(msg.charAt(i));
    }
    this.encodeMsg = sb.toString();
    return this.encodeMsg;
  }
}
