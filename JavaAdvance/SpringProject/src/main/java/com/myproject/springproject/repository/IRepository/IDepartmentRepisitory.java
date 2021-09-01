package com.myproject.springproject.repository.IRepository;

import com.myproject.springproject.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepisitory extends JpaRepository<Department, Short> {
}
