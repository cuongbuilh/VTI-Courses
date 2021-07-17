package entity;

import java.sql.Date;
import java.util.Arrays;

public class Group {
    private int id;
    private String name;
    private Account creator;
    private Date CreateDate;
    private Account[] accounts;

    public Group(){}

    public Group(int id, String grName) {
        this.id = id;
        this.name = grName;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupID=" + id +
                ", groupName='" + name + '\'' +
                ", creator=" + creator +
                ", CreateDate=" + CreateDate +
                ", accounts=" + Arrays.toString(accounts) +
                '}';
    }

    public int getGroupID() {
        return id;
    }

    public void setGroupID(int groupID) {
        this.id = groupID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getCreator() {
        return creator;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public Group(int groupID, String groupName, Account creator, Date createDate, Account[] accounts) {
        this.id = groupID;
        this.name = groupName;
        this.creator = creator;
        CreateDate = createDate;
        this.accounts = accounts;
    }
}
