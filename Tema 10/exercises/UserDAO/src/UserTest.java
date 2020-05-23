
import java.util.List;

public class UserTest {

	public static void printListUsers(List<User> list) {

		System.out.println("List of " + list.size() + " users:");

		for (User s : list) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) throws Exception {
		UserDAO userDAO = new UserDAOImpl();

		printListUsers(userDAO.getAllUsers());

		User ada = new User("ADA", "one", 10);

		System.out.println(userDAO.insertUser(ada));

		userDAO.insertUser(new User("BEN", "two", 20));
		userDAO.insertUser(new User("CLARK", "three", 30));
		userDAO.insertUser(new User("DEMI", "four", 40));
		userDAO.insertUser(new User("EDIE", "five", 50));

		User u = userDAO.getUserByUserNameAndPassword("BEN", "too");

		if (u != null) {
			System.out.println(u);
		} else {
			System.out.println("Not found");
		}

		System.out.println(userDAO.updateUser(new User(3, "CLARK", "thr33", 33)));

		System.out.println(userDAO.deleteUser(5));

		printListUsers(userDAO.getAllUsers());
	}
}
