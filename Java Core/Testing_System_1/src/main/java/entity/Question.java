package entity;

import java.sql.Date;

public class Question {
    private int questionID;
    private String content;
    private int categoryID;
    private int typeID;
    private int creatorID;
    private Date createDate;

    @Override
    public String toString() {
        return "Question{" +
                "questionID=" + questionID +
                ", content='" + content + '\'' +
                ", categoryID=" + categoryID +
                ", typeID=" + typeID +
                ", creatorID=" + creatorID +
                ", createDate=" + createDate +
                '}';
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public int getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(int creatorID) {
        this.creatorID = creatorID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Question(int questionID, String content, int categoryID, int typeID, int creatorID, Date createDate) {
        this.questionID = questionID;
        this.content = content;
        this.categoryID = categoryID;
        this.typeID = typeID;
        this.creatorID = creatorID;
        this.createDate = createDate;
    }

    public Question() {
    }
}
