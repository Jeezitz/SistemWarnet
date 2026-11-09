package com.mycompany.sistemwarnet;

public class RuanganWarnet {
    private String namaRuangan;
    private int kapasitas;

    public RuanganWarnet(String namaRuangan, int kapasitas) {
        this.namaRuangan = namaRuangan;
        this.kapasitas = kapasitas;
    }

    public String getNamaRuangan() {
        return namaRuangan;
    }

    public void setNamaRuangan(String namaRuangan) {
        if (!namaRuangan.isEmpty()) {
            this.namaRuangan = namaRuangan;
        }
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        if (kapasitas > 0) {
            this.kapasitas = kapasitas;
        }
    }

    public void tampilkanInfo() {
        System.out.println("Nama Ruangan : " + namaRuangan);
        System.out.println("Kapasitas    : " + kapasitas + " orang");
    }
}