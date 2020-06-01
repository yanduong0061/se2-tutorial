package tut07;

import java.util.Arrays;

public class BagTest {
public static void main(String[] args) {
ArrayBag<Integer> firstBag = new ArrayBag<>();
firstBag.add(10);
firstBag.add(4);
firstBag.add(12);
firstBag.add(3);
firstBag.add(4);
firstBag.add(5);
firstBag.add(25);
System.out.println("Before: " + Arrays.toString(firstBag.toArray()));
System.out.println(firstBag.isEmpty());
System.out.println(firstBag.isArrayFull());
System.out.println(firstBag.getCurrentSize());
System.out.println(firstBag.getFrequencyOf(0));
System.out.println(firstBag.getFrequencyOf(4));
System.out.println(firstBag.contains(10));
firstBag.clear();
System.out.println(firstBag.remove());
System.out.println("After: " + Arrays.toString(firstBag.toArray()));
System.out.println(firstBag.remove(12));
System.out.println("After: " + Arrays.toString(firstBag.toArray()));
System.out.println(firstBag.getIndexOf(3));
System.out.println(firstBag.removeEntry(0));
System.out.println("After: " + Arrays.toString(firstBag.toArray()));

System.out.println("-------------------------");

ArrayBag<String> secondBag = new ArrayBag<>(10);
secondBag.add("a");
secondBag.add("b");
secondBag.add("c");
secondBag.add("d");
secondBag.add("e");
secondBag.add("f");
secondBag.add("d");
System.out.println("Before: " + Arrays.toString(secondBag.toArray()));
System.out.println(secondBag.isEmpty());
System.out.println(secondBag.isArrayFull());
System.out.println(secondBag.getCurrentSize());
System.out.println(secondBag.getFrequencyOf("d"));
System.out.println(secondBag.getFrequencyOf("n"));
System.out.println(secondBag.contains("a"));
secondBag.clear();
System.out.println(secondBag.remove());
System.out.println("After: " + Arrays.toString(secondBag.toArray()));
System.out.println(secondBag.remove("f"));
System.out.println("After: " + Arrays.toString(secondBag.toArray()));
System.out.println(secondBag.getIndexOf("c"));
System.out.println(secondBag.removeEntry(0));
System.out.println("After: " + Arrays.toString(secondBag.toArray()));
}

}
