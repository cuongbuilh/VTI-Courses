package entity;

import java.util.Date;

public class Exam {
    int examID;
    String code;
    String title;
    int[] categories;
    int duration;
    int creatorID;
    Date createDate;

    public Exam() {
    }

    public Exam(int examID, String code, String title, int[] categories, int duration, int creatorID, Date createDate) {
        this.examID = examID;
        this.code = code;
        this.title = title;
        this.categories = categories;
        this.duration = duration;
        this.creatorID = creatorID;
        this.createDate = createDate;
    }
}
