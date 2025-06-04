/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab9;


import java.util.Scanner;

/**
 *
 * @author ASUS
 */
import java.util.Scanner;

public class SistemOjekOnline {

    public static void tampilkanInfo(InfoEntity entity) {
        System.out.println(entity.getInfo());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input Pelanggan
            System.out.print("Masukkan Nama Pelanggan: ");
            String namaPelanggan = bacaInput(scanner);

            System.out.print("Masukkan No HP Pelanggan: ");
            String noHPPelanggan = bacaInput(scanner);

            System.out.print("Masukkan Tujuan Pelanggan: ");
            String tujuan = bacaInput(scanner);

            Pelanggan pelanggan = new Pelanggan(namaPelanggan, noHPPelanggan, tujuan);

            // Input Driver
            System.out.print("Masukkan Nama Driver: ");
            String namaDriver = bacaInput(scanner);

            System.out.print("Masukkan No HP Driver: ");
            String noHPDriver = bacaInput(scanner);

            System.out.print("Masukkan Jenis Motor Driver: ");
            String motor = bacaInput(scanner);

            Driver driver = new Driver(namaDriver, noHPDriver, motor);

            // Metode Pembayaran
            System.out.print("Masukkan Metode Pembayaran: ");
            String metodeBayar = bacaInput(scanner);

            // Buat pesanan
            Pesanan pesanan = new Pesanan(pelanggan, driver, metodeBayar);

            // Tampilkan info menggunakan interface
            System.out.println("\n--- Info Pengguna ---");
            tampilkanInfo(pelanggan);
            tampilkanInfo(driver);

            // Tambahan: Contoh Ojek
            Ojek ojek = new Ojek("Ojek001", "L 1234 ZZ", "Surabaya");
            tampilkanInfo(ojek);

            // Tampilkan ringkasan pesanan
            System.out.println("\n--- Ringkasan Pesanan ---");
            System.out.println(pesanan.ringkasan(true));

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static String bacaInput(Scanner scanner) throws Exception {
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            throw new Exception("Input tidak boleh kosong!");
        }
        return input;
    }
}



