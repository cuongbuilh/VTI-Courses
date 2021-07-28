package entity;

abstract public class Student {
    public static int numOfStudent = 0;
    private static String college;
    private static long moneyGroup;

    private int id;
    private String name;

    public Student() throws OverStudentException {
        if (numOfStudent >= 7) throw new OverStudentException();
        numOfStudent++;
    }

    public Student(int id, String name) throws OverStudentException {
        if (numOfStudent >= 7) throw new OverStudentException();
        this.id = id;
        this.name = name;
        numOfStudent++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void nopQuy(long l) {
        if (l < 0) return;
        moneyGroup += l;
        System.out.printf("%s nop quy +%d, tong quy = %,d\n", name, l, moneyGroup);
    }

    public static long getMoneyGroup() {
        return moneyGroup;
    }

    public static void setMoneyGroup(long moneyGroup) {
        Student.moneyGroup = moneyGroup;
    }

    public void rutQuy(long l) {
        if (l > moneyGroup) {
            System.out.printf("quy khong du - (%,d)\n", moneyGroup);
            return;
        }
        moneyGroup -= l;
        System.out.printf("%s rut quy -%d, tong quy = %,d\n", name, l, moneyGroup);

    }

    public static String getCollege() {
        return college;
    }

    public static void setCollege(String college) {
        Student.college = college;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                "college=" + college +
                '}';
    }

    public abstract void study();
}
