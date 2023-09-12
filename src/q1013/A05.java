package q1013;

/**
 * @author miaow
 */
public class A05 {
    public static void main(String[] args) {
        int[] arr1 = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        System.out.println("result: true, actual: " + canThreePartsEqualSum(arr1));
        int[] arr2 = {0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1};
        System.out.println("result: false,actual: " + canThreePartsEqualSum(arr2));
        int[] arr3 = {3, 3, 6, 5, -2, 2, 5, 1, -9, 4};
        System.out.println("result: true, actual: " + canThreePartsEqualSum(arr3));
        int[] arr4 = {0, 0, 0, 0};
        System.out.println("result: true, actual: " + canThreePartsEqualSum(arr4));
        int[] arr5 = {18, 12, -18, 18, -19, -1, 10, 10};
        System.out.println("result: true, actual: " + canThreePartsEqualSum(arr5));
        int[] arr6 = {1, -1, 1, -1};
        System.out.println("result: false,actual: " + canThreePartsEqualSum(arr6));
    }

    //第四次通过但时间太长了，改为循环一次数组
    public static boolean canThreePartsEqualSum(int[] arr) {
        // 先判断是否能被3整除
        int sum = 0;
        for (int i : arr) {
            sum = sum + i;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int equalParts = sum / 3;
        int flag = -1;
        for (int i = 0; i < arr.length; i++) {
            // 判断是否等于等分的值
            if (flag >= 0 && flag <= arr.length - 3 && i <= arr.length - 2) {
                // 判断第二部分是否相等，第三部分不用判断
                int[] arr2 = new int[i - flag];
                System.arraycopy(arr, flag + 1, arr2, 0, i - flag);
                int sum2 = 0;
                for (int num : arr2) {
                    sum2 = sum2 + num;
                }
                if (equalParts == sum2) {
                    return true;
                }
            } else {
                int[] arr1 = new int[i + 1];
                System.arraycopy(arr, 0, arr1, 0, i + 1);
                int sum1 = 0;
                for (int num : arr1) {
                    sum1 = sum1 + num;
                }
                if (sum1 == equalParts) {
                    flag = i;
                }
            }
        }
        return false;
    }
}
