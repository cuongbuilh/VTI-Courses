package Excercise_3;

public class Student<T> {
    private T id;
    private String name;

    public Student(T id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    static <T> void print(T t){
        System.out.println(t);
    }

    public static void main(String[] args) {
     Student<String> st = new Student<>("if","name");
     print(st);
     print(4);
     print(4.0);
    }
}
