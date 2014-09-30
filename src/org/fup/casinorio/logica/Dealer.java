/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fup.casinorio.logica;

import java.util.ArrayList;
import java.util.Random;

/**
 * Calse para representar un dealer o repartidor de casino
 * @author JUAN MANUEL
 */
public class Dealer {
    /**
     * Lista de objetos de tipo carta para repartir 
     */
     private ArrayList<Carta> cartas;
     /**
      * Declaracion de un objeto de tipo baraja
      */
     private Baraja baraja;
     
     /**
      * Constructor de la clase Dealer
      */

    public Dealer() {
        cartas = new ArrayList<>();
        baraja = Baraja.getInstance();
    }

     public ArrayList<Carta> getMisCartas() {
        return cartas;
    }

    public void setMisCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }
    
    /**
     * metodo para mostrar las cartas que le corresponden al dealer
     */
    public void mostrarCartas(){
       for (int i=0; i < baraja.getCartas().size(); i++){
           System.out.print(baraja.getCartas().get(i).getValor()+baraja.getCartas().get(i).getPinta()+",");
       }
    }
    /**
     * Metodo para sacar una carta de la baraja tapada, removerla de la lista
     * e indicar que en su posicion ahora no hay nada
     * @param tapado
     * @return Carta
     */
    public Carta sacarCarta(boolean tapado){
      Carta carta=baraja.getCartas().get(0);
      carta.setTapado(tapado);
      baraja.getCartas().remove(0);
      baraja.getCartas().add(new Carta("_", "_"));
      return carta;
    }
    /**
     * Metodo que permite revolver las cartas un numero determinado de veces
     * segun el parametro que recibe de tipo entero
     * @param nveces 
     */
    public void barajar(int nveces){
        ArrayList<Carta> cartas = baraja.getCartas();
        int i = 0, n = nveces;
        Random numAleatorio = new Random();
        while (i < n) {
            for (int j = 0; j < cartas.size(); j++) {
                int pibote = numAleatorio.nextInt(52);
                Carta temp = cartas.get(i);
                cartas.set(i, cartas.get(pibote));
                cartas.set(pibote, temp);
            }
            i++;
        }
    }
      /**
       * Metodo para pedir una carta 
       * @param carta 
       */
    public void pedirCarta(Carta carta){
        if (cartas.size()<Constantes.MAXIMO_CARTAS_JUGADOR){
        cartas.add(carta);
    }else{
        System.out.println("El maximo de cartas por jugador es: "+ Constantes.MAXIMO_CARTAS_JUGADOR);
        }
    }
    /**
     * Metodo para determinar los puntos del valor de las cartas
     * @return int
     */
     public int sumarCartas(){
         int acum=0;
          for (int i=0; i < cartas.size(); i++){
              acum = acum + cartas.get(i).getPuntos();
              
          }
          return acum;
     }
     /**
      * metodo que retorna un booleano si de acuerdo a los puntos 
      * del valor de las cartas de su juego, es necesario pedir otra
      * carta
      * @return boolean 
      */
     public boolean pensar() {
        int acumulador = 0;
        for (Carta carta : cartas) {
            acumulador = acumulador + carta.getPuntos();
        }
        return acumulador < 17;
    }

        
}


