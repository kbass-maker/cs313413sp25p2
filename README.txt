COMP 313/413 Project 2 Report

TestList.java and TestIterator.java

	Question: try with a LinkedList - does it make any difference?

	    Response: There's no functional difference using LinkedList.

TestList.java

	testRemoveObject()

		list.remove(5); // what does this method do?

			This removes the last 77 from the list (the value at index 5).

		list.remove(Integer.valueOf(5)); // what does this one do?

			This removes 66 from the list (the value at index 5).

TestIterator.java

	testRemove()

		i.remove(); // what happens if you use list.remove(77)?

			Without the while loop: list.remove(Integer.valueOf(77)) will remove only
            the first occurrence of 77 from the list.
             but if list.remove(Integer.valueOf(77)) is used inside the loop instead of i.remove(),
             it will cause a ConcurrentModificationException.


# Performance Comparison: LinkedList vs. ArrayList

TestPerformance.java

SIZE 10
----------------------------------------------------------------------------------------
| Test                      | #1      | #2      | #3      | #4      | #5      | #6      |
-----------------------------------------------------------------------------------------
| testArrayListAddRemove    | 51.08ms | 63.25ms | 52.06ms | 51.03ms | 49.05ms | 53.23ms |
| testLinkedListAddRemove   | 22.97ms | 28.44ms | 29.90ms | 27.02ms | 25.86ms | 22.61ms |

| testArrayListAccess       | 10.63ms | 9.70ms  | 10.78ms | 16.58ms | 9.90ms  | 8.70ms  |
| testLinkedListAccess      | 12.63ms | 14.87ms | 13.84ms | 12.92ms | 11.93ms | 11.66ms |
-----------------------------------------------------------------------------------------

SIZE 100
----------------------------------------------------------------------------------------
| Test                      | #1      | #2      | #3      | #4      | #5      | #6      |
-----------------------------------------------------------------------------------------
| testArrayListAddRemove    | 67.26ms | 58.59ms | 60.20ms | 61.06ms | 51.30ms | 58.18ms |
| testLinkedListAddRemove   | 21.59ms | 23.04ms | 21.36ms | 20.36ms | 22.67ms | 21.93ms |

| testArrayListAccess       | 11.08ms | 11.53ms | 12.31ms | 11.11ms | 12.86ms | 11.54ms |
| testLinkedListAccess      | 18.13ms | 18.08ms | 17.42ms | 18.20ms | 19.60ms | 17.28ms |
-----------------------------------------------------------------------------------------

SIZE 1000
---------------------------------------------------------------------------------------------
| Test                      | #1       | #2      | #3       | #4       | #5       | #6       |
----------------------------------------------------------------------------------------------
| testArrayListAddRemove    | 179.06ms | 142.50ms| 168.34ms | 152.98ms | 172.08ms | 129.83ms |
| testLinkedListAddRemove   | 33.17ms  | 26.23ms | 21.60ms  | 21.87ms  | 24.36ms  | 21.16ms  |

| testArrayListAccess       | 17.99ms  | 14.05ms | 10.36ms  | 12.74ms  | 11.80ms  | 10.51ms  |
| testLinkedListAccess      | 297.01ms | 321.51ms| 345.96ms | 317.76ms | 316.28ms | 309.85ms |
----------------------------------------------------------------------------------------------

SIZE 10000
----------------------------------------------------------------------------------------------------
| Test                      | #1        | #2        | #3        | #4        | #5        | #6        |
-----------------------------------------------------------------------------------------------------
| testArrayListAddRemove    | 672.47ms  | 499.74ms  | 577.58ms  | 575.16ms  | 552.83ms  | 1028.03ms |
| testLinkedListAddRemove   | 25.34ms   | 22.24ms   | 21.76ms   | 20.22ms   | 27.79ms   | 40.35ms   |

| testArrayListAccess       | 11.56ms   | 9.86ms    | 8.75ms    | 8.10ms    | 10.64ms   | 16.60ms   |
| testLinkedListAccess      | 3337.51ms | 3159.39ms | 3249.27ms | 3546.46ms | 3130.96ms | 4453.92ms |
-----------------------------------------------------------------------------------------------------



	listAccess - which type of List is better to use, and why?

		ArrayLists is better to use for listAccess, because it outperforms LinkedList for element access,
		with times relatively low.
        LinkedList has extremely slow access times as the list size grows.
        This is because each access requires traversing the list from the start, resulting in high latency
        as the list grows.


	listAddRemove - which type of List is better to use, and why?

		LinkedList is better to use for listAddRemove, because it continues to be faster than ArrayList.
         The times remain relatively stable for LinkedList compared to ArrayList.
         As the list grows, ArrayList's performance degrades significantly, due to shifting elements when
         adding/removing,
         making it slower than LinkedList as the list size increases.



 - Conclusions: Performance of LinkedList vs. ArrayList when comparing their running times for AddRemove vs. Access?

  1. Add/Remove Performance
  ArrayList is significantly slower than LinkedList for add/remove.

  2️. Access Performance
  ArrayList is much faster than LinkedList for element access.

  # which of the two lists performs better as the size increases?
  As the size increases:
  ArrayList is better for access performance.
  LinkedList is better for add/remove operations.


  *****
  The running times were recorded using System.nanoTime().

  The total execution time is calculated as (endTime - startTime) / 1e6,
  converting the result from nanoseconds to milliseconds for easier interpretation.
  ******