/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab4;


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

    // Getter & Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }
}


