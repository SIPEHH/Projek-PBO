/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Pelanggan;

/**
 *
 * @author User
 */
public class ModelPelanggan {
    private Integer id;
    private String nama;
    private Integer no_pc;
    private String paket;
    private Double total_harga;

    // Getter dan Setter
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public Integer getNo_pc() { return no_pc; }
    public void setNo_pc(Integer no_pc) { this.no_pc = no_pc; }
    public String getPaket() { return paket; }
    public void setPaket(String paket) { this.paket = paket; }
    public Double getTotal_harga() { return total_harga; }
    public void setTotal_harga(Double total_harga) { this.total_harga = total_harga; }
}
