package com.docencia.repository.file;

import java.io.File;

public class FileCsv extends FileAbstract{

    private static String path = "alumnno.csv";

        public FileCsv(){
        super(path);
        }

    public FileCsv(String path){
        super(path);
        }

    
    
}


