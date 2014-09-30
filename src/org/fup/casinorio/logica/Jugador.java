/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fup.casinorio.logica;

import java.util.ArrayList;

/**
 * Clase que representa a un jugador de casino
 * @author JUAN MANUEL
 */
public class Jugador {
    /**
     * Declaracion del parametro nombre para el jugador
     */

    private String nombre;
    /**
     * Parametro para la cantidad de fichas del jugador
     */
    private int fichas;
    /**
     * Lista de objetos de tipo Carta para el juego propio
     */
    ArrayList<Carta> cartasJg;
    /**
     * Contructor de la clase jugador
     * @param nombre
     * @param fichas 
     */

    public Jugador(String nombre, int fichas) {
        this.nombre = nombre;
        this.fichas = fichas;
        cartasJg = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFichas() {
        return fichas;
    }

    public void setFichas(int fichas) {
        this.fichas = fichas;
    }
    /**
     * Metodo para pedir una carta 
     * @param carta 
     */

    public void pedirCarta(Carta carta) {
        if (cartasJg.size() < Constantes.MAXIMO_CARTAS_JUGADOR) {
            cartasJg.add(carta);
        } else {
            System.out.println("El maximo de cartas por jugador es: " + Constantes.MAXIMO_CARTAS_JUGADOR);
        }
    }
    /**
     * Metodo para mostrar las cartas del jugador
     */

    public void mostrarCartas() {
        cartasJg.stream().forEach((cartasJg1) -> {
            if (cartasJg1.isTapado()) {
                System.out.print("(" + cartasJg1.getValor() + cartasJg1.getPinta() + ")" + ",");
            } else {
                System.out.print(cartasJg1.getValor() + cartasJg1.getPinta() + ",");
            }
        });
    }
    /**
     * Metodo para obtener la suma de los puntos de las cartas del jugador
     * @return int
     */

    public int sumarCartas() {
        int acum = 0;
        for (int i = 0; i < cartasJg.size(); i++) {
            acum = acum + cartasJg.get(i).getPuntos();
            if (acum > 21 && cartasJg.get(i).getValor().equals("A")) {
                acum = acum - 10;
            }
        }
        return acum;
    }
    /**
     * Metodo para contar las cartas abiertas de todos los jugadores
     * para poder detrminar si se pide otra carta o no
     * @param cartasAbiertas
     * @return int 
     */

    public int contar(ArrayList<Carta> cartasAbiertas) {
        int cuenta = 0;
        for (Carta cartasAbierta : cartasAbiertas) {
            cuenta = cuenta + cartasAbierta.contarCartas();
        }
        return cuenta;
    }
    /**
     * Metodo que me retorna un true si tengo dos cartas iguales
     * @return boolean 
     */

    public boolean cartaDoble() {
        return cartasJg.size() == 2 && cartasJg.get(0).getValor().equals(cartasJg.get(1).getValor());
    }

    /**
     * metodo que, utilizando la tecnica del conteo de cartas
     * permite al jugador saber si pide otra carta o no
     * @param cartasAbiertas
     * @return boolean
     */

    public boolean pensar(ArrayList<Carta> cartasAbiertas) {
        int cuenta = contar(cartasAbiertas);
        int acum = sumarCartas();

        if (acum == 21) {
            return false;

        } else if ((cuenta > 0 && cuenta <= 5 && acum <= 17)||(cuenta<= -5 && acum>=17 )||(cuenta==0 && acum<17)) {
            return true;
        }   
        return false;

    }
    /**
     * Metodo para restar las fichas del jugador en caso de apostar
     * @param minima 
     */
    public void apostar(int minima) {
        fichas = fichas - minima;
    }
}


