package entity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

public class Account implements Comparable<Account>{
    private int id;
    private String email;
    private String userName;
    private String fullName;
    private Department department;
    private Position position;
    private LocalDate createDate;
    private Group[] groups;

    public Account(){}

    public Account(int accountID, String email, String userName, String fullName, Department department, Position position, LocalDate createDate, Group[] groups) {
        this.id = accountID;
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
        this.department = department;
        this.position = position;
        this.createDate = createDate;
        this.groups = groups;
    }

    public Account(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountID=" + id +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", department=" + department +
                ", position=" + position +
                ", createDate=" + createDate +
                ", groups=" + Arrays.toString(groups) +
                '}';
    }

    @Override
    public int compareTo(Account o) {
        if (o == null)
            return -1;
        if (this.getId()==o.getId())
            return 1;
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;

        if (getId() != account.getId()) return false;
        if (getEmail() != null ? !getEmail().equals(account.getEmail()) : account.getEmail() != null) return false;
        if (getUserName() != null ? !getUserName().equals(account.getUserName()) : account.getUserName() != null)
            return false;
        if (getFullName() != null ? !getFullName().equals(account.getFullName()) : account.getFullName() != null)
            return false;
        if (getDepartment() != null ? !getDepartment().equals(account.getDepartment()) : account.getDepartment() != null)
            return false;
        if (getPosition() != null ? !getPosition().equals(account.getPosition()) : account.getPosition() != null)
            return false;
        if (getCreateDate() != null ? !getCreateDate().equals(account.getCreateDate()) : account.getCreateDate() != null)
            return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(getGroups(), account.getGroups());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getUserName() != null ? getUserName().hashCode() : 0);
        result = 31 * result + (getFullName() != null ? getFullName().hashCode() : 0);
        result = 31 * result + (getDepartment() != null ? getDepartment().hashCode() : 0);
        result = 31 * result + (getPosition() != null ? getPosition().hashCode() : 0);
        result = 31 * result + (getCreateDate() != null ? getCreateDate().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getGroups());
        return result;
    }

}
