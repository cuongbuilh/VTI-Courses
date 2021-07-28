package backend;

import entity.*;

import java.util.ArrayList;
import java.util.List;

public class Exercise_1 {
    static Student[] students;

    public Exercise_1() {

    }

    public void q1() throws OverStudentException {
        students = new Student[3];
        students[0] = new Student(1, "nguyen van a") {
            @Override
            public void study() {

            }
        };
        students[1] = new Student(2, "nguyen van b") {
            @Override
            public void study() {

            }
        };
        students[2] = new Student(3, "nguyen van c") {
            @Override
            public void study() {

            }
        };

        Student.setCollege("dai hoc bach khoa");

        for (Student student : students) {
            System.out.println(student.toString());
        }

        Student.setCollege("dai hoc cong nghe");
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    public void q2() throws OverStudentException {
        students = new Student[3];
        students[0] = new Student(1, "nguyen van a") {
            @Override
            public void study() {

            }
        };
        students[1] = new Student(2, "nguyen van b") {
            @Override
            public void study() {

            }
        };
        students[2] = new Student(3, "nguyen van c") {
            @Override
            public void study() {

            }
        };

        for (Student student : students) {
            student.nopQuy(100000);
        }

        students[1].rutQuy(50000);
        students[1].rutQuy(20000);
        students[1].rutQuy(100000);

        for (Student student : students) {
            student.nopQuy(50000);
        }

        System.out.printf("so tien con lai la: %,d\n", Student.getMoneyGroup());
    }

    public void q3() {
        System.out.println(MyMath.min(1, 2));
        System.out.println(MyMath.sum(1, 2));
    }

    public void q4() {

    }

    public void q5() throws OverStudentException {
        students = new Student[3];
        students[0] = new Student(1, "nguyen van a") {
            @Override
            public void study() {

            }
        };
        students[1] = new Student(2, "nguyen van b") {
            @Override
            public void study() {

            }
        };
        students[2] = new Student(3, "nguyen van c") {
            @Override
            public void study() {

            }
        };

        System.out.println("so sv da tao: " + Student.numOfStudent);
    }

    public void q6() throws OverStudentException {
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new PrimaryStudent());
        studentList.add(new PrimaryStudent());
        studentList.add(new PrimaryStudent());
        studentList.add(new PrimaryStudent());

        studentList.add(new SecondaryStudent());
        studentList.add(new SecondaryStudent());

        System.out.println("student             : " + Student.numOfStudent);
        System.out.println("primary student     : " + PrimaryStudent.numOfPrimayStudent);
        System.out.println("secondary student   : " + SecondaryStudent.numOfSecondaryStudent);
    }

    public void q8(){

    }



}
