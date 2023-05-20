package cloud.juanko.models;


public class Agente {

    private int id;

    private String nombre;
    private String ciudad;
    private String departamento;
    private int salario;

    public Agente(int id, String nombre, String ciudad, String departamento, int salario) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.salario = salario;
    }

    public Agente() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
}
