/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transformaciones;

/**
 *
 * @author ale
 */
/**
 *
 * @author ale
 */
public class Punto {
 private int x;
 private int y;
 /**
  * Generar un punto e las coordenadas 0/0
  */
 public Punto(){
   this.x=0;
   this.y=0;
     
 }
/**
 * 
 * @param x coordenada en X
 * @param y coordenada en Y
 */
    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }
 
 public void setX(int x){
  this.x=x;
 }
 
  public void setY(int y){
  this.y=y;
 }
 /**
  * Obtener el valor de la coordenada en x
  * return coordenada x
     * @return 
  */
 public int getX(){
     return this.x;
   
 }
 
  public int getY(){
     return this.y;
   
 }
}
