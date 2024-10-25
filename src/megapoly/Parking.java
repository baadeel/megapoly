/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package megapoly;

/**
 *
 * @author Badal
 */
public class Parking extends Casillas {

  //Constructores
  public Parking(String nombre, int posicion) {
    super(nombre, posicion);
  }
  
  //toString

  @Override
  public String toString() {
    return "Descansa un poquito que se vienen largos viajes :P \n";
  }
  
  
}
