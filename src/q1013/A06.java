package q1013;

/**
 * @author miaow
 */
public class A06 {
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

    //第五次通过但时间太长了，遍历时就计算
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
        int curSum = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            curSum = curSum + arr[i];
            if (curSum == equalParts) {
                if (flag) {
                    return i <= arr.length - 2;
                } else {
                    curSum = 0;
                    flag = true;
                }
            }
        }
        return false;
    }
}
