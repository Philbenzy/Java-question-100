package my_work;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 截取一句话中三个字符串的拼音
 * 思路：
 * （1）构造正则匹配规则
 * （2）构造模式对象，传入匹配规则
 * （3）构造匹配器对象，传入字符
 * （4）接下来调用m.find方法，进行判断
 * （5）判断成功，使用m.group方法返回字符串
 * 注意：
 * （1）find方法应该在group方法返回前调用判断是否存在，再调用
 * （2)匹配器对象的group方法返回找到的字符串
 * */


public class GetThreeDemo {
    public static void main(String[] args) {
        String s = "da jia ting wo shuo,jin tian yao xia yu,bu shang wan zi xi,gao xing bu?";
        String regex = "\\b\\w{3}\\b"; // 字符按边的表示

        // 构造模式对象
        Pattern p = Pattern.compile(regex);
        // 构造匹配器对象
        Matcher m = p.matcher(s);
        while (m.find()){
            System.out.println(m.group());
        }
    }
}
