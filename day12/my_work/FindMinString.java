package my_work;
/*方法说明：本方法是用来查找字符串出现次数的方法

* indexOf:返回查找的字符串第一次出现的索引位置
* substring:切割字符串
* */
public class FindMinString {
    public static void main(String[] args) {
        String maxString = "woaijavawozhenaijavawozhendeaijavawozhendehenaijavaxinbuxinwoaijavagun";
        String myString = "java";
        System.out.println("查找的字符串其中出现了： "+findMethod(maxString,myString)+" 次！");

    }

    public static int findMethod(String maxString, String myString){
        int index;
        int count = 0;
        while ((index = maxString.indexOf(myString)) != -1){
            count++;
            maxString = maxString.substring(index + myString.length());
        }
        return count;
    }
}
