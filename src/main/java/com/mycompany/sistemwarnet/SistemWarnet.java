package com.mycompany.sistemwarnet;

import java.util.Scanner;

public class SistemWarnet {
    static Perangkat[] daftarPerangkat = new Perangkat[10];
    static int jumlahPerangkat = 0;

    public static void cariPerangkat(String nama) {
        boolean ditemukan = false;

        for (int i = 0; i < jumlahPerangkat; i++) {
            if (daftarPerangkat[i].getNamaPerangkat().equalsIgnoreCase(nama)) {
                System.out.println("\nPerangkat ditemukan:");
                daftarPerangkat[i].tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Perangkat tidak ditemukan.");
        }
    }

    public static void cariPerangkat(int id) {
        boolean ditemukan = false;

        for (int i = 0; i < jumlahPerangkat; i++) {
            if (daftarPerangkat[i].getId() == id) {
                System.out.println("\nPerangkat ditemukan:");
                daftarPerangkat[i].tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Perangkat tidak ditemukan.");
        }
    }

    public static void mulaiPenggunaan(Perangkat perangkat) {
        System.out.println("\n========== SIMULASI PENGGUNAAN ==========");
        System.out.println("Perangkat yang dipilih: " + perangkat.getNamaPerangkat());
        perangkat.mulaiLayanan();
        System.out.println("Simulasi penggunaan selesai.");
    }

    public static void jalankanFiturInterface(Perangkat perangkat) {
        System.out.println("\n========== FITUR INTERFACE ==========");
        System.out.println("Perangkat: " + perangkat.getNamaPerangkat());

        if (perangkat instanceof DapatDisewa) {
            DapatDisewa sewaan = (DapatDisewa) perangkat;
            sewaan.prosesPenyewaan();
        } else {
            System.out.println("Perangkat ini tidak menyediakan fitur penyewaan.");
        }

        if (perangkat instanceof DapatDiberiRating) {
            DapatDiberiRating penilaian = (DapatDiberiRating) perangkat;
            penilaian.beriRating(5);
        } else {
            System.out.println("Perangkat ini tidak menyediakan fitur rating.");
        }
    }

    public static void tampilkanDaftarSingkat() {
        for (int i = 0; i < jumlahPerangkat; i++) {
            System.out.println((i + 1) + ". "
                    + daftarPerangkat[i].getNamaPerangkat()
                    + " (" + daftarPerangkat[i].getClass().getSimpleName() + ")");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        daftarPerangkat[jumlahPerangkat++] =
                new PC(1, "PC-01", 5000, "Tersedia", "Intel Core i5", "RTX 3060");
        daftarPerangkat[jumlahPerangkat++] =
                new PC(2, "PC-02", 5000, "Digunakan", "Ryzen 5", "GTX 1660");
        daftarPerangkat[jumlahPerangkat++] =
                new Konsol(3, "PS-01", 10000, "Tersedia", "PlayStation 5", 2);
        daftarPerangkat[jumlahPerangkat++] =
                new Konsol(4, "PS-02", 8000, "Digunakan", "PlayStation 4", 2);
        daftarPerangkat[jumlahPerangkat++] =
                new Laptop(5, "LAP-01", 7000, "Tersedia", "Ryzen 5", "15.6 Inch");

        boolean isRunning = true;

        System.out.println("==========================================");
        System.out.println("       SISTEM PENGELOLAAN WARNET");
        System.out.println("==========================================");

        while (isRunning) {
            System.out.println("\n------------ MENU UTAMA ------------");
            System.out.println("1. Tambah Data Perangkat");
            System.out.println("2. Tampilkan Seluruh Data");
            System.out.println("3. Cari Perangkat");
            System.out.println("4. Simulasi Penggunaan");
            System.out.println("5. Jalankan Fitur Interface");
            System.out.println("6. Keluar");
            System.out.println("------------------------------------");
            System.out.print("Pilih menu: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    if (jumlahPerangkat >= daftarPerangkat.length) {
                        System.out.println("Data perangkat sudah penuh.");
                        break;
                    }

                    System.out.println("\n=== TAMBAH DATA PERANGKAT ===");
                    System.out.println("1. PC");
                    System.out.println("2. Konsol");
                    System.out.println("3. Laptop");
                    System.out.print("Pilih tipe: ");
                    int tipe = scanner.nextInt();
                    scanner.nextLine();

                    if (tipe < 1 || tipe > 3) {
                        System.out.println("Tipe perangkat tidak valid.");
                        break;
                    }

                    System.out.print("ID perangkat: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nama perangkat: ");
                    String nama = scanner.nextLine();

                    System.out.print("Harga per jam: ");
                    double harga = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Status (Tersedia/Digunakan): ");
                    String status = scanner.nextLine();

                    if (tipe == 1) {
                        System.out.print("Processor: ");
                        String processor = scanner.nextLine();

                        System.out.print("Kartu grafis: ");
                        String gpu = scanner.nextLine();

                        daftarPerangkat[jumlahPerangkat++] =
                                new PC(id, nama, harga, status, processor, gpu);
                        System.out.println("Data PC berhasil ditambahkan.");
                    } else if (tipe == 2) {
                        System.out.print("Jenis konsol: ");
                        String jenisKonsol = scanner.nextLine();

                        System.out.print("Jumlah controller: ");
                        int controller = scanner.nextInt();
                        scanner.nextLine();

                        daftarPerangkat[jumlahPerangkat++] =
                                new Konsol(id, nama, harga, status, jenisKonsol, controller);
                        System.out.println("Data konsol berhasil ditambahkan.");
                    } else {
                        System.out.print("Processor: ");
                        String processor = scanner.nextLine();

                        System.out.print("Ukuran layar: ");
                        String layar = scanner.nextLine();

                        daftarPerangkat[jumlahPerangkat++] =
                                new Laptop(id, nama, harga, status, processor, layar);
                        System.out.println("Data laptop berhasil ditambahkan.");
                    }
                    break;

                case 2:
                    if (jumlahPerangkat == 0) {
                        System.out.println("Belum ada data perangkat.");
                    } else {
                        System.out.println("\n========== DAFTAR PERANGKAT ==========");
                        for (int i = 0; i < jumlahPerangkat; i++) {
                            System.out.println("\nData ke-" + (i + 1));
                            System.out.println("--------------------------------------");
                            daftarPerangkat[i].tampilkanInfo();
                        }
                        System.out.println("\nTotal objek perangkat: "
                                + Perangkat.getTotalPerangkat());
                    }
                    break;

                case 3:
                    System.out.println("\n========== PENCARIAN ==========");
                    System.out.println("1. Cari berdasarkan ID");
                    System.out.println("2. Cari berdasarkan Nama");
                    System.out.print("Pilih: ");
                    int jenisCari = scanner.nextInt();
                    scanner.nextLine();

                    if (jenisCari == 1) {
                        System.out.print("Masukkan ID: ");
                        int idCari = scanner.nextInt();
                        scanner.nextLine();
                        cariPerangkat(idCari);
                    } else if (jenisCari == 2) {
                        System.out.print("Masukkan nama: ");
                        String namaCari = scanner.nextLine();
                        cariPerangkat(namaCari);
                    } else {
                        System.out.println("Pilihan pencarian tidak valid.");
                    }
                    break;

                case 4:
                    if (jumlahPerangkat == 0) {
                        System.out.println("Belum ada perangkat.");
                        break;
                    }

                    System.out.println("\n===== SIMULASI PENGGUNAAN =====");
                    tampilkanDaftarSingkat();
                    System.out.print("Pilih perangkat: ");
                    int pilihanPenggunaan = scanner.nextInt();
                    scanner.nextLine();

                    if (pilihanPenggunaan >= 1 && pilihanPenggunaan <= jumlahPerangkat) {
                        mulaiPenggunaan(daftarPerangkat[pilihanPenggunaan - 1]);
                    } else {
                        System.out.println("Pilihan perangkat tidak valid.");
                    }
                    break;

                case 5:
                    if (jumlahPerangkat == 0) {
                        System.out.println("Belum ada perangkat.");
                        break;
                    }

                    System.out.println("\n===== FITUR INTERFACE =====");
                    tampilkanDaftarSingkat();
                    System.out.print("Pilih perangkat: ");
                    int pilihanFitur = scanner.nextInt();
                    scanner.nextLine();

                    if (pilihanFitur >= 1 && pilihanFitur <= jumlahPerangkat) {
                        jalankanFiturInterface(daftarPerangkat[pilihanFitur - 1]);
                    } else {
                        System.out.println("Pilihan perangkat tidak valid.");
                    }
                    break;

                case 6:
                    isRunning = false;
                    System.out.println("Terima kasih telah menggunakan Sistem Warnet.");
                    break;

                default:
                    System.out.println("Pilihan menu tidak tersedia.");
            }
        }

        scanner.close();
    }
}
