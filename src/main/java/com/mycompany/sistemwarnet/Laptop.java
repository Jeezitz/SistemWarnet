package com.mycompany.sistemwarnet;

public class Laptop extends Perangkat implements DapatDiberiRating {
    private String processor;
    private String ukuranLayar;

    public Laptop(int id, String namaPerangkat, double hargaPerJam,
                  String status, String processor, String ukuranLayar) {
        super(id, namaPerangkat, hargaPerJam, status);
        this.processor = processor;
        this.ukuranLayar = ukuranLayar;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        if (!processor.isEmpty()) {
            this.processor = processor;
        }
    }

    public String getUkuranLayar() {
        return ukuranLayar;
    }

    public void setUkuranLayar(String ukuranLayar) {
        if (!ukuranLayar.isEmpty()) {
            this.ukuranLayar = ukuranLayar;
        }
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Processor : " + processor);
        System.out.println("Layar     : " + ukuranLayar);
        System.out.println("Tipe      : Laptop");
    }

    @Override
    public void mulaiLayanan() {
        System.out.println("Laptop siap digunakan untuk bekerja atau bermain.");
    }

    @Override
    public void beriRating(int rating) {
        System.out.println("Laptop mendapat rating: " + rating + "/5.");
    }
}