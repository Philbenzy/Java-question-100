package my_work;

public class StringAndBuffer {
    public static void main(String[] args) {
        String s = "wzy";
        // String to buffer 方法1：调用构造方法转换
        StringBuffer sb = new StringBuffer(s);
        System.out.println("字符缓冲区类型:" + sb);

        // buffer to String 方法1：调用buffer方法进行反转
        String s2 = sb.toString();
        System.out.println("字符串类型：" + s2);

        //String to buffer 方法2：调用append方法完成
        StringBuffer sb2 = new StringBuffer();
        sb2.append(s);
        System.out.println("字符缓冲区类型:" + sb2);

        // buffer to String 方法2：调用构造方法
        String s3 = new String(s);
        System.out.println("字符串类型"+s3);

    }
}
