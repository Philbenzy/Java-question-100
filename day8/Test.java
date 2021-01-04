class Father {
    int age;

    public Father() {
        System.out.println("Father的无参构造方法");
    }

    public Father(String name) {
        System.out.println("Father的带参构造方法");
    }
}

class Son extends Father {
    public Son() {
        super("");
        System.out.println("Son的无参构造方法");
    }

    public Son(String name) {
        //super();
        System.out.println("Son的带参构造方法");
    }
}

class ExtendsDemo5 {
    public static void main(String[] args) {
        //创建对象
        Son s = new Son();
        System.out.println("------------");
        Son s2 = new Son("林青霞");
    }
}

// 静态代码块 构造代码块 构造方法 三者在继承时的执行顺序？   ExtendsTest2