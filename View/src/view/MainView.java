/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

/**
 *
 * @author Hafiz
 */
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainView extends JFrame {
    private MemberController controller;
    private JTable table;
    private JLabel lblClock;

    public MainView() {
        controller = new MemberController();
        setTitle("Net-Management Hub | Member Center");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Header + Multithreading Jam
        lblClock = new JLabel("Memuat waktu...", SwingConstants.CENTER);
        lblClock.setFont(new Font("Consolas", Font.BOLD, 16));
        lblClock.setOpaque(true);
        lblClock.setBackground(Color.DARK_GRAY);
        lblClock.setForeground(Color.CYAN);
        add(lblClock, BorderLayout.NORTH);
        jalankanJamDigital(); // Eksekusi Pilar Multithreading

        // Tabel Data
        table = new JTable(controller.getModelData());
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Panel Aksi Bawah
        JPanel panelAksi = new JPanel();
        JButton btnDaftar = new JButton("Member Baru");
        JButton btnTambahJam = new JButton("Billing (Tambah Jam)");
        JButton btnHapus = new JButton("Hapus Member");

        panelAksi.add(btnDaftar);
        panelAksi.add(btnTambahJam);
        panelAksi.add(btnHapus);
        add(panelAksi, BorderLayout.SOUTH);

        // -- LOGIKA EVENT TOMBOL --

        // Daftar Member Baru
        btnDaftar.addActionListener(e -> {
            String nama = JOptionPane.showInputDialog(this, "Nama Member:");
            if (nama == null || nama.isEmpty()) return;
            
            String[] tipePilihan = {"Regular", "VIP"};
            int tipeIndex = JOptionPane.showOptionDialog(this, "Pilih Tipe Member:", "Tipe Member",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, tipePilihan, tipePilihan[0]);
            
            String jamStr = JOptionPane.showInputDialog(this, "Beli Berapa Jam Awal?");
            if (jamStr != null && !jamStr.isEmpty()) {
                int jam = Integer.parseInt(jamStr);
                Member memberBaru = (tipeIndex == 1) ? new MemberVIP() : new MemberRegular(); // Polymorphism
                memberBaru.setNama(nama);
                controller.daftarMember(memberBaru, jam);
                refreshTabel();
            }
        });

        // Tambah Jam (Update)
        btnTambahJam.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                int id = (int) table.getValueAt(row, 0);
                String tipe = (String) table.getValueAt(row, 2); // Ambil tipe dari tabel
                
                String jamStr = JOptionPane.showInputDialog(this, "Input Tambahan Jam:");
                if (jamStr != null && !jamStr.isEmpty()) {
                    int jam = Integer.parseInt(jamStr);
                    controller.tambahJamBilling(id, tipe, jam);
                    refreshTabel();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Pilih member di tabel dulu!");
            }
        });

        // Hapus Member (Delete)
        btnHapus.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                int id = (int) table.getValueAt(row, 0);
                int konfirmasi = JOptionPane.showConfirmDialog(this, "Hapus member ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (konfirmasi == JOptionPane.YES_OPTION) {
                    controller.hapusMember(id);
                    refreshTabel();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Pilih member di tabel dulu!");
            }
        });
    }

    private void refreshTabel() {
        table.setModel(controller.getModelData());
    }

    // MULTITHREADING: Jam Real-Time
    private void jalankanJamDigital() {
        Thread threadJam = new Thread(() -> {
            try {
                while (true) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    String waktuSekarang = sdf.format(new Date());
                    SwingUtilities.invokeLater(() -> lblClock.setText(" WAKTU SERVER : " + waktuSekarang + " "));
                    Thread.sleep(1000); // Update setiap 1 detik
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadJam.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainView().setVisible(true);
        });
    }
}