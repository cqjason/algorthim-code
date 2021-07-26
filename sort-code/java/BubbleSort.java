import java.util.Arrays;

/**
 * @author jasonCQ
 * @version 1.0
 * @date 2019-12-3 18:30
 */
public class BubbleSort {
    public static int[] sort(int[] sourceArray) {
        //executions
        for (int i = 1; i < sourceArray.length; i++) {
            //At every execution, 'j' is startIndex,'len  -i' is endIndex
            for (int j = 0; j < sourceArray.length - i; j++) {
                if (sourceArray[j] > sourceArray[j + 1]) {
                    SortUtils.swapIntArray(sourceArray,j,j+1);
                }
            }
        }
        return sourceArray;
    }

    public static void main(String[] args) {
        int[] sourceArray = new int[]{5, 1, 7, 2, 8, 4, 6};
        System.out.println("before sorted:" + Arrays.toString(sourceArray));
        int[] sortedArray = sort(sourceArray);
        System.out.println("after sorted:" + Arrays.toString(sortedArray));
    }
}
