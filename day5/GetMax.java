public class GetMax {
    public static void main(String[] args) {
        int[] arr = {123,45,86,250,45,686};
        int max = getMax(arr);
        System.out.println("数组中的最大元素是"+max);
    }

    public static int getMax(int[] arr){
        int max = arr[0];

        for(int i=0;i<arr.length;i++){
            if (arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }
}
