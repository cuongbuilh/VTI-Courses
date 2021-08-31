package repository.IRepository;

import entity.Account;

import java.util.List;

public interface IAccountRepository {
    // R - read account
    boolean isEmailExists(String email);
    boolean isUserNameExsist(String username);
    List<Account> getAll();
    Account getAccountByEmail(String email);
    Account getAccountByUsername(String username);
    List<Account> getAccountForPaging(int page, int numPerPage);

    // C - create account
    boolean create(Account newAccount);

    // U - update account
    boolean updateByID(int ID, Account newAccount);
    boolean updateByEmail(String email, Account newAccount);
    boolean updateByUsername(String username, Account newAccount);


    // D - delete
    boolean deleteAccountByEmail(String email);
    boolean deleteAccountByUsername(String username);
    boolean deleteAccountByID(short id);

}
