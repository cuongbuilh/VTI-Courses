package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    /*
     * chú ý nên tạo db mới (Accounts) - trong đó có các table:
     *  User( _id, fullname, email, password,  )
     *  Admin( _id, expInYear )
     *  Skill( _id, _skill )
     *  note: các trường có "_" là khóa của bảng đó;
     *  database ở cuối file này.
     */
    protected int id;
    protected String fullname;
    protected String email;
    protected String password;

    public boolean isAdmin() {
        return (this instanceof Admin);
    }
}

//          --database script
//
//        drop database if exists Accounts;
//        create database Accounts;
//        use Accounts;
//        create table User
//        (
//        id int auto_increment primary key,
//        fullname varchar(50),
//        email varchar(50),
//        password varchar(50)
//        );
//        create table Admin
//        (
//        id int primary key,
//        expInYear int default (0)
//        );
//        create table Skill
//        (
//        id int,
//        skill nvarchar(50),
//        primary key(id,skill)
//        );
//        insert into User value(1,'admin','admin@gmail.com','admin');
//        insert into Admin value(1,0);
//        insert into User value(2,'user','user@user.com','user');
//        insert into Skill value(2,'Java');