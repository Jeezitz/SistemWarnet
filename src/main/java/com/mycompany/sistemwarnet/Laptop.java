package com.mycompany.sistemwarnet;

public class Laptop extends Perangkat {
    private String processor;
    private String ukuranLayar;

    public Laptop(int id, String namaPerangkat,
                  double hargaPerJam, String status,
                  String processor, String ukuranLayar) {

        super(id, namaPerangkat, hargaPerJam, status);
        this.processor = processor;
        this.ukuranLayar = ukuranLayar;
    }

    public String getProcessor() {
        return this.processor;
    }

    public void setProcessor(String processor) {
        if (!processor.isEmpty()) {
            this.processor = processor;
        } else {
            System.out.println("Processor tidak boleh kosong.");
        }
    }

    public String getUkuranLayar() {
        return this.ukuranLayar;
    }

    public void setUkuranLayar(String ukuranLayar) {
        if (!ukuranLayar.isEmpty()) {
            this.ukuranLayar = ukuranLayar;
        } else {
            System.out.println("Ukuran layar tidak boleh kosong.");
        }
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Processor : " + this.processor);
        System.out.println("Layar     : " + this.ukuranLayar);
        System.out.println("Tipe      : Laptop");
    }
}