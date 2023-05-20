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
             ResultSet rs = stmt.executeQuery("SELECT * FROM empleados")
        ) {
            while(rs.next()){
                Agente agente = new Agente();
                agente.setId(rs.getInt("id"));
                agente.setNombre(rs.getString("nombre"));
                agente.setCiudad(rs.getString("ciudad"));
                agente.setDepartamento(rs.getString("departament"));
                agente.setSalario(rs.getInt("salario"));

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
        String sql =  "insert into empleados (id, nombre, ciudad, departament, salario) values (?,?,?,?,?)";

        try(
                PreparedStatement stmt = conect.prepareStatement(sql)
        ) {
            stmt.setInt(1, agente.getId());
            stmt.setString(2, agente.getNombre());
            stmt.setString(3, agente.getDepartamento());
            stmt.setString(4, agente.getCiudad());
            stmt.setInt(5, agente.getSalario());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean eliminar(int id) {
        Connection conect = ConexionBaseDatos.getConnection();
        String sql =  "delete from empleados where id = ?";

        try(
                PreparedStatement stmt = conect.prepareStatement(sql)
        ) {
            stmt.setInt(1,id);
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

        String sql =  "update empleados SET nombre = ?, departament = ?, salario = ?, ciudad = ? WHERE id = ?";

        try(
                PreparedStatement stmt = conect.prepareStatement(sql);
        ) {
            stmt.setString(1, agente.getNombre());
            stmt.setString(2, agente.getDepartamento());
            stmt.setInt(3, agente.getSalario());
            stmt.setString(4, agente.getCiudad());
            stmt.setInt(5, agente.getId());

            stmt.executeUpdate();
            System.out.println("se actualizo empleado");
            conect.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean validar(int id, String nombre) {
        System.out.println("Validando empleadorepository " + id + nombre);


        try {
            Connection conect = ConexionBaseDatos.getConnection();
            String query = "SELECT * FROM empleados WHERE nombre = ? AND id = ?";

            PreparedStatement statement = conect.prepareStatement(query);
            statement.setString(1, nombre);
            statement.setInt(2, id);

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
