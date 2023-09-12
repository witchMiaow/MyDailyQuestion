package q949;

import java.util.Arrays;

/**
 * @author miaow
 */
public class A04 {


    /**
     * 查看答案
     */
    public static void main(String[] args) {
        int[] array5 = {0, 0, 3, 0};
        String result5 = largestTimeFromDigits(array5);
        System.out.println("result: 03:00, actual: " + result5);
        int[] array = {1, 2, 3, 4};
        String result1 = largestTimeFromDigits(array);
        System.out.println("result: 23:41, actual: " + result1);
        int[] array2 = {5, 5, 5, 5};
        String result2 = largestTimeFromDigits(array2);
        System.out.println("result:  , actual: " + result2);
        int[] array3 = {0, 0, 0, 0};
        String result3 = largestTimeFromDigits(array3);
        System.out.println("result: 00:00, actual: " + result3);
        int[] array4 = {0, 0, 1, 0};
        String result4 = largestTimeFromDigits(array4);
        System.out.println("result: 10:00, actual: " + result4);
        int[] array6 = {1, 9, 6, 0};
        String result6 = largestTimeFromDigits(array6);
        System.out.println("result: 19:06, actual: " + result6);
        int[] array7 = {2, 0, 6, 6};
        String result7 = largestTimeFromDigits(array7);
        System.out.println("result: 06:26, actual: " + result7);
        int[] array8 = {0, 0, 0, 2};
        String result8 = largestTimeFromDigits(array8);
        System.out.println("result: 20:00, actual: " + result8);
    }

    public static String largestTimeFromDigits(int[] A) {
        Arrays.sort(A);
        for (int i = 3; i >= 0; i--) {
            if (A[i] > 2) continue;
            for (int j = 3; j >= 0; j--) {
                if (j == i || A[i] == 2 && A[j] > 3) continue;
                for (int k = 3; k >= 0; k--) {
                    if (k == i || k == j || A[k] > 5) continue;
                    return "" + A[i] + A[j] + ':' + A[k] + A[6 - i - j - k];
                }
            }
        }
        return "";
    }


}
