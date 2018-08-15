### Template for binary search 

```
while (l < r) {
  mid = (l + r) / 2;
  if (mid < r) / if (nums[mid] < nums[mid+1])
    // update l / r
    l = mid; / r = mid;
}
```
