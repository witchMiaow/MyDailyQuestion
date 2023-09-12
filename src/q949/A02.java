package q949;

import java.util.Arrays;

/**
 * @author miaow
 */
public class A02 {
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
    }

    public static String largestTimeFromDigits(int[] arr) {
        // 先从小到大排序
        Arrays.sort(arr);

        // 排除掉无法拼装成时间小时数的情况
        if (arr[0] > 2 || (arr[0] == 2 && arr[1] > 3)) {
            return "";
        }
        // 先确定第一位和第二位
        int index1 = getMaxIndex(arr, 2, -1);
        int index2;
        if (arr[index1] == 2) {
            // 确定第二位
            index2 = getMaxIndex(arr, 3, index1);
        } else {
            // 确定第二位
            index2 = getMaxIndex(arr, 9, index1);
        }
        // 错误地方, index2应该取arr的下标, 实际取了arr2

        // 判断第三第四位
        int value3 = -1, value4 = -1;
        for (int i = 0; i < arr.length; i++) {
            if (i != index1 && i != index2) {
                if (value3 < 0) {
                    value3 = arr[i];
                } else {
                    value4 = arr[i];
                }
            }
        }
        // 无法组装成分钟数
        if (value3 > 5 && value4 > 5) {
            return "";
        }
        String result = arr[index1] + "" + arr[index2];
        if (value3 >= 6) {
            return result + ":" + value4 + value3;
        } else if (value4 >= 6) {
            return result + ":" + value3 + value4;
        } else if (value3 > value4) {
            return result + ":" + value3 + value4;
        } else {
            return result + ":" + value4 + value3;
        }
    }

    /**
     * 获取数组内最大的数, 不能超过maxValue
     *
     * @param arr           数组
     * @param maxValue      界限
     * @param ExcludedIndex 需要排除掉的下标
     * @return 最大数的下标
     */
    private static int getMaxIndex(int[] arr, int maxValue, int ExcludedIndex) {
        int max = 0;
        int index = 0;
        // 错误地方: 这里的i取1了, 应该取0
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= maxValue && i != ExcludedIndex) {
                if (arr[i] >= max) {
                    max = arr[i];
                    index = i;
                }
            }
        }
        return index;
    }
}
