package com.mycompany.sistemwarnet;

public class PC extends Perangkat implements DapatDisewa, DapatDiberiRating {
    private String processor;
    private String kartuGrafis;

    public PC(int id, String namaPerangkat, double hargaPerJam,
              String status, String processor, String kartuGrafis) {
        super(id, namaPerangkat, hargaPerJam, status);
        this.processor = processor;
        this.kartuGrafis = kartuGrafis;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        if (!processor.isEmpty()) {
            this.processor = processor;
        }
    }

    public String getKartuGrafis() {
        return kartuGrafis;
    }

    public void setKartuGrafis(String kartuGrafis) {
        if (!kartuGrafis.isEmpty()) {
            this.kartuGrafis = kartuGrafis;
        }
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Processor: " + processor);
        System.out.println("GPU      : " + kartuGrafis);
        System.out.println("Tipe     : PC");
    }

    @Override
    public void mulaiLayanan() {
        System.out.println("PC siap digunakan untuk bermain game.");
    }

    @Override
    public void prosesPenyewaan() {
        System.out.println("Proses penyewaan PC berhasil.");
    }

    @Override
    public void beriRating(int rating) {
        System.out.println("PC mendapat rating: " + rating + "/5.");
    }
}