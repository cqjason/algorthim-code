import java.util.Arrays;

/**
 * @author jasonCQ
 * @version 1.0
 * @date 2019-12-3 18:30
 */
public class BubbleSort {
    public static int[] sort(int[] sourceArray) {
        for (int i = 0; i < sourceArray.length; i++) {
            for (int j = 0; j < sourceArray.length - i; j++) {
                if (j < sourceArray.length - 1 && sourceArray[j] > sourceArray[j + 1]) {
                    sourceArray[j] = sourceArray[j] ^ sourceArray[j + 1];
                    sourceArray[j + 1] = sourceArray[j] ^ sourceArray[j + 1];
                    sourceArray[j] = sourceArray[j] ^ sourceArray[j + 1];
                }
            }
        }
        return sourceArray;
    }

    public static void main(String[] args) {
        int[] sourceArray = new int[]{5, 1, 7, 2, 8, 4, 6};
        System.out.println("before sorted:" + Arrays.toString(sourceArray));
        int[] soertedArray = sort(sourceArray);
        System.out.println("after sorted:" + Arrays.toString(soertedArray));
    }
}
