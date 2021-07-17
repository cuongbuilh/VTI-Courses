package entity;

import java.sql.Date;
import java.util.Arrays;

public class Exam {
    private int id;
    private String code;
    private String title;
    private CategoryQuestion[] categories;
    private int duration;
    private Account creator;
    private Date createDate;

    public Exam(){}

    public Exam(int id, String code, String title, CategoryQuestion[] categories, int duration, Account creator, Date createDate) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.categories = categories;
        this.duration = duration;
        this.creator = creator;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public CategoryQuestion[] getCategories() {
        return categories;
    }

    public void setCategories(CategoryQuestion[] categories) {
        this.categories = categories;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Account getCreator() {
        return creator;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
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
                "id=" + id +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", categories=" + Arrays.toString(categories) +
                ", duration=" + duration +
                ", creator=" + creator +
                ", createDate=" + createDate +
                '}';
    }
}
