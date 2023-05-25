package cloud.juanko.models;


public class Inmueble {

    private Long codigo;
    private String descripcion;
    private String tipo;
    private String direccion;
    private String estado;
    private int tamano_m2;
    private String modalidad;
    private Long precio;
    private Long cant_banos;
    private String fotos;
    private String pais;
    private String departamento;
    private String ciudad;
    private Propietario propiedad;


    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getTamano_m2() {
        return tamano_m2;
    }

    public void setTamano_m2(int tamano_m2) {
        this.tamano_m2 = tamano_m2;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public Long getCant_banos() {
        return cant_banos;
    }

    public void setCant_banos(Long cant_banos) {
        this.cant_banos = cant_banos;
    }

    public String getFotos() {
        return fotos;
    }

    public void setFotos(String fotos) {
        this.fotos = fotos;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Propietario getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propietario propiedad) {
        this.propiedad = propiedad;
    }
}
