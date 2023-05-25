package cloud.juanko.services;

import cloud.juanko.models.Agente;
import cloud.juanko.models.ContratoPropietario;
import cloud.juanko.models.Inmueble;
import cloud.juanko.models.Propietario;
import cloud.juanko.repositories.ContratoPropietarioRepository;

import java.util.List;

public class ContratoPropietarioService implements IService<ContratoPropietario>{

    private ContratoPropietarioRepository contratoPropietarioRepository;

    public ContratoPropietarioService() {
        contratoPropietarioRepository = new ContratoPropietarioRepository();
    }

    public List<ContratoPropietario> listar(){


        List<ContratoPropietario> listaContratoPropietario = contratoPropietarioRepository.listar();
        return listaContratoPropietario;
    }

    @Override
    public ContratoPropietario consultar() {
        return null;
    }

    @Override
    public boolean guardar(ContratoPropietario contratoPropietario) {
        return contratoPropietarioRepository.crear(contratoPropietario);    }

    public boolean guardar(ContratoPropietario contratoPropietario, Propietario propietario, Inmueble inmueble, Agente agente) {
        return contratoPropietarioRepository.crear(contratoPropietario, propietario, inmueble, agente);    }

    @Override
    public boolean eliminar(Long codigo) {
        return contratoPropietarioRepository.eliminar(codigo);
    }

    @Override
    public boolean actualizar(ContratoPropietario o) {
        return false;
    }


    public boolean actualizar(ContratoPropietario contratoPropietario, Propietario propietario, Inmueble inmueble, Agente agente) {
        return contratoPropietarioRepository.actualizar(contratoPropietario, propietario, inmueble, agente);
    }



    @Override
    public boolean validar(String usuario, String contrasena) {
        return false;
    }


}
