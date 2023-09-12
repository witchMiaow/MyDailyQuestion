package q1013;

/**
 * @author miaow
 */
public class A01 {
    public static void main(String[] args) {
        int[] arr1 = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        System.out.println("result: true, actual: " + canThreePartsEqualSum(arr1));
        int[] arr2 = {0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1};
        System.out.println("result: false,actual: " + canThreePartsEqualSum(arr2));
        int[] arr3 = {3, 3, 6, 5, -2, 2, 5, 1, -9, 4};
        System.out.println("result: true, actual: " + canThreePartsEqualSum(arr3));
    }

    public static boolean canThreePartsEqualSum(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (i <= arr.length - 3) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (j <= arr.length - 2) {
                        int[] arr1 = new int[i + 1];
                        int[] arr2 = new int[j - i];
                        int[] arr3 = new int[arr.length - j - 1];
                        System.arraycopy(arr, 0, arr1, 0, i + 1);
                        System.arraycopy(arr, i + 1, arr2, 0, j - i);
                        System.arraycopy(arr, j + 1, arr3, 0, arr.length - j - 1);
                        if (equalArr(arr1, arr2, arr3)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean equalArr(int[] arr1, int[] arr2, int[] arr3) {
        int sum1 = sum(arr1);
        return sum1 == sum(arr2) && sum1 == sum(arr3);
    }

    private static int sum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum = sum + i;
        }
        return sum;
    }
}
