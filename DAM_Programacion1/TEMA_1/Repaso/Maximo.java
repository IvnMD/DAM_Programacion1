package TEMA_1.Repaso;


public class Maximo {
    public static void main(String[] args) {
        int [] numeros = {4,7,5,9,24,8,31,3,110,66};
        int maximo = 0;

        for (int numero : numeros) {
            if (numero > maximo){
                maximo = numero;
            }
        }
        System.out.println("Maximo es = " + maximo);

        //! MANERA MAS OPTIMA DE REALIZARLO
        // int maximo = numeros[0]; 
        
        // for (int i = 1; i < numeros.length; i++) {
        //     if (numeros[i] > maximo){
        //         maximo = numeros[i];
        //     }
        // }
        //? DAMOS UN PASO MENOS PARA RECORRER EL ARRAY

    }
}
