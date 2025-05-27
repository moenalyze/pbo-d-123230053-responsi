package DAOData;

import java.sql.*;
import java.util.*;
import connection.Connector;
import model.*;
import DAOImplement.ProduksiImplement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProduksiDAO implements ProduksiImplement{
    Connection connection;
    
    final String select = "SELECT * FROM produksi";
    final String insert = "INSERT INTO produksi (id, nama, biaya_tenaga_kerja, efisiensi_produksi, total_biaya_produksi) VALUES (null, ?, ?, ?, ?)";
    final String delete = "DELETE FROM produksi where id = ?";
    final String update = "UPDATE produksi SET nama = ?, biaya_tenaga_kerja = ?, efisiensi_produksi = ?, total_biaya_produksi = ? WHERE id = ?";
    
    public ProduksiDAO() {
        connection = Connector.connection();
    }

    @Override
    public void insert(ProduksiModel p) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getNama());
            statement.setInt(2, p.getBiayaTenagaKerja());
            statement.setDouble(3, p.getEfisiensiProduksi());
            statement.setInt(4, p.getTotalBiayaProduksi());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            
            while(rs.next()) {
                p.setId(rs.getInt("id"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(ProduksiModel p) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getNama());
            statement.setInt(2, p.getBiayaTenagaKerja());
            statement.setDouble(3, p.getEfisiensiProduksi());
            statement.setInt(4, p.getTotalBiayaProduksi());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            
            while(rs.next()) {
                p.setId(rs.getInt("id"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(delete, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<ProduksiModel> getAll(ProduksiModel p) {
        List<ProduksiModel> pm = null;
        
        try {
            pm = new ArrayList<ProduksiModel>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            
            while(rs.next()) {
                ProduksiModel produksi = new ProduksiModel();
                produksi.setNama(rs.getString("nama"));
                produksi.setBiayaTenagaKerja(rs.getInt("biaya_tenaga_kerja"));
                produksi.setEfisiensiProduksi(rs.getDouble("efisiensi_produksi"));
                produksi.setTotalBiayaProduksi(rs.getInt("total_biaya_produksi"));
                produksi.setId(rs.getInt("id"));
                
                pm.add(produksi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduksiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return pm;
    }
    
}
