/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package megapoly;

/**
 *
 * @author Badal
 */
public class Carcel extends Casillas {

  //Contructores
  public Carcel() {
  }
  
  public Carcel(String nombre, int posicion){
    super(nombre,posicion);
  }
  
  //Getters

 
  
  //Setters

 //toString

  @Override
  public String toString() {
    return "ALTO! Esta en la Cárcel, debes de sacar un 5 para salir de aquí. \n";
  }
  
  
  
  
  
}
