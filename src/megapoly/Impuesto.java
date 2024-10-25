/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package megapoly;

/**
 *
 * @author Badal
 */
public class Impuesto extends Casillas{
  

  
  //Constructores

  public Impuesto() {
    super();

  }

  public Impuesto(String nombre, int posicion) {
    super(nombre, posicion);
    
  }
  
 
  
  //toString

  @Override
  public String toString() {
    return "Esta es la casilla de " + nombre + " ,debe pagar 20 Mm. \n";
  }
  
  
  
  
  
  
}
