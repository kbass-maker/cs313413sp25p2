# Performance Comparison: LinkedList vs. ArrayList

## Test Setup
- **Tested Operations:** Add/Remove at the beginning, Access (get)
- **List Sizes (SIZE):** 10, 100, 1000, 10000, 1000000
- **Number of Repetitions (REPS):** 100,000

---

## Running Times (in milliseconds)

| **Size**   | **Access (ArrayList)** | **Access (LinkedList)** | **Add/Remove (ArrayList)** | **Add/Remove (LinkedList)** |
|------------|------------------------|-------------------------|----------------------------|-----------------------------|
| **10**     | 10.6413 ms             | 8.6826 ms               | 48.641 ms                  | 20.5405 ms                  |
| **100**    | 11.5661 ms             | 23.3278 ms              | 48.4588 ms                 | 19.4363 ms                  |
| **1000**   | 11.2634 ms             | 249.5518 ms             | 116.6927 ms                | 19.8763 ms                  |
| **10000**  | 7.3234 ms              | 2802.8375 ms            | 487.8209 ms                | 22.0844 ms                  |
| **100000**  | 7.2979 ms              | 40937.38 ms             | 9411.4571 ms               | 16.1684 ms                  |

---

## Observations & Conclusions

###  **Add/Remove Performance**
 `LinkedList` continues to be **faster** than `ArrayList` for **inserting/removing elements** at the **beginning**, with
  the times remaining relatively stable for `LinkedList` (16.17 ms → 22.08 ms) compared to `ArrayList` (48.64 ms → 116.69 ms → 487.82 ms → 9411.46 ms ).
  As the list grows, `ArrayList`'s **performance degrades** significantly, due to shifting elements when adding/removing,
  making it slower than `LinkedList` as the list size increases.

###  **Access Performance**
  **`ArrayList`** still outperforms `LinkedList` for element access, with times stable and relatively low
  (7.32 ms for SIZE = 10,000 vs. 11.26 ms for 1000, 10.64 ms for 10).
  **`LinkedList`** suffers from **extremely slow access times** as the list size grows (2802.84 ms for SIZE = 10,000 vs. 249.55 ms for 1000, 23.33 ms for 100).
  This is because each access requires traversing the list from the start, resulting in high latency as the list grows.


---


