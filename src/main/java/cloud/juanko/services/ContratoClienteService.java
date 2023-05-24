package cloud.juanko.services;

import cloud.juanko.models.ContratoCliente;
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

    @Override
    public boolean eliminar(Long cedula) {
        return contratoClienteRepository.eliminar(cedula);
    }

    @Override
    public boolean actualizar(ContratoCliente contratoCliente) {
        return contratoClienteRepository.actualizar(contratoCliente);
    }

    @Override
    public boolean validar(String usuario, String contrasena) {
        return false;
    }


}
