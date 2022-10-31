package encryption;

public abstract class AbstractEncryption implements IEncryption {
  protected String msg;
  protected String encodeMsg;

  public AbstractEncryption(String msg) {
    this.msg = msg;
    this.encodeMsg = "";
  }

  @Override
  public String encode(int encoding) {
    return "";
  }

  @Override
  public String toString() {
    return this.encodeMsg + "\n" + this.msg;
  }
}
