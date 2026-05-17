/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package I3.DatabaseOperation;

import I3.Classes.UserInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Faysal Ahmed
 */
public class CustomerDb {
    private Connection conn = DataBaseConnection.getInstance().getConnection();
    private PreparedStatement statement = null;
    private ResultSet result = null;
    private String UPDATE_CUSTOMER;
    private String DELETE_CUSTOMER;
    
    public CustomerDb()
    {
        conn = DataBaseConnection.getInstance().getConnection();
    }
      private static final String INSERT_CUSTOMER =
    "INSERT INTO userInfo (name, address, phone, type) VALUES (?, ?, ?, ?)";

      public void insertCustomer(UserInfo user) {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_CUSTOMER)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getAddress());
            ps.setString(3, user.getPhoneNo());
            ps.setString(4, user.getType());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Successfully inserted new Customer");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\nInsertQuery Failed");
        }
    }
    
    public void updateCustomer(UserInfo user) {
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_CUSTOMER)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getAddress());
            ps.setString(3, user.getPhoneNo());
            ps.setString(4, user.getType());
            ps.setInt(5, user.getCustomerId());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Successfully updated Customer");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\nUpdate Customer Failed");
        }
    }

    public void deleteCustomer(int userId) {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_CUSTOMER)) {
            ps.setInt(1, userId);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Deleted Customer");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\nDelete Customer Failed");
        }
    }

    public ResultSet getAllCustomer() {
        try {
            String query = "select * from userInfo";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning all customer DB Operation");
        }
        

        return result;
    }
     
}
