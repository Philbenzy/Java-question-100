class Demo{
    public static void main(String[] args){
        MakeStudent ms = new MakeStudent();
        Student s = ms.getStudent();
        s.method();
    }
}

class Student{
    public void method(){
        System.out.println("学习Java");
    }
}

class MakeStudent{
    public Student getStudent(){
        return new Student();
    }

}
