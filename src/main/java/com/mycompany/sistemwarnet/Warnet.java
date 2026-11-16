
package com.mycompany.sistemwarnet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Warnet implements Serializable {

    private static final long serialVersionUID = 1L;

    private String namaWarnet;
    private ArrayList<Perangkat> daftarPerangkat;
    private HashMap<String, Pelanggan> dataPelanggan;
    private RuanganWarnet ruangan;

    public Warnet(String namaWarnet) {
        this.namaWarnet = namaWarnet;
        this.daftarPerangkat = new ArrayList<>();
        this.dataPelanggan = new HashMap<>();

        this.ruangan = new RuanganWarnet("Ruang Utama", 20);
    }

    public String getNamaWarnet() {
        return namaWarnet;
    }

    public void setNamaWarnet(String namaWarnet) {
        if (namaWarnet != null && !namaWarnet.isEmpty()) {
            this.namaWarnet = namaWarnet;
        }
    }

    public RuanganWarnet getRuangan() {
        return ruangan;
    }

    public void tambahPerangkat(Perangkat perangkat) {
        daftarPerangkat.add(perangkat);
    }

    public void tambahPelanggan(Pelanggan pelanggan) {
        dataPelanggan.put(pelanggan.getIdPelanggan(), pelanggan);
    }

    public ArrayList<Perangkat> getDaftarPerangkat() {
        return daftarPerangkat;
    }

    public HashMap<String, Pelanggan> getDataPelanggan() {
        return dataPelanggan;
    }

    // Pencarian perangkat menggunakan ID String
    public Perangkat cariPerangkat(String id)
            throws PerangkatTidakDitemukanException {

        for (Perangkat perangkat : daftarPerangkat) {
            if (String.valueOf(perangkat.getId()).equals(id)) {
                return perangkat;
            }
        }

        throw new PerangkatTidakDitemukanException(
                "Perangkat dengan ID tersebut tidak ditemukan.");
    }

    // Overloading untuk pencarian menggunakan ID angka
    public Perangkat cariPerangkat(int id)
            throws PerangkatTidakDitemukanException {

        return cariPerangkat(String.valueOf(id));
    }

    public Pelanggan cariPelanggan(String id)
            throws PerangkatTidakDitemukanException {

        if (dataPelanggan.containsKey(id)) {
            return dataPelanggan.get(id);
        }

        throw new PerangkatTidakDitemukanException(
                "Pelanggan dengan ID tersebut tidak ditemukan.");
    }

    public void tampilkanPerangkat() {
        if (daftarPerangkat.isEmpty()) {
            System.out.println("Belum ada data perangkat.");
            return;
        }

        System.out.println("\n========== DAFTAR PERANGKAT ==========");

        for (int i = 0; i < daftarPerangkat.size(); i++) {
            System.out.println("\nData ke-" + (i + 1));
            System.out.println("--------------------------------------");
            daftarPerangkat.get(i).tampilkanInfo();
        }
    }

    public void tampilkanPelanggan() {
        if (dataPelanggan.isEmpty()) {
            System.out.println("Belum ada data pelanggan.");
            return;
        }

        System.out.println("\n========== DAFTAR PELANGGAN ==========");

        for (Pelanggan pelanggan : dataPelanggan.values()) {
            pelanggan.tampilkanInfo();
            System.out.println("----------------------");
        }
    }

    public void tampilkanInfoWarnet() {
        System.out.println("\n========== INFORMASI WARNET ==========");
        System.out.println("Nama Warnet       : " + namaWarnet);
        ruangan.tampilkanInfo();
        System.out.println("Jumlah Perangkat  : " + daftarPerangkat.size());
        System.out.println("Jumlah Pelanggan  : " + dataPelanggan.size());
    }
}
