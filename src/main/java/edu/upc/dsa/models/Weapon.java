package edu.upc.dsa.models;

public class Weapon {
    private String nombre;

    public Weapon() {
    }

    public Weapon(String nombre) {
        this.nombre = nombre;
    }

    public String getWeapon() {
        return nombre;
    }

    public void setWeapon(String nombre) {
        this.nombre = nombre;
    }
}
