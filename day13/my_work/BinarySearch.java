package my_work;

/*
 * 二分查找
 * 注意：这样的查找只局限于有序的数组，才可以使用
 * max:最大处的索引
 * min:最小索引
 * mid:中间索引
 * */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 8, 11, 22, 33, 44, 55, 66};

        int index = binSearch(arr, 77);
        System.out.println("查找索引：" + index);

    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int x = 0; x < arr.length; x++) {
            if (x == arr.length - 1) {
                System.out.print(arr[x]);
            } else {
                System.out.print(arr[x] + ", ");
            }
        }
        System.out.print("]");
    }

    public static int binSearch(int[] arr, int value) {
        int min = 0;
        int max = arr.length - 1;

        int mid = (min + max) / 2;
        while (value != arr[mid]) {
            if (arr[mid] > value) {
                max = mid - 1;
            } else {
                min = min + 1;
            }
            mid = (min + max) / 2;

            if (min > max) {
                System.out.println("结果不存在！");
                return -1;
            }
        }

        return mid;
    }
}
