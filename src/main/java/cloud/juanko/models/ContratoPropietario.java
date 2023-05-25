package cloud.juanko.models;


public class ContratoPropietario {

    private Long codigo;
    private String tipo;
    private String fecha_finalizacion;
    private String fecha_creacion;
    private String descripcion;
    private Long valor;
    private String comision;
    private Agente cedula_agente;
    private Propietario cedula_propietario;
    private Inmueble codigo_imnueble;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha_finalizacion() {
        return fecha_finalizacion;
    }

    public void setFecha_finalizacion(String fecha_finalizacion) {
        this.fecha_finalizacion = fecha_finalizacion;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public String getComision() {
        return comision;
    }

    public void setComision(String comision) {
        this.comision = comision;
    }

    public Agente getCedula_agente() {
        return cedula_agente;
    }

    public void setCedula_agente(Agente cedula_agente) {
        this.cedula_agente = cedula_agente;
    }

    public Propietario getCedula_propietario() {
        return cedula_propietario;
    }

    public void setCedula_propietario(Propietario cedula_propietario) {
        this.cedula_propietario = cedula_propietario;
    }

    public Inmueble getCodigo_imnueble() {
        return codigo_imnueble;
    }

    public void setCodigo_imnueble(Inmueble codigo_imnueble) {
        this.codigo_imnueble = codigo_imnueble;
    }

}
