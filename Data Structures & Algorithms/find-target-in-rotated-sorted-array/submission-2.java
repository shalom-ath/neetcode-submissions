class Solution {
    public int search(int[] nums, int target) {
       
        //find pivot

        int pivot = findpivot(nums);

        //if you dont find pivot, array is not rotated
        //use pivot to find ans (three cases)

        if(pivot == -1){
            //write a normal binary search
            return binarysearch(nums, target, 0, nums.length-1);
        }
        //if you find a pivot , you have two sorted asc arrays
         if(nums[pivot] == target){ //case 1
             return pivot;
         }
         if(target >= nums[0]){
             return binarysearch(nums, target, 0, pivot -1);
         }
         else{
             return binarysearch(nums, target, pivot + 1, nums.length-1);
         }
    }

     int binarysearch(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target < arr[mid]){
                end = mid - 1;
            }
            else if(target > arr[mid]){
                start = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
    int findpivot(int[] arr ){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end - start) / 2;

            //4 cases to find the pivot

            //imagine if mid equals to last index in some scenario
            //it will give out of bounds, error

            //mid should be less than end so the comparsion

            if(mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            }
            if(mid > start && arr[mid] < arr[mid -1]){
                 return mid - 1;
            }
            if(arr[mid] <= arr[start]){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
            
        }
        return -1;
    }
}
    

