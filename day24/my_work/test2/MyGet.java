package my_work.test2;
// ������
public class MyGet implements Runnable{
    private MyStudent ms;

    MyGet(MyStudent ms){
        this.ms = ms;
    }

    @Override
    public void run() {
        while (true){
            synchronized (ms){
                if(!ms.flag){ // ����Ǳ�׼�����˵Ļ�����ô�������Ҫ��ʼ�ȴ���������
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
