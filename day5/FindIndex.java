//����Ԫ�ز���(����ָ��Ԫ�ص�һ���������г��ֵ�����)

public class FindIndex {
    public static void main(String[] args) {
        int[] arr = {250,250,3,45,567,23,678,686,11,1};
        int n = 1111;
        int index = findIIndex(arr,n);
        System.out.println("����"+n+"��һ�γ��ֵ�����Ϊ��"+index);
    }
    public static int findIIndex(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n){
                return i;
            }
        }
        return -1;
    }
}
