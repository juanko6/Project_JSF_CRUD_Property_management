package cloud.juanko.repositories;

import cloud.juanko.models.ContratoPropietario;
import cloud.juanko.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContratoPropietarioRepository implements IRepository<ContratoPropietario>{
    @Override
    public List<ContratoPropietario> listar() {
        List<ContratoPropietario> listaContratoPropietario = new ArrayList<>();
        Connection conect = ConexionBaseDatos.getConnection();

        try (Statement stmt = conect.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM contrato_propietario")
        ) {
            while(rs.next()){
                ContratoPropietario contratoPropietario = new ContratoPropietario();
                contratoPropietario.setCodigo(rs.getLong("codigo"));
                contratoPropietario.setDescripcion(rs.getString("descripcion"));
                contratoPropietario.setTipo(rs.getString("tipo"));
                contratoPropietario.setFecha_creacion(rs.getString("fecha_creacion"));
                contratoPropietario.setFecha_finalizacion(rs.getString("fecha_finalizacion"));
                contratoPropietario.setValor(rs.getLong("valor"));
                contratoPropietario.setComision(rs.getInt("comision"));

                listaContratoPropietario.add(contratoPropietario);


            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return listaContratoPropietario;
    }


    @Override
    public ContratoPropietario consultar() {
        return null;
    }

    @Override
    public boolean crear(ContratoPropietario contratoPropietario) {

        Connection conect = ConexionBaseDatos.getConnection();
        String sql =  "insert into contrato_propietario (codigo, tipo, valor, fecha_creacion, fecha_finalizacion, descripcion, comision) values (?,?,?,?,?,?,?)";

        try(
                PreparedStatement stmt = conect.prepareStatement(sql)
        ) {
            stmt.setLong(1, contratoPropietario.getCodigo());
            stmt.setString(2, contratoPropietario.getTipo());
            stmt.setLong(3, contratoPropietario.getValor());
            stmt.setString(4, contratoPropietario.getFecha_creacion());
            stmt.setString(5, contratoPropietario.getFecha_finalizacion());
            stmt.setString(6, contratoPropietario.getDescripcion());
            stmt.setInt(7, contratoPropietario.getComision());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliminar(Long codigo) {
        Connection conect = ConexionBaseDatos.getConnection();
        String sql =  "delete from contrato_propietario where codigo = ?";

        try(
                PreparedStatement stmt = conect.prepareStatement(sql)
        ) {
            stmt.setLong(1,codigo);
            stmt.executeUpdate();
            conect.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean actualizar(ContratoPropietario contratoPropietario) {

        Connection conect = ConexionBaseDatos.getConnection();

        String sql =  "update contrato SET tipo = ?, valor = ?, fecha_creacion = ?, fecha_finalizacion = ?, descripcion = ?, comision = ? WHERE codigo = ?";

        try(
                PreparedStatement stmt = conect.prepareStatement(sql);
        ) {
            stmt.setString(1, contratoPropietario.getTipo());
            stmt.setLong(2, contratoPropietario.getValor());
            stmt.setString(3, contratoPropietario.getFecha_creacion());
            stmt.setString(4, contratoPropietario.getFecha_finalizacion());
            stmt.setString(5, contratoPropietario.getDescripcion());
            stmt.setInt(6, contratoPropietario.getComision());
            stmt.setLong(7, contratoPropietario.getCodigo());




            stmt.executeUpdate();
            System.out.println("se actualizo contrato");
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
