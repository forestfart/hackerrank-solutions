package oracle.ocp.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToMySQL {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_kodilla?serverTimezone=Europe/Warsaw&useSSL=False", "library_user", "my_password")) {
            Statement statement = connection.createStatement();
            String query = "SELECT * from Book";
            ResultSet resultSet = statement.executeQuery(query);
            printToConsole(resultSet);
        }
    }

    private static void printToConsole(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.print(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3) + "\t" + resultSet.getString(4) + "\n");
        }
    }
}
