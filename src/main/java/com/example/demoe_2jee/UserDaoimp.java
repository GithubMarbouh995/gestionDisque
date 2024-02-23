package com.example.demoe_2jee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoimp implements UserDao{
    @Override
    public void addUser(User user) {
        Connection con = ConnexionBD.getConnection();
        if (con == null) {
            return;
        }
        String sql = "INSERT INTO user (email, password) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public User getUser(int id) {
        User user = new User();
        Connection con = ConnexionBD.getConnection();
        if (con == null) {
            return null;
        }
        String sql = "SELECT * FROM user WHERE id=?";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return user;
    }
    @Override
    public void updateUser(User user) {
        Connection con = ConnexionBD.getConnection();
        if (con == null) {
            return;
        }
        String sql = "UPDATE user SET email=?, password=? WHERE id=?";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getId());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteUser(int id) {
        Connection con = ConnexionBD.getConnection();
        if (con == null) {
            return;
        }
        String sql = "DELETE FROM user WHERE id=?";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();

    }
}
}
