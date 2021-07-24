package asignment_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise_5 {
    enum Gender {
        NAM, NU, OTHER
    }

    static class Person {
        protected String name;
        protected int age;
        protected Gender gender;

        public Person() {
        }

        public Person(String name, int age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    '}';
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

        public Gender getGender() {
            return gender;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }
    }

    class Worker extends Person {
        private int level;

        public Worker(int level) {
            this.level = level;
        }

        public Worker(String name, int age, Gender gender, int level) {
            super(name, age, gender);
            this.level = level;
        }

        @Override
        public String toString() {
            return "Worker{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    ", level=" + level +
                    '}';
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }
    }

    class Engineer extends Person {
        private String branch;

        public Engineer(String branch) {
            this.branch = branch;
        }

        public Engineer(String name, int age, Gender gender, String branch) {
            super(name, age, gender);
            this.branch = branch;
        }

        @Override
        public String toString() {
            return "Engineer{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    ", branch='" + branch + '\'' +
                    '}';
        }

        public String getBranch() {
            return branch;
        }

        public void setBranch(String branch) {
            this.branch = branch;
        }
    }

    class Staff extends Person {
        private String work;

        @Override
        public String toString() {
            return "Staff{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    ", work='" + work + '\'' +
                    '}';
        }

        public String getWork() {
            return work;
        }

        public void setWork(String work) {
            this.work = work;
        }

        public Staff(String work) {
            this.work = work;
        }

        public Staff(String name, int age, Gender gender, String work) {
            super(name, age, gender);
            this.work = work;
        }
    }

    static class Managerment {
        List<Person> list = new ArrayList<Person>();

        public Managerment() {
        }

        public int add(Person person) {
            try {
                list.add(person);
                return 1;
            } catch (Exception ignore) {
            }
            return 0;
        }

        public List<Person> find(String name) {
            List<Person> result = new ArrayList<Person>();
            for (Person p : list) {
                if (p.name.equals(name))
                    result.add(p);
            }
            return result;
        }

        public void show() {
            for (Person p : list) {
                System.out.println(p.toString());
            }
        }

        public int remove(String name) {
            if (name == null) return 0;

            int count = 0;
            for (int i=0; i < list.size(); i++) {
                if(list.get(i).getName().equals(name)){
                    list.remove(i);
                    i--;
                    count++;
                }
            }
            return count;
        }
    }

    static boolean menu(Managerment managerment) {

        Scanner sc = new Scanner(System.in);
        System.out.println("================");
        System.out.println("manager contronler:");
        System.out.println(" 1, add");
        System.out.println(" 2, search");
        System.out.println(" 3, show");
        System.out.println(" 4, delete");
        System.out.println(" other exit");
        System.out.print("> ");
        char c = sc.nextLine().charAt(0);


        switch (c) {
            case '1':
                // TO-DO
                managerment.add(new Person("a"));
                break;
            case '2':
                // TO-DO
                System.out.println(managerment.find("a").toString());
                break;
            case '3':
                // TO-DO
                managerment.show();
                break;
            case '4':
                // TO-DO
                managerment.remove("a");
                break;
            default:
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Managerment managerment = new Managerment();

        while (menu(managerment)) ;
        System.out.println("Bye");
    }

}
