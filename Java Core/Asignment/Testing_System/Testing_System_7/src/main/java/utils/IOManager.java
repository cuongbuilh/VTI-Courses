package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class IOManager {
    public static void main(String[] args) throws Exception {
        IOManager ioManager = new IOManager();
        String testPath = "data/test.txt";

        // write data
        ioManager.writeObject(testPath, false, new Integer(1));
        ioManager.writeObject(testPath, true, new Integer(1));
        // read all objects
        ioManager.readObjects(testPath);
    }

    private final FileManager fileManager = new FileManager();

    private FileWriter getFileWriter(String filePath, boolean isContinue) {
        try {
            return new FileWriter(filePath, isContinue);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private FileReader getFileReader(String filePath) {
        try {
            return new FileReader(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Scanner getFileScanner(String filePath) {
        return new Scanner(Objects.requireNonNull(getFileReader(filePath)));
    }

    private ObjectOutputStream getObjectOutputStream(String filePath, boolean isContinue) {
        try {
            return new ObjectOutputStream(new FileOutputStream(filePath, isContinue));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ObjectInputStream getObjectInputStream(String filePath) {
        try {
            return new ObjectInputStream(new FileInputStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String readFile(String filePath) throws Exception {
        if (!fileManager.isFileExists(filePath)) {
            throw new Exception("Error! File not exists");
        }
        Scanner sc = getFileScanner(filePath);
        StringBuilder result = new StringBuilder();
        String s = "";
        while (sc.hasNextLine()) {
            s = sc.nextLine();
            System.out.println(s);
            result.append(s);
        }
        return result.toString();
    }

    public void writeFile(String filePath, Boolean isContinue, String content) {
        if (!fileManager.isFileExists(filePath)) {
            return;
        }

        FileWriter fileWriter = getFileWriter(filePath, isContinue);
        String add_content = content + "\n";
        try {
            Objects.requireNonNull(fileWriter).write(add_content);
            System.out.println("writed : " + content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeObject(String filePath, boolean isContinue, Object o) {
        ObjectOutputStream objectOutputStream = getObjectOutputStream(filePath, isContinue);
        try {
            Objects.requireNonNull(objectOutputStream).writeObject(o);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Object> readObjects(String filePath) {
        ObjectInputStream objectInputStream = getObjectInputStream(filePath);
        List<Object> result = new ArrayList<>();
        Object o;

        try {
            while (true) {
                o = Objects.requireNonNull(objectInputStream).readObject();
                System.out.println(o.toString());
                result.add(o);
            }
        } catch (EOFException ignore) {
            System.out.println("end file");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e){
            System.out.println("something wrong !!");
        }

        return result;
    }

}
