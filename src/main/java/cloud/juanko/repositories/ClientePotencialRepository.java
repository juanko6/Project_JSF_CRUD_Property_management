package cloud.juanko.repositories;

import cloud.juanko.models.*;
import cloud.juanko.util.ConexionBaseDatos;
import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientePotencialRepository implements IRepository<ClientePotencial>{

    @Override
    public List<ClientePotencial> listar() {
        List<ClientePotencial> listaClientePotencial = new ArrayList<>();
        Connection conect = ConexionBaseDatos.getConnection();

        try {
            assert conect != null;
            try (Statement stmt = conect.createStatement();
                     ResultSet rs = stmt.executeQuery("SELECT * FROM cliente_potencial ")
            ) {
                while(rs.next()){
                    ClientePotencial clientePotencial = new ClientePotencial();
                    clientePotencial.setId(rs.getInt("id"));

                    Inmueble inmueble = new Inmueble();
                    inmueble.setCodigo(rs.getLong("codigo"));
                    clientePotencial.setInmueble(inmueble);

                    Cliente cliente = new Cliente();
                    cliente.setCedula(rs.getLong("cedula"));
                    clientePotencial.setCliente(cliente);

                    Agente agente = new Agente();
                    agente.setCedula(rs.getLong("cedula_agente"));
                    clientePotencial.setAgente(agente);

                    listaClientePotencial.add(clientePotencial);

                    conect.close();



                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return listaClientePotencial;
    }


    @Override
    public ClientePotencial consultar() {
        return null;
    }


    public boolean crear(ClientePotencial clientePotencial, Inmueble inmueble, Cliente cliente, Agente agente ) {

        Connection conect = ConexionBaseDatos.getConnection();
        String sql = "insert into cliente_potencial (id, codigo, cedula, cedula_agente) values (?,?,?,?)";

        try (
                PreparedStatement stmt = conect.prepareStatement(sql)
        ) {
            stmt.setInt(1, clientePotencial.getId());
            stmt.setLong(2, inmueble.getCodigo());
            stmt.setLong(3, cliente.getCedula());
            stmt.setLong(4, agente.getCedula());

            if (!comprobarId(clientePotencial)) {
                stmt.executeUpdate();
                return true;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean crear(ClientePotencial clientePotencial) {
        return false;
    }

    @Override
    public boolean eliminar(Long cedula) {
        return false;
    }

    public boolean eliminar(int id) {
        Connection conect = ConexionBaseDatos.getConnection();
        String sql =  "delete from cliente_potencial where id = ?";

        try(
                PreparedStatement stmt = conect.prepareStatement(sql)
        ) {
            stmt.setInt(1,id);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean actualizar(ClientePotencial clientePotencial) {
        return false;
    }

    public boolean actualizar(ClientePotencial clientePotencial, Inmueble inmueble, Cliente cliente, Agente agente) {

        Connection conect = ConexionBaseDatos.getConnection();

        String sql =  "update cliente_potencial SET codigo = ?, cedula = ?, cedula_agente = ? WHERE id = ?";

        try(
                PreparedStatement stmt = conect.prepareStatement(sql);
        ) {

            stmt.setLong(1, inmueble.getCodigo());
            stmt.setLong(2, cliente.getCedula());
            stmt.setLong(3, agente.getCedula());

            stmt.setInt(4, clientePotencial.getId());


            stmt.executeUpdate();
            System.out.println("se actualizo Cliente Potencial");
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


    public boolean comprobarId(ClientePotencial clientePotencial) {
        Connection conect = ConexionBaseDatos.getConnection();


        try (
                Statement stmt = conect.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM cliente_potencial");
        ) {
            while (rs.next()) {
                ClientePotencial aux = new ClientePotencial();
                aux.setId(rs.getInt("id"));
                int au = aux.getId();
                int in = clientePotencial.getId();
                if (au == in) {
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

