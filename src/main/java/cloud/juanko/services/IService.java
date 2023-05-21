package cloud.juanko.services;

import java.util.List;

public interface IService <T> {
    List<T> listar();
    T consultar();

    boolean guardar(T o);
    boolean eliminar(Long cedula);

    boolean actualizar(T o);

    boolean validar(String usuario, String contrasena);
}
