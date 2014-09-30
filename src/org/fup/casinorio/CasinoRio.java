/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fup.casinorio;

import java.util.ArrayList;
import org.fup.casinorio.logica.Carta;
import org.fup.casinorio.logica.Dealer;
import org.fup.casinorio.logica.Jugador;
import org.fup.casinorio.logica.MesadeJugador;


/**
 *
 * @author JUAN MANUEL
 */
public class CasinoRio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       // Carta carta = new Carta();
        
        //System.out.println("Los puntos de esta carta son: "+carta.getPuntos());
//        ArrayList<Carta> cartasAbiertas;
         Dealer d = new Dealer();
         MesadeJugador mj=new MesadeJugador(d);
         mj.jugarBlackjack(4);
         
         
         
//        Jugador j1=new Jugador("Juan", 3000);
//        Jugador j2=new Jugador("Jose", 3000);
//        Jugador j3=new Jugador("Pedro", 3000);
//        Jugador j4=new Jugador("Daniel", 2000);
//        
//        
//       
//        System.out.println("");
//        
//        
//        d.barajar(3);
//        mj.sentarJugador(j1);
//        mj.sentarJugador(j2);
//        mj.sentarJugador(j3);
//        mj.sentarJugador(j4);
//        cartasAbiertas=mj.iniciarPartida();
//        
//        
//        j1.mostrarCartas();
//        j2.mostrarCartas();
//        j3.mostrarCartas();
//        j4.mostrarCartas();
//         System.out.println("La cuenta esta en: " +j1.contar(cartasAbiertas));
//        
//        System.out.println("");
        /**jugador.pedirCarta(d.sacarCarta(true));
        jugador.pedirCarta(d.sacarCarta(false));
        d.pedirCarta(d.sacarCarta(true));
        d.pedirCarta(d.sacarCarta(false));
        //jugador.mostrarCartas();
       // System.out.println(""+jugador.sumarCartas());
        MesadeJugador mj = new MesadeJugador(d);
        mj.sentarJugador(jugador);
        mj.mostrarJugadores();
        jugador.mostrarCartas();   
        System.out.println("");
        d.mostrarCartas();
        */
        
        
    }
    
}
