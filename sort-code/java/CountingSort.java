import java.util.Arrays;

//自然数排序(包含0)
//example: input: {5,1,1,2,4,4,3}   imply index start with 1
//         keyArray:{0,2,1,1,2,1} -->  {0,2,3,4,6,7}
//         orderedArray:              {1,1,2,3,4,4,5}
public class CountingSort {
    public static int[] sort(int[] arr) {
        // maxIndex = max(arr) --> length - 1 = max(arr) --> length = max(arr) + 1
        int[] keyArray =  new int[max(arr) + 1];
        //store element at the corresponding index
        for (int value : arr) {
            keyArray[value]++;
        }

        // compute sorted order starting with 1
        for(int i = 1; i< keyArray.length; i++){
            keyArray[i] = keyArray[i] + keyArray[i-1];
        }

        int[] orderedArray = new int[arr.length];
        // restore element to orderedArray
        // reversed order traversal ensure stable
        for (int j = orderedArray.length - 1; j >=0; j--){
            //index = sorted order -1
            orderedArray[keyArray[arr[j]]-1] = arr[j];
            keyArray[arr[j]]--;
        }

        return orderedArray;
    }

    public static int max(int[] arr){
        int max = 0;
        for (int value : arr){
            if(value > max){
                max = value;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] sourceArray = new int[]{5, 1, 7, 5, 3, 9, 0, 1, 4, 6};
        System.out.println("before sorted:" + Arrays.toString(sourceArray));
        System.out.println("after sorted:" + Arrays.toString(sort(sourceArray)));
    }
}
