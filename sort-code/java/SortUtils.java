/**
 * @author jasonCQ
 * @version 1.0
 * @date 2019/12/3 18:39
 */
public class SortUtils {
    public static void swapIntArray(int[] a, int index1, int index2){
        a[index1] = a[index1]^a[index2];
        a[index2] = a[index1]^a[index2];
        a[index1] = a[index1]^a[index2];
    }
}
