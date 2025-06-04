/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab9;

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

    public abstract String getInfo();

    public void tampilkanInfo() {
        System.out.println("Nama      : " + nama);
        System.out.println("Nomor HP  : " + nomorHP);
    }
}



