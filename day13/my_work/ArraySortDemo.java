package my_work;

public class ArraySortDemo {
    public static void main(String[] args) {
        int[] arr = {33, 44, 25, 47, 87};
        System.out.print("≈≈–Ú«∞£∫");
        printArray(arr);
        System.out.println();
        System.out.print("≈≈–Ú∫Û£∫");
        bubbleSort(arr);
        printArray(arr);

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

    public static void bubbleSort(int[] arr) {
        for (int x = 0;x<arr.length-1; x++){
            for (int y=0;y<arr.length-1-x;y++){
                if (arr[y]>arr[y+1]){
                    int temp = arr[y+1];
                    arr[y+1] = arr[y];
                    arr[y] = temp;
                }
            }
        }
    }
}
