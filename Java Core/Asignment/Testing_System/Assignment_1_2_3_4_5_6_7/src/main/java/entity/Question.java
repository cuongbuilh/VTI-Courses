package entity;

import java.sql.Date;

public class Question {
    private int id;
    private String content;
    private TypeQuestion type;
    private Account creator;
    private Date createDate;

    public Question(){}

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", type=" + type +
                ", creator=" + creator +
                ", createDate=" + createDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TypeQuestion getType() {
        return type;
    }

    public void setType(TypeQuestion type) {
        this.type = type;
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

    public Question(int id, String content, TypeQuestion type, Account creator, Date createDate) {
        this.id = id;
        this.content = content;
        this.type = type;
        this.creator = creator;
        this.createDate = createDate;
    }
}
