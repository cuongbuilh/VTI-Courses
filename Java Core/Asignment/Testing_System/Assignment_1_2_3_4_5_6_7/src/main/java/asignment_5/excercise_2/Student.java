package asignment_5.excercise_2;

public class Student implements IStudent {
    private int id;
    private String name;
    private int group;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public void diemDanh() {
        System.out.println(name + " da diem danh");
    }

    @Override
    public void hocBai() {
        System.out.println(name + " da hoc bai");
    }

    @Override
    public void donVeSinh() {
        System.out.println(name + " da don ve sinh");
    }


}
