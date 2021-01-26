// —°‘Ò≈≈–Ú∑®
package my_work;

public class ArraySearchDemo {
    public static void main(String[] args) {
        int[] arr = {22,33,98,43,1,43};
        System.out.print("≈≈–Ú«∞£∫");
        printArray(arr);

        System.out.println();

        searchSort(arr);
        System.out.print("≈≈–Ú∫Û£∫");
        printArray(arr);
    }

    public static void searchSort(int[] arr) {
        for (int x = 0; x < arr.length - 1; x++) {
            for (int y = x+1;y<arr.length;y++){
                if (arr[x]>arr[y]){
                    int temp = arr[x];
                    arr[x] = arr[y];
                    arr[y] = temp;
                }
            }
        }
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
}
