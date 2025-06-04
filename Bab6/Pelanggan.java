/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab6;

/**
 *
 * @author ASUS
 */
public class Pelanggan extends Pengguna {
    private String tujuan;

    public Pelanggan() {
        super("Guest", "Unknown");
        this.tujuan = "Tidak diketahui";
    }

    public Pelanggan(String nama, String noHP, String tujuan) {
        super(nama, noHP);
        this.tujuan = tujuan;
    }

    @Override
    public String getInfo() {
        return "Pelanggan: " + nama + ", Tujuan: " + tujuan;
    }

    public String getTujuan() {
        return tujuan;
    }
}





