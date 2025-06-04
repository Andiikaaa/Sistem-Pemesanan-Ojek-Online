/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab6;

/**
 *
 * @author ASUS
 */
public class SistemOjekOnline {
    public static void main(String[] args) {
        Pelanggan pelanggan = new Pelanggan("Andi", "08123456789", "Bandara");
        Driver driver = new Driver("Budi", "08987654321", "Yamaha NMAX");

        Pesanan pesanan = new Pesanan(pelanggan, driver, "Tunai");

        System.out.println(pesanan.ringkasan());
        System.out.println(pesanan.ringkasan(true));
    }
}


