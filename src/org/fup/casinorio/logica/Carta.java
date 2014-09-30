/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fup.casinorio.logica;

/**
 * Esta clase representa una carta con los atributos 
 * pinta, valor y si se encuentra tapada o no.
 * @author JUAN MANUEL
 */
public class Carta {
/**
 * Declaracion del atributo valor el cual puede ser un numero o una letra
 */
    private String valor;
    /**
     * declaracion del atributo pinta que se refiere a 
     * corazones, treboles, diamantes o picas.
     */
    private String pinta;
    /**
     * Atributo de tipo boolean que retorna true si se encuentra destapada
     */
    private boolean tapado;
     /**
      * Constructor de la clase Carta
      * @param pinta
      * @param valor 
      */
     
    public Carta (String pinta,String valor) {
        this.valor = valor;
        this.pinta = pinta;
        this.tapado=true;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getPinta() {
        return pinta;
    }

    public void setPinta(String pinta) {
        this.pinta = pinta;
    }

    public boolean isTapado() {
        return tapado;
    }

    public void setTapado(boolean tapado) {
        this.tapado = tapado;
    }
    /**
     * metodo para determinar un valor entero 
     * correspondiente al valor de la carta
     * @return int
     */

    public int getPuntos() {
        if (null != valor) switch (valor) {
            case "J":
            case "Q":
            case "K":
                return 10;
            case "A":
                return 11;
            default:
                return Integer.parseInt(valor);
        }
        return -100;
    }
    /**
     * Metodo que permite llevar un conteo de cartas 
     * dandole un valor de  -1 a las cartas altas (10, J, K, Q, A)
     * 1 a las cartas bajas (2, 3, 4, 5, 6) y o a las demas
     * @return int
     */
    public int contarCartas(){
        int conteo;
        if ("J".equals(valor)||"K".equals(valor)||"Q".equals(valor)||"A".equals(valor)||"10".equals(valor)){
            conteo= -1;
        }else if ("2".equals(valor)||"3".equals(valor)||"4".equals(valor)||"5".equals(valor)||"6".equals(valor)){
            conteo= 1;
        }else{
            conteo=0;
        }
        return conteo;
    }

}
