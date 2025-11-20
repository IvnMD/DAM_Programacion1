package unidad3;

import java.util.Objects;

public class Ejercicio01 {

    private int nota;

    /**
     * Constructor vacio
     */
   public Ejercicio01(){};
   
   /**
    * Constructor parametrico
    * @param nota
    */
   public Ejercicio01(int nota) {
    this.nota = nota;
   }   

       public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        if (nota < 0 || nota > 10){
            throw new IllegalArgumentException("IllegalArgumentException");
        }
        this.nota = nota;
    }

    
    @Override
    public String toString() {
        if (nota < 5){return "Insuficiente";}
        if (nota == 5){return "Suficiente";}
        if (nota == 6) {return "Bien";}
        if (nota < 9) {return "Notable";}
        if (nota < 11) {return "Sobresaliente";}
    }

    @Override
    public int hashCode() {
        return Objects.hash(nota);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ejercicio01 other = (Ejercicio01) obj;
        return nota == other.nota;
    }

    public static String calificar(int nota) {
  
        return calificar(nota); 
        
    }









}

