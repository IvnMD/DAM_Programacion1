package com.docencia.ficheros.util;

import java.io.InputStream;

public final class ResourceUtils {
    private ResourceUtils() {}

    public static InputStream getResourceAsStream(String path) {
        InputStream in = ResourceUtils.class.getClassLoader().getResourceAsStream(path);
        if (in == null) {
            throw new IllegalArgumentException("No se encuentra el recurso: " + path);
        }
        return in;
    }
}
