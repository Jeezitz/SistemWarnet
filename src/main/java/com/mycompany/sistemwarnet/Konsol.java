package com.mycompany.sistemwarnet;

public class Konsol extends Perangkat {
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
        } else {
            System.out.println("Jenis konsol tidak boleh kosong.");
        }
    }

    public int getJumlahController() {
        return this.jumlahController;
    }

    public void setJumlahController(int jumlahController) {
        if (jumlahController > 0) {
            this.jumlahController = jumlahController;
        } else {
            System.out.println("Jumlah controller harus lebih dari 0.");
        }
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jenis     : " + this.jenisKonsol);
        System.out.println("Controller: " + this.jumlahController);
        System.out.println("Tipe      : Konsol");
    }
}