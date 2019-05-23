package edu.upc.dsa.models;

public class Obj {
    private String nombre;

    public Obj(String nombre) {
        this.nombre = nombre;
    }

    public Obj() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Obj{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
