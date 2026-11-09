package com.mycompany.sistemwarnet;

public class TransaksiWarnet {

    public void prosesTransaksi(Pelanggan pelanggan, Perangkat perangkat) {
        System.out.println("\n========== TRANSAKSI WARNET ==========");
        System.out.println("Pelanggan : " + pelanggan.getNama());
        System.out.println("Perangkat : " + perangkat.getNamaPerangkat());
        System.out.println("Harga     : Rp" + perangkat.getHargaPerJam() + "/jam");

        if (perangkat.getStatus().equalsIgnoreCase("Tersedia")) {
            perangkat.setStatus("Digunakan");

            System.out.println(
                    "Transaksi berhasil. Perangkat sekarang digunakan.");
        } else {
            System.out.println(
                    "Perangkat sedang digunakan dan tidak dapat dipilih.");
        }
    }
}