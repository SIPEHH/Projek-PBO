/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Pelanggan.*;
import View.Pelanggan.*;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class ControllerPelanggan {
    ViewData frameView;
    InterfaceDAOPelanggan impPelanggan;
    List<ModelPelanggan> lp;

    public ControllerPelanggan(ViewData frameView) {
        this.frameView = frameView;
        impPelanggan = new DAOPelanggan();
    }

    public void isiTable() {
        lp = impPelanggan.getAll();
        ModelTable mt = new ModelTable(lp);
        frameView.getTabelData().setModel(mt);
    }

    public void insert(InputData frameInput) {
        ModelPelanggan p = new ModelPelanggan();
        p.setNama(frameInput.getTxtNama().getText());
        p.setNo_pc(Integer.parseInt(frameInput.getTxtPC().getText()));
        p.setPaket(frameInput.getTxtPaket().getText());
        p.setTotal_harga(Double.parseDouble(frameInput.getTxtHarga().getText()));
        impPelanggan.insert(p);
    }

    public void update(EditData frameEdit) {
        ModelPelanggan p = new ModelPelanggan();
        p.setId(Integer.parseInt(frameEdit.getTxtID().getText()));
        p.setNama(frameEdit.getTxtNama().getText());
        p.setNo_pc(Integer.parseInt(frameEdit.getTxtPC().getText()));
        p.setPaket(frameEdit.getTxtPaket().getText());
        p.setTotal_harga(Double.parseDouble(frameEdit.getTxtHarga().getText()));
        impPelanggan.update(p);
    }

    public void delete(int id) {
        impPelanggan.delete(id);
    }
}
