package cloud.juanko.services;
import cloud.juanko.models.*;
import cloud.juanko.repositories.ContratoClienteRepository;

import java.util.List;

public class ContratoClienteService implements IService<ContratoCliente>{

    private ContratoClienteRepository contratoClienteRepository;

    public ContratoClienteService() {
        contratoClienteRepository = new ContratoClienteRepository();
    }

    public List<ContratoCliente> listar(){
        List<ContratoCliente> listaContratoCliente = contratoClienteRepository.listar();
        return listaContratoCliente;
    }

    @Override
    public ContratoCliente consultar() {
        return null;
    }

    @Override
    public boolean guardar(ContratoCliente contratoCliente) {
        return contratoClienteRepository.crear(contratoCliente);
    }

    public boolean guardar(ContratoCliente contratoCliente, Cliente cliente, Inmueble inmueble, Agente agente) {
        return contratoClienteRepository.crear(contratoCliente, cliente, inmueble, agente);
    }

    @Override
    public boolean eliminar(Long cedula) {
        return contratoClienteRepository.eliminar(cedula);
    }

    @Override
    public boolean actualizar(ContratoCliente o) {
        return false;
    }


    public boolean actualizar(ContratoCliente contratoCliente, Cliente cliente, Inmueble inmueble, Agente agente) {
        return contratoClienteRepository.actualizar(contratoCliente, cliente, inmueble, agente);
    }

    @Override
    public boolean validar(String usuario, String contrasena) {
        return false;
    }


}
