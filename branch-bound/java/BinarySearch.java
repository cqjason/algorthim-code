public class BinarySearch {
    public static int search(int[] source, int target,int left, int right){
        // when left == right, it's possible that source[left] ==source[right] == target
        while (left <= right){
            int middle = (left + right) >>> 1;
            if(source[middle] == target){
                return middle;
            }else if(source[middle] > target){
                // remove source[middle]
                right = middle - 1;
            }else {
                // remove source[middle]
                left = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] source = new int[]{1, 3, 4, 5, 6, 7, 9, 14, 18};
        System.out.printf("%d is found at position %d", 20 , search(source,20,0,source.length-1));
    }
}
