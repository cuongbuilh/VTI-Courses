package services.IServices;

import java.util.List;

public interface IDepartmentService {
    <T> boolean isExsist(T key);

    <T> List<T> getAllDepartment();
    <T> T getDepartmentByID(int id);
    <T> T getDepartmentByEmail(int email);
    <K> boolean deleteDepartment(K key);
    <T> boolean createDepartment(T Department);
    <T> boolean updateDepartment(T Department);
}
