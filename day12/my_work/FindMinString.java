package my_work;
/*����˵���������������������ַ������ִ����ķ���

* indexOf:���ز��ҵ��ַ�����һ�γ��ֵ�����λ��
* substring:�и��ַ���
* */
public class FindMinString {
    public static void main(String[] args) {
        String maxString = "woaijavawozhenaijavawozhendeaijavawozhendehenaijavaxinbuxinwoaijavagun";
        String myString = "java";
        System.out.println("���ҵ��ַ������г����ˣ� "+findMethod(maxString,myString)+" �Σ�");

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
