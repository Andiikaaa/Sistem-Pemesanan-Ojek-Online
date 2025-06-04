/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab5;

/**
 *
 * @author ASUS
 */
public class Pelanggan {
    private String nama;
    private String noHP;
    private String tujuan;
    // Constructor overloading
    public Pelanggan() {
        this.nama = "Guest";
        this.noHP = "Unknown";
        this.tujuan = "Tidak diketahui";
    }
    public Pelanggan(String nama, String noHP, String tujuan) {
        this.nama = nama;
        this.noHP = noHP;
        this.tujuan = tujuan;
    }
    public String getInfo() {
        return "Pelanggan: " + nama;
    }
    // Getter/Setter...
}



