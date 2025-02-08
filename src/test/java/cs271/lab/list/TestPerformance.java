package cs271.lab.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPerformance {

  // running test and recording running times for SIZE = 10, 100, 1000, 10000, ...

  // Conclusions: Performance of LinkedList vs. ArrayList when comparing their running times for AddRemove vs. Access?
  // (Running times recorded in README.txt!)
  //
  // 1. Add/Remove Performance
  //ArrayList is significantly slower than LinkedList for add/remove.
  //
  // 2️. Access Performance
  //ArrayList is much faster than LinkedList for element access.
  //
  // which of the two lists performs better as the size increases?
  // As the size increases:
  // ArrayList is better for access performance.
  // LinkedList is better for add/remove operations.

  private final int SIZE = 1000;

  // for increasing problem sizes
  private final int REPS = 1000000;

  private List<Integer> arrayList;

  private List<Integer> linkedList;

  @Before
  public void setUp() throws Exception {
    arrayList = new ArrayList<Integer>(SIZE);
    linkedList = new LinkedList<Integer>();
    for (var i = 0; i < SIZE; i++) {
      arrayList.add(i);
      linkedList.add(i);
    }
  }

  @After
  public void tearDown() throws Exception {
    arrayList = null;
    linkedList = null;
  }

  @Test
  public void testLinkedListAddRemove() {
    long startTime = System.nanoTime(); // Start time measurement
    for (var r = 0; r < REPS; r++) {
      linkedList.add(0, 77);
      linkedList.remove(0);
    }
    long endTime = System.nanoTime(); // End time measurement
    System.out.println("LinkedList Add/Remove Time: " + (endTime - startTime) / 1e6 + " ms"); // Print execution time
  }

  @Test
  public void testArrayListAddRemove() {
    long startTime = System.nanoTime(); // Start time measurement
    for (var r = 0; r < REPS; r++) {
      arrayList.add(0, 77);
      arrayList.remove(0);
    }
    long endTime = System.nanoTime(); // CHANGED: End time measurement
    System.out.println("ArrayList Add/Remove Time: " + (endTime - startTime) / 1e6 + " ms"); // Print execution time
  }

  @Test
  public void testLinkedListAccess() {
    var sum = 0L;
    long startTime = System.nanoTime(); // Start time measurement
    for (var r = 0; r < REPS; r++) {
      sum += linkedList.get(r % SIZE);
    }
    long endTime = System.nanoTime(); // End time measurement
    System.out.println("LinkedList Access Time: " + (endTime - startTime) / 1e6 + " ms"); // Print execution time
  }

  @Test
  public void testArrayListAccess() {
    var sum = 0L;
    long startTime = System.nanoTime(); // Start time measurement
    for (var r = 0; r < REPS; r++) {
      sum += arrayList.get(r % SIZE);
    }
    long endTime = System.nanoTime(); // End time measurement
    System.out.println("ArrayList Access Time: " + (endTime - startTime) / 1e6 + " ms"); // Print execution time
  }
}

