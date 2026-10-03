package com.mycompany.sistemwarnet;

public class SistemWarnet {
    public static void main(String[] args) {
        Perangkat perangkat = new Perangkat(
                1,
                "PC-01",
                5000,
                "Tersedia"
        );

        perangkat.tampilkanInfo();
    }
}