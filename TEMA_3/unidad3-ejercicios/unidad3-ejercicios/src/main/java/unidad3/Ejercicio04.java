package unidad3;


public class Ejercicio04 {

    public static class ContadorSignos {
        private final int positivos;
        private final int negativos;
        private final int ceros;

        public ContadorSignos(int positivos, int negativos, int ceros) {
            this.positivos = 0;
            this.negativos = 0;
            this.ceros = 0;
        }

        public int getPositivos() {
            if(positivos < 0) {
                return 0;
            }
            return positivos;
        }

        public int getNegativos() {
            if(negativos < 0) {
                return 0;
            }
            return negativos;
        }

        public int getCeros() {
            if (ceros > 0 || ceros < 0 ) {
                return 0;
            }
            return ceros;
        }
    }

    
    public static ContadorSignos contarSignos(int[] numeros) {
        
        for (int i = 0; i<numeros.length; i++){
            if (numeros[i] < 0){
                
            }
        }

        return 0;
    }
}
