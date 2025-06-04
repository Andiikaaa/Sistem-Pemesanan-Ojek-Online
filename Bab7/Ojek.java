/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab7;

/**
 *
 * @author ASUS
 */
public class Ojek {
    // Atribut
    private String nama;
    private String platNomor;
    private String lokasi;
    private boolean tersedia;

    // 👇 Ini adalah constructor
    public Ojek(String nama, String platNomor, String lokasi) {
        this.nama = nama;
        this.platNomor = platNomor;
        this.lokasi = lokasi;
        this.tersedia = true; // default: tersedia saat baru dibuat
    }

    // Getter dan setter (method-method tambahan)
    public String getNama() {
        return nama;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public String getLokasi() {
        return lokasi;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    // Method untuk menampilkan informasi ojek
    public void tampilkanInfo() {
        System.out.println("Nama Ojek     : " + nama);
        System.out.println("Plat Nomor    : " + platNomor);
        System.out.println("Lokasi        : " + lokasi);
        System.out.println("Status        : " + (tersedia ? "Tersedia" : "Sedang Mengantar"));
    }
}


