package dao;
import model.User;
import java.util.List;
public interface UserDAO {
 List<User> getAllUser();
 boolean updateUser(User user);
 boolean deleteUser(int id);
 boolean insertUser(User user);
 User getUser(int id);
}
