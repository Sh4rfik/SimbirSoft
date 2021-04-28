package Main;

import java.sql.*;
import java.util.Map;


public class DataBaseActions {

    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public static void connect(Map<String, Integer> map) {

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            addStatistic(map);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public static void disconnect() {

        try {
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void addStatistic(Map<String, Integer> map) {

        try {
            preparedStatement = connection.prepareStatement("INSERT INTO public.statistic (word, count) VALUES (?, ?)");
            for (Map.Entry<String, Integer> m : map.entrySet()) {
                preparedStatement.setString(1, m.getKey());
                preparedStatement.setInt(2, m.getValue());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}


