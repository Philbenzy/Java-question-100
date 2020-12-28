public class MyPhoneDemo {
    public static void main(String[] args) {
        MyPhone mp = new MyPhone();
        System.out.println(mp.color+mp.name+mp.price);

        mp.color="黄色";
        mp.name = "啊哈哈";
        mp.price = 1800;
        System.out.println(mp.color+mp.name+mp.price);

        mp.call("王所银");
        mp.groundMsessage();
        mp.sendMessage();
        System.out.println(mp);//MyPhone@5315b42e
    }
}

class MyPhone{
    String name;
    int price;
    String color;

    public void call(String name){
        System.out.println("给"+name+"打电话！");
    }
    public void sendMessage(){
        System.out.println("发短信。。。");
    }
    public void groundMsessage(){
        System.out.println("短信群发...");
    }
}
