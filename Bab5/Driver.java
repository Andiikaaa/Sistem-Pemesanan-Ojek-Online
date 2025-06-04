/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab5;

/**
 *
 * @author ASUS
 */
public class Driver {
    private String namaDriver;
    private String motor;
    private String status;
    private boolean isPremium;
    private boolean asuransi;

    // Constructor Default
    public Driver(String namaDriver, String motor) {
        this.namaDriver = namaDriver;
        this.motor = motor;
        this.status = "Dalam Perjalanan";
        this.isPremium = false;
        this.asuransi = false;
    }

    // OVERLOADING constructor untuk Premium
    public Driver(String namaDriver, String motor, boolean isPremium, boolean asuransi) {
        this.namaDriver = namaDriver;
        this.motor = motor;
        this.status = "Dalam Perjalanan";
        this.isPremium = isPremium;
        this.asuransi = asuransi;
    }

    // OVERRIDING method (secara dinamis di satu class)
    public String getInfo() {
        if (isPremium) {
            return "Driver: " + namaDriver + ", Motor: " + motor + " [Premium, Asuransi: " + (asuransi ? "Ya" : "Tidak") + "]";
        } else {
            return "Driver: " + namaDriver + ", Motor: " + motor;
        }
    }

    // Getter dan Setter
    public String getNamaDriver() {
        return namaDriver;
    }

    public String getMotor() {
        return motor;
    }

    public String getStatus() {
        return status;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public boolean isAsuransi() {
        return asuransi;
    }
}



