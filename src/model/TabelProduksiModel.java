package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelProduksiModel extends AbstractTableModel{
    List<ProduksiModel> pm;
    
    public TabelProduksiModel(List<ProduksiModel> pm) {
        this.pm = pm;
    }

    @Override
    public int getRowCount() {
        return pm.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
               return "Nama Produk";
            case 1:
               return "Biaya Tenaga Kerja";
            case 2:
               return "Efisiensi Produksi";
            case 3:
               return "Total Biaya Produksi";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
               return pm.get(row).getNama();
            case 1:
               return pm.get(row).getBiayaTenagaKerja();
            case 2:
               return pm.get(row).getEfisiensiProduksi();
            case 3:
               return pm.get(row).getTotalBiayaProduksi();
            default:
                return null;
        }
    }
    
}
