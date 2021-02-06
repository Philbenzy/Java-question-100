package my_work;

import java.util.Objects;

public class MyStudent {
    private String name;
    private int age;

    public MyStudent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyStudent)) return false;
        MyStudent myStudent = (MyStudent) o;
        return age == myStudent.age &&
                Objects.equals(name, myStudent.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
