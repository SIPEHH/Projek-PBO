/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Pelanggan;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author User
 */
public class ModelTable extends AbstractTableModel {
    List<ModelPelanggan> lp;
    public ModelTable(List<ModelPelanggan> lp) { this.lp = lp; }
    @Override public int getRowCount() { return lp.size(); }
    @Override public int getColumnCount() { return 5; }
    @Override public String getColumnName(int column) {
        switch (column) {
            case 0: return "ID"; case 1: return "Nama"; case 2: return "No PC";
            case 3: return "Paket"; case 4: return "Total Harga"; default: return null;
        }
    }
    @Override public Object getValueAt(int row, int col) {
        switch (col) {
            case 0: return lp.get(row).getId(); case 1: return lp.get(row).getNama();
            case 2: return lp.get(row).getNo_pc(); case 3: return lp.get(row).getPaket();
            case 4: return lp.get(row).getTotal_harga(); default: return null;
        }
    }
}