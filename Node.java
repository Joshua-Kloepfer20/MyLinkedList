public class Node {
  public Node(String value) {
    data = value;
  }
  private String data;
  private Node next, prev;
  public String getData() {
    return data;
  }
  public Node getNext() {
    return next;
  }
  public Node getPrev() {
    return prev;
  }
  public String setData(String d) {
    data = d;
    return data;
  }
  public Node setNext(Node n) {
    next = n;
    return next;
  }
  public Node setPrev(Node p) {
    prev = p;
    return prev;
  }
}
