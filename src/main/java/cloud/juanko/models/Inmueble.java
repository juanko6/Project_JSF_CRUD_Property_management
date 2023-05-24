package cloud.juanko.models;


public class Inmueble {

    private Long codigo;
    private String descripcion;
    private String tipo;
    private String direccion;
    private String estado;
    private String tamano_m2;
    private String modalidad;
    private Long precio;
    private Long cant_banos;
    private String fotos ;
    private int paisId;
    private int departamentoId;
    private int ciudadId;
    private int propiedadId;



    public Inmueble() {

    }

    public Inmueble(Long codigo, String descripcion, String tipo, String direccion, String estado, String tamano_m2, String modalidad, Long precio, Long cant_banos, String fotos, int paisId, int departamentoId, int ciudadId, int propiedadId) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.direccion = direccion;
        this.estado = estado;
        this.tamano_m2 = tamano_m2;
        this.modalidad = modalidad;
        this.precio = precio;
        this.cant_banos = cant_banos;
        this.fotos = fotos;
        this.paisId = paisId;
        this.departamentoId = departamentoId;
        this.ciudadId = ciudadId;
        this.propiedadId = propiedadId;
    }

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

    public String getTamano_m2() {
        return tamano_m2;
    }

    public void setTamano_m2(String tamano_m2) {
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

    public int getPaisId() {
        return paisId;
    }

    public void setPaisId(int paisId) {
        this.paisId = paisId;
    }

    public int getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(int departamentoId) {
        this.departamentoId = departamentoId;
    }

    public int getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(int ciudadId) {
        this.ciudadId = ciudadId;
    }

    public int getPropiedadId() {
        return propiedadId;
    }

    public void setPropiedadId(int propiedadId) {
        this.propiedadId = propiedadId;
    }
}
