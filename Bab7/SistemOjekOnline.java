/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab7;

/**
 *
 * @author ASUS
 */
public class SistemOjekOnline {
    public static void cetakInfoPengguna(Pengguna p) {
        System.out.println(p.getInfo());
    }

    public static void main(String[] args) {
        Pengguna p1 = new Driver("Budi", "0812345678", "Honda Beat");
        Pengguna p2 = new Pelanggan("Ayu", "0822334455", "Bandara");

        // Polimorfisme: meskipun bertipe Pengguna, method getInfo() yang dipanggil sesuai objek aslinya
        cetakInfoPengguna(p1); // akan memanggil getInfo() milik Driver
        cetakInfoPengguna(p2); // akan memanggil getInfo() milik Pelanggan
    }
}


