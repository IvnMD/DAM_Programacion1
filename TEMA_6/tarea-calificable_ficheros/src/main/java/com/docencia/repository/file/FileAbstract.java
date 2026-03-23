package com.docencia.repository.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.docencia.model.Usuario;

public abstract class FileAbstract{
    
    private final String path;
    private final File file;


    public FileAbstract(String path){
        this.path = path;
        file = new File(path);
        if (!file.exists() || !file.isFile()){
            System.err.println("La ruta " + path + ", no es una ruta valida o un fichero");
            //!  throw new IllegalArgumentException(path);  Pararia el codigo rompiendolo, Serr no,
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void write(String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(data);
            writer.newLine(); // Añadir una nueva línea después del registro
            System.out.println("Registro agregado.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    

    public Set<Usuario> read() {
        Set<Usuario>usuariosLectura = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                //0;Juan;email@net.es;123456
                String[] datos = line.split(";"); //[0][Juan][email@net.es][123456]
                Usuario usuarioLeido = new Usuario(Integer.parseInt(datos[0]), datos[1], datos[2], datos[3]);
                usuariosLectura.add(usuarioLeido);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return usuariosLectura;
    }

    public void delete(){
        if(!file.exists()){
            return;
        }
        file.delete();
        try {
            file.createNewFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // public boolean update(List<Object> elementos){
    //     delete();
    //     for (Object object : elementos) {  

            
    //     }

    //     return true;
    // }
    
}
