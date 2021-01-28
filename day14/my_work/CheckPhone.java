package my_work;
/**
 * 默认的，手机号码一般采用1开头
 * （2）第二位为[3568]数字
 * （3）手机号码长度是11位*/
public class CheckPhone {
    public static void main(String[] args) {
        String phoneNumber = "17712345678";
        String regex = "1[3568]\\d{9}";
        boolean result = phoneNumber.matches(regex);
        System.out.println("是否为我们需要的手机号码？ "+result);
    }
}
