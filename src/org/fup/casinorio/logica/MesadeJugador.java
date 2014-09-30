/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fup.casinorio.logica;

import java.util.ArrayList;

/**
 * Clase que nos representa una mesa de juego para 21
 * @author JUAN MANUEL
 */
public class MesadeJugador {
    /**
     * Declaracion de un objeto de tipo Dealer
     */
    private Dealer d;
    /**
     * Declaracion de una lista de objetos de tipo Jugador
     */
    private ArrayList<Jugador> jugadores;
    /**
     * Lista de objetos de tipo carta para todas las cartas abiertas de la mesa
     */
    ArrayList<Carta> cartasAbiertas = new ArrayList<>();
    /**
     * Contructor de la Clase mesa de juego recibe como parametro un Dealer
     * @param d 
     */
    
    public MesadeJugador(Dealer d) {
        this.d = d;
        jugadores= new ArrayList<>();
    }
    /**
     * Metodo para agregar un jugador a la mesa
     * @param jugador 
     */
   public void sentarJugador(Jugador jugador){
        if (jugadores.size()<Constantes.MAXIMO_JUGADOR_MESA){
        jugadores.add(jugador);
    }else{
        System.out.println("El maximo de jugadores por mesa es: "+ Constantes.MAXIMO_JUGADOR_MESA);
        }
    }
   /**
    * Metodo para retirar un jugador de la mesa recibe como parametro la posicion del jugador
    * @param p 
    */
   public void levantarJugador(int p){
       jugadores.remove(p);
   }
   /**
    * Metodo para mostrar los jugadores de la mesa
    */
   public void mostrarJugadores() {
        System.out.println();
        System.out.print("Posición\tNombre\tFichas\tCartas");
        System.out.println("");
        for (Jugador jugador : jugadores) {
            System.out.print("# " + jugadores.indexOf(jugador));
            System.out.print("\t\t" + jugador.getNombre());
            System.out.print("\t" + jugador.getFichas());
            System.out.print("\t");
            jugador.mostrarCartas();
            System.out.println("");
        }
        System.out.print("# " + jugadores.size());
        System.out.print("\t\tDealer");
        System.out.print("\tMany");
        System.out.print("\t");
        d.mostrarCartas();
        System.out.println("");

    }
    /**
     * Metodo para iniciar una partida, el dealer reparte una carta tapada y una 
     * destapada a cada jugador.
     * Este metodo retorna una lista de objetos tipo Carta para realizar el conteo.
     * @return ArrayList
     */
   public ArrayList iniciarPartida() {
        
        Carta laCarta;
        for (Jugador jugador : jugadores) {
            laCarta = d.sacarCarta(false);
            jugador.pedirCarta(laCarta);
            cartasAbiertas.add(laCarta);
        }
        laCarta = d.sacarCarta(false);
        d.pedirCarta(laCarta);
        cartasAbiertas.add(laCarta);

        for (Jugador jugador : jugadores) {
            laCarta = d.sacarCarta(true);
            jugador.pedirCarta(laCarta);
        }
        laCarta = d.sacarCarta(true);
        d.pedirCarta(laCarta);
        return cartasAbiertas; 
    }
   /**
    * Metodo para iniciar una partida.
    * @param numJugadores 
    */
   
   public void jugarBlackjack(int numJugadores){
       d.barajar(3);
       d.mostrarCartas();
       
       String jugador;
       jugador = "jugador";
       for(int i=0; i<numJugadores;i++){
           sentarJugador(new Jugador(jugador+i, 3000));
        }
       iniciarPartida();
       mostrarJugadores();
        for (Jugador jugadores : jugadores) {
            
            while(jugadores.pensar(cartasAbiertas)){     
                jugadores.pedirCarta(d.sacarCarta(true));
            }
        }
        ganadorPartida();
        mostrarJugadores();
   }
   /**
    * Metodo para determinar el ganador de la partida.
    */
    public void ganadorPartida() {

        for (Jugador jugador : jugadores) {
            if ((jugador.sumarCartas() > d.sumarCartas()) && (jugador.sumarCartas() <= 21)) {
                System.out.println("Gano :" + jugador.getNombre());
                
            } else {
                System.out.println("Gano el Dealer a :" + jugador.getNombre());
            }
        }
    }
}

