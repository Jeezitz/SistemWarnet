package com.mycompany.sistemwarnet;

public class Konsol extends Perangkat implements DapatDisewa {

    private String jenisKonsol;
    private int jumlahController;

    public Konsol(int id, String namaPerangkat,
                  double hargaPerJam, String status,
                  String jenisKonsol, int jumlahController) {

        super(id, namaPerangkat, hargaPerJam, status);
        this.jenisKonsol = jenisKonsol;
        this.jumlahController = jumlahController;
    }

    public String getJenisKonsol() {
        return this.jenisKonsol;
    }

    public void setJenisKonsol(String jenisKonsol) {
        if (!jenisKonsol.isEmpty()) {
            this.jenisKonsol = jenisKonsol;
        }
    }

    public int getJumlahController() {
        return this.jumlahController;
    }

    public void setJumlahController(int jumlahController) {
        if (jumlahController > 0) {
            this.jumlahController = jumlahController;
        }
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jenis      : " + this.jenisKonsol);
        System.out.println("Controller : " + this.jumlahController);
        System.out.println("Tipe       : Konsol");
    }

    @Override
    public void mulaiLayanan() {
        System.out.println("Konsol siap digunakan untuk bermain.");
    }

    @Override
    public void prosesPenyewaan() {
        System.out.println("Proses penyewaan konsol berhasil.");
    }
}