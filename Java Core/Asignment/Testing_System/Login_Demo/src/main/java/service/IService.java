package service;

import java.util.List;

public interface IService<T> {
    public T get(String key);
    public List<T> gets();
    public int insert(String key, String pass, String value);
    public int update(T t);
    public int delete(String k);
}
