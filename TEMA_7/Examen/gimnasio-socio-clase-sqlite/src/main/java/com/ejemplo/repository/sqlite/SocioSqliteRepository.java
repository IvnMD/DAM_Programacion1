package com.ejemplo.repository.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ejemplo.model.Socio;
import com.ejemplo.repository.ISocioRepository;

public class SocioSqliteRepository extends SQLiteConnectionManager implements ISocioRepository {


   public SocioSqliteRepository(String rutaDB) {
        super();
    }

    public SocioSqliteRepository() {
        super();
    }



    
    public boolean create(Socio socio) {
        String sql = ("INSERT INTO socio id, dni, nombre, email, telefono, plan, activo,"
            +" values (?,?,?,?,?,?, ?)");
        try (Connection connection = this.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setInt(1, socio.getId());
            ps.setString(2, socio.getDni());
            ps.setString(3, socio.getNombre());
            ps.setString(4, socio.getEmail());
            ps.setString(5, socio.getTelefono());
            ps.setString(6, socio.getPlan());
            ps.setInt(7, socio.getActivo());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("No se ha podido almacenar el socio:"+socio.getId());
            return false;
        }
        return true;
    }
    // private final Integer id;
    // private final String dni;
    // private final String nombre;
    // private final String email;
    // private final String telefono;
    // private final String plan;
    // private final Integer activo;


    public List<Socio> findAll(){

        String sql = "SELECT * FROM socio";
        ArrayList<Socio> socios =new ArrayList<>();
        try (Connection connection = this.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                // Integer miId = Integer.valueOf(id);
                String dni = resultado.getString("dni");
                String nombre = resultado.getString("nombre");
                String email = resultado.getString("email");
                String telefono = resultado.getString("telefono");
                // Integer miCupo = Integer.valueOf(cupoMaximo);
                String plan = resultado.getString("plan");
                int activo = resultado.getInt("activo");
                // Integer miMonitor = Integer.valueOf(activo);
                Socio socio = new Socio(id, dni, nombre, email, telefono, plan, activo);
                socios.add(socio);

            }
        } catch (Exception e) {
            System.err.println("No se han podido obtener la lista de todas las socios");
            return new ArrayList<>();
        }
        return socios;
    }


    
    public Socio findById(Integer id){
        String sql = "SELECT * FROM socio where id = ?";
        Socio socio = null;
        try (Connection connection = this.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                // Integer miId = Integer.valueOf(id);
                String dni = resultado.getString("dni");
                String nombre = resultado.getString("nombre");
                String email = resultado.getString("email");
                String telefono = resultado.getString("telefono");
                // Integer miCupo = Integer.valueOf(cupoMaximo);
                String plan = resultado.getString("plan");
                int activo = resultado.getInt("activo");
                // Integer miMonitor = Integer.valueOf(activo);
                socio = new Socio(id, dni, nombre, email, telefono, plan, activo);
                

            }
        } catch (Exception e) {
            System.err.println("No se han podido obtener el id" + id);
        }
        return socio;
    }


        
    public boolean update(Socio socio){
        String sql = ("UPDATE socio id, nombre, dni, horario, cupo_maximo, plazas_disponibles, activa, id_monitor "
            +" values (?,?,?,?,?,?,?,?)");
        try (Connection connection = this.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setInt(1, socio.getId());
            ps.setString(2, socio.getDni());
            ps.setString(3, socio.getNombre());
            ps.setString(4, socio.getEmail());
            ps.setString(5, socio.getTelefono());
            ps.setString(6, socio.getPlan());
            ps.setInt(7, socio.getActivo());
            ps.executeUpdate();

        } catch (Exception e) {
            System.err.println("No se ha podido almacenar el socio:"+socio.getId());
            return false;
        }
        return true;
    }
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
