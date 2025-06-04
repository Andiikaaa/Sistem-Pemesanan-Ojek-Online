/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab1;

/**
 *
 * @author ASUS
 */
public class SistemOjekOnline {
    public static void main(String[] args) {
        // Membuat objek ojek
        Ojek ojek1 = new Ojek("Budi", "N 1234 AB", "Malang");
        Ojek ojek2 = new Ojek("Siti", "N 5678 CD", "Surabaya");
        // Menampilkan informasi ojek
        System.out.println("Data Ojek Online:");
        ojek1.tampilkanInfo();
        System.out.println("-------------------");
        ojek2.tampilkanInfo();
        // Simulasi pemesanan
        System.out.println("\nPelanggan memesan ojek...");
        if (ojek1.isTersedia()) {
            System.out.println("Ojek " + ojek1.getNama() + " menerima pesanan!");
            ojek1.setTersedia(false); // Update status ojek
        }
        // Tampilkan status setelah pemesanan
        System.out.println("\nStatus Ojek Setelah Pemesanan:");
        ojek1.tampilkanInfo();
        System.out.println("-------------------");
        ojek2.tampilkanInfo();
    }
}

