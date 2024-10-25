/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package megapoly;

/**
 *
 * @author Badal
 */
public class Calle extends Casillas{
  
  private boolean estacomprada;
  private int valor;
  private int alquiler;
  private Jugador jugadorPropietario;
  
  //Constructores

  public Calle() {
    super();
    this.estacomprada = false;
    this.valor = 0;
    this.alquiler = 0;
  }

  public Calle(String nombre, int posicion, boolean estacomprada, int valor, int alquiler, Jugador jugadorPropietario) {
    super(nombre, posicion);
    this.estacomprada = estacomprada;
    this.valor = valor;
    this.alquiler = alquiler;
    this.jugadorPropietario = jugadorPropietario;
  }
  
  //Getters
  public boolean isEstacomprada() {
    return estacomprada;
  }

  public int getValor() {
    return valor;
  }

  public int getAlquiler() {
    return alquiler;
  }

  public Jugador getJugadorPropietario() {
    return jugadorPropietario;
  }

  
  
  //Setters
  public void setEstacomprada(boolean estacomprada) {
    this.estacomprada = estacomprada;
  }

  public void setValor(int valor) {
    this.valor = valor;
  }

  public void setAlquiler(int alquiler) {
    this.alquiler = alquiler;
  }

  public void setJugadorPropietario(Jugador jugadorPropietario) {
    this.jugadorPropietario = jugadorPropietario;
  }


  
  //toString

  @Override
  public String toString() {
    return "Te encuentras en " + nombre + ". \n";
    
  }
  


  
  
  
}
