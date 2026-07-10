# 📚 ARRAYS — Complete Notes (Zero to Placement Ready)
> **From Absolute Basics to Advanced Level | Theory Only | Interview-Ready**

---

## 📑 TABLE OF CONTENTS

1. [What is an Array?](#1-what-is-an-array)
2. [Why Do We Need Arrays?](#2-why-do-we-need-arrays)
3. [Real-Life Analogy](#3-real-life-analogy)
4. [Internal Memory Representation](#4-internal-memory-representation)
5. [How Array Address is Calculated](#5-how-array-address-is-calculated)
6. [Types of Arrays](#6-types-of-arrays)
7. [Properties of Arrays](#7-properties-of-arrays)
8. [Array vs Other Data Structures](#8-array-vs-other-data-structures)
9. [Operations on Arrays](#9-operations-on-arrays)
10. [Time and Space Complexity](#10-time-and-space-complexity)
11. [Static vs Dynamic Arrays](#11-static-vs-dynamic-arrays)
12. [Row-Major vs Column-Major Order](#12-row-major-vs-column-major-order)
13. [Multi-Dimensional Arrays (2D, 3D)](#13-multi-dimensional-arrays-2d-3d)
14. [Jagged Arrays](#14-jagged-arrays)
15. [Advantages of Arrays](#15-advantages-of-arrays)
16. [Disadvantages of Arrays](#16-disadvantages-of-arrays)
17. [Important Concepts for Interviews](#17-important-concepts-for-interviews)
18. [Common Interview Questions & Answers](#18-common-interview-questions--answers)
19. [Key Terminologies Glossary](#19-key-terminologies-glossary)

---

## 1. What is an Array?

An **Array** is a **linear data structure** that stores a **fixed-size, sequential collection of elements of the same data type** in **contiguous (adjacent) memory locations**.

- **Linear** → Elements are arranged one after another in a line (sequence).
- **Fixed-size** → The size of the array is decided at the time of declaration and **cannot be changed** (in static arrays).
- **Same data type** → All elements must be of the same type (e.g., all integers, all characters, all floats).
- **Contiguous memory** → All elements are stored next to each other in memory, no gaps.

### Simple Definition:
> An array is like a **row of boxes** where each box holds one value, all boxes are of the same size and type, and they are placed right next to each other.

---

## 2. Why Do We Need Arrays?

Before arrays, if we had to store 100 student marks, we would need **100 separate variables**:

```
mark1, mark2, mark3, ... mark100
```

Problems with this approach:
- Too many variable names to remember
- Cannot use loops to process them
- Code becomes very long and unmanageable
- Searching, sorting becomes impossible programmatically

**Arrays solve this** by storing all 100 marks under **one name** with an **index** to access each one.

> Arrays allow us to store and manage **large amounts of similar data** efficiently under **one variable name**.

---

## 3. Real-Life Analogy

### 🏢 Analogy 1: Hotel Rooms
Imagine a hotel with rooms numbered 101, 102, 103, 104...

- All rooms are on the **same floor** (contiguous)
- All rooms are of the **same type** (similar size/structure)
- Each room has a **unique room number** (index)
- You can directly go to room 105 without passing through other rooms (direct access)

This is exactly how an array works in memory!

---

### 🪑 Analogy 2: Train Seats
A train compartment has seats numbered S1, S2, S3... S50.
- All seats are in a row (sequential)
- Same type (passenger seat)
- Directly accessible by seat number

---

### 📫 Analogy 3: Mailboxes
A row of mailboxes in an apartment. Each mailbox:
- Has a number (index)
- Is the same size (same data type)
- Placed next to each other (contiguous memory)
- Can be accessed directly using the number

---

## 4. Internal Memory Representation

This is the **most important concept** for interviews. Understanding how arrays work internally in memory is what separates average candidates from great ones.

### How Memory Works

- Computer memory (RAM) is like a **long street of houses** where each house has a unique address.
- Each memory address stores **1 byte** of data.
- Memory addresses are sequential numbers: 1000, 1001, 1002, 1003...

### Array in Memory

When you declare an array, the OS allocates a **contiguous block of memory**.

**Example:** An integer array of size 5

```
Array: A = [10, 20, 30, 40, 50]
Data type: Integer (each integer = 4 bytes)
Base Address (starting address): 1000
```

| Index | Value | Memory Address |
|-------|-------|----------------|
| 0     | 10    | 1000           |
| 1     | 20    | 1004           |
| 2     | 30    | 1008           |
| 3     | 40    | 1012           |
| 4     | 50    | 1016           |

### Visual Memory Map:

```
Memory Address:  1000  1001  1002  1003  | 1004  1005  1006  1007  | 1008  ...
                 [  10 (4 bytes)        ] | [  20 (4 bytes)        ] | [  30  ...
                  A[0]                   |  A[1]                   |  A[2]
```

### Key Observations:
1. Each integer occupies **4 bytes**, so addresses jump by 4.
2. The **base address** is the address of the **first element (index 0)**.
3. The address of any element can be calculated using a simple formula.
4. Because of contiguous allocation, **random access is O(1)** — the CPU can directly jump to any element's address.

---

## 5. How Array Address is Calculated

This is a **formula-based concept** asked in many university exams and some interviews.

### For 1D Array:

```
Address of A[i] = Base_Address + (i × Size_of_DataType)
```

**Where:**
- `Base_Address` = Address of first element A[0]
- `i` = Index of the element you want
- `Size_of_DataType` = Number of bytes the data type occupies

**Example:**
- Base Address = 1000
- Data type = int (4 bytes)
- Find address of A[3]

```
Address of A[3] = 1000 + (3 × 4) = 1000 + 12 = 1012
```

---

### If Array is 0-Indexed (most common):

```
Address of A[i] = Base_Address + (i × Size)
```

### If Array is 1-Indexed (some languages):

```
Address of A[i] = Base_Address + ((i - 1) × Size)
```

---

### For 2D Array (Row-Major Order — C, C++, Java):

A 2D array A[m][n] (m rows, n columns):

```
Address of A[i][j] = Base_Address + ((i × n) + j) × Size_of_DataType
```

**Where:**
- `i` = row index
- `j` = column index
- `n` = total number of columns

**Example:**
- A[3][4] → 3 rows, 4 columns
- Base = 2000, int (4 bytes)
- Address of A[2][3]:

```
= 2000 + ((2 × 4) + 3) × 4
= 2000 + (8 + 3) × 4
= 2000 + 11 × 4
= 2000 + 44
= 2044
```

---

### For 2D Array (Column-Major Order — Fortran, MATLAB):

```
Address of A[i][j] = Base_Address + ((j × m) + i) × Size_of_DataType
```

**Where:**
- `m` = total number of rows

---

## 6. Types of Arrays

### Based on Size:

#### 1. Static Array
- Size is **fixed at compile time**
- Memory is allocated on the **Stack**
- Cannot grow or shrink at runtime
- Faster than dynamic arrays

#### 2. Dynamic Array
- Size can **change at runtime**
- Memory is allocated on the **Heap**
- Examples: ArrayList (Java), Vector (C++), List (Python)
- Internally, when capacity is full, a new larger array is created and all elements are copied

---

### Based on Dimensions:

#### 1. One-Dimensional (1D) Array
- A simple list of elements in a single row/line
- Like a single row of lockers

#### 2. Two-Dimensional (2D) Array
- A table (rows and columns) — like a spreadsheet or matrix
- Also called a **Matrix**

#### 3. Three-Dimensional (3D) Array
- Like a 3D cube — imagine multiple 2D matrices stacked
- Example: Used in image processing (height × width × color channels)

#### 4. Multi-Dimensional Array
- Arrays with more than 3 dimensions
- Rare in practice but conceptually possible

---

### Based on Storage:

#### 1. Homogeneous Array
- All elements are of the **same data type**
- Traditional arrays in C, Java, C++

#### 2. Heterogeneous Array
- Elements can be of **different data types**
- Found in Python lists, JavaScript arrays

---

## 7. Properties of Arrays

| Property | Description |
|----------|-------------|
| **Fixed Size** | Size cannot change after declaration (static) |
| **Homogeneous** | All elements same data type |
| **Contiguous Memory** | Stored side-by-side in memory |
| **Zero-Indexed** | First element is at index 0 (in most languages) |
| **Random Access** | Any element accessible in O(1) time |
| **Cache Friendly** | Contiguous storage means CPU cache hits are high |
| **Index-based** | Elements accessed using index numbers |

---

## 8. Array vs Other Data Structures

### Array vs Linked List

| Feature | Array | Linked List |
|---------|-------|-------------|
| Memory | Contiguous | Non-contiguous (scattered) |
| Access | O(1) — direct/random | O(n) — sequential traversal |
| Insertion at middle | O(n) — shift elements | O(1) — change pointers |
| Deletion at middle | O(n) — shift elements | O(1) — change pointers |
| Memory overhead | Less (no extra pointers) | More (stores data + pointer) |
| Cache performance | Excellent | Poor |
| Size | Fixed (static) | Dynamic |
| Search | O(n) linear, O(log n) if sorted | O(n) always |

---

### Array vs Stack

| Feature | Array | Stack |
|---------|-------|-------|
| Access | Any element (random) | Only top element |
| Operations | Insert/delete anywhere | Only push/pop (LIFO) |
| Use case | General storage | Function calls, undo operations |

> **Note:** Stack can be **implemented using** an array internally.

---

### Array vs Queue

| Feature | Array | Queue |
|---------|-------|-------|
| Access | Random access | Only front/rear |
| Operations | Any position | Enqueue/Dequeue (FIFO) |

> **Note:** Queue can also be **implemented using** an array.

---

### Array vs HashMap

| Feature | Array | HashMap |
|---------|-------|---------|
| Key | Integer index only | Any key type |
| Access | O(1) by index | O(1) average by key |
| Memory | Less | More (stores key-value pairs) |
| Order | Ordered (by index) | Unordered (generally) |

---

## 9. Operations on Arrays

### 1. Traversal
- **Definition:** Visiting each element of the array one by one.
- **Purpose:** To read, print, or process all elements.
- **Time Complexity:** O(n) — must visit all n elements.
- **Direction:** Can be forward (0 to n-1) or backward (n-1 to 0).

---

### 2. Insertion
Adding a new element to the array.

#### a) Insert at End
- Simply place the element at the last position.
- **Time Complexity:** O(1) — no shifting needed.

#### b) Insert at Beginning
- Must shift ALL existing elements one position to the right.
- **Time Complexity:** O(n) — n shifts needed.

#### c) Insert at a Specific Position (index k)
- Must shift elements from position k to end, one position to the right.
- **Time Complexity:** O(n) — worst case n shifts.

> **Important:** Array must have empty space to accommodate the new element. If full, cannot insert (static array).

---

### 3. Deletion
Removing an element from the array.

#### a) Delete from End
- Simply decrement the size/pointer.
- **Time Complexity:** O(1).

#### b) Delete from Beginning
- Must shift ALL elements one position to the left.
- **Time Complexity:** O(n).

#### c) Delete from Specific Position (index k)
- Shift all elements after position k one step to the left.
- **Time Complexity:** O(n) worst case.

> **Note:** In arrays, "deletion" doesn't free memory — it just overwrites and size is reduced logically.

---

### 4. Searching
Finding whether an element exists and/or its position.

#### a) Linear Search
- Check every element one by one from start to end.
- **Time Complexity:** O(n)
- **Works on:** Unsorted and sorted arrays.

#### b) Binary Search
- Only works on **sorted arrays**.
- Divide the array in half, check middle, discard one half, repeat.
- **Time Complexity:** O(log n)
- Much faster than linear search for large arrays.

---

### 5. Sorting
Rearranging elements in ascending or descending order.

| Algorithm | Time (Best) | Time (Avg) | Time (Worst) | Space | Stable? |
|-----------|-------------|------------|--------------|-------|---------|
| Bubble Sort | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Selection Sort | O(n²) | O(n²) | O(n²) | O(1) | No |
| Insertion Sort | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | O(n) | Yes |
| Quick Sort | O(n log n) | O(n log n) | O(n²) | O(log n) | No |
| Heap Sort | O(n log n) | O(n log n) | O(n log n) | O(1) | No |

---

### 6. Update / Modification
- Directly access the element using its index and change its value.
- **Time Complexity:** O(1) — direct memory access.

---

### 7. Merging
- Combining two arrays into one.
- **Time Complexity:** O(m + n) where m and n are sizes of the two arrays.

---

### 8. Reversing
- Rearranging elements in reverse order.
- **Time Complexity:** O(n)
- **Space Complexity:** O(1) if done in-place (two-pointer technique).

---

## 10. Time and Space Complexity

### Summary Table

| Operation | Best Case | Average Case | Worst Case |
|-----------|-----------|--------------|------------|
| Access (by index) | O(1) | O(1) | O(1) |
| Search (Linear) | O(1) | O(n) | O(n) |
| Search (Binary - sorted) | O(1) | O(log n) | O(log n) |
| Insert at End | O(1) | O(1) | O(1) |
| Insert at Beginning | O(n) | O(n) | O(n) |
| Insert at Middle | O(n) | O(n) | O(n) |
| Delete at End | O(1) | O(1) | O(1) |
| Delete at Beginning | O(n) | O(n) | O(n) |
| Delete at Middle | O(n) | O(n) | O(n) |
| Traversal | O(n) | O(n) | O(n) |

### Space Complexity:
- **Static Array:** O(n) — where n is the declared size.
- **Dynamic Array:** O(n) — but with some extra capacity (usually 1.5x or 2x when resized).

---

## 11. Static vs Dynamic Arrays

### Static Array

- **Size:** Fixed at compile time (declaration time).
- **Memory:** Allocated on the **Stack** (for local arrays) or **Data segment** (for global arrays).
- **Resizing:** NOT possible. Once declared, size is permanent.
- **Speed:** Faster — no runtime overhead for memory management.
- **Example languages:** C arrays, C++ arrays (without vector).

**Characteristics:**
- If you declare an array of size 10, you get exactly 10 slots. No more, no less.
- If you try to store 11 elements, it causes a **Buffer Overflow** (a serious security vulnerability).
- Memory is wasted if you use fewer elements than declared.

---

### Dynamic Array

- **Size:** Can grow or shrink at runtime.
- **Memory:** Allocated on the **Heap**.
- **Resizing:** Possible — done automatically behind the scenes.
- **Speed:** Slightly slower due to potential reallocation.
- **Examples:** ArrayList (Java), Vector (C++), List (Python), Array (JavaScript).

**How Dynamic Array Grows Internally:**

1. Start with an initial capacity (e.g., size 4).
2. Elements are added one by one.
3. When the array is **full**, a new array of **double the size** (or 1.5x) is created in heap memory.
4. All existing elements are **copied** to the new array.
5. The old array is discarded (garbage collected / freed).
6. The new element is added.

This is called **Amortized O(1)** insertion — because most insertions are O(1), and occasional resizing makes it O(n) but rarely enough that the **average cost per insertion is still O(1)**.

**Amortized Analysis:**
> If you insert n elements and resizing happens at 1, 2, 4, 8, 16... (powers of 2), total copy operations = 1+2+4+...+n ≈ 2n = O(n). So average cost per insertion = O(n)/n = O(1).

---

## 12. Row-Major vs Column-Major Order

This concept is crucial when dealing with 2D arrays and is frequently asked in interviews and exams.

### The Problem:
Memory is **1-dimensional** (a straight line of addresses), but a 2D array is a **table** (rows and columns). So how do we map a 2D structure into 1D memory?

There are two standard ways:

---

### Row-Major Order
> Store the array **row by row** — all elements of row 0 first, then row 1, then row 2, etc.

**Used by:** C, C++, Java, Python (NumPy default), C#

**Example:** A[3][3] → 3×3 matrix

```
Matrix:
| 1  2  3 |   → Row 0
| 4  5  6 |   → Row 1
| 7  8  9 |   → Row 2
```

**Stored in memory as:**
```
1, 2, 3, 4, 5, 6, 7, 8, 9
```
(Row 0 complete → Row 1 complete → Row 2 complete)

**Address Formula (Row-Major):**
```
Address of A[i][j] = Base + ((i × n) + j) × Size
```

---

### Column-Major Order
> Store the array **column by column** — all elements of column 0 first, then column 1, then column 2, etc.

**Used by:** Fortran, MATLAB, R, Octave

**Same matrix stored as:**
```
1, 4, 7, 2, 5, 8, 3, 6, 9
```
(Column 0 complete → Column 1 complete → Column 2 complete)

**Address Formula (Column-Major):**
```
Address of A[i][j] = Base + ((j × m) + i) × Size
```

---

### Why Does This Matter?

**Cache Performance!**

Modern CPUs don't load one memory cell at a time — they load a **cache line** (typically 64 bytes = 16 integers at once). If you access memory **sequentially**, you get **cache hits** (fast). If you jump around, you get **cache misses** (slow).

- Accessing a 2D array **row by row** in a Row-Major language = Sequential = Cache friendly = FAST
- Accessing a 2D array **column by column** in a Row-Major language = Jumping around = Cache unfriendly = SLOW

> This is why in C/Java, iterating row by row is faster than column by column for 2D arrays.

---

## 13. Multi-Dimensional Arrays (2D, 3D)

### 2D Array (Matrix)

A 2D array is logically a **table with rows and columns**.

**Notation:** A[rows][columns] or A[m][n]

**Total elements:** m × n

**Memory required:** m × n × size_of_datatype bytes

**Real-world uses:**
- Representing a **chessboard** (8×8)
- Representing a **spreadsheet** (rows and columns of data)
- **Image processing** — a grayscale image is a 2D array where each value is a pixel's intensity (0-255)
- **Adjacency matrix** for graphs
- **Dynamic Programming tables**

---

### 3D Array

A 3D array is like a **stack of 2D matrices** (like pages of a book).

**Notation:** A[depth][rows][columns] or A[l][m][n]

**Total elements:** l × m × n

**Real-world uses:**
- **Color images** — RGB image = 3D array (height × width × 3 channels)
- **Videos** — sequence of frames (frame × height × width)
- **3D grids** in simulations

---

## 14. Jagged Arrays

A **Jagged Array** (also called Ragged Array) is an **array of arrays** where each inner array can have a **different length**.

**Contrast with regular 2D array:**
- Regular 2D: All rows have the same number of columns (rectangular)
- Jagged: Each row can have a different number of columns (non-rectangular, like a jagged edge)

**Visual:**
```
Row 0: [1, 2, 3]         → 3 elements
Row 1: [4, 5]            → 2 elements
Row 2: [6, 7, 8, 9]      → 4 elements
Row 3: [10]              → 1 element
```

**Real-world use:**
- Storing sentences (each sentence has different number of words)
- Storing student subjects (each student may have different number of subjects)
- Pascal's Triangle (each row has different length)

**Memory:** More efficient than rectangular 2D when rows have very different lengths (no wasted padding).

---

## 15. Advantages of Arrays

1. **O(1) Random Access:** Can access any element directly using its index in constant time. No need to traverse.

2. **Cache Friendly:** Contiguous memory layout means CPU cache loads nearby elements automatically. This makes array iteration very fast in practice.

3. **Simple and Easy to Use:** Conceptually straightforward. No complex structure.

4. **Memory Efficient:** Only stores data, no extra pointers or metadata (unlike linked lists).

5. **Best for Known, Fixed Data:** When the number of elements is known in advance, arrays are ideal.

6. **Foundation for Other Structures:** Stacks, queues, heaps, and hash tables are often implemented using arrays internally.

7. **Supports Binary Search:** On sorted arrays, binary search gives O(log n) search time.

8. **Suitable for Mathematical Operations:** Matrices (2D arrays) are used in linear algebra, machine learning, and graphics.

---

## 16. Disadvantages of Arrays

1. **Fixed Size (Static Arrays):** Once declared, size cannot change. If you need more space, you must create a new larger array and copy everything — O(n) operation.

2. **Costly Insertion/Deletion in Middle:** Inserting or deleting in the middle requires shifting elements — O(n) time.

3. **Memory Wastage:** If you declare an array of size 100 but use only 10, 90 slots are wasted.

4. **Homogeneous:** Cannot store different data types in the same array (in statically typed languages).

5. **No Built-in Bounds Checking (in some languages):** In C/C++, accessing an index out of bounds causes undefined behavior or buffer overflow — a major security risk.

6. **Contiguous Memory Requirement:** For large arrays, the OS must find a large contiguous block of free memory. This can fail even if total free memory is enough (fragmentation issue).

7. **Expensive to Resize:** Dynamic array resizing involves allocating new memory + copying all elements = O(n) time and memory.

---

## 17. Important Concepts for Interviews

### 🔑 Concept 1: Two-Pointer Technique
- Use two pointers (usually `left` and `right` starting at both ends) to solve problems in O(n) instead of O(n²).
- Used for: finding pairs with a sum, reversing arrays, removing duplicates from sorted arrays, container with most water.

### 🔑 Concept 2: Sliding Window
- Maintain a "window" (subarray) of fixed or variable size that slides through the array.
- Used for: maximum sum subarray of size k, longest subarray with condition, string problems.

### 🔑 Concept 3: Prefix Sum (Cumulative Sum)
- Create a prefix sum array where prefix[i] = sum of elements from index 0 to i.
- Allows range sum queries in O(1) after O(n) preprocessing.
- Used for: range sum, equilibrium index, subarray sum equals k.

### 🔑 Concept 4: Kadane's Algorithm
- Find the maximum sum subarray in O(n) time.
- Key idea: At each index, decide whether to extend the current subarray or start fresh.
- Result: Maximum subarray sum.

### 🔑 Concept 5: Sorting-based Techniques
- Many array problems become easier after sorting.
- Examples: Finding duplicates, merging intervals, 3-sum problem.

### 🔑 Concept 6: Hashing with Arrays
- Use a frequency/count array as a hash map when elements are within a known range.
- Example: Counting frequencies of elements, checking if two arrays are equal.

### 🔑 Concept 7: Binary Search on Arrays
- Only applicable on sorted arrays.
- Also used in "search space" problems where you binary search on the answer.

### 🔑 Concept 8: Merge Two Sorted Arrays
- Classic O(m+n) technique using two pointers.
- Foundation of Merge Sort.

### 🔑 Concept 9: In-Place Operations
- Modifying an array without using extra space.
- Uses O(1) extra space by rearranging elements cleverly.

### 🔑 Concept 10: Dutch National Flag (3-way Partition)
- Partition an array into 3 sections (e.g., 0s, 1s, 2s) in O(n) time and O(1) space.
- Uses 3 pointers: low, mid, high.

---

## 18. Common Interview Questions & Answers

### Q1: What is an array?
**A:** An array is a linear data structure that stores a collection of elements of the same data type in contiguous memory locations, accessible via indices starting from 0.

---

### Q2: Why is array indexing 0-based?
**A:** Because the index represents the **offset** from the base address. The first element is at the base address itself, so offset = 0. The formula is: `Address = Base + index × size`. If indexing started at 1, we'd always compute `(index-1) × size`, which is unnecessarily complex.

---

### Q3: Why is array access O(1)?
**A:** Because the address of any element can be directly computed using the formula: `Base_Address + (index × size_of_type)`. The CPU can calculate this address instantly and jump directly to it. No traversal is needed. This is called **random access** or **direct access**.

---

### Q4: What is the difference between array and ArrayList?
**A:**
- **Array** is a fixed-size, static data structure. Size cannot change once declared.
- **ArrayList** is a dynamic array that can grow/shrink. It internally uses an array but handles resizing automatically.
- Arrays can hold both primitives and objects (in Java); ArrayList can only hold objects.
- Arrays are faster; ArrayList is more flexible.

---

### Q5: What happens when a dynamic array is full?
**A:** A new array of larger size (usually **2x or 1.5x** the current size) is created in heap memory. All existing elements are copied to the new array, and the old array is discarded. This is an O(n) operation but happens infrequently, so the amortized cost of insertion is still O(1).

---

### Q6: Can we decrease the size of an array?
**A:** For **static arrays**, no — size is permanently fixed. For **dynamic arrays**, yes — some implementations allow shrinking (e.g., when size drops below 25% of capacity, the array is shrunk to half).

---

### Q7: What is a Buffer Overflow?
**A:** A buffer overflow occurs when you write data beyond the allocated array bounds. This overwrites adjacent memory, which can corrupt data, crash the program, or create security vulnerabilities. This is a critical security concern in languages like C/C++ that don't perform automatic bounds checking.

---

### Q8: What is memory fragmentation and how does it affect arrays?
**A:** Memory fragmentation occurs when free memory exists but in scattered, non-contiguous blocks. Since arrays need **contiguous** memory, a large array allocation might fail even if enough total free memory is available but not in one block. This is an advantage of linked lists, which can use scattered memory.

---

### Q9: What is a sparse array?
**A:** A sparse array is an array where most elements have the same "default" value (usually 0 or null). Instead of allocating memory for all positions, special data structures store only non-default values with their indices. Example: a 1000×1000 matrix where only 100 cells have values — wasteful to store 1,000,000 cells.

---

### Q10: What is the difference between Row-Major and Column-Major order?
**A:** Row-Major stores a 2D array row by row in linear memory (used in C, C++, Java). Column-Major stores it column by column (used in Fortran, MATLAB). This affects performance due to cache behavior — accessing elements in the storage order is faster due to spatial locality and cache hits.

---

### Q11: What is an in-place algorithm?
**A:** An algorithm that modifies the input data structure directly without using significant extra memory (O(1) extra space). For arrays, this means rearranging elements without creating a new array. Example: reversing an array in-place using two pointers.

---

### Q12: What is a circular array?
**A:** A circular array treats the array as if the last element is connected to the first element (like a circle). It's used to implement circular queues. When you reach the end, you wrap around to the beginning. This is done using modulo operation: `next_index = (current_index + 1) % size`.

---

### Q13: What is the difference between a 2D array and an array of arrays?
**A:**
- A **2D array** is a true matrix — stored as one contiguous block of memory. All rows have equal length.
- An **array of arrays** (jagged array) — each row is a separate array stored at a different memory location. Rows can have different lengths.

---

### Q14: How is an array stored in memory vs a linked list?
**A:**
- **Array:** Contiguous block of memory. Elements physically adjacent. Enables O(1) access, cache-friendly.
- **Linked List:** Non-contiguous. Each node can be anywhere in memory, connected by pointers. O(n) access, cache-unfriendly (pointer chasing).

---

### Q15: What are the real-world applications of arrays?
**A:**
1. **Image processing** — pixel data stored as 2D/3D arrays
2. **Database tables** — rows of records
3. **Spreadsheets** — Excel uses 2D arrays internally
4. **Music/Audio** — sound samples stored as arrays of numbers
5. **Machine Learning** — neural network weights, input features as arrays (tensors)
6. **Leaderboards/Rankings** — sorted arrays of scores
7. **Undo/Redo** — history stored as array
8. **Video frames** — each frame is a 2D array of pixels
9. **Contact lists** — sorted array of names

---

### Q16: What is amortized O(1) for dynamic array insertion?
**A:** Most insertions into a dynamic array are O(1). But occasionally, when the array is full, it resizes (O(n) operation). If we average the cost of n insertions including the resizing events, each insertion costs O(1) on average. This is called **amortized O(1)** — the expensive operations are "amortized" (spread out) over many cheap operations.

---

### Q17: What is cache locality and why do arrays benefit from it?
**A:** Modern CPUs use a **cache** (small, very fast memory) to store recently/frequently used data. When you access a memory location, the CPU loads a chunk of nearby memory (a "cache line") into cache. Since array elements are contiguous, accessing one element automatically loads nearby elements into cache. This makes sequential array access very fast. Linked lists, with nodes scattered in memory, suffer from frequent **cache misses** (data not in cache, must fetch from slower RAM).

---

## 19. Key Terminologies Glossary

| Term | Meaning |
|------|---------|
| **Array** | Linear, contiguous, fixed-size collection of same-type elements |
| **Index** | The position of an element in an array (0-based in most languages) |
| **Base Address** | Memory address of the first element (index 0) |
| **Element** | A single item stored in the array |
| **Size / Length** | Total number of elements the array can hold |
| **Bounds** | Valid index range: 0 to size-1 |
| **Buffer Overflow** | Accessing memory beyond array bounds (security vulnerability) |
| **Traversal** | Visiting each element one by one |
| **Random Access** | Directly accessing any element using its index in O(1) |
| **Contiguous Memory** | Memory blocks placed side-by-side with no gaps |
| **Static Array** | Fixed-size array allocated at compile time |
| **Dynamic Array** | Resizable array allocated at runtime on heap |
| **Amortized O(1)** | Average O(1) time per operation over a sequence of operations |
| **In-place** | Modifying array without extra space O(1) |
| **Row-Major Order** | Storing 2D array row by row in memory |
| **Column-Major Order** | Storing 2D array column by column in memory |
| **Jagged Array** | Array of arrays where rows can have different lengths |
| **Sparse Array** | Array where most elements are default (e.g., 0) |
| **Circular Array** | Array where last element connects back to first |
| **Cache Line** | Chunk of memory loaded into CPU cache at once (usually 64 bytes) |
| **Cache Miss** | When needed data is NOT in cache and must be fetched from RAM |
| **Cache Hit** | When needed data IS in cache (fast access) |
| **Two-Pointer** | Technique using two indices to solve array problems efficiently |
| **Sliding Window** | Technique maintaining a moving subarray over the array |
| **Prefix Sum** | Array where each element is sum of all previous elements |
| **Kadane's Algorithm** | O(n) algorithm to find maximum sum subarray |
| **Fragmentation** | Scattered free memory preventing large contiguous allocation |
| **Offset** | Distance from base address (= index × element size) |
| **Homogeneous** | All elements of the same data type |
| **Heap Memory** | Dynamic memory region used for runtime allocation |
| **Stack Memory** | Memory region for local variables, automatically managed |

---

> 📌 **Revision Tip:** Go through the glossary first, then re-read the sections that feel unclear. Practice explaining each concept out loud — if you can explain it simply, you truly understand it.

> 💡 **Interview Tip:** For every array problem in an interview, ask yourself:
> 1. Is the array sorted? (enables Binary Search)
> 2. Do I need extra space or can I do it in-place?
> 3. Can Two-Pointer or Sliding Window help?
> 4. Can Prefix Sum make range queries faster?
> 5. Is Hashing useful to count frequencies?

---

*Last Updated: July 2026 | PlacementPreparation/DSA/03_Arrays*
