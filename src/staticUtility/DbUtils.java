package staticUtility;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.sql.*;
import java.time.LocalDate;

import static java.sql.DriverManager.getConnection;


public class DbUtils {

    private static String retrievedName;
    private static String retrievedPassword;
    public static void signUpUser(ActionEvent event, String name, String email, String password, LocalDate created_at) {

        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection("jdbc:mysql://localhost:3306/akara_db", "root", "050903");
            psCheckUserExists = connection.prepareStatement("SELECT * FROM user WHERE email = ?");
            psCheckUserExists.setString(1, email);
            resultSet = psCheckUserExists.executeQuery();

            if (resultSet.isBeforeFirst()) {
                System.out.println("User already Exists!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please use another email!");
                alert.show();
            }
            else {
                psInsert = connection.prepareStatement("INSERT INTO user (name, email, password, created_at) VALUES (?, ?, ?, ?)");
                psInsert.setString(1, name);
                psInsert.setString(2, email);
                psInsert.setString(3, password);
                psInsert.setDate(4, Date.valueOf(created_at));
                psInsert.executeUpdate();
            }
        }   catch (SQLException e) {
            e.printStackTrace();
        }   finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                }   catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psCheckUserExists != null) {
                try {
                    psCheckUserExists.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psInsert != null) {
                try {
                    psInsert.close();
                }   catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                }   catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void logInUser(ActionEvent event, Label alertLabel, String email, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection("jdbc:mysql://localhost:3306/akara_db", "root", "050903");
            preparedStatement = connection.prepareStatement("SELECT password, name FROM user WHERE email = ?");
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("User not found in the database!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Email or Password are incorrect!");
                alert.show();
                alert.close();

                alertLabel.setText("Email or Password are incorrect!");
                alertLabel.setTextFill(Color.RED);
            }   else {
                while (resultSet.next()) {
                    retrievedPassword = resultSet.getString("password");
                    retrievedName = resultSet.getString("name");
                    if (retrievedPassword.equals(password)) {

                    }   else {
                        System.out.println("Password did not match!");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.show();
                        alert.close();

                        alertLabel.setText("The password are incorrect!");
                        alertLabel.setTextFill(Color.RED);
                    }
                }
            }
        }   catch (SQLException e) {
            e.printStackTrace();
        }   finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                }   catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                }   catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                }   catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getRetrievedName() {
        return retrievedName;
    }
    public static String getRetrievedPassword() {
        return retrievedPassword;
    }
}
