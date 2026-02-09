package com.docencia.enumerados.ejercicio2;

public final class ControlSemaforo {

  /** Funcion para saber si se puede avanzar en el semafoto
   * @param color encendido
   * @return true si puede avanzar, false en lo contrario
   */
  public boolean puedeAvanzar(ColorSemaforo color) {
    // return color == ColorSemaforo.Verde;
    if (color.equals(ColorSemaforo.Verde)){
      return true;
    }
    return false;
  }

  /** Funcion para saber cual es el proximo color
   * @param color encendido
   * @return siguiente color en la secuenta
   */
  public ColorSemaforo siguienteColor(ColorSemaforo color) {
    return switch (color) {
      case Rojo -> ColorSemaforo.Verde;
      case Verde -> ColorSemaforo.Ambar;
      case Ambar -> ColorSemaforo.Rojo;
    };
  }

  /** Segundos hasta que cambie el semaforo
   * @param color de la luz encendida
   * @return tiempo hasta cambiar de estado
   */
  public int segundosHastaCambio(ColorSemaforo color) {
    return switch (color) {
      case Rojo -> 45;
      case Verde -> 40;
      case Ambar -> 5;
    };
  }
}
