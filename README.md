# Comparison of throughput of different java stuff

> Bare numbers do not matter. The important thing is comparison between them.

### Java collections

Collection of Integer type is used for the tests. Troove collections support using primitives, so int primitive is used for them.

| Collection | Add | Remove | Get | Insert in the beginning | Insert in the middle | 
| - | - | - | - | - | - |
| ArrayList | 41.953 | 3927.111 | 1305.534 | 5.064 | 10.477 |
| LinkedList | 35.973 | 4360.926 | 0.483 | 1305.162 | 0.941 |
| TIntArrayList | 98.480 | 3899.559 | 1182.798 | 5.217 | 10.725 |
| TIntLinkedList | 72.861 | 4490.124 | 0.527 | 2687.024 | 1.286 |
| HashSet | 12.113 | 2455.101 | 750.583 |  |  |
| LinkedHashSet | 9.319 | 2468.913 | 938.768 |  |  |
| TreeSet | 2.537 | 3267.110 | 514.536 |  |  |
| TIntHashSet | 8.895 | 997.116 | 1435.792 |  |  |

#### Maps
