package com.docencia;

import com.docencia.Animal;

public class Gata implements Animal{
    
    @Override
    public String comer(){
        return "No hablan y tiran pa'lante";
    }
}
