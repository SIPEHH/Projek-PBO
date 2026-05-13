/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author User
 */
public class Connector {
    private static Connection koneksi;

    public static Connection connection() {
        if (koneksi == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/db_warnet";
                String user = "root";
                String password = ""; 
                
                DriverManager.registerDriver(new Driver());
                koneksi = DriverManager.getConnection(url, user, password);
                System.out.println("Koneksi Berhasil!");
            } catch (SQLException e) {
                System.err.println("Koneksi Gagal: " + e.getMessage());
            }
        }
        return koneksi;
    }
}
