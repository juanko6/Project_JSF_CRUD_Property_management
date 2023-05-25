package cloud.juanko.services;

import cloud.juanko.models.Inmueble;
import cloud.juanko.models.Propietario;
import cloud.juanko.repositories.InmuebleRepository;

import java.util.List;

public class InmuebleService implements IService<Inmueble>{

    private InmuebleRepository inmuebleRepository;

    public InmuebleService() {
        inmuebleRepository = new InmuebleRepository();
    }

    public List<Inmueble> listar(){


        List<Inmueble> listaInmueble = inmuebleRepository.listar();
        return listaInmueble;
    }

    @Override
    public Inmueble consultar() {
        return null;
    }

    @Override
    public boolean guardar(Inmueble inmueble) {
        return inmuebleRepository.crear(inmueble);
    }

    public boolean guardar(Inmueble inmueble, Propietario propietario) {
        return inmuebleRepository.crear(inmueble, propietario);
    }

    @Override
    public boolean eliminar(Long codigo) {
        return inmuebleRepository.eliminar(codigo);
    }

    @Override
    public boolean actualizar(Inmueble inmueble) {
        return inmuebleRepository.actualizar(inmueble);
    }

    public boolean actualizar(Inmueble inmueble, Propietario propietario) {
        return inmuebleRepository.actualizar(inmueble, propietario);
    }

    @Override
    public boolean validar(String usuario, String contrasena) {
        return false;
    }


}
