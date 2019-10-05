package oracle.ocp.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionSetUpFun {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_kodilla?serverTimezone=Europe/Warsaw&useSSL=False", "library_user", "my_password");
            Statement statement = connection.createStatement();
            String query = "SELECT * from book WHERE book_id=16";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.printf("%s, %s, %s\n", resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
            }
        } catch (SQLException e) {}
    }
}
