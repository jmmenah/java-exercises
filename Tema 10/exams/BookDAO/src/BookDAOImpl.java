import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO{

    @Override
    public List<Book> getAllBooks() {

        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();

        Statement stmt = null;
        ResultSet rs = null;
        List<Book> bookList = new ArrayList<>();
        try(Connection con = connectionFactory.getConnection()) {
            String query = "SELECT * FROM books";
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                Book book = new Book();
                book.setIsbn(rs.getLong("isbn"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setYear(rs.getInt("year"));
                bookList.add(book);
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
        return bookList;
    }

    @Override
    public Book getBook(long isbn) {
        Book result = null;
        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Statement stmt = null;
        ResultSet rs = null;
        try (Connection con = connectionFactory.getConnection()) {
            String query = "SELECT * FROM books where isbn=" + isbn;
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            if(rs.next()) {
                Book book = new Book();
                book.setIsbn(rs.getLong("isbn"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setYear(rs.getInt("year"));

                result = book;
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
        return result;
    }

    @Override
    public Book getBook(String title) {
        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Statement stmt = null;
        ResultSet rs = null;
        try(Connection con = connectionFactory.getConnection()) {
            String query = "SELECT * FROM books where title='" + title+"';";
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            if(rs.next()) {
                Book book = new Book();
                book.setIsbn(rs.getLong("isbn"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setYear(rs.getInt("year"));
                return book;
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
    public boolean insertBook(Book book) {
        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        String query = "INSERT INTO books (isbn, title, author, year) "
                + " VALUES (?,?,?,?)";
        try (Connection con = connectionFactory.getConnection();
             PreparedStatement prsmt = con.prepareStatement(query)) {
            con.setAutoCommit(false);
            prsmt.setLong(1, book.getIsbn());
            prsmt.setString(2, book.getTitle());
            prsmt.setString(3, book.getAuthor());
            prsmt.setInt(4, book.getYear());
            prsmt.executeUpdate();
            con.commit();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateBook(Book book){
        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        PreparedStatement statement = null;

        String sql = "update books set title='" + book.getTitle() + "' where isbn="
                + book.getIsbn()+";";

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
    public boolean deleteBook(long isbn){
        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Statement statement = null;
        int delete;
        boolean result = true;

        String sql = "delete from books where isbn=" + isbn+";";

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

    @Override
    public int deleteBooks(String author){
        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Statement statement = null;
        int delete = 0;

        String sql = "delete from books where author='" + author+"';";

        try (Connection con = connectionFactory.getConnection()) {
            statement = con.prepareStatement(sql);
            delete = statement.executeUpdate(sql);


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
        return delete;
    }
}
