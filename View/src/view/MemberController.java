/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Hafiz
 */
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class MemberController {

    // CREATE: Tambah Member Baru
    public void daftarMember(Member member, int jamAwal) {
        double biayaAwal = member.hitungTarif(jamAwal);
        String sql = "INSERT INTO tb_member (nama, tipe, sisa_jam, total_pengeluaran) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, member.getNama());
            pstmt.setString(2, member.getTipe());
            pstmt.setInt(3, jamAwal);
            pstmt.setDouble(4, biayaAwal);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ: Tampil Data
    public DefaultTableModel getModelData() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Nama", "Tipe", "Sisa Jam", "Total Pengeluaran"}, 0);
        String sql = "SELECT * FROM tb_member";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"), 
                    rs.getString("nama"), 
                    rs.getString("tipe"), 
                    rs.getInt("sisa_jam"), 
                    rs.getDouble("total_pengeluaran")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }

    // UPDATE: Tambah Jam Billing
    public void tambahJamBilling(int id, String tipe, int jamTambahan) {
        Member dummyMember = tipe.equals("VIP") ? new MemberVIP() : new MemberRegular();
        double biayaTambahan = dummyMember.hitungTarif(jamTambahan);

        String sql = "UPDATE tb_member SET sisa_jam = sisa_jam + ?, total_pengeluaran = total_pengeluaran + ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, jamTambahan);
            pstmt.setDouble(2, biayaTambahan);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE: Hapus Member
    public void hapusMember(int id) {
        String sql = "DELETE FROM tb_member WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}