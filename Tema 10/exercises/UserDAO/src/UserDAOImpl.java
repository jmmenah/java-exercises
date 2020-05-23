import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public User getUser(int id) {
        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Statement stmt = null;
        ResultSet rs = null;
        try(Connection con = connectionFactory.getConnection()) {
            String query = "SELECT * FROM user where id=" + id;
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setPass(rs.getString("pass"));
            user.setAge(rs.getInt("age"));

            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception exe) {
                exe.printStackTrace();
            }

        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {

        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Statement stmt = null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<>();
        try(Connection con = connectionFactory.getConnection()) {
            String query = "SELECT * FROM user";
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPass(rs.getString("pass"));
                user.setAge(rs.getInt("age"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception exe) {
                exe.printStackTrace();
            }

        }
        return userList;
    }

    @Override
    public User getUserByUserNameAndPassword(String name, String pass) {
        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Statement stmt = null;
        ResultSet rs = null;
        try(Connection con = connectionFactory.getConnection()) {
            String query = "SELECT * FROM user where name='" + name+"' AND pass='"+pass+"';";
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPass(rs.getString("pass"));
                user.setAge(rs.getInt("age"));

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception exe) {
                exe.printStackTrace();
            }

        }
        return null;
    }

    @Override
    public boolean insertUser(User user) {
        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        String query = "INSERT INTO user (id, name, pass, age) "
                + " VALUES (?,?,?,?)";
        try (Connection con = connectionFactory.getConnection();
             PreparedStatement prsmt = con.prepareStatement(query)) {
            con.setAutoCommit(false);
            prsmt.setInt(1, user.getId());
            prsmt.setString(2, user.getName());
            prsmt.setString(3, user.getPass());
            prsmt.setInt(4, user.getAge());
            prsmt.executeUpdate();
            con.commit();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateUser(User user){
        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        PreparedStatement statement = null;

        String sql = "update user set name=" + "'" + user.getName() + "'" + "where id="
                + user.getId();

        try (Connection con = connectionFactory.getConnection()) {
            statement = con.prepareStatement(sql);
            statement.executeUpdate(sql);
            return true;

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        }
        return false;

    }

    @Override
    public boolean deleteUser(int id){
        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Statement statement = null;
        int delete;
        boolean result = true;

        String sql = "delete from user where id=" + id;

        try (Connection con = connectionFactory.getConnection()) {
            statement = con.prepareStatement(sql);
            delete = statement.executeUpdate(sql);

            result = delete == 0;
            
        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        return !result;
    }

}
