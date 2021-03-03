package my_work.Factory;

public class FactoryDemo {
    public static void main(String[] args) {
        Factory f = new DogFactory();

        Animal a = f.createAnimal();
        a.eat();

        f = new CatFactory();

        Animal b = f.createAnimal();
        b.eat();
    }
}
