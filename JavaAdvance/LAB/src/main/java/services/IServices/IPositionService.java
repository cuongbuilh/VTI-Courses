package services.IServices;

import java.util.List;

public interface IPositionService {
    <T> boolean isExsist(T key);

    <T> List<T> getAllPosition();
    <T> T getPositionByID(int id);
    <T> T getPositionByEmail(int email);
    <K> boolean deletePosition(K key);
    <T> boolean createPosition(T Position);
    <T> boolean updatePosition(T Position);
}
