class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length){

            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length, y = nums2.length;

        int start = 0, end = x;

        while(start <= end){

            int partX = (start + end) / 2, partY = (x + y + 1) / 2 - partX;

            int leftx = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            int rightx = partX == x ? Integer.MAX_VALUE : nums1[partX];
            int lefty = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            int righty = partY == y ? Integer.MAX_VALUE : nums2[partY];

            if(leftx <= righty && lefty <= rightx){

                if((x + y) % 2 == 0){

                    return ((double) Math.max(leftx, lefty) + Math.min(rightx, righty)) / 2.0;
                }

                else{

                    return (double) Math.max(leftx, lefty);
                }
            }

            else if(leftx > righty){

                end = partX - 1;
            }

            else{

                start = partX + 1;
            }
        }

        return 0;
        
    }
}
