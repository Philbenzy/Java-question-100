/*
 * ������ת�����б��ӡ�Ĺ���
 * */
package my_work;

public class GetListTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        String s = "";
        s += "[";
        for (int x = 0; x < arr.length; x++) {
            if (x == arr.length - 1) {
                s += arr[x];
                s += "]";
            } else {
                s += arr[x];
                s += " ,";
            }
        }
        System.out.println("����ƴ�ӵĽ��Ϊ��" + s);
        System.out.println("ʹ�÷�������ƴ�ӵĽ��Ϊ��" + arrayToString(arr));
    }


    public static String arrayToString(int[] arr) {
        String s = "";
        s += "[";
        for (int x = 0; x < arr.length; x++) {
            if (x == arr.length - 1) {
                s += arr[x];
                s += "]";
            } else {
                s += arr[x];
                s += " ,";
            }
        }
        return s;
    }
}
