/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package megapoly;

/**
 *
 * @author Badal
 */
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Jugador implements Serializable {

  private String nombre;
  private int dinero;
  private int posicion;
  private int propiedades[];
  private int numeroVueltas;
  private boolean carcel;
  private int numeroDado;
  private int turno;
  private static final long serialVersionUID = 1L;

  public Jugador() {
    this.dinero = 100;
    this.posicion = 0;
    this.propiedades = new int[24];
    this.numeroVueltas = 0;
    this.carcel = false;
    this.numeroDado = 0;
    turno = 0;
  }

  public Jugador(String nombre, int dinero, int numeroDado, int numeroVueltas, int posicion, int[] propiedades) {
    this.nombre = nombre;
    this.dinero = dinero;
    this.posicion = posicion;
    this.propiedades = propiedades;
    this.numeroVueltas = numeroVueltas;
  }

  public boolean isCarcel() {
    return carcel;
  }

  public void setNumeroVueltas(int numeroVueltas) {
    this.numeroVueltas = numeroVueltas;
  }

  public void setCarcel(boolean carcel) {
    this.carcel = carcel;
  }

  public int getNumeroDado() {
    return numeroDado;
  }

  public int getTurno() {
    return turno;
  }

  public String getNombre() {
    return nombre;
  }

  public int getDinero() {
    return dinero;
  }

  public int getPosicion() {
    return posicion;
  }

  public int[] getPropiedades() {
    return propiedades;
  }

  public int getNumeroVueltas() {
    return numeroVueltas;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setNumeroDado(int numeroDado) {
    this.numeroDado = numeroDado;
  }

  public void setDinero(int dinero) {
    this.dinero = dinero;
  }

  public void setPosicion(int posicion) {
    this.posicion = posicion;
  }

  public void setPropiedades(int[] propiedades) {
    this.propiedades = propiedades;
  }

  public void setTurno(int turno) {
    this.turno = turno;
  }

  public void setPropiedades(int propiedades) {
    this.propiedades[propiedades] = 1;
  }

  //toString
  @Override
  public String toString() {
    return nombre + "";
  }

  // Métodos
  public void escribirArchivosGuardarPartida(Jugador jugador, String ruta) {

    FileOutputStream fos = null;
    ObjectOutputStream salida = null;

    //Se escriben las notas en un fichero
    try {
      //Se crea el fichero
      fos = new FileOutputStream(ruta);
      salida = new ObjectOutputStream(fos);

      salida.writeObject(jugador);
    } catch (IOException e) {

      System.out.println("Error 1: " + e.toString());

    } finally {
      try {

        salida.close();
        fos.close();
      } catch (IOException e2) {

        System.out.println("Error 2: " + e2.toString());

      }
    }
  }

  public Jugador leerDatos1(String ruta) throws IOException, ClassNotFoundException {

    FileInputStream fis = null;
    ObjectInputStream entrada = null;
    Jugador jugador = null;

    //Se leen las notas del fichero
    fis = new FileInputStream(ruta);
    entrada = new ObjectInputStream(fis);

    jugador = (Jugador) entrada.readObject();

    return jugador;

  }
}
