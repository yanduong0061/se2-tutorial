package dao;
import java.util.List;
import model.Ordered;
public interface OrderedDAO {
List<Ordered> getAllOrdered();
Ordered getOrdered(int id);
boolean insertOrdered(Ordered ordered);
boolean updateOrdered(Ordered ordered);
boolean deleteOrdered(int id);
}
