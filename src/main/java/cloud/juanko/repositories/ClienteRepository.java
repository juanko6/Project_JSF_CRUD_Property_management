package cloud.juanko.repositories;
import cloud.juanko.models.Cliente;
import cloud.juanko.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository implements IRepository<Cliente>{
    @Override
    public List<Cliente> listar() {
        List<Cliente> listaCliente = new ArrayList<>();
        Connection conect = ConexionBaseDatos.getConnection();

        try (Statement stmt = conect.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Cliente")
        ) {
            while(rs.next()){
                Cliente Cliente = new Cliente();
                Cliente.setCedula(rs.getLong("cedula"));
                Cliente.setNombre(rs.getString("nombre"));
                Cliente.setApellido(rs.getString("apellido"));
                Cliente.setFechaNacimiento(rs.getString("fecha_nacimiento"));
                Cliente.setFechaExpedicion(rs.getString("fecha_expedicion_cedula"));
                Cliente.setCorreo(rs.getString("correo"));
                Cliente.setDireccion(rs.getString("direccion"));
                Cliente.setCelular(rs.getLong("celular"));

                listaCliente.add(Cliente);


            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return listaCliente;
    }


    @Override
    public Cliente consultar() {
        return null;
    }

    @Override
    public boolean crear(Cliente cliente) {

        Connection conect = ConexionBaseDatos.getConnection();
        String sql =  "insert into cliente (cedula, nombre, apellido, fecha_nacimiento, fecha_expedicion_cedula, correo, direccion, celular) values (?,?,?,?,?,?,?,?)";

        try(
                PreparedStatement stmt = conect.prepareStatement(sql)
        ) {
            stmt.setLong(1, cliente.getCedula());
            stmt.setString(2, cliente.getNombre());
            stmt.setString(3, cliente.getApellido());
            stmt.setString(4, cliente.getFechaNacimiento());
            stmt.setString(5, cliente.getFechaExpedicion());
            stmt.setString(6, cliente.getCorreo());
            stmt.setString(7, cliente.getDireccion());
            stmt.setLong(8, cliente.getCelular());
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
        String sql =  "delete from cliente where cedula = ?";

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
    public boolean actualizar(Cliente cliente) {

        Connection conect = ConexionBaseDatos.getConnection();

        String sql =  "update Cliente SET nombre = ?, apellido = ?, fecha_nacimiento = ?, fecha_expedicion_cedula = ?, correo = ?, direccion = ?, celular = ? WHERE cedula = ?";

        try(
                PreparedStatement stmt = conect.prepareStatement(sql);
        ) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getFechaNacimiento());
            stmt.setString(4, cliente.getFechaExpedicion());
            stmt.setString(5, cliente.getCorreo());
            stmt.setString(6, cliente.getDireccion());
            stmt.setLong(7, cliente.getCelular());

            stmt.setLong(8, cliente.getCedula());



            stmt.executeUpdate();
            System.out.println("se actualizo Cliente");
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
