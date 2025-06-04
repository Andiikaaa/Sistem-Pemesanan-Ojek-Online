/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab9;

/**
 *
 * @author ASUS
 */

interface VerifikasiIdentitas {
    boolean verifikasi();
}

public class Driver extends Pengguna implements InfoEntity {
    private String motor;
    private String status;

    public Driver(String nama, String noHP, String motor) {
        super(nama, noHP);
        this.motor = motor;
        this.status = "Siap Antar";
    }

    public String getMotor() {
        return motor;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String getInfo() {
        return "Driver: " + nama + ", Motor: " + motor + ", Status: " + status;
    }
}










