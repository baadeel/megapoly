/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package megapoly;

import java.util.Scanner;

/**
 *
 * @author Badal
 */
public class Tablero {

  protected Casillas[] tablero;

  //Constructores
  public Tablero() {
    this.tablero = new Casillas[24];
  }

  //Getters
  public Casillas getTablero(int numero) {
    return tablero[numero];
  }

  //Setters
  public void setTablero(Casillas[] tablero) {
    this.tablero = tablero;
  }

  //Métodos
  
  
  public void crearTablero() {
    tablero[0] = new Inicio();
    tablero[1] = new Calle("Bélgica", 1, false, 15, 10, null);
    tablero[2] = new Calle("República Checa", 2, false, 15, 10, null);
    tablero[3] = new Impuesto("Impuestos sobre la renta", 3);
    tablero[4] = new Calle("Dinamarca", 4, false, 15, 10, null);
    tablero[5] = new Calle("Austria", 5, false, 20, 15, null);
    tablero[6] = new Carcel("Cárcel", 6);
    tablero[7] = new Calle("Suecia", 7, false, 20, 15, null);
    tablero[8] = new Calle("Noruega", 8, false, 20, 15, null);
    tablero[9] = new Suerte("Suerte", 9);
    tablero[10] = new Calle("Portugal", 10, false, 20, 15, null);
    tablero[11] = new Calle("Grecia", 11, false, 20, 15, null);
    tablero[12] = new Parking("Parking", 12);
    tablero[13] = new Calle("Países Bajos", 13, false, 20, 15, null);
    tablero[14] = new Calle("Polonia", 14, false, 25, 20, null);
    tablero[15] = new Impuesto("Impuestos sobre la renta", 15);
    tablero[16] = new Calle("Reino Unido", 16, false, 20, 15, null);
    tablero[17] = new Calle("Francia", 17, false, 25, 20, null);
    tablero[18] = new Carcel("Cárcel", 18);
    tablero[19] = new Calle("Irlanda", 19, false, 25, 20, null);
    tablero[20] = new Calle("España", 20, false, 30, 25, null);
    tablero[21] = new Suerte("Suerte", 21);
    tablero[22] = new Calle("Alemania", 22, false, 30, 25, null);
    tablero[23] = new Calle("Italia", 23, false, 30, 25, null);
  }


}

  


  



 