/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package megapoly;

/**
 *
 * @author Badal
 */
public class Suerte extends Casillas {

  private String mensaje;
  private Suerte[] cartas;

 
  //Constructores

  public Suerte() {
    super();
    this.mensaje = "";
    this.cartas = cartas;
  }

  public Suerte(String nombre, int posicion){
    super(nombre,posicion);
  }
  
  public Suerte(String mensaje) {
    this.mensaje = mensaje;
  }
  
  

  //Getters

  public String getMensaje() {
    return mensaje;
  }

  public Suerte[] getCartas() {
    return cartas;
  }

  
  //Setters
 
  public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
  }

  public void setCartas(Suerte[] cartas) {
    this.cartas = cartas;
  }
  
  //toString

  @Override
  public String toString() {
    return "Se cogerá una carta Suerte aleatoria... \n";
  }


  
  
  
  
 
  
}
