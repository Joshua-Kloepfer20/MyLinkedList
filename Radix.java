public class Radix {
  public static int nth(int n, int col) {
    return Math.abs((n % (int)Math.pow(10, col + 1) - n % (int)Math.pow(10, col)) / (int)Math.pow(10, col));
  }
  public static int length(int n) {
    if (n != 0) {
      return (int)(Math.log10(Math.abs(n)) + 1);
    }
    return 1;
  }
  public static void merge(SortableLinkedList original,SortableLinkedList[]buckets) {
    for (int i = original.size() - 1; i >= 0; i--) {
      original.remove(i);
    }
    for (int i = 0; i < buckets.length; i++) {
      original.extend(buckets[i]);
    }
  }
  public static void radixSortSimple(SortableLinkedList data) {
      SortableLinkedList[] bucket = new SortableLinkedList[10];
      int y = data.get(0);
      for (int i = 0; i < data.size(); i++) {
        if (data.get(i) > y) {
          y = data.get(i);
        }
      }
      for (int i = 0; i < 10; i++) {
        bucket[i] = new SortableLinkedList();
      }
    for (int j = 0; j < length(y); j++) {
        for (int i = 0; i < data.size(); i++) {
          int x = nth(data.get(i), j);
          bucket[x].add(data.get(i));
        }
        merge(data, bucket);
      }
  }
  public static void radixSort(SortableLinkedList data) {
    SortableLinkedList positive = new SortableLinkedList();
    SortableLinkedList negative = new SortableLinkedList();
    for (int i = 0; i < data.size(); i++) {
      if (data.get(i) >= 0) {
        positive.add(data.get(i));
      }
      else {
        negative.add(Math.abs(data.get(i)));
      }
    }
    radixSortSimple(positive);
    radixSortSimple(negative);
    for (int i = data.size() - 1; i >= 0; i--) {
      data.remove(i);
    }
    for (int i = negative.size() - 1; i >= 0; i--) {
      data.add(-1 * negative.get(i));
    }
    data.extend(positive);
  }
}
