package formacion.dam;

public final class InvertirInPlace {
    private InvertirInPlace() {}
    public static int[] invertir(int[] datos) {
        for (int i = 0; i < datos.length /2; i++){
            int aux = datos[datos.length-1-i];
            datos[datos.length-1-i] = datos [i];
            datos[i] = aux;
        }
        return datos;
    }
}
