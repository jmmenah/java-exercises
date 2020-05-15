import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SpanishZipCode {

    public static void main(String[] args) {
        System.out.print("Please insert a Spanish zip code: ");
        Scanner sc = new Scanner(System.in);
        String number=sc.next();
        while (isValidSpanishZipCode(number)){
            getProvincia(number);
            System.out.print("Please insert a Spanish zip code: ");
            number=sc.next();
        }
    }
    public static void getProvincia(String number) {
        String COD_PROV = number.substring(0,2);
        String sql = "SELECT PROVINCIA,AUTONOMIA "
                + "FROM PROVINCIAS,AUTONOMIAS WHERE PROVINCIAS.COD_AUT=AUTONOMIAS.COD_AUT"
                + " AND COD_PROV = ?";
        Connection c = SQLiteConnectionShutdown.getSqliteConnection();
        try (PreparedStatement pstmt = c.prepareStatement(sql);) {

            // set the value
            pstmt.setString(1, COD_PROV);
            //
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                String PROVINCIA = rs.getString("PROVINCIA");
                String AUTONOMIA = rs.getString("AUTONOMIA");
                System.out.println(number+": "+PROVINCIA+"("+AUTONOMIA+")");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    private static boolean isValidSpanishZipCode(String input) {
        // https://es.stackoverflow.com/questions/110569/validaci%C3%B3n-de-c%C3%B3digo-postal-espa%C3%B1ol-con-expresiones-regulares
        Pattern pattern = Pattern.compile("^(?:0?[1-9]|[1-4]\\d|5[0-2])\\d{3}$");
        return pattern.matcher(input).matches();
    }
}
