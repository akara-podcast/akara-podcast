package staticUtility;

import com.github.javafaker.DateAndTime;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import model.TripleDes;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Calendar;

import static java.sql.DriverManager.getConnection;


public class DbUtils {

    private static String retrievedName;
    private static String retrievedPassword;
    private static int retrievedID = 0;
    public static void signUpUser(ActionEvent event, String name, String email, String password, LocalDateTime created_at) {

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

                // encrypt password and insert into database
                TripleDes tripleDes = new TripleDes();

                psInsert.setString(3, tripleDes.encrypt(password)); // need encrypt here

                psInsert.setString(4, String.valueOf(created_at));
                psInsert.executeUpdate();
            }
        }   catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
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
            preparedStatement = connection.prepareStatement("SELECT user_id, password, name FROM user WHERE email = ?");
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
                    TripleDes tripleDes = new TripleDes();
                    retrievedPassword = tripleDes.decrypt(resultSet.getString("password")); // need decrypt here

                    if (retrievedPassword.equals(password)) {
                        retrievedName = resultSet.getString("name");
                        retrievedID = resultSet.getInt("user_id");

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
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
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

    public static void updateUserName(ActionEvent event, int id, String newName) {

        Connection connection = null;
        PreparedStatement psUpdate = null;
        ResultSet resultSet = null;

        try {
            if (newName.isEmpty()){
                // user doesn't change their name
                System.out.println("user doesn't change their name");
            }
            else {
                connection = getConnection("jdbc:mysql://localhost:3306/akara_db", "root", "050903");
                psUpdate = connection.prepareStatement("UPDATE user SET name=? WHERE user_id=" + id);
                psUpdate.setString(1, newName);
                psUpdate.executeUpdate();
                retrievedName = newName;
            }
        }   catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                }   catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psUpdate != null) {
                try {
                    psUpdate.close();
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

    public static int getRetrievedID() {
        return retrievedID;
    }
}
