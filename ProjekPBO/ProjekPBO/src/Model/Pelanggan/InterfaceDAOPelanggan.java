/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.Pelanggan;
import java.util.List;
/**
 *
 * @author User
 */
public interface InterfaceDAOPelanggan {
    public void insert(ModelPelanggan p);
    public void update(ModelPelanggan p);
    public void delete(int id);
    public List<ModelPelanggan> getAll();
    public List<ModelPelanggan> getCariNama(String nama);
}