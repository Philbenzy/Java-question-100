import java.sql.SQLOutput;

public class HeartDemo {
    public static void main(String[] args) {
        People.Body heart = new People().new Body();
        heart.beating();
        heart.opterator();
    }
}


class People{
    class Body{
        public void beating(){
            System.out.println("心脏跳动");
        }

        public void opterator(){
            System.out.println("进行心脏搭桥");
        }
    }
}

