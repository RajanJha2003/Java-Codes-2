package prepared_statement;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        
        Class.forName("com.mysql.cj.jdbc.Driver");

        
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/users", "root", "Rajan@2003");

        
        String sql = "INSERT INTO user (id, name, contact) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        
        preparedStatement.setInt(1, 4);
        preparedStatement.setString(2, "Rajan");
        preparedStatement.setString(3, "09766");
        preparedStatement.executeUpdate();

        
        preparedStatement.setInt(1, 5);
        preparedStatement.setString(2, "King");
        preparedStatement.setString(3, "4855");
        preparedStatement.executeUpdate();

        
        preparedStatement.setInt(1, 6);
        preparedStatement.setString(2, "Developer");
        preparedStatement.setString(3, "55255");
        preparedStatement.executeUpdate();

      
        String selectSQL = "SELECT * FROM user";
        PreparedStatement selectStmt = connection.prepareStatement(selectSQL);
        ResultSet resultSet = selectStmt.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id") + " " +
                               resultSet.getString("name") + " " +
                               resultSet.getString("contact"));
        }

        connection.close();
    }
}
