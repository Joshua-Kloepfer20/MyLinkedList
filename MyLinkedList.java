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
      end = start;
    }
    size += 1;
    return true;
  }
  public boolean add(int index, String value) {
    Node current = start;
    if (size == 0) {
      return add(value);
    }
    else if (index == 0) {
      Node n = new Node(value);
      start.setPrev(n);
      n.setNext(start);
      start = n;
      size += 1;
      return true;
    }
    else if (index == size) {
      return add(value);
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
        throw new IndexOutOfBoundsException();
      }
    }
    return current.getData();
  }
  public String set(int index, String value) {
    Node current = start;
    for (int i = 0; i < index; i++) {
      current = current.getNext();
      if (current == null) {
        throw new IndexOutOfBoundsException();
      }

    }
    String x = current.getData();
    current.setData(value);
    return x;
  }
  public String toString() {
    if (size == 0) {
      return "[]";
    }
    Node current = start;
    String returnString = "[";
    while (current != null) {
      returnString += current.getData() + ", ";
      current = current.getNext();
    }
    return returnString.substring(0, returnString.length() - 2) + "]";
  }
  public String toStringReversed() {
    if (size == 0) {
      return "[]";
    }
    Node current = end;
    String returnString = "[";
    while (current != null) {
      returnString += current.getData() + ", ";
      current = current.getPrev();
    }
    return returnString.substring(0, returnString.length() - 2) + "]";
  }
  public String remove(int index) {
    String prev = get(index);
    if (size == 1) {
      start = null;
      size -= 1;
    }
    else if (index == size - 1) {
      end = end.getPrev();
      end.setNext(null);
      size -= 1;
    }
    else if (index == 0) {
      start = start.getNext();
      start.setPrev(null);
    }
    else {
      Node current = start;
      for (int i = 0; i < index; i++) {
        current = current.getNext();
        if (current == null) {
          throw new IndexOutOfBoundsException();
        }
      }
      current.getPrev().setNext(current.getNext());
      current.getNext().setPrev(current.getPrev());
      size -= 1;
    }
    return prev;
  }
  public void extend(MyLinkedList other) {
    end.setNext(other.start);
    other.start.setPrev(end);
    end = other.end;
    other.start = null;
    other.end = null;
    size = other.size + size;
    other.size = 0;
  }
}
