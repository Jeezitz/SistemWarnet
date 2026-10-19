package com.mycompany.sistemwarnet;

public class PC extends Perangkat implements DapatDisewa, DapatDiberiRating {
    private String processor;
    private String kartuGrafis;

    public PC(int id, String namaPerangkat,
              double hargaPerJam, String status,
              String processor, String kartuGrafis) {
        super(id, namaPerangkat, hargaPerJam, status);
        setProcessor(processor);
        setKartuGrafis(kartuGrafis);
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

    public String getKartuGrafis() {
        return this.kartuGrafis;
    }

    public void setKartuGrafis(String kartuGrafis) {
        if (kartuGrafis != null && !kartuGrafis.trim().isEmpty()) {
            this.kartuGrafis = kartuGrafis;
        } else {
            System.out.println("Kartu grafis tidak boleh kosong.");
        }
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Processor: " + this.processor);
        System.out.println("GPU      : " + this.kartuGrafis);
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
        if (rating >= 1 && rating <= 5) {
            System.out.println("PC mendapat rating: " + rating + "/5.");
        } else {
            System.out.println("Rating harus berada pada rentang 1 sampai 5.");
        }
    }
}
