/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Pelanggan;
import Model.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author User
 */
public class DAOPelanggan implements InterfaceDAOPelanggan {
    Connection connection;
    final String insert = "INSERT INTO pelanggan (nama, no_pc, paket, total_harga) VALUES (?, ?, ?, ?);";
    final String update = "UPDATE pelanggan set nama=?, no_pc=?, paket=?, total_harga=? where id=?;";
    final String delete = "DELETE FROM pelanggan where id=?;";
    final String select = "SELECT * FROM pelanggan;";
    final String cari   = "SELECT * FROM pelanggan where nama like ?;";

    public DAOPelanggan() {
        connection = Connector.connection();
    }

    @Override
    public void insert(ModelPelanggan p) {
        try (PreparedStatement st = connection.prepareStatement(insert)) {
            st.setString(1, p.getNama());
            st.setInt(2, p.getNo_pc());
            st.setString(3, p.getPaket());
            st.setDouble(4, p.getTotal_harga());
            st.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }

    @Override
    public void update(ModelPelanggan p) {
        try (PreparedStatement st = connection.prepareStatement(update)) {
            st.setString(1, p.getNama());
            st.setInt(2, p.getNo_pc());
            st.setString(3, p.getPaket());
            st.setDouble(4, p.getTotal_harga());
            st.setInt(5, p.getId());
            st.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement st = connection.prepareStatement(delete)) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }

    @Override
    public List<ModelPelanggan> getAll() {
        List<ModelPelanggan> lp = new ArrayList<>();
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(select)) {
            while (rs.next()) {
                ModelPelanggan p = new ModelPelanggan();
                p.setId(rs.getInt("id"));
                p.setNama(rs.getString("nama"));
                p.setNo_pc(rs.getInt("no_pc"));
                p.setPaket(rs.getString("paket"));
                p.setTotal_harga(rs.getDouble("total_harga"));
                lp.add(p);
            }
        } catch (SQLException ex) { ex.printStackTrace(); }
        return lp;
    }

    @Override
    public List<ModelPelanggan> getCariNama(String nama) {
        List<ModelPelanggan> lp = new ArrayList<>();
        try (PreparedStatement st = connection.prepareStatement(cari)) {
            st.setString(1, "%" + nama + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ModelPelanggan p = new ModelPelanggan();
                p.setId(rs.getInt("id"));
                p.setNama(rs.getString("nama"));
                p.setNo_pc(rs.getInt("no_pc"));
                p.setPaket(rs.getString("paket"));
                p.setTotal_harga(rs.getDouble("total_harga"));
                lp.add(p);
            }
        } catch (SQLException ex) { ex.printStackTrace(); }
        return lp;
    }
}