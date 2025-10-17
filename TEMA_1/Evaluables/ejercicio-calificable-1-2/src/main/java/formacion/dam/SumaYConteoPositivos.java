package formacion.dam;

public final class SumaYConteoPositivos {
    public record Resultado(int suma, int conteo) {}
    private SumaYConteoPositivos() {}
    public static int[] calcular(int[] datos) {
        int suma = 0;
        int conteo = 0;
        int[] array = new int [datos.length];

        if (datos == null){
        return null;
        }

        for (int i = 0; i < array.length; i++){
            if (datos[i] > 0){
                suma += datos[i];
                conteo++;
            }

        }
        int [] resultado = {suma, conteo};
 
        return resultado;
    }
}
