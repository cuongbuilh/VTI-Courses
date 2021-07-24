package asignment_4;


public class Student {
    private int id;
    private String name;
    private String hometown;
    private float mark;

    public Student() {
    }

    public Student(String name, String hometown) {
        this.name = name;
        this.hometown = hometown;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public void addMark(float mark) {
        this.mark += mark;
    }

    public void show() {
        String diem;
        if (mark < 4f)
            diem = "yeu";
        else if (mark < 6f)
            diem = "trung binh";
        else if (mark < 8f)
            diem = "kha";
        else
            diem = "gioi";

        System.out.printf("ho ten: %s\n", this.name);
        System.out.printf("diem: %s", diem);
    }
}
