package test7;

import java.util.Date;

public abstract class Pattern {
    public long getTime(){
        long startTime = System.currentTimeMillis();

        code(); // �Զ���ķ���

        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }

    public abstract void code();
}
