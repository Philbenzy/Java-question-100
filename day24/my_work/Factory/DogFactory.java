package my_work.Factory;

public class DogFactory implements Factory {
    @Override
    public Dog createAnimal() {
        return new Dog();
    }
}
