package cloud.juanko.repositories;
import cloud.juanko.models.Agente;
import cloud.juanko.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgenteRepository implements IRepository<Agente>{
    @Override
    public List<Agente> listar() {
        List<Agente> listaAgente = new ArrayList<>();
        Connection conect = ConexionBaseDatos.getConnection();

        try (Statement stmt = conect.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM agente_comercial")
        ) {
            while(rs.next()){
                Agente agente = new Agente();
                agente.setCedula(rs.getLong("cedula"));
                agente.setNombre(rs.getString("nombre"));
                agente.setApellido(rs.getString("apellido"));
                agente.setFechaNacimiento(rs.getString("fecha_nacimiento"));
                agente.setUsuario(rs.getString("usuario"));
                agente.setContrasena(rs.getString("contrasena"));
                agente.setFechaExpedicion(rs.getString("fecha_expedicioncedula"));
                agente.setCorreo(rs.getString("correo"));
                agente.setDireccion(rs.getString("direccion"));
                agente.setCelular(rs.getLong("celular"));

                listaAgente.add(agente);


            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return listaAgente;
    }


    @Override
    public Agente consultar() {
        return null;
    }

    @Override
    public boolean crear(Agente agente) {

        Connection conect = ConexionBaseDatos.getConnection();
        String sql =  "insert into agente_comercial (cedula, nombre, apellido, fecha_nacimiento, usuario, contrasena, fecha_expedicioncedula, correo, direccion, celular) values (?,?,?,?,?,?,?,?,?,?)";

        try(
                PreparedStatement stmt = conect.prepareStatement(sql)
        ) {
            stmt.setLong(1, agente.getCedula());
            stmt.setString(2, agente.getNombre());
            stmt.setString(3, agente.getApellido());
            stmt.setString(4, agente.getFechaNacimiento());
            stmt.setString(5, agente.getUsuario());
            stmt.setString(6, agente.getContrasena());
            stmt.setString(7, agente.getFechaExpedicion());
            stmt.setString(8, agente.getCorreo());
            stmt.setString(9, agente.getDireccion());
            stmt.setLong(10, agente.getCelular());
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
        String sql =  "delete from agente_comercial where cedula = ?";

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
    public boolean actualizar(Agente agente) {

        Connection conect = ConexionBaseDatos.getConnection();

        String sql =  "update agente_comercial SET nombre = ?, apellido = ?, fecha_nacimiento = ?, usuario = ?, contrasena = ?, fecha_expedicioncedula = ?, correo = ?, direccion = ?, celular = ? WHERE cedula = ?";

        try(
                PreparedStatement stmt = conect.prepareStatement(sql);
        ) {
            stmt.setString(1, agente.getNombre());
            stmt.setString(2, agente.getApellido());
            stmt.setString(3, agente.getFechaNacimiento());
            stmt.setString(4, agente.getUsuario());
            stmt.setString(5, agente.getContrasena());
            stmt.setString(6, agente.getFechaExpedicion());
            stmt.setString(7, agente.getCorreo());
            stmt.setString(8, agente.getDireccion());
            stmt.setLong(9, agente.getCelular());

            stmt.setLong(10, agente.getCedula());



            stmt.executeUpdate();
            System.out.println("se actualizo Agente");
            conect.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean validar(String usuario, String contrasena) {
        System.out.println("Validando Agente repository " + usuario + contrasena);


        try {
            Connection conect = ConexionBaseDatos.getConnection();
            String query = "SELECT * FROM agente_comercial WHERE usuario = ? AND contrasena = ?";

            PreparedStatement statement = conect.prepareStatement(query);
            statement.setString(1, usuario);
            statement.setString(2, contrasena);

            ResultSet resultSet = statement.executeQuery();
            conect.close();
            if (resultSet.next()) {
                // Usuario y contraseña válidos
                return true;
            } else {
                // Usuario o contraseña incorrectos
                return false;

            }


        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de errores
        }
        return false;

    }

}
