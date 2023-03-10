class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {



        if(nums1.length > nums2.length)
        return findMedianSortedArrays(nums2, nums1);

        int x = nums1.length;
        int y = nums2.length;

        if(x == 0)
        {
            if(y % 2 == 0)
            {

                return (double)(nums2[y/2] + nums2[(y/2)-1]) / 2;
            }

            return nums2[y/2];
        }

        int start = 0;
        int end = x;

        while(start <= end)
        {
        int partitionX = (start + end) / 2;
        int partitionY = (x + y + 1)/2 - partitionX;

        int maxX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
        int minX = partitionX == x ? Integer.MAX_VALUE : nums1[partitionX];

        int maxY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
        int minY = partitionY == y ? Integer.MAX_VALUE : nums2[partitionY];

        if(maxX <= minY && maxY <= minX)
        {
            if((x + y) % 2 == 0)
            return (double)(Math.max(maxX, maxY) + Math.min(minX, minY)) / 2;
            return Math.max(maxX, maxY);

        }

        else if(maxX > minY)
        {
            end = partitionX - 1;
        }

        else{
            start = partitionX + 1;
        }
     }

     throw new IllegalArgumentException();
        
    }
}
