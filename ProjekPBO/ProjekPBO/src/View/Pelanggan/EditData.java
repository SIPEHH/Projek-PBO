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
public class EditData extends JFrame {
    ControllerPelanggan ctp;

    public EditData(int row, ViewData frame) {
        initComponents();
        ctp = new ControllerPelanggan(frame);
        
        // Mengisi otomatis form dengan data dari tabel yang dipilih
        txtID.setText(frame.getTabelData().getValueAt(row, 0).toString());
        txtNama.setText(frame.getTabelData().getValueAt(row, 1).toString());
        txtPC.setText(frame.getTabelData().getValueAt(row, 2).toString());
        txtPaket.setText(frame.getTabelData().getValueAt(row, 3).toString());
        txtHarga.setText(frame.getTabelData().getValueAt(row, 4).toString());
    }

    public JTextField getTxtID() { return txtID; }
    public JTextField getTxtNama() { return txtNama; }
    public JTextField getTxtPC() { return txtPC; }
    public JTextField getTxtPaket() { return txtPaket; }
    public JTextField getTxtHarga() { return txtHarga; }

    private void initComponents() {
        txtID = new JTextField(); txtID.setEditable(false); // ID tidak boleh diedit
        txtNama = new JTextField();
        txtPC = new JTextField();
        txtPaket = new JTextField();
        txtHarga = new JTextField();
        btnUbah = new JButton("Update");
        btnBatal = new JButton("Batal");

        setTitle("Edit Data Pelanggan");

        btnUbah.addActionListener(e -> {
            ctp.update(this);
            new ViewData().setVisible(true);
            this.dispose();
        });

        btnBatal.addActionListener(e -> {
            new ViewData().setVisible(true);
            this.dispose();
        });

        setLayout(new java.awt.GridLayout(6, 2));
        add(new JLabel("ID:")); add(txtID);
        add(new JLabel("Nama:")); add(txtNama);
        add(new JLabel("No PC:")); add(txtPC);
        add(new JLabel("Paket:")); add(txtPaket);
        add(new JLabel("Harga:")); add(txtHarga);
        add(btnUbah); add(btnBatal);
        pack();
        setLocationRelativeTo(null);
    }

    private JButton btnBatal, btnUbah;
    private JTextField txtHarga, txtID, txtNama, txtPC, txtPaket;
}