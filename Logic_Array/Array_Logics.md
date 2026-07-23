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

## 9. Find the third largest element (Single pass logic)
- Track three variables: `largest`, `s_largest`, `t_largest` initialized to `Integer.MIN_VALUE`.
- Traverse the array:
  - If `arr[i] > largest`: Update all three (`t_largest = s_largest`, `s_largest = largest`, `largest = arr[i]`).
  - Else if `arr[i] > s_largest` AND `arr[i] < largest`: Update two (`t_largest = s_largest`, `s_largest = arr[i]`).
  - Else if `arr[i] > t_largest` AND `arr[i] < s_largest`: Update `t_largest = arr[i]`.
```java
// Core Logic
int largest = Integer.MIN_VALUE, s_largest = Integer.MIN_VALUE, t_largest = Integer.MIN_VALUE;
for (int i = 0; i < n; i++) {
    if (arr[i] > largest) {
        t_largest = s_largest;
        s_largest = largest;
        largest = arr[i];
    } else if (arr[i] > s_largest && arr[i] < largest) {
        t_largest = s_largest;
        s_largest = arr[i];
    } else if (arr[i] > t_largest && arr[i] < s_largest) {
        t_largest = arr[i];
    }
}
```

## 10. Left Rotate by 1 position
- Store the first element in a temporary variable (`temp = arr[0]`).
- Shift all other elements one position to the left (`arr[i] = arr[i+1]`).
- Place the temporary variable at the last index (`arr[n-1] = temp`).
```java
// Core Logic
int temp = arr[0];
for(int i = 0; i < n - 1; i++) {
    arr[i] = arr[i + 1];
}
arr[n - 1] = temp;
```

## 11. Left Rotate by K positions (Reversal Algorithm)
- Calculate effective rotations: `k = k % n`.
- Reverse the first `k` elements: `reverse(arr, 0, k - 1)`.
- Reverse the remaining `n - k` elements: `reverse(arr, k, n - 1)`.
- Reverse the entire array: `reverse(arr, 0, n - 1)`.
```java
// Core Logic
k = k % n;
reverse(arr, 0, k - 1);
reverse(arr, k, n - 1);
reverse(arr, 0, n - 1);
```

## 12. Right Rotate by K positions (Reversal Algorithm)
- Calculate effective rotations: `k = k % n`.
- Reverse the first `n - k` elements: `reverse(arr, 0, n - k - 1)`.
- Reverse the last `k` elements: `reverse(arr, n - k, n - 1)`.
- Reverse the entire array: `reverse(arr, 0, n - 1)`.
```java
// Core Logic
k = k % n;
reverse(arr, 0, n - k - 1);
reverse(arr, n - k, n - 1);
reverse(arr, 0, n - 1);
```

## 13. Move all zeros to end (Two pointer approach)
- Use a pointer `j` to track the position for the next non-zero element.
- Traverse the array: if `arr[i] != 0`, place it at index `j` (`arr[j] = arr[i]`), and increment `j`.
- After traversing, fill the rest of the array from `j` to `n - 1` with `0`.
```java
// Core Logic
int j = 0;
for(int i = 0; i < n; i++) {
    if(arr[i] != 0) {
        arr[j] = arr[i];
        j++;
    }
}
for(int i = j; i < n; i++) {
    arr[i] = 0;
}
```

## 15. Move negative numbers to one side
- Use a pointer `j` to track the position of the last placed negative number.
- Traverse the array. If the current element is negative (`arr[i] < 0`), swap it with the element at `j` and increment `j`.
```java
// Core Logic
int j = 0;
for(int i = 0; i < n; i++) {
    if(arr[i] < 0) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        j++;
    }
}
```

## 16. Linear Search
- Iterate through the array elements.
- If `arr[i] == target`, the element is found at index `i`.
```java
// Core Logic
for(int i = 0; i < n; i++) {
    if(arr[i] == target) {
        return i; // Found
    }
}
return -1; // Not Found
```

## 17. Union of 2 Sorted Arrays (Two Pointers)
- Use pointers `i` and `j` for both arrays.
- Compare elements at `i` and `j`. Add the smaller element to the result list and increment its pointer.
- If elements are equal, add any one and increment both pointers.
- Ensure duplicates are not added by checking the last element of the result list.
- Add remaining elements from both arrays.
```java
// Core Logic
ArrayList<Integer> list = new ArrayList<>();
int i = 0, j = 0;
while(i < n1 && j < n2) {
    if(arr1[i] < arr2[j]) {
        if(list.isEmpty() || list.get(list.size() - 1) != arr1[i])
            list.add(arr1[i]);
        i++;
    } else if (arr1[i] > arr2[j]) {
        if(list.isEmpty() || list.get(list.size() - 1) != arr2[j])
            list.add(arr2[j]);
        j++;
    } else {
        if(list.isEmpty() || list.get(list.size() - 1) != arr1[i])
            list.add(arr1[i]);
        i++;
        j++;
    }
}
while (i < n1) {
    if(list.isEmpty() || list.get(list.size() - 1) != arr1[i])
        list.add(arr1[i]);
    i++;
}
while (j < n2) {
    if(list.isEmpty() || list.get(list.size() - 1) != arr2[j])
        list.add(arr2[j]);
    j++;
}
```

## 18. Intersection of 2 Sorted Arrays (Two Pointers)
- Use pointers `i` and `j`.
- If `arr1[i] < arr2[j]`, increment `i`.
- If `arr1[i] > arr2[j]`, increment `j`.
- If they are equal, add to the result (avoid duplicates) and increment both `i` and `j`.
```java
// Core Logic
ArrayList<Integer> list = new ArrayList<>();
int i = 0, j = 0;
while(i < n1 && j < n2) {
    if(arr1[i] < arr2[j]) {
        i++;
    } else if(arr1[i] > arr2[j]) {
        j++;
    } else {
        if(list.isEmpty() || list.get(list.size() - 1) != arr1[i]) {
            list.add(arr1[i]);
        }
        i++;
        j++;
    }
}
```

## 19. Max Consecutive Ones
- Traverse the array. Maintain a `count` for current consecutive ones and `maxCount` for the maximum found so far.
- If `arr[i] == 1`, increment `count` and update `maxCount`.
- If `arr[i] != 1`, reset `count` to `0`.
```java
// Core Logic
int count = 0, maxCount = 0;
for(int i = 0; i < n; i++) {
    if(arr[i] == 1) {
        count++;
        maxCount = Math.max(maxCount, count);
    } else {
        count = 0;
    }
}
```

## 20. Find single number (appears once, others twice)
- **Optimal Approach (XOR)**: XOR of two same numbers is `0`. XOR of a number with `0` is the number itself.
- XOR all elements in the array; the remaining value is the single number.
```java
// Core Logic
int xor = 0;
for(int i = 0; i < n; i++) {
    xor = xor ^ arr[i];
}
return xor;
```

## 21. Majority Element (Appears > N/2 times)
- **HashMap Approach**: Store frequency of each element. Iterate over map keys to find the element with frequency `> n / 2`.
```java
// Core Logic
HashMap<Integer, Integer> map = new HashMap<>();
for(int i = 0; i < n; i++) {
    map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
}
for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
    if(entry.getValue() > n / 2) return entry.getKey();
}
```

## 22. Concatenation of 2 Arrays
- Create a new array of size `size1 + size2`.
- Copy all elements of the first array to the new array.
- Copy all elements of the second array to the new array starting from index `size1`.
```java
// Core Logic
int[] arr3 = new int[size1 + size2];
for(int i = 0; i < size1; i++) {
    arr3[i] = arr1[i];
}
for(int i = 0, j = 0; i < size2; i++, j++) {
    arr3[size1 + i] = arr2[j];
}
```

## 23. Maximum Subarray Sum (Kadane's Algorithm)
- Maintain two variables: `sum = 0` and `maxSum = arr[0]`.
- Iterate through the array, adding the current element to `sum`.
- Update `maxSum` if `sum > maxSum`.
- If `sum` becomes less than `0`, reset `sum` to `0`.
```java
// Core Logic
int maxSum = arr[0];
int sum = 0; 
for(int i = 0; i < arr.length; i++){   
    sum += arr[i];
    maxSum = Math.max(maxSum, sum);
    if(sum < 0){
        sum = 0;
    }
}
```

## 24. Find Numbers with Even Number of Digits
- Iterate through the array elements.
- For each element, count the number of digits by repeatedly dividing by `10` until it becomes `0`.
- If the digit count is even, increment the `evenDigitCount`.
```java
// Core Logic
int evenDigitCount = 0;
for(int i = 0; i < n; i++) {
    int digitCount = 0;
    int temp = arr[i];
    while(temp > 0) {
        digitCount++;
        temp /= 10;
    }
    if(digitCount % 2 == 0) {
        evenDigitCount++;
    }
}
```

## 25. Plus One
- Traverse the array from right to left (end to start).
- If the current digit is less than `9`, increment it by `1` and return the array.
- If it is `9`, set it to `0` and continue to the next digit.
- If all digits were `9` (loop finishes), create a new array of size `n + 1`, set the first element to `1`, and return it.
```java
// Core Logic
for(int i = digits.length - 1; i >= 0; i--) {
    if(digits[i] < 9) {
        digits[i] = digits[i] + 1;
        return digits; // Returned inside method
    }
    digits[i] = 0;
}
int newArray[] = new int[digits.length + 1];
newArray[0] = 1;
return newArray; // Returned inside method
```

## 26. Remove Element (In-place)
- Use a pointer `j` to keep track of the position for valid elements.
- Iterate through the array. If the current element is not equal to `val`, place it at index `j` and increment `j`.
- The first `j` elements will contain the array without `val`.
```java
// Core Logic
int j = 0;
for(int i = 0; i < nums.length; i++) {
    if(nums[i] != val) {
        nums[j] = nums[i];
        j++;
    }
}
// j is the new length
```

## 27. Richest Customer Wealth (2D Array)
- Iterate through each row (customer) of the 2D array.
- Calculate the sum of elements in the current row (wealth of the customer).
- Keep track of the maximum wealth encountered so far.
```java
// Core Logic
int maxWealth = 0;
for(int i = 0; i < r; i++) {
    int wealth = 0;         
    for(int j = 0; j < c; j++) {
        wealth += arr[i][j];
    }
    maxWealth = Math.max(maxWealth, wealth);
}
```

## 28. Running Sum of 1D Array
- Maintain a `sum` variable initialized to `0`.
- Iterate through the array, adding the current element to `sum`.
- Replace the current element with the updated `sum`.
```java
// Core Logic
int sum = 0;
for(int i = 0; i < size; i++) {
    sum = sum + arr[i];
    arr[i] = sum;
}
```

## 29. Squares of a Sorted Array (Brute Force)
- Iterate through the array and replace each element with its square.
- Use `Arrays.sort()` to sort the updated array.
```java
// Core Logic
for(int i = 0; i < arr.length; i++) {
    arr[i] = arr[i] * arr[i];
}
Arrays.sort(arr);
```
