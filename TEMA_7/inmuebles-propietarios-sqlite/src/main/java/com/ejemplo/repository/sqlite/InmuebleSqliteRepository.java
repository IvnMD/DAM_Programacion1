package com.ejemplo.repository.sqlite;

import com.ejemplo.model.Inmueble;
import com.ejemplo.repository.IInmuebleRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.jcp.xml.dsig.internal.dom.Utils;

public class InmuebleSqliteRepository extends SQLiteConnectionManager implements IInmuebleRepository {

    public InmuebleSqliteRepository() {
        super(rutaDb);
    }
    /**
     *     private Long id;
     * private String referencia;
     * private String tipo;
     * private String direccion;
     * private String ciudad;
     * private Integer anioConstruccion;
    private Integer metrosCuadrados;
    private Double precio;
    private boolean vendido;
    private String dniPropietario;
     */
    @Override
    public boolean create(Inmueble inmueble) {
        
        if (inmueble == null){
            return false;
        }
        String sql = "Insert into inmueble id, referencia, tipo, direccion, ciudad, anio_construccion, metros_cuadrados, precio, vendido, dni_propietario";
       try (Connection connection = SQLiteConnectionManager.getConnection()){
        
       } catch (Exception e) {
        // TODO: handle exception
       }
    }

    @Override
    public List<Inmueble> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Inmueble findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean update(Inmueble inmueble) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
}
