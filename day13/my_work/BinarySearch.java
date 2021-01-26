package my_work;

/*
 * ���ֲ���
 * ע�⣺�����Ĳ���ֻ��������������飬�ſ���ʹ��
 * max:��󴦵�����
 * min:��С����
 * mid:�м�����
 * */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 8, 11, 22, 33, 44, 55, 66};

        int index = binSearch(arr, 77);
        System.out.println("����������" + index);

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
                System.out.println("��������ڣ�");
                return -1;
            }
        }

        return mid;
    }
}
