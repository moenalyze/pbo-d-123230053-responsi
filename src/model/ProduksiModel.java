package model;

public class ProduksiModel {
    private int id;
    private String nama;
    private int biayaTenagaKerja;
    private double efisiensiProduksi;
    private int totalBiayaProduksi;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getBiayaTenagaKerja() {
        return biayaTenagaKerja;
    }

    public void setBiayaTenagaKerja(int biayaTenagaKerja) {
        this.biayaTenagaKerja = biayaTenagaKerja;
    }

    public double getEfisiensiProduksi() {
        return efisiensiProduksi;
    }

    public void setEfisiensiProduksi(double efisiensiProduksi) {
        this.efisiensiProduksi = efisiensiProduksi;
    }

    public int getTotalBiayaProduksi() {
        return totalBiayaProduksi;
    }

    public void setTotalBiayaProduksi(int totalBiayaProduksi) {
        this.totalBiayaProduksi = totalBiayaProduksi;
    }
}
