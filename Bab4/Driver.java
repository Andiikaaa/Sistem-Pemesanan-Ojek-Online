/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab4;

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
    public void setNamaDriver(String namaDriver) {
        this.namaDriver = namaDriver;
    }
    public String getMotor() {
        return motor;
    }
    public void setMotor(String motor) {
        this.motor = motor;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}


