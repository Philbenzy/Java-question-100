package test6;
// 枚举

public enum Direction {
    FRONT("1"){
        @Override
        public void show() {
            System.out.println("hello1");
        }
    }, BEHIND("2"){
        @Override
        public void show() {
            System.out.println("hello2");
        }
    }, LEFT("前"){
        @Override
        public void show() {
            System.out.println("hello3");
        }
    }, RIGHT("3"){
        @Override
        public void show() {
            System.out.println("hello4");
        }
    };

    private String name;

    private Direction(String s) {
        this.name = s;
    }

    public abstract void show();
}
