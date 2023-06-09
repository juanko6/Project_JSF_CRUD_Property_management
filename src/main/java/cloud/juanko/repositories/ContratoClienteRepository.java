package cloud.juanko.repositories;

import cloud.juanko.util.ConexionBaseDatos;
import cloud.juanko.models.Agente;
import cloud.juanko.models.ContratoCliente;
import cloud.juanko.models.Inmueble;
import cloud.juanko.models.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContratoClienteRepository implements IRepository<ContratoCliente>{
    @Override
    public List<ContratoCliente> listar() {
        List<ContratoCliente> listaContratoCliente = new ArrayList<>();
        Connection conect = ConexionBaseDatos.getConnection();

        try {
            assert conect != null;
            try (Statement stmt = conect.createStatement();
                     ResultSet rs = stmt.executeQuery("SELECT * FROM contrato_cliente")
            ) {
                while(rs.next()){
                    ContratoCliente contratoCliente = new ContratoCliente();
                    contratoCliente.setCodigo(rs.getLong("codigo"));
                    contratoCliente.setDescripcion(rs.getString("descripcion"));
                    contratoCliente.setTipo(rs.getString("tipo"));
                    contratoCliente.setFecha_creacion(rs.getString("fecha_creacion"));
                    contratoCliente.setFecha_finalizacion(rs.getString("fecha_finalizacion"));
                    contratoCliente.setValor(rs.getLong("valor"));

                    Agente agente = new Agente();
                    agente.setCedula(rs.getLong("cedula_agente"));
                    contratoCliente.setCedula_agente(agente);

                    Cliente cliente = new Cliente();
                    cliente.setCedula(rs.getLong("cedula_cliente"));
                    contratoCliente.setCedula_cliente(cliente);

                    Inmueble inmueble = new Inmueble();
                    inmueble.setCodigo(rs.getLong("codigo_inmueble"));
                    contratoCliente.setCodigo_imnueble(inmueble);

                    listaContratoCliente.add(contratoCliente);

                    conect.close();



                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return listaContratoCliente;
    }


    @Override
    public ContratoCliente consultar() {
        return null;
    }

    @Override
    public boolean crear(ContratoCliente contratoCliente) {

        Connection conect = ConexionBaseDatos.getConnection();
        String sql =  "insert into contrato_cliente (codigo, tipo, valor, fecha_creacion, fecha_finalizacion, descripcion,cedula_agente, cedula_propietario, codigo_inmueble ) values (?,?,?,?,?,?,?,?)";

        try(
                PreparedStatement stmt = conect.prepareStatement(sql)
        ) {
            stmt.setLong(1, contratoCliente.getCodigo());
            stmt.setString(2, contratoCliente.getTipo());
            stmt.setLong(3, contratoCliente.getValor());
            stmt.setString(4, contratoCliente.getFecha_creacion());
            stmt.setString(5, contratoCliente.getFecha_finalizacion());
            stmt.setString(6, contratoCliente.getDescripcion());


            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean crear(ContratoCliente contratoCliente, Cliente cliente, Inmueble inmueble, Agente agente ) {

        Connection conect = ConexionBaseDatos.getConnection();
        String sql =  "insert into contrato_cliente (codigo, tipo, valor, fecha_creacion, fecha_finalizacion, descripcion,cedula_agente, cedula_cliente, codigo_inmueble) values (?,?,?,?,?,?,?)";

        try(
                PreparedStatement stmt = conect.prepareStatement(sql)
        ) {
            stmt.setLong(1, contratoCliente.getCodigo());
            stmt.setString(2, contratoCliente.getTipo());
            stmt.setLong(3, contratoCliente.getValor());
            stmt.setString(4, contratoCliente.getFecha_creacion());
            stmt.setString(5, contratoCliente.getFecha_finalizacion());
            stmt.setString(6, contratoCliente.getDescripcion());
            stmt.setLong(8, agente.getCedula());
            stmt.setLong(9, cliente.getCedula());
            stmt.setLong(10, inmueble.getCodigo());
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
        String sql =  "delete from contrato_cliente where codigo = ?";

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
    public boolean actualizar(ContratoCliente contratoCliente) {
        return false;
    }


    public boolean actualizar(ContratoCliente contratoCliente,  Cliente cliente, Inmueble inmueble, Agente agente) {

        Connection conect = ConexionBaseDatos.getConnection();

        String sql =  "update contrato_cliente SET tipo = ?, valor = ?, fecha_creacion = ?, fecha_finalizacion = ?, descripcion = ? WHERE codigo = ?";

        try(
                PreparedStatement stmt = conect.prepareStatement(sql);
        ) {
            stmt.setString(1, contratoCliente.getTipo());
            stmt.setLong(2, contratoCliente.getValor());
            stmt.setString(3, contratoCliente.getFecha_creacion());
            stmt.setString(4, contratoCliente.getFecha_finalizacion());
            stmt.setString(5, contratoCliente.getDescripcion());
            stmt.setLong(6, contratoCliente.getCodigo());

            stmt.setLong(7, agente.getCedula());
            stmt.setLong(8, cliente.getCedula());
            stmt.setLong(9, inmueble.getCodigo());



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
