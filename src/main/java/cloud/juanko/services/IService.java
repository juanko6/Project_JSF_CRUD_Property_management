package cloud.juanko.services;

import java.util.List;

public interface IService <T> {
    List<T> listar();
    T consultar();

    boolean guardar(T o);
    boolean eliminar(int id);

    boolean actualizar(T o);

    boolean validar(int id, String nombre);
}
