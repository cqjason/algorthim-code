import java.util.Arrays;

public class RadixSort {
    public static int[] sort(int[] arr){
        int digit = 1;
        while (true){
            int[] keyArray =  new int[max(arr) + 1];
            int[] digitArray = carryDigitOf10(arr,digit);
            if(isZeroArray(digitArray)){
                break;
            }
            storeElement(digitArray, keyArray);

            // compute sorted order starting with 1
            for(int i = 1; i< keyArray.length; i++){
                keyArray[i] = keyArray[i] + keyArray[i-1];
            }

            arr = restoreElement(arr, digitArray, keyArray);
            digit ++;
        }
        return arr;
    }

    private static boolean isZeroArray(int[] arr){
        for (int value : arr){
            if(value != 0){
                return false;
            }
        }
        return true;
    }

    private static int[] restoreElement(int[] arr, int[]digitArray, int[] keyArray) {
        int[] orderedArray = new int[arr.length];
        // restore element to orderedArray
        // reversed order traversal ensure stable
        for (int j = orderedArray.length - 1; j >=0; j--){
            //index = sorted order -1
            orderedArray[keyArray[digitArray[j]]-1] = arr[j];
            keyArray[digitArray[j]]--;
        }
        return orderedArray;
    }

    private static void storeElement(int[] digitArray,int[] keyArray) {
        // maxIndex = max(arr) --> length - 1 = max(arr) --> length = max(arr) + 1
        //store element at the corresponding index
        for (int value : digitArray) {
            keyArray[value]++;
        }
    }

    private static int[] carryDigitOf10(int[] arr, int digit){
        String[] arrStr = toString(arr);
        int[] digitArray = new int[arr.length];
        for (int i = 0; i < arrStr.length; i++){
            if(arrStr[i].length()  < digit){
                digitArray[i] = 0;
            }else {
                // as index start with 0, so index = digit - 1
                char digitNum = arrStr[i].toCharArray()[digit - 1];
                digitArray[i] = Integer.parseInt(String.valueOf(digitNum));
            }
        }
        return digitArray;
    }

    private static String[] toString(int[] arr) {
        String[] arrStr = new String[arr.length];
        for (int i = 0; i < arr.length; i++){
            arrStr[i] = String.valueOf(arr[i]);
        }
        return arrStr;
    }

    private static int max(int[] arr){
        int max = 0;
        for (int value : arr){
            if(value > max){
                max = value;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] sourceArray = new int[]{5, 1, 7, 5, 3, 11, 0, 13, 27, 25};
        System.out.println("before sorted:" + Arrays.toString(sourceArray));
        System.out.println("after sorted:" + Arrays.toString(sort(sourceArray)));
    }
}
