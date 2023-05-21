package cloud.juanko.services;

import cloud.juanko.models.Agente;
import cloud.juanko.repositories.AgenteRepository;

import java.util.List;

public class AgenteService implements IService<Agente>{

    private AgenteRepository agenteRepository;

    public AgenteService() {
        agenteRepository = new AgenteRepository();
    }

    public List<Agente> listar(){


        List<Agente> listaAgente = agenteRepository.listar();
        /*Empleado empleado1 = new Empleado(1,"Juan", "Tulua", "Valle", 100L);
        Empleado empleado2 = new Empleado(1,"Mar", "Cali", "Valle", 200L);
        Empleado empleado3 = new Empleado(1,"Anto", "Buga", "Valle", 300L);
        Empleado empleado4 = new Empleado(1,"Moni", "San Pedro", "Valle", 400L);
        Empleado empleado5 = new Empleado(1,"Carlos", "Tulua", "Valle", 500L);

        listaEmpleado.add(empleado1);
        listaEmpleado.add(empleado2);
        listaEmpleado.add(empleado3);
        listaEmpleado.add(empleado4);
        listaEmpleado.add(empleado5);*/
        return listaAgente;
    }

    @Override
    public Agente consultar() {
        return null;
    }

    @Override
    public boolean guardar(Agente agente) {
        return agenteRepository.crear(agente);
    }

    @Override
    public boolean eliminar(Long cedula) {
        return agenteRepository.eliminar(cedula);
    }

    @Override
    public boolean actualizar(Agente agente) {
        return agenteRepository.actualizar(agente);
    }

    @Override
    public boolean validar(String usuario, String contrasena) {
        System.out.println("Validando Agenteservice" + usuario +" "+ contrasena);

        return agenteRepository.validar(usuario, contrasena);

    }


}
