package my_work.test1;
// 死锁问题复现

public class MyDieLock extends Thread{
    private boolean flag;

    MyDieLock(boolean flag){
        this.flag = flag;
    }

    // 死锁代码
    @Override
    public void run() {
        if (flag){
            synchronized (MyLock.obj1){
                System.out.println("if obj1");
                synchronized (MyLock.obj2){
                    System.out.println("if obj2");
                }
            }
        }else {
            synchronized (MyLock.obj2){
                System.out.println("else obj2");
                synchronized (MyLock.obj1){
                    System.out.println("else obj1");
                }
            }
        }
    }
}
