package utils;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class IOManager {
    public final FileManager fileManager = new FileManager();

    public FileWriter getFileWriter(String filePath, boolean isContinue) {
        try {
            return new FileWriter(filePath, isContinue);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public FileReader getFileReader(String filePath) {
        try {
            return new FileReader(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Scanner getFileScanner(String filePath) {
        return new Scanner(Objects.requireNonNull(getFileReader(filePath)));
    }

    public ObjectOutputStream getObjectOutputStream(String filePath ) {
        try {
            return new ObjectOutputStream(new FileOutputStream(filePath, false));
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

    public void writeObject(String filePath, Object o) {
        ObjectOutputStream objectOutputStream = getObjectOutputStream(filePath);
        try {
            Objects.requireNonNull(objectOutputStream).writeObject(o);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object readObjects(String filePath) {
        ObjectInputStream objectInputStream = getObjectInputStream(filePath);
        try {
            return Objects.requireNonNull(objectInputStream.readObject());
        } catch (Exception e) {
            System.out.println("something wrong !!");
            e.printStackTrace();
        }
        return null;
    }

    public ObjectInputStream getObjectInputStream(String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            return new ObjectInputStream(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("cannot get object input stream");
        }
        return null;
    }
}
