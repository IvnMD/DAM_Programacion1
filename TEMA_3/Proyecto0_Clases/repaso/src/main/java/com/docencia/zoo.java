package com.docencia;

import java.util.ArrayList;
import java.util.List;

public class zoo {
    
    final Animal[] animales;
    final List<Animal> animalesList; 

    public zoo(){
        animales = new Animal[3];
        animalesList = new ArrayList<>();
    }

    public boolean add (Animal animal){
        if (animalArray != null && animalArray.equals(animal){
            return true;
        }
        
        // animales[0] = animal; //! Anyade un animal en la posicion 0
        for (Animal animalArray : animales){
            if (animalArray == null){
                animalArray = animal;
            }
        }
        animalesList.add(animal); //! Anyade un animal al final de la lista
        
        
        return true;
    }
    

    public Animal search (Animal animal){
        if (animal == null || animal.getChip() == null || animal.getChip().isEmpty()){
            return false;
        }
        
        // animales[0] = animal; //! Anyade un animal en la posicion 0
        for (Animal animalArray : animales){
            if (animalArray == null){
                animalArray = animal;
            }
        }


}
