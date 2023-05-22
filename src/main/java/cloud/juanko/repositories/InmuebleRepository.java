package cloud.juanko.repositories;
import cloud.juanko.models.Inmueble;
import cloud.juanko.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InmuebleRepository implements IRepository<Inmueble>{
    @Override
    public List<Inmueble> listar() {
        List<Inmueble> listaInmueble = new ArrayList<>();
        Connection conect = ConexionBaseDatos.getConnection();

        try (Statement stmt = conect.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM inmueble")
        ) {
            while(rs.next()){
                Inmueble inmueble = new Inmueble();
                inmueble.setcodigo(rs.getLong("codigo"));
                inmueble.setdescripcion(rs.getString("descripcion"));
                inmueble.settipo(rs.getString("tipo"));
                inmueble.setestado(rs.getString("estado"));
                inmueble.settamano_m2(rs.getString("tamano_m2"));
                inmueble.setmodalidad(rs.getString("modalidad"));
                inmueble.setdireccion(rs.getString("direccion"));
                inmueble.setprecio(rs.getLong("precio"));
                inmueble.setcant_banos(rs.getLong("cant_banos"));
                inmueble.setfotos(rs.getString("fotos"));
                inmueble.setubicacion(rs.getString("ubicacion"));

                listaInmueble.add(inmueble);


            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return listaInmueble;
    }


    @Override
    public Inmueble consultar() {
        return null;
    }

    @Override
    public boolean crear(Inmueble inmueble) {

        Connection conect = ConexionBaseDatos.getConnection();
        String sql =  "insert into inmueble (codigo, descripcion, tipo, estado, tamano_m2, modalidad,direccion, precio, cant_banos,fotos,ubicacion) values (?,?,?,?,?,?,?,?,?,?,?)";

        try(
                PreparedStatement stmt = conect.prepareStatement(sql)
        ) {
            stmt.setLong(1, inmueble.getcodigo());
            stmt.setString(2, inmueble.getdescripcion());
            stmt.setString(3, inmueble.gettipo());
            stmt.setString(4, inmueble.getestado());
            stmt.setString(5, inmueble.gettamano_m2());
            stmt.setString(6, inmueble.getmodalidad());
            stmt.setString(7, inmueble.getdireccion());
            stmt.setLong(8, inmueble.getprecio());
            stmt.setLong(9, inmueble.getcant_banos());
            stmt.setString(10, inmueble.getfotos());
            stmt.setString(11, inmueble.getubicacion());
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
        String sql =  "delete from inmueble where cedula = ?";

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
    public boolean actualizar(Inmueble inmueble) {

        Connection conect = ConexionBaseDatos.getConnection();

        String sql =  "update Inmueble SET descripcion = ?, tipo = ?, estado = ?, tamano_m2 = ?, modalidad = ?, direccion = ?, precio = ?, cant_banos = ?,fotos = ?,ubicacion = ? WHERE codigo = ?";

        try(
                PreparedStatement stmt = conect.prepareStatement(sql);
        ) {
            stmt.setString(1, inmueble.getdescripcion());
            stmt.setString(2, inmueble.gettipo());
            stmt.setString(3, inmueble.getestado());
            stmt.setString(4, inmueble.gettamano_m2());
            stmt.setString(5, inmueble.getmodalidad());
            stmt.setString(6, inmueble.getdireccion());
            stmt.setLong(7, inmueble.getprecio());
            stmt.setLong(8, inmueble.getcant_banos());
            stmt.setString(9, inmueble.getfotos());
            stmt.setString(10, inmueble.getubicacion());

            stmt.setLong(11, inmueble.getcodigo());


            stmt.executeUpdate();
            System.out.println("se actualizo Inmueble");
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
