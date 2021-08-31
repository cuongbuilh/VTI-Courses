package services.IServices;

import entity.Account;

import java.util.List;

public interface IAccountService {
    <T> boolean isExsist(T key);

    <T> List<T> getAllAccount();
    <T> T getAccountByID(int id);
    <T> T getAccountByEmail(int email);
    <K> boolean deleteAccount(K key);
    <T> boolean createAccount(T account);
    <T> boolean updateAccount(T account);
}
