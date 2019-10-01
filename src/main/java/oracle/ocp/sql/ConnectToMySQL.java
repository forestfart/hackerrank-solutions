package oracle.ocp.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToMySQL {
    static Connection newConnection;

    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_kodilla?serverTimezone=Europe/Warsaw&useSSL=False", "library_user", "my_password")) {
            connection.setAutoCommit(false);

            Statement statement;
            String query = "SELECT * from Book";
            printToConsole(connection, query);

            statement = connection.createStatement();
            String delete = "DELETE from Book WHERE book_id = 98";
            System.out.println(" Delete Status: " + statement.executeUpdate(delete));
            printToConsole(connection, query); // updates table no matter if it is autocommit true or false!

            statement = connection.createStatement();
            String insert = "INSERT INTO Book VALUES('98', 'anonymous', '2016', 'OCPPractice')";
            System.out.println(" Insert Status: " + statement.executeUpdate(insert));
            printToConsole(connection, query);

            newConnection = connection;
        }
        // newConnection.createStatement(); //throws SQLNonTransientConnectionException
    }

    private static void printToConsole(Connection connection, String query) throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery(query);
        resultSet.absolute(1);
        while (resultSet.next()) {
            System.out.print(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3) + "\t" + resultSet.getString(4) + "\n");
        }
    }
}
