package week3;

import java.sql.*;

public class JDBCSample {

    private static Connection getConnection() {

        final String databaseBaseUrl = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "mysecretpassword";

        Connection connection = null;
        try {
            // Load the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(databaseBaseUrl, username, password);
        } catch (RuntimeException | ClassNotFoundException | SQLException e) {
            System.err.println("Hata olustu : " + e.getMessage());
        }

        return connection;
    }

    public static void main(String[] args) {

        // Establish a connection
        Connection mainConnection = getConnection();

        if (mainConnection == null)
            System.err.println("Database bağlantısı kurulamadı");
        else
            System.out.println("Database bağlantısı kuruldu");

        try {
            // Run a select query
            selectData(mainConnection);
            // Close the connection when done
            mainConnection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static void selectData(Connection connection) throws SQLException {

        String selectDataSQL = "SELECT * FROM sample_table";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectDataSQL)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }
        }
    }

}


//CREATE TABLE IF NOT EXISTS sample_table (
//        id SERIAL PRIMARY KEY,
//        name VARCHAR(255),
//        age INT
//);

//INSERT INTO sample_table (name, age) VALUES ('John Doe', 25);
//INSERT INTO sample_table (name, age) VALUES ('Helen Oack', 30);
//INSERT INTO sample_table (name, age) VALUES ('Karen Southe', 35);
//INSERT INTO sample_table (name, age) VALUES ('Jane Cliey', 20);
