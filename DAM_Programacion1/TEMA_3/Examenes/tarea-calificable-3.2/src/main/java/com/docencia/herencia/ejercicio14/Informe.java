package com.docencia.herencia.ejercicio14;
/**
 * @author IvnMD
 * @date 09/01/26
 * @version 1.0.0
 * @brief Implementar una jerarquia simple de documentos 
 *        y una funcionalidad común para obtener susdescripciones, 
 *        aplicando programación defensiva ante datos invalidos.
 */

import java.util.ArrayList;
import java.util.List;


/**
 * Ejercicio 14
 *
 * Clase lanzadora (opcional) y contenedor de métodos del enunciado.
 */



/**
 * Clase informe que hereda de documento
 */
public class Informe extends Documento {
        private int paginas;

        /**
         * Constructor parametrico
         * @param titulo del documento, heredado de documento
         * @param paginas numero de paginas del documento 
         */
        public Informe(String titulo, int paginas) {
            super(titulo);
            setPaginas(paginas);
        }
        /**
         * Setters/getters
         */
        public void setPaginas(int paginas) {
            if(paginas <=0){
                throw new IllegalArgumentException();
            }
            this.paginas = paginas;
        }

        public int getPaginas() {
            return paginas;
        }
        /**
         * Funcion descripcion, que hace las veces de toString en este caso
         */
        @Override
        public String descripcion() {
            return "Informe: " + getTitulo() + " (" + getPaginas() + " páginas)";
        }
    

}
