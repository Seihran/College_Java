public class Buffer
{
  private String contents;
  private boolean available = false;

  public synchronized String get() {
    while (available == false) {
      try {
        // wait for Producer to put value
        wait();
      } catch (InterruptedException e) {
      }
    }
    available = false;
    // notify Producer that value has been retrieved
    notifyAll();
    return contents;
  }

  public synchronized void put(String text) {
    while (available == true) {
      try {
        // wait for Consumer to get value
        wait();
      } catch (InterruptedException e) {
      }
    }
    contents = text;
    available = true;
    // notify Consumer that value has been set
    notifyAll();
  }
}
