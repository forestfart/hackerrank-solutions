package oracle.ocp.sql;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

class ConProps {
    final static String URL = "jdbc:mysql://localhost:3306/library_kodilla?serverTimezone=Europe/Warsaw&useSSL=False";
    final static String USER = "library_user";
    final static String PASSWORD = "my_password";
}

public class ConnectionSetUpFun {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(ConProps.URL, ConProps.USER, ConProps.PASSWORD);
            Statement statement = connection.createStatement();
            String query = "SELECT * from book WHERE book_id=16";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.printf("%s, %s, %s\n", resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
            }
        } catch (SQLException e) {
            System.out.println("ERROR");
        }
    }
}

class ConnectionSetUpFun2 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(ConProps.URL, ConProps.USER, ConProps.PASSWORD);
        String query = "SELECT book_id FROM book";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            stmt.executeQuery("SELECT book_id FROM book");
            while (rs.next()) {
                //process the results
                System.out.println("Book ID: " + rs.getInt("book_id"));
            }
        } catch (SQLException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }
    }
}

class ConnectionSetUpFun3 {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(ConProps.URL, ConProps.USER, ConProps.PASSWORD);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.execute("SELECT * FROM book");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                if (resultSet.getInt(1) == 98){
                    resultSet.updateString(2, "Anonymous");
                    resultSet.updateRow();
                }
            }
            resultSet.absolute(2);
            System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
        } catch (SQLException e) {
            System.out.println("Exception is raised");
            e.printStackTrace();
        }
    }
}