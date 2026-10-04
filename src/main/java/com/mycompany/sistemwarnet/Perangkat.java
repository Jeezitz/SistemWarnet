package com.mycompany.sistemwarnet;

public class Perangkat {
    private int id;
    private String namaPerangkat;
    private double hargaPerJam;
    private String status;

    private static int totalPerangkat = 0;

    public Perangkat(int id, String namaPerangkat,
                     double hargaPerJam, String status) {
        this.id = id;
        this.namaPerangkat = namaPerangkat;
        this.hargaPerJam = hargaPerJam;
        this.status = status;
        totalPerangkat++;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            System.out.println("ID harus lebih dari 0.");
        }
    }

    public String getNamaPerangkat() {
        return this.namaPerangkat;
    }

    public void setNamaPerangkat(String namaPerangkat) {
        if (!namaPerangkat.isEmpty()) {
            this.namaPerangkat = namaPerangkat;
        } else {
            System.out.println("Nama perangkat tidak boleh kosong.");
        }
    }

    public double getHargaPerJam() {
        return this.hargaPerJam;
    }

    public void setHargaPerJam(double hargaPerJam) {
        if (hargaPerJam > 0) {
            this.hargaPerJam = hargaPerJam;
        } else {
            System.out.println("Harga per jam harus lebih dari 0.");
        }
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        if (status.equalsIgnoreCase("Tersedia")
                || status.equalsIgnoreCase("Digunakan")) {
            this.status = status;
        } else {
            System.out.println("Status hanya boleh Tersedia atau Digunakan.");
        }
    }

    public static int getTotalPerangkat() {
        return totalPerangkat;
    }

    public void tampilkanInfo() {
        System.out.println("ID       : " + this.id);
        System.out.println("Nama     : " + this.namaPerangkat);
        System.out.println("Harga    : Rp" + this.hargaPerJam + "/jam");
        System.out.println("Status   : " + this.status);
    }
}