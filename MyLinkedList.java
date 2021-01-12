public class MyLinkedList {
  private int size;
  private Node start, end;
  public MyLinkedList() {
    size = 0;
  }
  public int size() {
    return size;
  }
  public boolean add(String value) {
    if (size >= 2) {
      Node n = new Node(value);
      n.setPrev(end);
      end.setNext(n);
      end = n;
      size += 1;
      return true;
    }
    else if (size == 1){
      end = new Node(value);
      end.setPrev(start);
      start.setNext(end);
    }
    else {
      start = new Node(value);
    }
    size += 1;
    return true;
  }
  public boolean add(int index, String value) {
    Node current = start;
    if (index == 0) {
      Node n = new Node(value);
      start.setPrev(n);
      n.setNext(start);
      start = n;
      size += 1;
      return true;
    }
    else if (index == size) {
      Node n = new Node(value);
      n.setPrev(end);
      end.setNext(n);
      end = n;
      size += 1;
      return true;
    }
    Node n = new Node(value);
    for (int i = 0; i < index; i++) {
      current = current.getNext();
      if (current == null) {
        return false;
      }
    }
    n.setPrev(current.getPrev());
    n.setNext(current);
    current.getPrev().setNext(n);
    current.setPrev(n);
    size += 1;
    return true;
  }
  public String get(int index) {
    Node current = start;
    for (int i = 0; i < index; i++) {
      current = current.getNext();
      if (current == null) {
        return "null";
      }
    }
    return current.getData();
  }
  public String set(int index, String value) {
    Node current = start;
    for (int i = 0; i < index; i++) {
      current = current.getNext();
      if (current == null) {
        return "null";
      }

    }
    return current.setData(value);
  }
  public String toString() {
    Node current = start;
    String returnString = "{";
    while (current != null) {
      returnString += current.getData() + ",";
      current = current.getNext();
    }
    return returnString.substring(0, returnString.length() - 1) + "}";
  }
}
