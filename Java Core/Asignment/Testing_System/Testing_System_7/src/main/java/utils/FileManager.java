package utils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;



public class FileManager {


    public static void main(String[] args) {
        FileManager fileManager = new FileManager();

//        System.out.println(fileManager.isFileExists("data/test_file_1.txt"));
//        fileManager.createNewFile("data","new.txt");
//        fileManager.deleteFile("data/new.txt");
//        System.out.println(fileManager.isFolder("data"));
//       for(String s : fileManager.getAllFileName("data")){
//           System.out.println(s);
//       }
//        try {
//            fileManager.copyFile("data/test_file_1.txt","data","test_copy.txt");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        fileManager.moveFile("data/test.txt", "data_copy");
//        fileManager.createNewFolder("data2");
//        fileManager.renameFile("data_copy/test.txt","test_renamed.txt");
        String imgLink = "https://www.baeldung.com/wp-content/uploads/2016/05/baeldung-rest-post-footer-main-1.2.0.jpg";
        String savedFolder = "data";

        try {
            fileManager.downloadFile(imgLink, savedFolder);
        } catch (IOException e) {
            System.out.println("cannot download - something was wrong");
            e.printStackTrace();
        }
    }

    public boolean isFileExists(String filePath) {
        File file = new File(filePath);
        if (!file.isFile()) return false;
        return file.exists();
    }

    public void createNewFile(String path) {
        File file = new File(path);
        try {
            if (file.createNewFile()) {
                System.out.println(file.getName() + " is created");
            } else {
                System.out.println("cannot create: " + file.getName());
            }
            ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createNewFile(String path, String fileName) {
        String fullPath = path + "/" + fileName;
        File file = new File(fullPath);
        try {
            if (file.createNewFile()) {
                System.out.println(file.getName() + "was created");
            } else {
                System.out.println("cannot create file: " + file.getName());
            }
            ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.delete()) {
            System.out.println(file.getName() + " was deleted");
        } else {
            System.out.println("cannot delete file");
        }
    }

    public boolean isFolder(String path) {
        File file = new File(path);
        return file.isDirectory();
    }

    public List<String> getAllFileName(String path) {
        List<String> allFileName = new ArrayList<>();
        File file = new File(path);
        allFileName = Arrays.stream(Objects.requireNonNull(file.list())).toList();
        return allFileName;
    }

    public void copyFile(String sourceFile, String distinationPath, String fileName) throws IOException {
        File fileSource = new File(sourceFile);
        String fullDistPath = distinationPath + "/" + fileName;
        File distinationFile = new File(fullDistPath);
        copyFile(sourceFile, fullDistPath);

//        if (fileSource.exists()) {
//            FileInputStream fin = new FileInputStream(fileSource);
//            BufferedInputStream source = new BufferedInputStream(fin);
//
//            FileOutputStream fos = new FileOutputStream(distinationFile);
//            BufferedOutputStream dist = new BufferedOutputStream(fos);
//            // write data as Byte
//            dist.write(source.readAllBytes());
//            dist.flush(); // put data from buffer -> file
//            // close file
//            fin.close();
//            fos.close();
//            System.out.printf("copy %s as %s\n",fileSource.getName(),distinationFile.getName());
//        } else {
//            System.out.println(fileSource.getName() + " is not exists");
//        }
    }

    public void copyFile(String sourceFile, String distinationPath) throws IOException {
        File fileSource = new File(sourceFile);
        File distinationFile = new File(distinationPath);

        if (fileSource.exists()) {
            FileInputStream fin = new FileInputStream(fileSource);
            BufferedInputStream source = new BufferedInputStream(fin);

            FileOutputStream fos = new FileOutputStream(distinationFile);
            BufferedOutputStream dist = new BufferedOutputStream(fos);
            // write data as Byte
            dist.write(source.readAllBytes());
            dist.flush(); // put data from buffer -> file
            // close file
            fin.close();
            fos.close();
            System.out.printf("copy %s as %s\n", fileSource.getName(), distinationFile.getName());
        } else {
            System.out.println(fileSource.getName() + " is not exists");
        }
    }

    public void moveFile(String sourceFile, String distinationPath) {
        File file = new File(sourceFile);
        File distFolder = new File(distinationPath);
        createNewFolder(distinationPath);
        // check -> maybe don't need
        String Dir = distFolder.isDirectory() ? distinationPath + "/" + file.getName() : distinationPath;


        try {
            copyFile(sourceFile, Dir);
            if (file.delete()) {
                System.out.printf("moved %s into %s", file.getName(), distinationPath);
            } else {
                System.out.println("cannot remove old file");
            }

        } catch (IOException e) {
            System.out.println("cannot move file, somthing went wrong");
        }
    }

    public void renameFile(String filePath, String newName) {
        File file = new File(filePath);
        if (file.getName().equals(newName)) {
            System.out.println("renamed");
            return;
        }

        try {
            copyFile(filePath, file.getParent(), newName);
            deleteFile(filePath);
        } catch (IOException e) {
            System.out.println("cannot rename - something was wrong");
        }
    }

    public void createNewFolder(String newPathFolder) {
        File file = new File(newPathFolder);
        if (file.exists()) {
            System.out.println("folder has exists");
            return;
        }

        if (file.mkdir()) {
            System.out.println(file.getPath() + " has been created");
        } else {
            System.out.println("cannot create folder - something wrong");
        }
    }

    public void downloadFile(String fileLink, String savedFolder) throws IOException {
        File folder = new File(savedFolder);
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("cannot download - folder has not exists!");
            return;
        }

//        // myWay
//        URL url = new URL(fileLink);
//        // get filename -> create fileSave
//        String[] s = fileLink.split("/");
//        String fileName = s[s.length - 1];
//        savedFolder = savedFolder + "/" + fileName;
//        ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
//        // transfer
//        FileOutputStream fileOutputStream = new FileOutputStream(savedFolder);
//        FileChannel fileChannel = fileOutputStream.getChannel();
//        fileChannel.transferFrom(readableByteChannel,0,Long.MAX_VALUE);
//        // close all
//        fileChannel.close();
//        fileOutputStream.close();
//        readableByteChannel.close();
//        System.out.println("dowload successful");

        // get filename -> create fileSave
        String[] s = fileLink.split("/");
        String fileName = s[s.length - 1];
        savedFolder = savedFolder + "/" + fileName;

        // connect to url
        URL url = new URL(fileLink);
        URLConnection connection = url.openConnection();
        connection.connect();

        // get stream
        InputStream in = connection.getInputStream();
        FileOutputStream fos = new FileOutputStream(savedFolder);

        // config
        long size = connection.getContentLengthLong();
        int byteDowloaded = 0;
        byte[] b = new byte[1024];
        int length = in.read(b);

        // downloading
        while (length != -1) {
            byteDowloaded += length;
            System.out.println(byteDowloaded * 100d / size + "%");
            fos.write(b, 0, length);
            length = in.read(b);
        }
        // close and notice
        fos.close();
        in.close();
        System.out.println("dowload sucssesful");
    }
}
