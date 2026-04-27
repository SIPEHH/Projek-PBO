/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Hafiz
 */
public abstract class Member {
    private int id;
    private String nama;
    private int sisaJam;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public int getSisaJam() { return sisaJam; }
    public void setSisaJam(int sisaJam) { this.sisaJam = sisaJam; }

    // Method abstrak untuk Polymorphism
    public abstract String getTipe();
    public abstract double hitungTarif(int tambahJam);
}
