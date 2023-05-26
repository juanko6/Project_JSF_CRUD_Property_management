package cloud.juanko.services;

import cloud.juanko.models.Agente;
import cloud.juanko.models.Cliente;
import cloud.juanko.models.ClientePotencial;
import cloud.juanko.models.Inmueble;
import cloud.juanko.repositories.ClientePotencialRepository;

import java.util.List;

public class ClientePotencialService implements IService<ClientePotencial>{

private ClientePotencialRepository clientePotencialRepository;

    public ClientePotencialService() {
        clientePotencialRepository = new ClientePotencialRepository();
    }


    @Override
    public List<ClientePotencial> listar() {
        List<ClientePotencial> listaClientePotencial = clientePotencialRepository.listar();
        return listaClientePotencial;
    }

    @Override
    public ClientePotencial consultar() {
        return null;
    }

    @Override
    public boolean guardar(ClientePotencial clientePotencial) {
        return clientePotencialRepository.crear(clientePotencial);
    }

    @Override
    public boolean eliminar(Long cedula) {
        return false;
    }

    public boolean guardar(ClientePotencial clientePotencial, Inmueble inmueble, Cliente cliente, Agente agente) {
        return clientePotencialRepository.crear(clientePotencial, inmueble, cliente, agente);
    }


    public boolean eliminar(int id) {
        return clientePotencialRepository.eliminar(id);
    }

    @Override
    public boolean actualizar(ClientePotencial o) {
        return false;
    }

    public boolean actualizar(ClientePotencial clientePotencial, Inmueble inmueble, Cliente cliente, Agente agente) {
        return clientePotencialRepository.actualizar(clientePotencial, inmueble, cliente, agente);
    }

    @Override
    public boolean validar(String usuario, String contrasena) {
        return false;
    }
}

