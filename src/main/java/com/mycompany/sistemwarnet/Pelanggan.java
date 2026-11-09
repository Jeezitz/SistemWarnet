package com.mycompany.sistemwarnet;

public class Pelanggan {
    private String idPelanggan;
    private String nama;

    public Pelanggan(String idPelanggan, String nama) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(String idPelanggan) {
        if (idPelanggan != null && !idPelanggan.isEmpty()) {
            this.idPelanggan = idPelanggan;
        }
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        if (nama != null && !nama.isEmpty()) {
            this.nama = nama;
        }
    }

    public void tampilkanInfo() {
        System.out.println("ID   : " + idPelanggan);
        System.out.println("Nama : " + nama);
    }
}