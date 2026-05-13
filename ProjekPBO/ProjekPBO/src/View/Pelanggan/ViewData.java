/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Pelanggan;
import Controller.ControllerPelanggan;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.*;
/**
 *
 * @author User
 */
public class ViewData extends JFrame {
    ControllerPelanggan ctp;
    private JTable tabelData;
    private JTextField txtCari;
    private JButton btnTambah, btnEdit, btnHapus;

    public ViewData() {
        setTitle("Manajemen Pelanggan Warnet");
        setSize(700, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Inisialisasi Komponen
        tabelData = new JTable();
        txtCari = new JTextField(15);
        btnTambah = new JButton("Tambah Data");
        btnEdit = new JButton("Edit");
        btnHapus = new JButton("Hapus");
        
        // Layout Utama menggunakan BorderLayout
        setLayout(new BorderLayout(10, 10));
        
        // Panel Atas (Tombol & Cari)
        JPanel panelAtas = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelAtas.add(btnTambah);
        panelAtas.add(btnEdit);
        panelAtas.add(btnHapus);
        panelAtas.add(new JLabel(" Cari Nama:"));
        panelAtas.add(txtCari);
        add(panelAtas, BorderLayout.NORTH);
        
        // Panel Tengah (Tabel)
        add(new JScrollPane(tabelData), BorderLayout.CENTER);
        
        // Inisialisasi Controller
        ctp = new ControllerPelanggan(this);
        ctp.isiTable();
        
        // Action Listeners
        btnTambah.addActionListener(e -> {
            new InputData().setVisible(true);
            this.dispose();
        });

        btnEdit.addActionListener(e -> {
            int row = tabelData.getSelectedRow();
            if (row != -1) {
                new EditData(row, this).setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Pilih data di tabel dulu!");
            }
        });

        btnHapus.addActionListener(e -> {
            int row = tabelData.getSelectedRow();
            if (row != -1) {
                int id = (int) tabelData.getValueAt(row, 0);
                int confirm = JOptionPane.showConfirmDialog(null, "Hapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    ctp.delete(id);
                    ctp.isiTable();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Pilih data yang akan dihapus!");
            }
        });
    }

    // Getter untuk Controller
    public JTable getTabelData() { return tabelData; }
    public JTextField getTxtCari() { return txtCari; }
}