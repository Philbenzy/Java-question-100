public class MyPhoneDemo {
    public static void main(String[] args) {
        MyPhone mp = new MyPhone();
        System.out.println(mp.color+mp.name+mp.price);

        mp.color="��ɫ";
        mp.name = "������";
        mp.price = 1800;
        System.out.println(mp.color+mp.name+mp.price);

        mp.call("������");
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
        System.out.println("��"+name+"��绰��");
    }
    public void sendMessage(){
        System.out.println("�����š�����");
    }
    public void groundMsessage(){
        System.out.println("����Ⱥ��...");
    }
}
