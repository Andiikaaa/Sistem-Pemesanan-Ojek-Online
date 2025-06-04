/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab3;

/**
 *
 * @author ASUS
 */
public class Pelanggan {
    private String nama;
    private String noHP;
    private String tujuan;
    public Pelanggan(String nama, String noHP, String tujuan) {
        this.nama = nama;
        this.noHP = noHP;
        this.tujuan = tujuan;
    }
    public String getNama() {
        return nama;
    }
    public String getNoHP() {
        return noHP;
    }
    public String getTujuan() {
        return tujuan;
    }
}

