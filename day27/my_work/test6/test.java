package test6;

public class test {
    public static void main(String[] args) {
        Direction d1 = Direction.LEFT;
        Direction d2 = Direction.BEHIND;
        Direction d3 = Direction.RIGHT;
        Direction d4 = Direction.FRONT;

        d1.show();
        d2.show();
        d3.show();
        System.out.println(d1.compareTo(d2));

        System.out.println(" - - - ");
        Direction[] dir = Direction.values();
        for (Direction d : dir){
            System.out.println(d);
            System.out.println(d.name());
        }
    }
}
