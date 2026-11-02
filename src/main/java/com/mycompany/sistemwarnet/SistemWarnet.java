package com.mycompany.sistemwarnet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemWarnet {

    static ArrayList<Perangkat> daftarPerangkat =
            new ArrayList<>();

    static HashMap<String, String> dataPelanggan =
            new HashMap<>();

    public static void validasiInput(String input)
            throws PerangkatTidakDitemukanException {

        if (input == null || input.trim().isEmpty()) {
            throw new PerangkatTidakDitemukanException(
                    "Input tidak boleh kosong.");
        }
    }

    public static void cariPerangkat(int id)
            throws PerangkatTidakDitemukanException {

        for (int i = 0; i < daftarPerangkat.size(); i++) {

            if (daftarPerangkat.get(i).getId() == id) {

                System.out.println("\nPerangkat ditemukan:");
                daftarPerangkat.get(i).tampilkanInfo();
                return;
            }
        }

        throw new PerangkatTidakDitemukanException(
                "Perangkat dengan ID tersebut tidak ditemukan.");
    }

    public static void cariPerangkat(String nama)
            throws PerangkatTidakDitemukanException {

        validasiInput(nama);

        for (int i = 0; i < daftarPerangkat.size(); i++) {

            if (daftarPerangkat.get(i).getNamaPerangkat()
                    .equalsIgnoreCase(nama)) {

                System.out.println("\nPerangkat ditemukan:");
                daftarPerangkat.get(i).tampilkanInfo();
                return;
            }
        }

        throw new PerangkatTidakDitemukanException(
                "Perangkat dengan nama tersebut tidak ditemukan.");
    }

    public static void mulaiPenggunaan(Perangkat perangkat) {

        System.out.println("\n========== SIMULASI PENGGUNAAN ==========");
        System.out.println("Perangkat yang dipilih: "
                + perangkat.getNamaPerangkat());

        perangkat.mulaiLayanan();

        System.out.println("Simulasi penggunaan selesai.");
    }

    public static void jalankanFiturInterface(
            Perangkat perangkat) {

        System.out.println("\n========== FITUR INTERFACE ==========");
        System.out.println("Perangkat: "
                + perangkat.getNamaPerangkat());

        if (perangkat instanceof DapatDisewa) {

            DapatDisewa sewaan =
                    (DapatDisewa) perangkat;

            sewaan.prosesPenyewaan();

        } else {

            System.out.println(
                    "Perangkat ini tidak memiliki fitur penyewaan.");
        }

        if (perangkat instanceof DapatDiberiRating) {

            DapatDiberiRating penilaian =
                    (DapatDiberiRating) perangkat;

            penilaian.beriRating(5);

        } else {

            System.out.println(
                    "Perangkat ini tidak memiliki fitur rating.");
        }
    }

    public static void tampilkanDaftarSingkat() {

        for (int i = 0; i < daftarPerangkat.size(); i++) {

            System.out.println((i + 1) + ". "
                    + daftarPerangkat.get(i)
                            .getNamaPerangkat());
        }
    }

    public static void kelolaPelanggan(Scanner scanner)
            throws PerangkatTidakDitemukanException {

        System.out.println("\n===== KELOLA DATA PELANGGAN =====");
        System.out.println("1. Tambah Pelanggan");
        System.out.println("2. Cari Pelanggan");
        System.out.println("3. Tampilkan Semua Pelanggan");

        System.out.print("Pilih menu: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        switch (pilihan) {

            case 1:

                System.out.print("Masukkan ID pelanggan: ");
                String idPelanggan = scanner.nextLine();

                System.out.print("Masukkan nama pelanggan: ");
                String namaPelanggan = scanner.nextLine();

                validasiInput(idPelanggan);
                validasiInput(namaPelanggan);

                dataPelanggan.put(
                        idPelanggan,
                        namaPelanggan);

                System.out.println(
                        "Data pelanggan berhasil ditambahkan.");

                break;

            case 2:

                System.out.print("Masukkan ID pelanggan: ");
                String cariId = scanner.nextLine();

                validasiInput(cariId);

                if (dataPelanggan.containsKey(cariId)) {

                    System.out.println("Nama pelanggan: "
                            + dataPelanggan.get(cariId));

                } else {

                    throw new PerangkatTidakDitemukanException(
                            "Data pelanggan tidak ditemukan.");
                }

                break;

            case 3:

                if (dataPelanggan.isEmpty()) {

                    System.out.println(
                            "Belum ada data pelanggan.");

                } else {

                    System.out.println(
                            "\n===== DAFTAR PELANGGAN =====");

                    System.out.println(
                            "Jumlah pelanggan: "
                            + dataPelanggan.size());

                    for (String id
                            : dataPelanggan.keySet()) {

                        System.out.println(
                                "ID   : " + id);

                        System.out.println(
                                "Nama : "
                                + dataPelanggan.get(id));

                        System.out.println(
                                "----------------------");
                    }
                }

                break;

            default:

                System.out.println(
                        "Pilihan tidak tersedia.");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        daftarPerangkat.add(
                new PC(
                        1,
                        "PC-01",
                        5000,
                        "Tersedia",
                        "Intel Core i5",
                        "RTX 3060"
                )
        );

        daftarPerangkat.add(
                new PC(
                        2,
                        "PC-02",
                        5000,
                        "Digunakan",
                        "Ryzen 5",
                        "GTX 1660"
                )
        );

        daftarPerangkat.add(
                new Konsol(
                        3,
                        "PS-01",
                        10000,
                        "Tersedia",
                        "PlayStation 5",
                        2
                )
        );

        daftarPerangkat.add(
                new Konsol(
                        4,
                        "PS-02",
                        8000,
                        "Digunakan",
                        "PlayStation 4",
                        2
                )
        );

        daftarPerangkat.add(
                new Laptop(
                        5,
                        "LAP-01",
                        7000,
                        "Tersedia",
                        "Ryzen 5",
                        "15.6 Inch"
                )
        );

        dataPelanggan.put(
                "PLG001",
                "Andi"
        );

        dataPelanggan.put(
                "PLG002",
                "Budi"
        );

        dataPelanggan.put(
                "PLG003",
                "Citra"
        );

        boolean isRunning = true;

        System.out.println(
                "==========================================");

        System.out.println(
                "       SISTEM PENGELOLAAN WARNET");

        System.out.println(
                "==========================================");

        while (isRunning) {

            try {

                System.out.println(
                        "\n------------ MENU UTAMA ------------");

                System.out.println(
                        "1. Tambah Data Perangkat");

                System.out.println(
                        "2. Tampilkan Seluruh Data");

                System.out.println(
                        "3. Cari Perangkat");

                System.out.println(
                        "4. Kelola Data Pelanggan");

                System.out.println(
                        "5. Simulasi Penggunaan");

                System.out.println(
                        "6. Jalankan Fitur Interface");

                System.out.println(
                        "7. Keluar");

                System.out.println(
                        "------------------------------------");

                System.out.print("Pilih menu: ");

                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {

                    case 1:

                        System.out.println(
                                "\n=== TAMBAH DATA PERANGKAT ===");

                        System.out.println("1. PC");
                        System.out.println("2. Konsol");
                        System.out.println("3. Laptop");

                        System.out.print("Pilih tipe: ");

                        int tipe = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print(
                                "ID perangkat: ");

                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print(
                                "Nama perangkat: ");

                        String nama = scanner.nextLine();

                        validasiInput(nama);

                        System.out.print(
                                "Harga per jam: ");

                        double harga =
                                scanner.nextDouble();

                        scanner.nextLine();

                        System.out.print(
                                "Status "
                                + "(Tersedia/Digunakan): ");

                        String status =
                                scanner.nextLine();

                        if (tipe == 1) {

                            System.out.print(
                                    "Processor: ");

                            String processor =
                                    scanner.nextLine();

                            System.out.print(
                                    "Kartu grafis: ");

                            String gpu =
                                    scanner.nextLine();

                            daftarPerangkat.add(
                                    new PC(
                                            id,
                                            nama,
                                            harga,
                                            status,
                                            processor,
                                            gpu
                                    )
                            );

                            System.out.println(
                                    "Data PC berhasil ditambahkan.");

                        } else if (tipe == 2) {

                            System.out.print(
                                    "Jenis konsol: ");

                            String jenisKonsol =
                                    scanner.nextLine();

                            System.out.print(
                                    "Jumlah controller: ");

                            int controller =
                                    scanner.nextInt();

                            scanner.nextLine();

                            daftarPerangkat.add(
                                    new Konsol(
                                            id,
                                            nama,
                                            harga,
                                            status,
                                            jenisKonsol,
                                            controller
                                    )
                            );

                            System.out.println(
                                    "Data konsol berhasil ditambahkan.");

                        } else if (tipe == 3) {

                            System.out.print(
                                    "Processor: ");

                            String processor =
                                    scanner.nextLine();

                            System.out.print(
                                    "Ukuran layar: ");

                            String layar =
                                    scanner.nextLine();

                            daftarPerangkat.add(
                                    new Laptop(
                                            id,
                                            nama,
                                            harga,
                                            status,
                                            processor,
                                            layar
                                    )
                            );

                            System.out.println(
                                    "Data laptop berhasil ditambahkan.");

                        } else {

                            System.out.println(
                                    "Tipe perangkat tidak valid.");
                        }

                        break;

                    case 2:

                        if (daftarPerangkat.isEmpty()) {

                            System.out.println(
                                    "Belum ada data perangkat.");

                        } else {

                            System.out.println(
                                    "\n========== DAFTAR PERANGKAT ==========");

                            for (int i = 0;
                                    i < daftarPerangkat.size();
                                    i++) {

                                System.out.println(
                                        "\nData ke-" + (i + 1));

                                System.out.println(
                                        "--------------------------------------");

                                daftarPerangkat.get(i)
                                        .tampilkanInfo();
                            }

                            System.out.println(
                                    "\nTotal objek perangkat: "
                                    + Perangkat.getTotalPerangkat());
                        }

                        break;

                    case 3:

                        System.out.println(
                                "\n========== PENCARIAN ==========");

                        System.out.println(
                                "1. Cari berdasarkan ID");

                        System.out.println(
                                "2. Cari berdasarkan Nama");

                        System.out.print("Pilih: ");

                        int jenisCari =
                                scanner.nextInt();

                        scanner.nextLine();

                        if (jenisCari == 1) {

                            System.out.print(
                                    "Masukkan ID: ");

                            int idCari =
                                    scanner.nextInt();

                            scanner.nextLine();

                            cariPerangkat(idCari);

                        } else if (jenisCari == 2) {

                            System.out.print(
                                    "Masukkan nama: ");

                            String namaCari =
                                    scanner.nextLine();

                            cariPerangkat(namaCari);

                        } else {

                            System.out.println(
                                    "Pilihan pencarian tidak valid.");
                        }

                        break;

                    case 4:

                        kelolaPelanggan(scanner);

                        break;

                    case 5:

                        if (daftarPerangkat.isEmpty()) {

                            System.out.println(
                                    "Belum ada perangkat.");

                        } else {

                            System.out.println(
                                    "\n===== SIMULASI PENGGUNAAN =====");

                            tampilkanDaftarSingkat();

                            System.out.print(
                                    "Pilih perangkat: ");

                            int pilihanPenggunaan =
                                    scanner.nextInt();

                            scanner.nextLine();

                            if (pilihanPenggunaan >= 1
                                    && pilihanPenggunaan
                                    <= daftarPerangkat.size()) {

                                mulaiPenggunaan(
                                        daftarPerangkat.get(
                                                pilihanPenggunaan - 1
                                        )
                                );

                            } else {

                                System.out.println(
                                        "Pilihan perangkat tidak valid.");
                            }
                        }

                        break;

                    case 6:

                        if (daftarPerangkat.isEmpty()) {

                            System.out.println(
                                    "Belum ada perangkat.");

                        } else {

                            System.out.println(
                                    "\n===== FITUR INTERFACE =====");

                            tampilkanDaftarSingkat();

                            System.out.print(
                                    "Pilih perangkat: ");

                            int pilihanFitur =
                                    scanner.nextInt();

                            scanner.nextLine();

                            if (pilihanFitur >= 1
                                    && pilihanFitur
                                    <= daftarPerangkat.size()) {

                                jalankanFiturInterface(
                                        daftarPerangkat.get(
                                                pilihanFitur - 1
                                        )
                                );

                            } else {

                                System.out.println(
                                        "Pilihan perangkat tidak valid.");
                            }
                        }

                        break;

                    case 7:

                        isRunning = false;

                        System.out.println(
                                "Terima kasih telah menggunakan "
                                + "Sistem Warnet.");

                        break;

                    default:

                        System.out.println(
                                "Pilihan menu tidak tersedia.");
                }

            } catch (InputMismatchException e) {

                System.out.println(
                        "Error: Input harus sesuai dengan "
                        + "jenis data yang diminta.");

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
}