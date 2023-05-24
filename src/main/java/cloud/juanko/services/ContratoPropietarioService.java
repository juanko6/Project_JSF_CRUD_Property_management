package cloud.juanko.services;

import cloud.juanko.models.ContratoPropietario;
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
        return contratoPropietarioRepository.crear(contratoPropietario);
    }

    @Override
    public boolean eliminar(Long codigo) {
        return contratoPropietarioRepository.eliminar(codigo);
    }

    @Override
    public boolean actualizar(ContratoPropietario contratoPropietario) {
        return contratoPropietarioRepository.actualizar(contratoPropietario);
    }

    @Override
    public boolean validar(String usuario, String contrasena) {
        return false;
    }


}
