package cloud.juanko.repositories;

import java.time.LocalDate;
import java.util.List;

public interface IRepository<T> {
    List<T> listar();
    T consultar();
    boolean crear(T t);

    boolean eliminar(Long cedula);

    boolean actualizar(T t);

    boolean validar(String usuario, String contrasena);


}

