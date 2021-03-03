package my_work.test3;

// Ë½ÓÐ»¯ÐÞ¸Ä°æ

public class MyStudent2 {
    private String name;
    private int age;
    private boolean flag;

    public synchronized void set(String name, int age){
        if (this.flag){
            try{
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.age = age;
        this.name = name;
        this.flag = true;
        this.notify();

    }

    public synchronized void get(){
        if (!this.flag){
            try{
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.name+" - - "+this.age);
        this.flag = false;
        this.notify();

    }
}
