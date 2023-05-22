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
    private String ubicacion;


    public Inmueble(Long codigo, String descripcion, String tipo, String estado, String tamano_m2, String modalidad, String direccion, Long precio, Long cant_banos, String fotos, String ubicacion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.estado = estado;
        this.tamano_m2 = tamano_m2;
        this.modalidad = modalidad;
        this.direccion = direccion;
        this.precio = precio;
        this.cant_banos =cant_banos;
        this.fotos = fotos;
        this.ubicacion = ubicacion;
    }

    public Inmueble() {

    }

    public Long getcodigo() {
        return codigo;
    }

    public void setcodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getdescripcion() {
        return descripcion;
    }

    public void setdescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String gettipo() {
        return tipo;
    }

    public void settipo(String tipo) {
        this.tipo = tipo;
    }

    public String getdireccion() {
        return direccion;
    }

    public void setdireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getestado() {
        return estado;
    }

    public void setestado(String estado) {
        this.estado = estado;
    }

    public String gettamano_m2() {
        return tamano_m2;
    }

    public void settamano_m2(String tamano_m2) {
        this.tamano_m2 = tamano_m2;
    }

    public String getmodalidad() {
        return modalidad;
    }

    public void setmodalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public Long getprecio() {
        return precio;
    }


    public void setprecio(Long precio) {
        this.precio = precio;
    }

    //
    public Long getcant_banos() {
        return cant_banos;
    }
    public void setcant_banos(Long cant_banos) {
        this.cant_banos = cant_banos;
    }

    public  String getfotos(){
        return fotos;
    }
    public void setfotos(String fotos) {
        this.fotos = fotos;
    }

    public  String getubicacion(){
        return ubicacion;
    }
    public void setubicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }



}
