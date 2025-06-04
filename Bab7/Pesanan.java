/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab7;

/**
 *
 * @author ASUS
 */
public class Pesanan {
    private Pelanggan pelanggan;
    private Driver driver;
    private String metodePembayaran;

    public Pesanan(Pelanggan pelanggan, Driver driver, String metodePembayaran) {
        this.pelanggan = pelanggan;
        this.driver = driver;
        this.metodePembayaran = metodePembayaran;
    }

    // Method overloading
    public String ringkasan() {
    return pelanggan.getInfo() + " memesan ojek ke " + driver.getInfo();
    }

    public String ringkasan(boolean detail) {
    if (detail) {
        return ringkasan() + "\nMetode Bayar: " + metodePembayaran;
    }
    return ringkasan();
    }
}


