package formacion.dam;


public final class MaximoYPrimeraPosicion {
    
    private MaximoYPrimeraPosicion() {}
    public static int[] calcular(int[] datos) {
        
        int maximo = datos[0];
        int indice = 0;

        for (int i = 1; i < datos.length; i++){

            if (maximo < datos[i]){
               maximo = datos[i];
               indice = i;
            }        
        }
        int[] resultado = {maximo,indice};

        return resultado;
    }
}
