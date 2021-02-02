package my_work.genericWithInter;

public class GenericDemo2 {
    public static void main(String[] args) {
        InterImp<String> ii = new InterImp<String>();
        ii.show("hello");
        InterImp<Integer> iii = new InterImp<Integer>();
        iii.show(100);
        InterImp<Boolean> iiii = new InterImp<Boolean>();
        iiii.show(false);

    }


}
