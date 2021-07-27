import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public  static void sort(int[] arr, int left, int right){
        if(left < right){
            int position = partition(arr,left,right);
            sort(arr,left,position);
            sort(arr,position+1,right);
        }
    }

    public static int partition(int[] arr, int left, int right){
        int pivot = arr[left];
//        while (left < right){
//            while (left < right && arr[right] >= pivot){
//                right --;
//            }
//            arr[left] = arr[right];
//            while (left < right && arr[left] < pivot){
//                left ++;
//            }
//            arr[right] = arr[left];
//        }
//        arr[left] = pivot;
//        return left;
        int i = left;
        for( int j = left+ 1; j < right; j++){
            if(arr[j] < pivot){
                SortUtils.swapIntArray(arr,++i, j);
            }

        }
        SortUtils.swapIntArray(arr,left,i);
        return i;
    }

    public static int randomPartition(int[] arr, int left, int right){
        Random random = new Random();
        int pivotIndex = random.nextInt(right - left) + left;
        SortUtils.swapIntArray(arr,left,pivotIndex);
        return partition(arr,left,right);
    }



    public static void main(String[] args) {
        int[] sourceArray = new int[]{5, 1, 7, 5, 3, 9, 1, 4, 6};
        System.out.println("before sorted:" + Arrays.toString(sourceArray));
        sort(sourceArray,0,sourceArray.length-1);
        System.out.println("after sorted:" + Arrays.toString(sourceArray));
    }
}
