package com.mycompany.sistemwarnet;

public class Perangkat {
    int id;
    String namaPerangkat;
    double hargaPerJam;
    String status;

    public Perangkat(int id, String namaPerangkat,
                     double hargaPerJam, String status) {
        this.id = id;
        this.namaPerangkat = namaPerangkat;
        this.hargaPerJam = hargaPerJam;
        this.status = status;
    }

    public void tampilkanInfo() {
        System.out.println("ID       : " + id);
        System.out.println("Nama     : " + namaPerangkat);
        System.out.println("Harga    : Rp" + hargaPerJam + "/jam");
        System.out.println("Status   : " + status);
    }
}