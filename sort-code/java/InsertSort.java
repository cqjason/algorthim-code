import java.util.Arrays;

/**
 * @author jasonCQ
 * @version 1.0
 * @date 2019/12/3 18:39
 */
public class InsertSort {
    public static int[] sort(int[] array) {
        //executions
        for (int i = 1; i < array.length; i++) {
            //At every execution，'j' is startIndex
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                SortUtils.swapIntArray(array, j, j - 1);
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] sourceArray = new int[]{5, 1, 7, 3, 9, 4, 6};
        System.out.println("before sorted:" + Arrays.toString(sourceArray));
        int[] sortedArray = sort(sourceArray);
        System.out.println("after sorted:" + Arrays.toString(sortedArray));
    }
}
