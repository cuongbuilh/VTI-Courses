package repository.IRepository;

import entity.Department;

import java.util.List;

public interface IDepartmentRepository {
    // R - read department
    List<Department> getAllDepartment();
    Department getByNamme(String name);
    List<Department> getByKeyword(String key);

    // C - create department
    boolean create(Department newDepartment);

    // D - delete
    boolean deleteByName(String name);
    boolean deleteByID(short id);
}
