package cn.swu.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
    private static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String DB_URL    = "jdbc:mysql://localhost:3306/films";
    private static String DB_USER   = "root";
    private static String DB_PASS   = "root";

    public static void insert(String sql) throws SQLException {
        excute(sql);
    }

    public static void delete(String sql) throws SQLException {
        excute(sql);
    }

    public static void update(String sql) throws SQLException {
        excute(sql);
    }

    private static void excute(String sql) throws SQLException {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            try (Statement statement = connection.createStatement()) {
                statement.execute(sql);
            }
        }
    }

    public static List<Film> getFilms(String sql) throws SQLException {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<Film> Films = new ArrayList<Film>();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            try (Statement statement = connection.createStatement()) {
                ResultSet rs = statement.executeQuery(sql);
                while (rs.next()) {
                    Film Film = new Film();
                    Film.setId(rs.getInt("id"));
                    Film.setFilm(rs.getString("film"));
                    Film.setEditor(rs.getString("editor"));
                    Film.setActor(rs.getString("actor"));
                    Film.setType(rs.getString("type"));
                    Film.setTime(rs.getString("time"));
                    Film.setReview(rs.getString("review"));
                   Film.setPics(rs.getString("pics"));
                    Films.add(Film);
                }
            }
        }

        return Films;
    }

}

