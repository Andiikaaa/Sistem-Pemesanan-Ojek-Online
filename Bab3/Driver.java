/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab3;

/**
 *
 * @author ASUS
 */
public class Driver {
    private String namaDriver;
    private String motor;
    private String status;
    public Driver(String namaDriver, String motor) {
        this.namaDriver = namaDriver;
        this.motor = motor;
        this.status = "Dalam Perjalanan";
    }
    public String getNamaDriver() {
        return namaDriver;
    }
    public String getMotor() {
        return motor;
    }
    public String getStatus() {
        return status;
    }
}

