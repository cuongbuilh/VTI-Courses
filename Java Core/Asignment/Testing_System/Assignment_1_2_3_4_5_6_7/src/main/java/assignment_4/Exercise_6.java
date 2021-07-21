package assignment_4;

import java.util.ArrayList;

public class Exercise_6 {
    static class Contact {
        protected String number;
        protected String name;

        public Contact() {
        }

        public Contact(String name, String number) {
            this.number = number;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Contact{" +
                    "number='" + number + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    abstract static class Phone {
        protected ArrayList<Contact> contacts = new ArrayList<Contact>();

        abstract void insertContact(String name, String phone);

        abstract void removeContact(String name);

        abstract void updateContact(String name, String newPhone);

        abstract void searchContact(String name);

    }

    static class VietnamesePhone extends Phone {

        @Override
        void insertContact(String name, String phone) {
            contacts.add(new Contact(name, phone));
        }

        @Override
        void removeContact(String name) {
            if (contacts == null) return;

            for (int i = 0; i < contacts.size(); i++) {
                if (contacts.get(i).name.equals(name)){
                    contacts.remove(i);
                    System.out.println("removed");
                    i--;
                }
            }
        }

        @Override
        void updateContact(String name, String newPhone) {
            if (contacts == null) return;

            for (int i = 0; i < contacts.size(); i++) {
                if (contacts.get(i).name.equals(name)){
                    contacts.get(i).number = newPhone;
                    System.out.println("updated");
                }
            }
        }

        @Override
        void searchContact(String name) {
            if (contacts == null) return;

            for (int i = 0; i < contacts.size(); i++) {
                if (contacts.get(i).name.equals(name)){
                    System.out.println(contacts.get(i).toString());
                }
            }
        }
    }

    public static void main(String[] args) {
        VietnamesePhone vp = new VietnamesePhone();
        vp.insertContact("a","1");
        vp.insertContact("b","1");
        vp.insertContact("c","1");


        vp.updateContact("a","3");
        vp.searchContact("a");
        vp.removeContact("a");

        for(Contact c:vp.contacts){
            System.out.println(c.toString());
        }
    }
}
