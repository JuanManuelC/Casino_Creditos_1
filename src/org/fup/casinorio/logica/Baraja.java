/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fup.casinorio.logica;

import java.util.ArrayList;

/**
 * Clase que genera una baraja compuesta por 52 objetos de tipo carta
 * 
 * @author JUAN MANUEL
 */
public class Baraja {
   /**
    * Se declara un objeto de tipo baraja para utilizar el patron singleton
    */ 
    private static Baraja baraja;
    /**
     * Declaracion de una lista de cartas 
     */
    private ArrayList<Carta> cartas;
    
    /**
     * Constructor de la clase baraja
     */
    private Baraja(){    
         cartas = new ArrayList<>();
         crearBaraja();
         
    }
      public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }
    
    /**
     * metodo que se encarga de instanciar la clase Baraja una sola vez 
     * @return 
     */
    public static Baraja getInstance(){
        if (baraja==null){
            baraja=new Baraja();
        }
        return baraja;
    }
    /**
     * metodo que se encarga de crear la baraja de 52 cartas
     * con sus respectivas pintas (♥, ♦, ♣, ♠)y los numeros de 2 a 10
     * y las letras J,K,Q y A
     */
    public void crearBaraja(){
        String[] pintas = {"♥", "♦", "♣", "♠"};
        String[] valores = {"A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
        for (int i=0; i< pintas.length;i++){
            for (int j=0; j < valores.length;j++){
                cartas.add(new Carta(pintas[i], valores[j]));
                
            }
        }
    }

}
