package repository.IRepository;

import entity.Position;

import java.util.List;

public interface IPositionRepository {
    // R - read position
    List<Position> getAllPosition();
    Position getByName(String name);
}
