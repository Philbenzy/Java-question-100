package my_work.test2;
// 消费者
public class MyGet implements Runnable{
    private MyStudent ms;

    MyGet(MyStudent ms){
        this.ms = ms;
    }

    @Override
    public void run() {
        while (true){
            synchronized (ms){
                if(!ms.flag){ // 如果那边准备好了的话，那么这里就需要开始等待或者消费
                    try {
                        ms.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    System.out.println(ms.name+"- - - -"+ms.age);
                    ms.flag = false;
                    ms.notify();
                }
            }
        }
    }
}
