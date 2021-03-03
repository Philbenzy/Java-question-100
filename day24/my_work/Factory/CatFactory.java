package my_work.Factory;

public class CatFactory implements Factory{
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}
