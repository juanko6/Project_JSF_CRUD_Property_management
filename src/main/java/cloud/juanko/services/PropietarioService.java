package cloud.juanko.services;

import cloud.juanko.models.Agente;
import cloud.juanko.models.Propietario;
import cloud.juanko.repositories.AgenteRepository;
import cloud.juanko.repositories.PropietarioRepository;

import java.util.List;

public class PropietarioService implements IService<Propietario>{

    private PropietarioRepository propietarioRepository;

    public PropietarioService() {
        propietarioRepository = new PropietarioRepository();
    }

    public List<Propietario> listar(){


        List<Propietario> listaPropietario = propietarioRepository.listar();

        return listaPropietario;
    }

    @Override
    public Propietario consultar() {
        return null;
    }

    @Override
    public boolean guardar(Propietario propietario) {
        return propietarioRepository.crear(propietario);
    }

    @Override
    public boolean eliminar(Long cedula) {
        return propietarioRepository.eliminar(cedula);
    }

    @Override
    public boolean actualizar(Propietario propietario) {
        return propietarioRepository.actualizar(propietario);
    }

    @Override
    public boolean validar(String usuario, String contrasena) {
        return false;
    }


}
