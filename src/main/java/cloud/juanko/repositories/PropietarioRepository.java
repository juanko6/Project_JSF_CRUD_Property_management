package cloud.juanko.repositories;
import cloud.juanko.models.Agente;
import cloud.juanko.models.Propietario;
import cloud.juanko.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropietarioRepository implements IRepository<Propietario>{
    @Override
    public List<Propietario> listar() {
        List<Propietario> listaPropietario = new ArrayList<>();
        Connection conect = ConexionBaseDatos.getConnection();

        try (Statement stmt = conect.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM propietario")
        ) {
            while(rs.next()){
                Propietario propietario = new Propietario();
                propietario.setCedula(rs.getLong("cedula"));
                propietario.setNombre(rs.getString("nombre"));
                propietario.setApellido(rs.getString("apellido"));
                propietario.setFechaNacimiento(rs.getString("fecha_nacimiento"));
                propietario.setFechaExpedicion(rs.getString("fecha_expedicion_cedula"));
                propietario.setCorreo(rs.getString("correo"));

                propietario.setCelular(rs.getLong("celular"));
                propietario.setDireccion(rs.getString("direccion"));

                listaPropietario.add(propietario);


            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return listaPropietario;
    }


    @Override
    public Propietario consultar() {
        return null;
    }

    @Override
    public boolean crear(Propietario propietario) {

        Connection conect = ConexionBaseDatos.getConnection();
        String sql =  "insert into propietario (cedula, nombre, apellido, fecha_nacimiento, fecha_expedicion_cedula, correo, celular, direccion) values (?,?,?,?,?,?,?,?)";

        try(
                PreparedStatement stmt = conect.prepareStatement(sql)
        ) {
            stmt.setLong(1, propietario.getCedula());
            stmt.setString(2, propietario.getNombre());
            stmt.setString(3, propietario.getApellido());
            stmt.setString(4, propietario.getFechaNacimiento());
            stmt.setString(5, propietario.getFechaExpedicion());
            stmt.setString(6, propietario.getCorreo());

            stmt.setLong(7, propietario.getCelular());
            stmt.setString(8, propietario.getDireccion());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean eliminar(Long cedula) {
        Connection conect = ConexionBaseDatos.getConnection();
        String sql =  "delete from propietario where cedula = ?";

        try(
                PreparedStatement stmt = conect.prepareStatement(sql)
        ) {
            stmt.setLong(1,cedula);
            stmt.executeUpdate();
            conect.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean actualizar(Propietario propietario) {

        Connection conect = ConexionBaseDatos.getConnection();

        String sql =  "update propietario SET nombre = ?, apellido = ?, fecha_nacimiento = ?, fecha_expedicion_cedula = ?, correo = ?, direccion = ?, celular = ? WHERE cedula = ?";

        try(
                PreparedStatement stmt = conect.prepareStatement(sql);
        ) {
            stmt.setString(1, propietario.getNombre());
            stmt.setString(2, propietario.getApellido());
            stmt.setString(3, propietario.getFechaNacimiento());
            stmt.setString(4, propietario.getFechaExpedicion());
            stmt.setString(5, propietario.getCorreo());
            stmt.setString(6, propietario.getDireccion());
            stmt.setLong(7, propietario.getCelular());

            stmt.setLong(8, propietario.getCedula());



            stmt.executeUpdate();
            System.out.println("se actualizo Propietario");
            conect.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean validar(String usuario, String contrasena) {
        return false;
    }


}
