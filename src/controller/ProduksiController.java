package controller;

import java.util.List;
import DAOData.ProduksiDAO;
import DAOImplement.ProduksiImplement;
import javax.swing.JOptionPane;
import model.*;
import view.MainView;

public class ProduksiController {
    MainView frame;
    
    ProduksiImplement implProduksi;
    List<ProduksiModel> pm;
    
    public ProduksiController(MainView frame) {
        this.frame = frame;
        implProduksi = new ProduksiDAO();
        pm = implProduksi.getAll(new ProduksiModel());
    }
    
    public void isiTabel() {
        pm = implProduksi.getAll(new ProduksiModel());
        TabelProduksiModel tabel = new TabelProduksiModel(pm);
        frame.getjTableProduksi().setModel(tabel);
    }
    
    public void insert() {
        ProduksiModel pm = new ProduksiModel();
        
        if(false) {
            System.out.println("halo");
        } else {
            String nama = frame.getjTextFieldNama().getText();
            int jumlahUnit = Integer.parseInt(frame.getjTextFieldJumlahUnit().getText());
            int jamKerja = Integer.parseInt(frame.getjTextFieldJamKerja().getText());
            int jumlahTenagaKerja = Integer.parseInt(frame.getjTextFieldJumlahTenagaKerja().getText());
            int biayaBahanBaku = Integer.parseInt(frame.getjTextFieldBiayaBahanBaku().getText());
            
            int biayaTenagaKerja = jamKerja * jumlahTenagaKerja * 15000;
            double efisiensi = (jumlahUnit / (jamKerja * jumlahTenagaKerja)) * 100;
            int total = biayaBahanBaku + biayaTenagaKerja;
            
            pm.setNama(nama);
            pm.setBiayaTenagaKerja(biayaTenagaKerja);
            pm.setEfisiensiProduksi(efisiensi);
            pm.setTotalBiayaProduksi(total);
            
            if(efisiensi <= 20) {
                JOptionPane.showMessageDialog(frame, "Efisiensi kurang dari 20%","Gagal", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            implProduksi.insert(pm);
            
            JOptionPane.showMessageDialog(frame, "Data berhasil disimpan","Sukses", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void delete() {
        int baris = frame.getjTableProduksi().getSelectedRow();
        
        if(baris != -1) {
            ProduksiModel produksi = pm.get(baris);
            int id = produksi.getId();
            int konfirmasi = JOptionPane.showConfirmDialog(frame, "Yakin hapus data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            
            if(konfirmasi == JOptionPane.YES_OPTION) {
                implProduksi.delete(id);
                JOptionPane.showMessageDialog(frame, "Data berhasil dihapus","Sukses", JOptionPane.INFORMATION_MESSAGE);
                
            } else {
                frame.getjTextFieldNama().setText("");
                frame.getjTextFieldJumlahUnit().setText("");
                frame.getjTextFieldJamKerja().setText("");
                frame.getjTextFieldJumlahTenagaKerja().setText("");
                frame.getjTextFieldBiayaBahanBaku().setText("");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Pilih data yang ingin dihapus","Kesalahan", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void update() {
        int baris = frame.getjTableProduksi().getSelectedRow();
        
        if(baris != -1) {
            ProduksiModel produksi = pm.get(baris);
            
            int jumlahUnit = Integer.parseInt(frame.getjTextFieldJumlahUnit().getText());
            int jamKerja = Integer.parseInt(frame.getjTextFieldJamKerja().getText());
            int jumlahTenagaKerja = Integer.parseInt(frame.getjTextFieldJumlahTenagaKerja().getText());
            int biayaBahanBaku = Integer.parseInt(frame.getjTextFieldBiayaBahanBaku().getText());
            
            int biayaTenagaKerja = jamKerja * jumlahTenagaKerja * 15000;
            double efisiensi = (jumlahUnit / (jamKerja * jumlahTenagaKerja)) * 100;
            int total = biayaBahanBaku + biayaTenagaKerja;
            
           
            
        } else {
            JOptionPane.showMessageDialog(frame, "Pilih data yang ingin dihapus","Kesalahan", JOptionPane.WARNING_MESSAGE);
        }
    }
}
