
package com.mycompany.sistemwarnet;

import java.io.Serializable;

public abstract class Perangkat implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String namaPerangkat;
    private double hargaPerJam;
    private String status;
    private static int totalPerangkat = 0;

    public Perangkat(int id, String namaPerangkat, double hargaPerJam, String status) {
        this.id = id;
        this.namaPerangkat = namaPerangkat;
        this.hargaPerJam = hargaPerJam;
        this.status = status;
        totalPerangkat++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            System.out.println("ID harus lebih dari 0.");
        }
    }

    public String getNamaPerangkat() {
        return namaPerangkat;
    }

    // Getter tambahan agar sesuai dengan pemanggilan di TransaksiWarnet
    public String getNama() {
        return namaPerangkat;
    }

    public void setNamaPerangkat(String namaPerangkat) {
        if (namaPerangkat != null && !namaPerangkat.isEmpty()) {
            this.namaPerangkat = namaPerangkat;
        } else {
            System.out.println("Nama perangkat tidak boleh kosong.");
        }
    }

    public double getHargaPerJam() {
        return hargaPerJam;
    }

    public void setHargaPerJam(double hargaPerJam) {
        if (hargaPerJam > 0) {
            this.hargaPerJam = hargaPerJam;
        } else {
            System.out.println("Harga per jam harus lebih dari 0.");
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status != null && 
            (status.equalsIgnoreCase("Tersedia") ||
             status.equalsIgnoreCase("Digunakan"))) {
            this.status = status;
        } else {
            System.out.println("Status hanya boleh Tersedia atau Digunakan.");
        }
    }

    public static int getTotalPerangkat() {
        return totalPerangkat;
    }

    public void tampilkanInfo() {
        System.out.println("ID       : " + id);
        System.out.println("Nama     : " + namaPerangkat);
        System.out.println("Harga    : Rp" + hargaPerJam + "/jam");
        System.out.println("Status   : " + status);
    }

    public abstract void mulaiLayanan();
}
