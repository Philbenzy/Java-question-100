
public class ArrayDemo12 {
    public static void main(String[] args) {
        int[] a = new int[3];
        System.out.println(a);//[I@48140564

        // ¶¯Ì¬³õÊ¼»¯
        int[] b = {4,5,6,7,8,9,0};

        System.out.println(b);
        // ArrayIndexOutOfBoundsException
        System.out.println(b.length);
        System.out.println("- - - - - - ");

        for (int i=0;i<b.length;i++){
            System.out.print(b[i]+",");
        }
    }
}
