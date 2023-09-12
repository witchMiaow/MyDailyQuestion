package q949;

import java.util.Arrays;

/**
 * @author miaow
 */
public class A01 {
    public static void main(String[] args) {
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
    }

    public static String largestTimeFromDigits(int[] arr) {
        // 先从小到大排序
        Arrays.sort(arr);

        // 排除掉无法拼装成时间小时数的情况
        if (arr[0] > 2 || (arr[0] == 2 && arr[1] > 3)) {
            return "";
        }
        // 先确定第一位和第二位
        int index1 = getMaxIndex(arr, 2);
        int index2;
        int[] arr2 = getNewAry(arr, index1);
        if (arr[index1] == 2) {
            // 确定第二位
            index2 = getMaxIndex(arr2, 4);
        } else {
            // 确定第二位
            index2 = getMaxIndex(arr2, 9);
        }

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
        if (value3 > value4 && value3 <= 5) {
            return result + ":" + value3 + value4;
        } else {
            return result + ":" + value4 + value3;
        }
    }

    /**
     * 获取数组内最大的数, 不能超过maxValue
     *
     * @param arr      数组
     * @param maxValue 界限
     * @return 最大数的下标
     */
    private static int getMaxIndex(int[] arr, int maxValue) {
        int max = 0;
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= maxValue) {
                if (arr[i] >= max) {
                    max = arr[i];
                    index = i;
                }
            }
        }
        return index;
    }

    /**
     * 排除掉下标构建新数组
     *
     * @param arr   原数组
     * @param index 需要排除掉的下标
     * @return 新数组
     */
    private static int[] getNewAry(int[] arr, int index) {
        int[] result = new int[arr.length - 1];
        int flag = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != index) {
                result[flag++] = arr[i];
            }
        }
        return result;
    }
}
