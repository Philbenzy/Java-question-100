interface Inter {
    void show();
}

class Outer {
    //²¹Æë´úÂë
    public static Inter method() {
        return new Inter() {
            public void show() {
                System.out.println("HelloWorld");
            }
        };
    }
}

class OuterDemo {
    public static void main(String[] args) {
        Outer.method().show(); //"HelloWorld"
    }
}