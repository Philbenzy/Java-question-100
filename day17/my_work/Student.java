package my_work;
// 按照 总分，姓名，语文成绩、数学成绩、英语成绩 进行排序

public class Student implements Comparable<Student> {
    private String name;
    private int chineseGrand;
    private int mathGrand;
    private int englishGrand;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChineseGrand(int chineseGrand) {
        this.chineseGrand = chineseGrand;
    }

    public void setMathGrand(int mathGrand) {
        this.mathGrand = mathGrand;
    }

    public void setEnglishGrand(int englishGrand) {
        this.englishGrand = englishGrand;
    }

    public int getChineseGrand() {
        return chineseGrand;
    }

    public int getMathGrand() {
        return mathGrand;
    }

    public int getEnglishGrand() {
        return englishGrand;
    }

    public Student(String name, int chineseGrand, int mathGrand, int englishGrand) {
        this.name = name;
        this.chineseGrand = chineseGrand;
        this.mathGrand = mathGrand;
        this.englishGrand = englishGrand;
    }

    public int sum() {
        return chineseGrand + mathGrand + englishGrand;
    }

    @Override
    public int compareTo(Student o) {
        int num = o.sum() - this.sum();
        int num2 = num == 0 ? this.chineseGrand - o.chineseGrand : num;
        int num3 = num2 == 0 ? this.mathGrand - o.mathGrand : num2;
        int num4 = num3 == 0 ? this.englishGrand - o.englishGrand : num3;
        int num5 = num4 == 0 ? this.name.compareTo(o.name):num4;
        return num5;
    }
}
