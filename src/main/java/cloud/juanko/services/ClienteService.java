package cloud.juanko.services;

import cloud.juanko.models.Cliente;
import cloud.juanko.repositories.ClienteRepository;


import java.util.List;

public class ClienteService implements IService<Cliente>{

    private ClienteRepository clienteRepository;

    public ClienteService() {
        clienteRepository = new ClienteRepository();
    }

    public List<Cliente> listar(){


        List<Cliente> listaCliente = clienteRepository.listar();
        return listaCliente;
    }

    @Override
    public Cliente consultar() {
        return null;
    }

    @Override
    public boolean guardar(Cliente cliente) {
        return clienteRepository.crear(cliente);
    }

    @Override
    public boolean eliminar(Long cedula) {
        return clienteRepository.eliminar(cedula);
    }

    @Override
    public boolean actualizar(Cliente cliente) {
        return clienteRepository.actualizar(cliente);
    }

    @Override
    public boolean validar(String usuario, String contrasena) {
        return false;
    }


}
