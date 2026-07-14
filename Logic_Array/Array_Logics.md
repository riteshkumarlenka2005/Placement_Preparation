# Array Question Logics

This document contains clean and minimal logic notes for quick revision of array problems.

## 1. Find the largest element in an array (Traversal)
- Assume the first element is the maximum (`max = arr[0]`).
- Iterate through the rest of the array.
- If current element > `max`, update `max`.
```java
// Core Logic
int max = arr[0];
for (int i = 1; i < n; i++) {
    if (arr[i] > max) max = arr[i];
}
```

## 2. Find the smallest element in an array (Traversal)
- Assume the first element is the minimum (`min = arr[0]`).
- Iterate through the rest of the array.
- If current element < `min`, update `min`.
```java
// Core Logic
int min = arr[0];
for (int i = 1; i < n; i++) {
    if (arr[i] < min) min = arr[i];
}
```

## 3. Find the second largest element (Single pass logic)
- Track two variables: `largest = -1` and `second_largest = -1`.
- Traverse the array:
  - If current element > `largest`: The old `largest` becomes `second_largest`, and current element becomes new `largest`.
  - Else if current element > `second_largest` AND current element != `largest`: Update `second_largest`.
```java
// Core Logic
int largest = -1, second_largest = -1;
for (int i = 0; i < n; i++) {
    if (arr[i] > largest) {
        second_largest = largest;
        largest = arr[i];
    } else if (arr[i] > second_largest && arr[i] != largest) {
        second_largest = arr[i];
    }
}
```

## 4. Find the second smallest element (Single pass logic)
- Track two variables: `smallest = INT_MAX` and `second_smallest = INT_MAX`.
- Traverse the array:
  - If current element < `smallest`: The old `smallest` becomes `second_smallest`, and current element becomes new `smallest`.
  - Else if current element < `second_smallest` AND current element != `smallest`: Update `second_smallest`.
```java
// Core Logic
int smallest = Integer.MAX_VALUE, second_smallest = Integer.MAX_VALUE;
for (int i = 0; i < n; i++) {
    if (arr[i] < smallest) {
        second_smallest = smallest;
        smallest = arr[i];
    } else if (arr[i] < second_smallest && arr[i] != smallest) {
        second_smallest = arr[i];
    }
}
```

## 5. Check if array is sorted (Linear scan)
- Start from the second element (index `1`).
- Compare each element with the previous one.
- If `arr[i] < arr[i - 1]` at any point, it means the array is not sorted.
```java
// Core Logic
for (int i = 1; i < n; i++) {
    if (arr[i] < arr[i - 1]) return false;
}
return true;
```

## 6. Check if array is sorted and rotated (Counting breaks)
- A sorted and rotated array will have at most **one break point** where the current element is greater than the next element (`arr[i] > arr[i + 1]`).
- Iterate through the array and count how many times this drop occurs.
- Don't forget to check the boundary condition: compare the last element with the first element (`arr[N - 1] > arr[0]`), because in a rotated array, the last element should wrap around to the first.
- If the count of drops is **less than or equal to 1**, the array is sorted and rotated. (A count of 0 means it's sorted but not rotated, which is still a valid rotated array with 0 shifts).
- If the count exceeds 1, it is not sorted and rotated.

-compare arr[i]>arr[(i+1)%n], then count++, if count <=1 it is sorted and rotated, else no

## 7. Reverse an array (Two pointer swap)
- Use two pointers: `left` starting at the beginning (`0`) and `right` starting at the end (`N - 1`).
- Swap the elements at `left` and `right`.
- Increment `left` (`left++`) and decrement `right` (`right--`).
- Repeat this process as long as `left < right`.
```java
// Core Logic
int left = 0, right = n - 1;
while (left < right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
    left++;
    right--;
}
```

## 8. Remove duplicates from sorted array (in-place)
- Use a pointer `i` to keep track of the index of the last unique element found. Initialize `i = 0`.
- Iterate through the array with another pointer `j` from index `1` to `N - 1`.
- Because the array is sorted, duplicates will be adjacent. If `arr[j] != arr[i]`, a new unique element is found.
- Increment `i`, and overwrite `arr[i]` with `arr[j]`.
- The total number of unique elements will be `i + 1`.
```java
// Core Logic
int i = 0;
for (int j = 1; j < n; j++) {
    if (arr[j] != arr[i]) {
        i++;
        arr[i] = arr[j];
    }
}
// New length of the unique elements is (i + 1)
```

## 14. Find missing number in array [1 to N] (Sum formula)
- Compute the expected sum of the first `N` natural numbers: `N * (N + 1) / 2`.
- Compute the actual sum of the elements given.
- The difference is the missing number.
- *(Note: Use `long` for sums to prevent integer overflow for large `N`)*
```java
// Core Logic
long expectedSum = (n * (n + 1)) / 2;
long actualSum = 0;
for (int i = 0; i < n - 1; i++) {
    actualSum += arr[i];
}
long missingNumber = expectedSum - actualSum;
```


