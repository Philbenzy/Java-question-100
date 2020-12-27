public class PrintStars {
    public static void main(String[] args) {
        print_nn(15,10);
    }

    public static void print_nn(int a, int b){
        for (int i=0;i<a;i++){
            for (int j=0;j<b;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
