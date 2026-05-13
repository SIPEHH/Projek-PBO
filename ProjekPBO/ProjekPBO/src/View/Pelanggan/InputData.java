/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Pelanggan;
import Controller.ControllerPelanggan;
import javax.swing.*;
/**
 *
 * @author User
 */
public class InputData extends JFrame {
    ControllerPelanggan ctp;

    public InputData() {
        initComponents();
        // Karena insert butuh ViewData untuk refresh tabel, kita buat objek dummy atau langsung redirect
        ctp = new ControllerPelanggan(null); 
    }

    // Getter untuk Controller
    public JTextField getTxtNama() { return txtNama; }
    public JTextField getTxtPC() { return txtPC; }
    public JTextField getTxtPaket() { return txtPaket; }
    public JTextField getTxtHarga() { return txtHarga; }

    private void initComponents() {
        txtNama = new JTextField();
        txtPC = new JTextField();
        txtPaket = new JTextField();
        txtHarga = new JTextField();
        btnSimpan = new JButton("Simpan");
        btnBatal = new JButton("Batal");

        setTitle("Input Pelanggan Baru");

        btnSimpan.addActionListener(e -> {
            ctp.insert(this);
            new ViewData().setVisible(true);
            this.dispose();
        });

        btnBatal.addActionListener(e -> {
            new ViewData().setVisible(true);
            this.dispose();
        });

        // Bagian Layouting (Form Sederhana)
        setLayout(new java.awt.GridLayout(5, 2));
        add(new JLabel("Nama:")); add(txtNama);
        add(new JLabel("No PC:")); add(txtPC);
        add(new JLabel("Paket:")); add(txtPaket);
        add(new JLabel("Harga:")); add(txtHarga);
        add(btnSimpan); add(btnBatal);
        pack();
        setLocationRelativeTo(null);
    }

    private JButton btnBatal, btnSimpan;
    private JTextField txtHarga, txtNama, txtPC, txtPaket;
}