package com.example.demoe_2jee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class BrandDaoimp implements BrandDao {
//    @Override
//    public void saveBrand(Brand brand) {
//        Connection con = ConnexionBD.getConnection();
//        if (con == null) {
//            return;
//        }
//
//        try {
//            // Vérifier si l'employé existe déjà
//            if (BrandExistsByName(con, brand.getBrand())) {
//                // Effectuer la mise à jour
////                updateBrand(con, brand);
//            } else {
//                // Effectuer l'insertion
//                insertEmployee(con, brand);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                con.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//    }
//
//    // Méthode pour vérifier si l'employé existe déjà en utilisant le nom comme critère
//    private boolean BrandExistsByName(Connection con, String employeeName) throws SQLException {
//        String sql = "SELECT COUNT(*) FROM employee WHERE name = ?";
//        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
//            preparedStatement.setString(1, employeeName);
//            try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                if (resultSet.next()) {
//                    return resultSet.getInt(1) > 0;
//                }
//            }
//        }
//        return false;
//    }
    @Override
    public void updateBrand( Brand brand,int id ) {
        Connection con = ConnexionBD.getConnection();
        if (con == null) {
            return;
        }
        String sql = "UPDATE brands SET brand=?, category=?, price=?, status=?,email=?,image_url=? WHERE id=?";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1,brand.getBrand());
            preparedStatement.setString(2, brand.getCategory());
            preparedStatement.setDouble(3, brand.getPrice());
            preparedStatement.setString(4, brand.getStatus());
            preparedStatement.setString(5, brand.getEmail());
            preparedStatement.setString(6, brand.getImage_url());
            preparedStatement.setInt(7, id);
            preparedStatement.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void add_Brand(Brand brand) {
        Connection con = ConnexionBD.getConnection();
        if (con == null) {
            return;
        }
        String sql = "INSERT INTO brands (brand,category,price,status,email,image_url) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1,brand.getBrand());
            preparedStatement.setString(2, brand.getCategory());
            preparedStatement.setDouble(3, brand.getPrice());
            preparedStatement.setString(4, brand.getStatus());
            preparedStatement.setString(5, brand.getEmail());
            preparedStatement.setString(6, brand.getImage_url());
            preparedStatement.executeUpdate();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBrend(int id) {
        Connection con = ConnexionBD.getConnection();
        if(con == null) {
            return;
        }

        String query = "DELETE FROM brands WHERE id=?;";
        try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    @Override
    public List<Brand> getAllBrand() {
        Connection con = ConnexionBD.getConnection();
        if (con == null) {
            return null;
        }
        List<Brand> brands = new LinkedList<>();
        String sql = "SELECT * FROM brands";
        try(PreparedStatement preparedStatement= con.prepareStatement(sql)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {

                Brand brand = new Brand(rs.getInt("id"),rs.getString("brand"),rs.getString("category"),rs.getDouble("price"),rs.getString("status"),rs.getString("email"),rs.getString("image_url"));
                brands.add(brand);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return brands;
    }
}
