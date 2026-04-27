package com.ejemplo.repository.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ejemplo.model.Clase;
import com.ejemplo.repository.IClaseRepository;

public class ClaseSqliteRepository extends SQLiteConnectionManager implements IClaseRepository {
    
    
    public ClaseSqliteRepository(String rutaDB) {
        super();
    }

    public ClaseSqliteRepository() {
        super();
    }



        @Override
    public boolean create(Clase clase) {
        String sql = ("INSERT INTO clase id, nombre, tipo, horario, cupo_maximo, plazas_disponibles, activa, id_monitor "
            +" values (?,?,?,?,?,?,?,?)");
        try (Connection connection = this.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setInt(1, clase.getId());
            ps.setString(2, clase.getNombre());
            ps.setString(3, clase.getTipo());
            ps.setString(4, clase.getHorario());
            ps.setInt(5, clase.getCupoMaximo());
            ps.setInt(6, clase.getPlazasDisponibles());
            ps.setInt(7, clase.getActiva());
            ps.setInt(8, clase.getIdMonitor());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("No se ha podido almacenar el clase:"+clase.getId());
            return false;
        }
        return true;
    }

    // private final Integer id;
    // private final String nombre;
    // private final String tipo;
    // private final String horario;
    // private final Integer cupoMaximo;
    // private final Integer plazasDisponibles;
    // private final Integer activa;
    // private final Integer idMonitor;
    @Override
    public List<Clase> findAll(){

        String sql = "SELECT * FROM clase";
        ArrayList<Clase> clases =new ArrayList<>();
        try (Connection connection = this.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                // Integer miId = Integer.valueOf(id);
                String nombre = resultado.getString("nombre");
                String tipo = resultado.getString("tipo");
                String horario = resultado.getString("horario");
                int cupoMaximo = resultado.getInt("cupo_maximo");
                // Integer miCupo = Integer.valueOf(cupoMaximo);
                int plazasDisponibles = resultado.getInt("plazas_disponible");
                // Integer miPlaza = resultado.getInt(plazasDisponibles);
                int activa = resultado.getInt("activa");
                int idMonitor = resultado.getInt("id_monitor");
                // Integer miMonitor = Integer.valueOf(idMonitor);
                Clase clase = new Clase(id, nombre, tipo, horario, cupoMaximo, plazasDisponibles, activa, idMonitor);
                clases.add(clase);

            }
        } catch (Exception e) {
            System.err.println("No se han podido obtener la lista de todas las clases");
            return new ArrayList<>();
        }
        return clases;
    }


    @Override
    public Clase findById(Integer id){
        String sql = "SELECT * FROM clase where id = ?";
        Clase clase = null;
        try (Connection connection = this.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                // Integer miId = Integer.valueOf(id);
                String nombre = resultado.getString("nombre");
                String tipo = resultado.getString("tipo");
                String horario = resultado.getString("horario");
                int cupoMaximo = resultado.getInt("cupo_maximo");
                // Integer miCupo = Integer.valueOf(cupoMaximo);
                int plazasDisponibles = resultado.getInt("plazas_disponible");
                // Integer miPlaza = resultado.getInt(plazasDisponibles);
                int activa = resultado.getInt("activa");
                int idMonitor = resultado.getInt("id_monitor");
                // Integer miMonitor = Integer.valueOf(idMonitor);
                clase = new Clase(id, nombre, tipo, horario, cupoMaximo, plazasDisponibles, activa, idMonitor);
                

            }
        } catch (Exception e) {
            System.err.println("No se han podido obtener el id" + id);
        }
        return clase;
    }


    @Override
    public boolean update(Clase clase){
        String sql = ("UPDATE clase id, nombre, tipo, horario, cupo_maximo, plazas_disponibles, activa, id_monitor "
            +" values (?,?,?,?,?,?,?,?)");
        try (Connection connection = this.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setInt(1, clase.getId());
            ps.setString(2, clase.getNombre());
            ps.setString(3, clase.getTipo());
            ps.setString(4, clase.getHorario());
            ps.setInt(5, clase.getCupoMaximo());
            ps.setInt(6, clase.getPlazasDisponibles());
            ps.setInt(7, clase.getActiva());
            ps.setInt(8, clase.getIdMonitor());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("No se ha podido almacenar el clase:"+clase.getId());
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteById(Integer id){
        String sql = "DELETE * FROM cliente where id = ?";
        try (Connection connection = this.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("No se ha eliminado el id " + id);
            return false;
         }
    }
}
