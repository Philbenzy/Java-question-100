//数组元素查找(查找指定元素第一次在数组中出现的索引)

public class FindIndex {
    public static void main(String[] args) {
        int[] arr = {250,250,3,45,567,23,678,686,11,1};
        int n = 1111;
        int index = findIIndex(arr,n);
        System.out.println("数字"+n+"第一次出现的索引为："+index);
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
