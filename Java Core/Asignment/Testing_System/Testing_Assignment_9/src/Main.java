import java.lang.annotation.Documented;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Main {

    @SuppressWarnings("deprecated")
    public static void main(String[] args) {
        // write your code here
        new Main().v1("");
        new Main().v2();
    }



    /**
     * @Deprecated
     * @deprecated repalce {{@link #v2()}}
     * @returns void
     * @param v1 teh thiers alsfn
     * @throws Exception
     */
    @Deprecated
    public  void v1(String v1) {
    }

    public  void v2() {
    }
}
