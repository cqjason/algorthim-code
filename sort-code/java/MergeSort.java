import java.util.Arrays;

/**
 * @author jasonCQ
 * @version 1.0
 * @date 2019/12/4 16:01
 */
public class MergeSort {
    public static void mergeSortRecursion(int[] src, int[] dest, int low, int high) {
        if (high == low) {
            return;
        }
        if (high - low == 1) {
            if (src[low] > src[high]) {
                SortUtils.swapIntArray(dest, low, high);
            }
            return;
        }

        // Low + high always is positive
        int mid = (low + high) >>> 1;
        mergeSortRecursion(dest, src, low, mid);
        mergeSortRecursion(dest, src, mid + 1, high);

        //If list is already sorted, just copy from src to dest
        if (src[mid] < src[mid + 1]) {
            System.arraycopy(src, low, dest, low, high - low + 1);
            return;
        }

        for (int i = low, lowRef = low, highRef = mid + 1; i <= high; i++) {
            // ”lowRef > mid“ ： As lowArray is token wholly, just take highArray
            if (lowRef > mid || (highRef <= high && src[highRef] < src[lowRef]) ) {
                dest[i] = src[highRef++];
            } else {
                dest[i] = src[lowRef++];
            }
        }
    }

    public static void main(String[] args) {
        int[] sourceArray = new int[]{5, 1, 7, 3, 9, 4, 6};
        int[] sortedArray = new int[sourceArray.length];
        System.arraycopy(sourceArray, 0, sortedArray, 0, sourceArray.length);
        System.out.println("before sorted:" + Arrays.toString(sourceArray));
        mergeSortRecursion(sourceArray, sortedArray, 0, sourceArray.length - 1);
        System.out.println("after sorted:" + Arrays.toString(sortedArray));
    }
}
