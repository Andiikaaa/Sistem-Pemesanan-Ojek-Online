/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab2;

/**
 *
 * @author ASUS
 */
public class SistemOjekOnline {
    public static void main(String[] args) {
        // 👇 Memanggil constructor untuk membuat objek
        Ojek ojek1 = new Ojek("Budi", "N 1234 AB", "Malang");
        Ojek ojek2 = new Ojek("Siti", "N 5678 CD", "Surabaya");
        ojek1.tampilkanInfo();
        System.out.println();
        ojek2.tampilkanInfo();
    }
}

