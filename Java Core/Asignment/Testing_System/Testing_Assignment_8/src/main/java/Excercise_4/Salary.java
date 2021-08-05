package Excercise_4;

public class Salary<N extends Number> {
    private N _num;

    public Salary(N n) {
        this._num = n;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "_num=" + _num +
                '}';
    }

}
