package edu.upc.dsa.models.Users;

import edu.upc.dsa.models.ObjTO;

import java.util.ArrayList;
import java.util.List;

public class User {


    private String username;
    private String password;
    private String name;
    private String surname;
    private String mail;
    private int age;
    private List<ObjTO> listObjetos;
    private int enemigosmatados;
    private int minutostotales;
    private int monedasconseguidas;
    private int partidasjugadas;

    public User() {
        this.listObjetos = new ArrayList<ObjTO>();
    }

    public User(String username, String password, String name, String surname, String mail, int age){
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.age = age;
        this.listObjetos = new ArrayList<>();
    }

    public User(String username, String password, String name, String surname, String mail, int age, List<ObjTO> listObjetos, int enemigosmatados, int minutostotales, int monedasconseguidas, int partidasjugadas) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.age = age;
        this.listObjetos = listObjetos;
        this.enemigosmatados = enemigosmatados;
        this.minutostotales = minutostotales;
        this.monedasconseguidas = monedasconseguidas;
        this.partidasjugadas = partidasjugadas;
    }

    public User(String username, String password, String name, String surname, String mail, int age, int enemigosmatados, int minutostotales, int monedasconseguidas, int partidasjugadas) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.age = age;
        this.listObjetos = new ArrayList<ObjTO>();
        this.enemigosmatados = enemigosmatados;
        this.minutostotales = minutostotales;
        this.monedasconseguidas = monedasconseguidas;
        this.partidasjugadas = partidasjugadas;
    }

    public User (String username, String password)
    {
        this.username = username;
        this.password = password;
        this.listObjetos = new ArrayList<ObjTO>();

    }
    public List<ObjTO> getListObjetos() {
        return listObjetos;
    }

    public void setListObjetos(List<ObjTO> listObjetos) {
        this.listObjetos = listObjetos;
    }

    public String getUsername() {
        return username;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void addObject (ObjTO objTO)
    {
        this.listObjetos.add(objTO);
    }
    public int size ()
    {
       return this.listObjetos.size();
    }
}
