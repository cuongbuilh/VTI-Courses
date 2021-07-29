package exception;

public class PermissonDeniedException extends Exception {
    public PermissonDeniedException() {
        super("YOU DO NOT HAVE PERMISSION");
    }

    public PermissonDeniedException(String msg) {
        super(msg);
    }
}
