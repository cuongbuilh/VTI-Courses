package com.myproject.springproject.repository.IRepository;

import com.myproject.springproject.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position, Short> {
}
