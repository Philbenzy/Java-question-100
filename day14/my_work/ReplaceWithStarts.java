package my_work;

public class ReplaceWithStarts {
    public static void main(String[] args) {
        String s = "ainiwsy1998yunnansdwttsv1122334455";
        String regex = "\\d"; // ±íÊ¾Êý×Ö

        String result = s.replaceAll(regex,"*");
        System.out.println(result);
    }
}
