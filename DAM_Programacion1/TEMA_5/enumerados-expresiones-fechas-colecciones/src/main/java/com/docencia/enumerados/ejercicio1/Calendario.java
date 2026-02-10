package com.docencia.enumerados.ejercicio1;

public final class Calendario {

  public boolean isFinDeSemana(DiaSemana dia) {
    // return dia == DiaSemana.Sabado || dia == DiaSemana.Domingo;
    if (dia.equals(DiaSemana.Sabado) || dia.equals(DiaSemana.Domingo)){
      return true;
    }
    return false;
  }

  public boolean isLaboral(DiaSemana dia){
      return !isFinDeSemana(dia);

  }

  public DiaSemana siguienteDia(DiaSemana dia) {
    DiaSemana[] v = DiaSemana.values();
    return v[(dia.ordinal() + 1) % v.length];
  }

  public int numeroIso(DiaSemana dia) {
    return dia.ordinal() + 1;
  }
}
