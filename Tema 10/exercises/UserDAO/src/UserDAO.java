import java.util.List;

public interface UserDAO {

    public User getUser(int id);

    public List<User> getAllUsers();

    public User getUserByUserNameAndPassword(String name, String pass);

    public boolean insertUser(User user);

    public boolean updateUser(User user);

    public boolean deleteUser(int id);
}
