package entity;

import java.util.Date;

public class Question {
    int questionID;
    String content;
    int[] categories;
    int[] types;
    int creatorID;
    Date createDate;

    public Question() {
    }

    public Question(int questionID, String content, int[] categories, int[] types, int creatorID, Date createDate) {
        this.questionID = questionID;
        this.content = content;
        this.categories = categories;
        this.types = types;
        this.creatorID = creatorID;
        this.createDate = createDate;
    }
}
