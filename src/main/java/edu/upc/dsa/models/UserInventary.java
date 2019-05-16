package edu.upc.dsa.models;

import java.util.List;

public class UserInventary {
    private List<String> lista;

    public UserInventary(List<String> lista) {
        this.lista = lista;
    }

    public UserInventary() {
    }

    public List<String> getLista() {
        return lista;
    }

    public void setLista(List<String> lista) {
        this.lista = lista;
    }
}
