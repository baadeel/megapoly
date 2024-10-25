/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package megapoly;
/**
 *
 * @author Badal
 */
public class Casillas extends Tablero{
  
  protected String nombre;
  private int posicion;

  //Constructores
  
  public Casillas() {
    this.nombre = " ";
    this.posicion = 0;
  }

  public Casillas(String nombre, int posicion) {
    this.nombre = nombre;
    this.posicion = posicion;
  }
  
  

  
  
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setPosicion(int posicion) {
    this.posicion = posicion;
  }

  public String getNombre() {
    return nombre;
  }

  public int getPosicion() {
    return posicion;
  }
  
  
  
  
  
}
