public class MyPhoneDemo {
    public static void main(String[] args) {
        MyPhone mp = new MyPhone();
        System.out.println(mp.getBrand()+"---"+mp.getColor()+"---"+mp.getPrice());
        // ´«µÝ²ÎÊý
        mp.setBrand("apple");
        mp.setColor("black");
        mp.setPrice(6999);

        System.out.println(mp.getBrand()+"---"+mp.getColor()+"---"+mp.getPrice());
    }
}


class MyPhone{
    private int price;
    private String color;
    private String brand;

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public void setColor(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    }

    public void setBrand(String brand){
        this.brand=brand;
    }

    public String getBrand(){
        return brand;
    }
}