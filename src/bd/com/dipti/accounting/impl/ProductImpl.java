/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.com.dipti.accounting.impl;

import bd.com.dipti.accounting.dao.Dao;
import bd.com.dipti.accounting.model.Product;
import bd.com.dipti.accounting.util.DButil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tahmi
 */
public class ProductImpl implements Dao<Product>{
    
    DButil dbutil;

    public ProductImpl(DButil dbutil) {
       
            try {
                dbutil = new DButil();
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    
    
    @Override
    public void save(Product value) {
        
        try {
            String sql = "insert into product values (?,?,?,?)";
            PreparedStatement pst = dbutil.getCon().prepareStatement(sql);
            
            pst.setString(1, value.getName());
            pst.setDouble(2, value.getPrice());
            pst.setInt(3, value.getQuantity());
            pst.setString(4, value.getVendorName());
            
            pst.executeUpdate();
            pst.close();
            
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Product value) {
        
        try {
            String sql = "Update product set name = ?,price = ? , vendorName = ? , quantity = ? where pid =?";
            
            PreparedStatement pstm = dbutil.getCon().prepareStatement(sql);
            
            pstm.setString(1, value.getName());
            pstm.setDouble(2, value.getPrice());
            pstm.setInt(3, value.getQuantity());
            pstm.setString(4, value.getVendorName());
            
            pstm.executeUpdate();
            pstm.close();
            
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Product value) {
        
        try {
            String sql = "delete from product where pid = ?";
            
            PreparedStatement pstm = dbutil.getCon().prepareStatement(sql);
            
             pstm.setInt(1, value.getPid());
             pstm.executeUpdate();
             pstm.close();
             
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Product find(Product value) {
   
        try {
            String sql = "select * from product where pid = ?";
            
            PreparedStatement pstm = dbutil.getCon().prepareStatement(sql);
            
            pstm.setInt(1, value.getPid());
            ResultSet rs = pstm.executeQuery();
            
            if(rs.next()){
            return new Product(rs.getInt(1), rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getString(5));
            }
            
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Product> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
