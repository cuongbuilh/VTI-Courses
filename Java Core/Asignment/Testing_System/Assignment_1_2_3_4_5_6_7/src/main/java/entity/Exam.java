package entity;

import java.sql.Date;

public class Exam {
    private int examID;
    private String code;
    private String title;
    private int categoryID;
    private int duration;
    private int creatorID;
    private Date createDate;

    public Exam(){}

    public Exam(int examID, String code, String title, int categoryID, int duration, int creatorID, Date createDate) {
        this.examID = examID;
        this.code = code;
        this.title = title;
        this.categoryID = categoryID;
        this.duration = duration;
        this.creatorID = creatorID;
        this.createDate = createDate;
    }

    public int getExamID() {
        return examID;
    }

    public void setExamID(int examID) {
        this.examID = examID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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

    @Override
    public String toString() {
        return "Exam{" +
                "examID=" + examID +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", categoryID=" + categoryID +
                ", duration=" + duration +
                ", creatorID=" + creatorID +
                ", createDate=" + createDate +
                '}';
    }
}
