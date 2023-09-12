package q949;

/**
 * @author miaow
 */
public class A03 {

    private static int max = -1;

    /**
     * 换思路, 直接遍历所有情况, 挨个判断是否为正确格式, 如果是正确格式查找出最大值
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

    public static String largestTimeFromDigits(int[] arr) {
        permute(arr, 0);
        String res = "";

        if (max > 0) {
            int hour = max / 100;
            int min = max % 100;
            if (max > 999) {
                res = hour + ":" + (min > 9 ? min : "0" + min);
            } else if (max > 99) {
                res = "0" + hour + ":" + (min > 9 ? min : "0" + min);
            } else if (max > 9) {
                res = "00:" + max;
            } else {
                res = "00:" + "0" + max;
            }
        } else if (max == 0) {
            res = "00:00";
        }
        max = -1;
        return res;
    }

    static void permute(int[] arr, int index) {
        if (index >= arr.length - 1) {
            if (index == arr.length -1) {
                if(judgeTime(arr)){
                    int cur = arr[0] * 1000 + arr[1] * 100
                            + arr[2] * 10 + arr[3];
                    if (cur > max) {
                        max = cur;
                    }
                }

            }
        }

        for (int i = index; i < arr.length; i++) { // 单层循环，递归策略
            swap(arr, index, i); // 向后交换
            permute(arr, index + 1); //交换之后，再进行全排列操作
            swap(arr, index, i); // 向后交换
        }
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static boolean judgeTime(int[] arr) {
        int hour = arr[0] * 10 + arr[1];
        if (hour > 23) {
            return false;
        }
        int min = arr[2] * 10 + arr[3];
        return min <= 59;
    }
}
