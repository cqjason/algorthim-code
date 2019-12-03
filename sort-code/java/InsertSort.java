import java.util.Arrays;

/**
 * @author jasonCQ
 * @version 1.0
 * @date 2019/12/3 18:39
 */
public class InsertSort {
    public static int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] < array[j]) {
                    array[i] = array[i] ^ array[j];
                    array[j] = array[i] ^ array[j];
                    array[i] = array[i] ^ array[j];
                    break;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] sourceArray = new int[]{5, 1, 7, 3, 9, 4, 6};
        System.out.println("before sorted:" + Arrays.toString(sourceArray));
        int[] soertedArray = sort(sourceArray);
        System.out.println("after sorted:" + Arrays.toString(soertedArray));
    }
}
