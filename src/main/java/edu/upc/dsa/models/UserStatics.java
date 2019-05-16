package edu.upc.dsa.models;

public class UserStatics {
    private int enemigosmatados;
    private int minutostotales;
    private int monedasconseguidas;
    private int partidasjugadas;

    public UserStatics() {
    }

    public UserStatics(int enemigosmatados, int minutostotales, int monedasconseguidas, int partidasjugadas) {
        this.enemigosmatados = enemigosmatados;
        this.minutostotales = minutostotales;
        this.monedasconseguidas = monedasconseguidas;
        this.partidasjugadas = partidasjugadas;
    }

    public int getEnemigosmatados() {
        return enemigosmatados;
    }

    public void setEnemigosmatados(int enemigosmatados) {
        this.enemigosmatados = enemigosmatados;
    }

    public int getMinutostotales() {
        return minutostotales;
    }

    public void setMinutostotales(int minutostotales) {
        this.minutostotales = minutostotales;
    }

    public int getMonedasconseguidas() {
        return monedasconseguidas;
    }

    public void setMonedasconseguidas(int monedasconseguidas) {
        this.monedasconseguidas = monedasconseguidas;
    }

    public int getPartidasjugadas() {
        return partidasjugadas;
    }

    public void setPartidasjugadas(int partidasjugadas) {
        this.partidasjugadas = partidasjugadas;
    }
}
