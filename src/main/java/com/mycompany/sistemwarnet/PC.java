package com.mycompany.sistemwarnet;

public class PC extends Perangkat {
    private String processor;
    private String kartuGrafis;

    public PC(int id, String namaPerangkat,
              double hargaPerJam, String status,
              String processor, String kartuGrafis) {
        super(id, namaPerangkat, hargaPerJam, status);
        this.processor = processor;
        this.kartuGrafis = kartuGrafis;
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

    public String getKartuGrafis() {
        return this.kartuGrafis;
    }

    public void setKartuGrafis(String kartuGrafis) {
        if (!kartuGrafis.isEmpty()) {
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
}