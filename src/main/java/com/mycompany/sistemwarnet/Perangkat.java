package com.mycompany.sistemwarnet;

public abstract class Perangkat {
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
        }
    }

    public String getNamaPerangkat() {
        return namaPerangkat;
    }

    public void setNamaPerangkat(String namaPerangkat) {
        if (namaPerangkat != null && !namaPerangkat.isEmpty()) {
            this.namaPerangkat = namaPerangkat;
        }
    }

    public double getHargaPerJam() {
        return hargaPerJam;
    }

    public void setHargaPerJam(double hargaPerJam) {
        if (hargaPerJam > 0) {
            this.hargaPerJam = hargaPerJam;
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status.equalsIgnoreCase("Tersedia")
                || status.equalsIgnoreCase("Digunakan")) {
            this.status = status;
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