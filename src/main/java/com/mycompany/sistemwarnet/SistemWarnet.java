package com.mycompany.sistemwarnet;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemWarnet {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Warnet warnet = new Warnet("Sistem Warnet Gaming");
        TransaksiWarnet transaksi = new TransaksiWarnet();

        warnet.tambahPerangkat(
                new PC(1, "PC-01", 5000,
                        "Tersedia", "Intel Core i5", "RTX 3060"));

        warnet.tambahPerangkat(
                new PC(2, "PC-02", 5000,
                        "Digunakan", "Ryzen 5", "GTX 1660"));

        warnet.tambahPerangkat(
                new Konsol(3, "PS-01", 10000,
                        "Tersedia", "PlayStation 5", 2));

        warnet.tambahPerangkat(
                new Konsol(4, "PS-02", 8000,
                        "Tersedia", "PlayStation 4", 2));

        warnet.tambahPerangkat(
                new Laptop(5, "LAP-01", 7000,
                        "Tersedia", "Ryzen 5", "15.6 Inch"));

        warnet.tambahPelanggan(
                new Pelanggan("PLG001", "Andi"));

        warnet.tambahPelanggan(
                new Pelanggan("PLG002", "Budi"));

        warnet.tambahPelanggan(
                new Pelanggan("PLG003", "Citra"));

        boolean berjalan = true;

        System.out.println("==========================================");
        System.out.println("       SISTEM PENGELOLAAN WARNET");
        System.out.println("==========================================");

        while (berjalan) {

            try {
                System.out.println("\n------------ MENU UTAMA ------------");
                System.out.println("1. Tambah Data Perangkat");
                System.out.println("2. Tampilkan Seluruh Perangkat");
                System.out.println("3. Cari Perangkat");
                System.out.println("4. Kelola Data Pelanggan");
                System.out.println("5. Informasi Warnet dan Ruangan");
                System.out.println("6. Simulasi Penggunaan");
                System.out.println("7. Jalankan Transaksi Warnet");
                System.out.println("8. Keluar");
                System.out.println("------------------------------------");

                System.out.print("Pilih menu: ");

                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {

                    case 1:
                        tambahPerangkat(scanner, warnet);
                        break;

                    case 2:
                        warnet.tampilkanPerangkat();
                        break;

                    case 3:
                        System.out.print("Masukkan ID perangkat: ");
                        int idCari = scanner.nextInt();
                        scanner.nextLine();

                        Perangkat perangkat =
                                warnet.cariPerangkat(idCari);

                        System.out.println("\nPerangkat ditemukan:");
                        perangkat.tampilkanInfo();
                        break;

                    case 4:
                        kelolaPelanggan(scanner, warnet);
                        break;

                    case 5:
                        warnet.tampilkanInfoWarnet();
                        break;

                    case 6:
                        simulasiPenggunaan(scanner, warnet);
                        break;

                    case 7:
                        jalankanTransaksi(
                                scanner, warnet, transaksi);
                        break;

                    case 8:
                        berjalan = false;
                        System.out.println(
                                "Terima kasih telah menggunakan Sistem Warnet.");
                        break;

                    default:
                        System.out.println(
                                "Pilihan menu tidak tersedia.");
                }

            } catch (InputMismatchException e) {

                System.out.println(
                        "Error: Input harus berupa angka.");

                scanner.nextLine();

            } catch (PerangkatTidakDitemukanException e) {

                System.out.println(
                        "Error: " + e.getMessage());

            } finally {

                System.out.println(
                        "Program selesai memproses pilihan.");
            }
        }

        scanner.close();
    }

    public static void tambahPerangkat(
            Scanner scanner, Warnet warnet) {

        System.out.println("\n=== TAMBAH DATA PERANGKAT ===");
        System.out.println("1. PC");
        System.out.println("2. Konsol");
        System.out.println("3. Laptop");

        System.out.print("Pilih tipe: ");
        int tipe = scanner.nextInt();
        scanner.nextLine();

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

            warnet.tambahPerangkat(
                    new PC(id, nama, harga,
                            status, processor, gpu));

            System.out.println(
                    "Data PC berhasil ditambahkan.");

        } else if (tipe == 2) {

            System.out.print("Jenis konsol: ");
            String jenis = scanner.nextLine();

            System.out.print("Jumlah controller: ");
            int controller = scanner.nextInt();
            scanner.nextLine();

            warnet.tambahPerangkat(
                    new Konsol(id, nama, harga,
                            status, jenis, controller));

            System.out.println(
                    "Data Konsol berhasil ditambahkan.");

        } else if (tipe == 3) {

            System.out.print("Processor: ");
            String processor = scanner.nextLine();

            System.out.print("Ukuran layar: ");
            String layar = scanner.nextLine();

            warnet.tambahPerangkat(
                    new Laptop(id, nama, harga,
                            status, processor, layar));

            System.out.println(
                    "Data Laptop berhasil ditambahkan.");

        } else {

            System.out.println(
                    "Tipe perangkat tidak valid.");
        }
    }

    public static void kelolaPelanggan(
            Scanner scanner, Warnet warnet)
            throws PerangkatTidakDitemukanException {

        System.out.println(
                "\n===== KELOLA DATA PELANGGAN =====");

        System.out.println("1. Tambah Pelanggan");
        System.out.println("2. Cari Pelanggan");
        System.out.println("3. Tampilkan Semua Pelanggan");

        System.out.print("Pilih menu: ");

        int pilihan = scanner.nextInt();
        scanner.nextLine();

        switch (pilihan) {

            case 1:

                System.out.print(
                        "Masukkan ID pelanggan: ");

                String id = scanner.nextLine();

                System.out.print(
                        "Masukkan nama pelanggan: ");

                String nama = scanner.nextLine();

                if (id.isEmpty() || nama.isEmpty()) {

                    System.out.println(
                            "Data pelanggan tidak boleh kosong.");

                } else {

                    warnet.tambahPelanggan(
                            new Pelanggan(id, nama));

                    System.out.println(
                            "Data pelanggan berhasil ditambahkan.");
                }

                break;

            case 2:

                System.out.print(
                        "Masukkan ID pelanggan: ");

                String idCari = scanner.nextLine();

                Pelanggan pelanggan =
                        warnet.cariPelanggan(idCari);

                System.out.println(
                        "\nPelanggan ditemukan:");

                pelanggan.tampilkanInfo();

                break;

            case 3:

                warnet.tampilkanPelanggan();

                break;

            default:

                System.out.println(
                        "Pilihan tidak tersedia.");
        }
    }

    public static void simulasiPenggunaan(
            Scanner scanner, Warnet warnet)
            throws PerangkatTidakDitemukanException {

        System.out.print(
                "Masukkan ID perangkat yang akan digunakan: ");

        int id = scanner.nextInt();
        scanner.nextLine();

        Perangkat perangkat =
                warnet.cariPerangkat(id);

        System.out.println(
                "\n========== SIMULASI PENGGUNAAN ==========");

        System.out.println(
                "Perangkat yang dipilih: "
                        + perangkat.getNamaPerangkat());

        perangkat.mulaiLayanan();
    }

    public static void jalankanTransaksi(
            Scanner scanner,
            Warnet warnet,
            TransaksiWarnet transaksi)
            throws PerangkatTidakDitemukanException {

        System.out.print("Masukkan ID pelanggan: ");
        String idPelanggan = scanner.nextLine();

        System.out.print("Masukkan ID perangkat: ");
        int idPerangkat = scanner.nextInt();
        scanner.nextLine();

        Pelanggan pelanggan =
                warnet.cariPelanggan(idPelanggan);

        Perangkat perangkat =
                warnet.cariPerangkat(idPerangkat);

        transaksi.prosesTransaksi(
                pelanggan, perangkat);
    }
}