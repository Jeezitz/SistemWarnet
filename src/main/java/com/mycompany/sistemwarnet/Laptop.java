package com.mycompany.sistemwarnet;

public class Laptop extends Perangkat implements DapatDiberiRating {
    private String processor;
    private String ukuranLayar;

    public Laptop(int id, String namaPerangkat,
                  double hargaPerJam, String status,
                  String processor, String ukuranLayar) {
        super(id, namaPerangkat, hargaPerJam, status);
        setProcessor(processor);
        setUkuranLayar(ukuranLayar);
    }

    public String getProcessor() {
        return this.processor;
    }

    public void setProcessor(String processor) {
        if (processor != null && !processor.trim().isEmpty()) {
            this.processor = processor;
        } else {
            System.out.println("Processor tidak boleh kosong.");
        }
    }

    public String getUkuranLayar() {
        return this.ukuranLayar;
    }

    public void setUkuranLayar(String ukuranLayar) {
        if (ukuranLayar != null && !ukuranLayar.trim().isEmpty()) {
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

    @Override
    public void mulaiLayanan() {
        System.out.println("Laptop siap digunakan untuk bekerja atau bermain.");
    }

    @Override
    public void beriRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            System.out.println("Laptop mendapat rating: " + rating + "/5.");
        } else {
            System.out.println("Rating harus berada pada rentang 1 sampai 5.");
        }
    }
}
