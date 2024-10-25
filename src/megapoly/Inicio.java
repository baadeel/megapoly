/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package megapoly;

/**
 *
 * @author Badal
 */
public class Inicio extends Casillas {
  
  private int turno;
  private int vueltas;

  //Constructores
  public Inicio() {
    super();
    this.turno = 0;
    this.vueltas = 0;
  }

  //Getters
  public int getTurno() {
    return turno;
  }

  public int getVueltas() {
    return vueltas;
  }

  //Setters
  public void setTurno(int turno) {
    this.turno = turno;
  }

  public void setVueltas(int vueltas) {
    this.vueltas = vueltas;
  }
  
  //toString

  @Override
  public String toString() {
    return "Has caído en la casilla de inicio. Avanza para recibir una bonificación. \n";
  }
  

  
  
  
  
  
  
}
