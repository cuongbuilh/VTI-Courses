package asignment_5.excercise_1;

import java.util.Random;

public class News implements INews {
    private int id;
    private String title;
    private String publishDate;
    private String author;
    private String content;
    private float averageRate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getAverageRate() {
        return averageRate;
    }


    @Override
    public void display() {
        System.out.println("title: " + title);
        System.out.println("publishdate: " + publishDate);
        System.out.println("author: " + author);
        System.out.println("content: " + content);
        System.out.println("averageRate: " + averageRate);
    }

    @Override
    public float calculate() {
        Random rd = new Random();
        int[] rates = new int[3];
        rates[0] = rd.nextInt(10);
        rates[1] = rd.nextInt(10);
        rates[2] = rd.nextInt(10);
        averageRate = (rates[0]+rates[1]+rates[2])/3.0f;
        return averageRate;
    }
}
