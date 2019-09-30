package oracle.ocp.locale;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class PropertiesClazz {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        String userName = "dfs", password = "pass";
        prop.put("user", userName); prop.put("password", password);
        System.out.println(prop.getProperty("user" + " " + prop.getProperty("password")));
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/high_performance_java_persistence", prop);
            Statement statement = con.createStatement();
            String query = "SELECT * FROM Users";
            ResultSet resultSet = statement.executeQuery(query);
            statement.execute(query);
            resultSet.first();
            while (resultSet.next()) {
                String userNamed = resultSet.getString(1);
                System.out.println(userNamed);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        FileInputStream fis = new FileInputStream(".\\src\\main\\resources\\ResourceBundle.properties");
        prop.load(fis);
        System.out.println(prop.getProperty("Greeting"));
        System.out.println(prop.getProperty("Greeting2","Test")); //line n1
        System.out.println(prop.getProperty("welcome3"));
    }
}
