package DAO;

import entity.User;

import java.util.List;

public interface IDAO<T> {
    public List<? extends T> gets();
    public T get(String key);
    public boolean has(String key);
    public int insert(T t);
    public int update(T t);
    public int delete(String key);
}
