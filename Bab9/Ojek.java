/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab9;

/**
 *
 * @author ASUS
 */
public class Ojek implements InfoEntity {
    private String nama;
    private String platNomor;
    private String lokasi;
    private boolean tersedia;

    public Ojek(String nama, String platNomor, String lokasi) {
        this.nama = nama;
        this.platNomor = platNomor;
        this.lokasi = lokasi;
        this.tersedia = true;
    }

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

    @Override
    public String getInfo() {
        return "Ojek: " + nama + ", Plat: " + platNomor + ", Lokasi: " + lokasi + ", Status: " + (tersedia ? "Tersedia" : "Sedang Mengantar");
    }
}



