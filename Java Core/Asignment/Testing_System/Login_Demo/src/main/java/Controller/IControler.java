package Controller;

import java.util.List;

public interface IControler<T> {
    public T login();
    public T logout();
    public boolean delete(T t, String key);
    public boolean insert(T t, String key, String pass, String value);
    public List<? extends T> gets(T t);
    public T get();
}
