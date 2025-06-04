/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab6;

/**
 *
 * @author ASUS
 */
public abstract class Pengguna {
    protected String nama;
    protected String nomorHP;

    public Pengguna(String nama, String nomorHP) {
        this.nama = nama;
        this.nomorHP = nomorHP;
    }

    // Abstract method
    public abstract String getInfo();

    // Bisa juga punya method non-abstract
    public void tampilkanInfo() {
        System.out.println("Nama      : " + nama);
        System.out.println("Nomor HP  : " + nomorHP);
    }
}


