package cloud.juanko.repositories;
import cloud.juanko.models.Inmueble;
import cloud.juanko.models.Propietario;
import cloud.juanko.util.ConexionBaseDatos;
import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InmuebleRepository implements IRepository<Inmueble>{
    @Override
    public List<Inmueble> listar() {
        List<Inmueble> listaInmueble = new ArrayList<>();
        Connection conect = ConexionBaseDatos.getConnection();

        try (Statement stmt = conect.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM inmueble ")
        ) {
            while(rs.next()){
                Inmueble inmueble = new Inmueble();
                inmueble.setCodigo(rs.getLong("codigo"));
                inmueble.setDescripcion(rs.getString("descripcion"));
                inmueble.setTipo(rs.getString("tipo"));
                inmueble.setEstado(rs.getString("estado"));
                inmueble.setTamano_m2(rs.getInt("tamano_m2"));
                inmueble.setModalidad(rs.getString("modalidad"));
                inmueble.setDireccion(rs.getString("direccion"));
                inmueble.setPrecio(rs.getLong("precio"));
                inmueble.setCant_banos(rs.getLong("cant_banos"));
                inmueble.setFotos(rs.getString("fotos"));
                inmueble.setPais(rs.getString("pais"));
                inmueble.setDepartamento(rs.getString("departamento"));
                inmueble.setCiudad(rs.getString("municipio"));

                Propietario propietario = new Propietario();
                propietario.setCedula(rs.getLong("propiedad"));


                inmueble.setPropiedad(propietario);


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


    /*
    *
    *
    * TODO: cambiar tanto base de datos como aqui el model inmueble para que se almacene pais, departamento y ciudad
     */
    @Override
    public boolean crear(Inmueble inmueble) {

        Connection conect = ConexionBaseDatos.getConnection();
        String sql = "insert into inmueble (codigo, descripcion, tipo, estado, tamano_m2, modalidad, direccion, precio, cant_banos, fotos, pais, departamento, municipio, propiedad) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (
                PreparedStatement stmt = conect.prepareStatement(sql)
        ) {
            stmt.setLong(1, inmueble.getCodigo());
            stmt.setString(2, inmueble.getDescripcion());
            stmt.setString(3, inmueble.getTipo());
            stmt.setString(4, inmueble.getEstado());
            stmt.setInt(5, inmueble.getTamano_m2());
            stmt.setString(6, inmueble.getModalidad());
            stmt.setString(7, inmueble.getDireccion());
            stmt.setLong(8, inmueble.getPrecio());
            stmt.setLong(9, inmueble.getCant_banos());
            stmt.setString(10, inmueble.getFotos());
            stmt.setString(11, inmueble.getPais());
            stmt.setString(12, inmueble.getDepartamento());
            stmt.setString(13, inmueble.getCiudad());
            stmt.setLong(14, inmueble.getPropiedad().getCedula());
            if (comprobarId(inmueble)) {
                stmt.executeUpdate();
                return true;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean crear(Inmueble inmueble, Propietario propietario ) {

        Connection conect = ConexionBaseDatos.getConnection();
        String sql = "insert into inmueble (codigo, descripcion, tipo, estado, tamano_m2, modalidad, direccion, precio, cant_banos, fotos, pais, departamento, municipio, propiedad) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (
                PreparedStatement stmt = conect.prepareStatement(sql)
        ) {
            stmt.setLong(1, inmueble.getCodigo());
            stmt.setString(2, inmueble.getDescripcion());
            stmt.setString(3, inmueble.getTipo());
            stmt.setString(4, inmueble.getEstado());
            stmt.setInt(5, inmueble.getTamano_m2());
            stmt.setString(6, inmueble.getModalidad());
            stmt.setString(7, inmueble.getDireccion());
            stmt.setLong(8, inmueble.getPrecio());
            stmt.setLong(9, inmueble.getCant_banos());
            stmt.setString(10, inmueble.getFotos());
            stmt.setString(11, inmueble.getPais());
            stmt.setString(12, inmueble.getDepartamento());
            stmt.setString(13, inmueble.getCiudad());
            stmt.setLong(14, propietario.getCedula());

            if (!comprobarId(inmueble)) {
                stmt.executeUpdate();
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliminar(Long codigo) {
        Connection conect = ConexionBaseDatos.getConnection();
        String sql =  "delete from inmueble where codigo = ?";

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
    public boolean actualizar(Inmueble inmueble) {

        Connection conect = ConexionBaseDatos.getConnection();

        String sql = "update inmueble SET descripcion = ?, tipo = ?, estado = ?, tamano_m2 = ?, modalidad = ?, direccion = ?, precio = ?, cant_banos = ?,fotos = ?,pais = ?,departamento = ?,municipio = ?,propiedad = ? WHERE codigo = ?";

        try (
                PreparedStatement stmt = conect.prepareStatement(sql);
        ) {

            stmt.setString(1, inmueble.getDescripcion());
            stmt.setString(2, inmueble.getTipo());
            stmt.setString(3, inmueble.getEstado());
            stmt.setInt(4, inmueble.getTamano_m2());
            stmt.setString(5, inmueble.getModalidad());
            stmt.setString(6, inmueble.getDireccion());
            stmt.setLong(7, inmueble.getPrecio());
            stmt.setLong(8, inmueble.getCant_banos());
            stmt.setString(9, inmueble.getFotos());
            stmt.setString(10, inmueble.getPais());
            stmt.setString(11, inmueble.getDepartamento());
            stmt.setString(12, inmueble.getCiudad());
            stmt.setLong(13, inmueble.getPropiedad().getCedula());
            stmt.setLong(14, inmueble.getCodigo());


            stmt.executeUpdate();
            System.out.println("se actualizo Inmueble");
            conect.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean actualizar(Inmueble inmueble, Propietario propietario) {

        Connection conect = ConexionBaseDatos.getConnection();

        String sql =  "update inmueble SET descripcion = ?, tipo = ?, estado = ?, tamano_m2 = ?, modalidad = ?, direccion = ?, precio = ?, cant_banos = ?,fotos = ?,pais = ?,departamento = ?,municipio = ?,propiedad = ? WHERE codigo = ?";

        try(
                PreparedStatement stmt = conect.prepareStatement(sql);
        ) {

            stmt.setString(1, inmueble.getDescripcion());
            stmt.setString(2, inmueble.getTipo());
            stmt.setString(3, inmueble.getEstado());
            stmt.setInt(4, inmueble.getTamano_m2());
            stmt.setString(5, inmueble.getModalidad());
            stmt.setString(6, inmueble.getDireccion());
            stmt.setLong(7, inmueble.getPrecio());
            stmt.setLong(8, inmueble.getCant_banos());
            stmt.setString(9, inmueble.getFotos());
            stmt.setString(10, inmueble.getPais());
            stmt.setString(11, inmueble.getDepartamento());
            stmt.setString(12, inmueble.getCiudad());
            stmt.setLong(13, propietario.getCedula());

            stmt.setLong(14, inmueble.getCodigo());


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


    public boolean comprobarId(Inmueble inmueble) {
        Connection conect = ConexionBaseDatos.getConnection();


        try (
                Statement stmt = conect.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM inmueble");
        ) {
            while (rs.next()) {
                System.out.println("Recorriendo inmueble ");
                Inmueble aux = new Inmueble();
                aux.setCodigo(rs.getLong("codigo"));
                System.out.println(inmueble.getCodigo() + " Codigo Ingresado");
                System.out.println(aux.getCodigo() + " Codigo Listado");
                int au = aux.getCodigo().intValue();
                int in = inmueble.getCodigo().intValue();
                if (au == in) {
                    System.out.println("Se Comprobo");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El codigo ingresado se encuentra en la base de datos de 'INMUEBLE'"));
                    PrimeFaces.current().ajax().update("form:messages", "form:dtinmueble");
                    return true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
