package entity;

import lombok.*;

@NoArgsConstructor   // = Admin()
@Getter @Setter // = tất cả getter, setter , toString
final public class Admin extends User{
    private int expInYear;

    public Admin(int id, String fullname, String email, String password, int expInYear) {
        super(id, fullname, email, password);
        this.expInYear = expInYear;
    }

    public Admin(int expInYear) {
        this.expInYear = expInYear;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "expInYear=" + expInYear +
                ", id=" + id +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
