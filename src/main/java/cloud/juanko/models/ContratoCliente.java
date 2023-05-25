package cloud.juanko.models;


public class ContratoCliente {

    private Long codigo;
    private String tipo;
    private Long valor;
    private String fecha_creacion;
    private String fecha_finalizacion;
    private String descripcion;
    private Agente cedula_agente;
    private Inmueble codigo_imnueble;
    private Cliente cedula_cliente;


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

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getFecha_finalizacion() {
        return fecha_finalizacion;
    }

    public void setFecha_finalizacion(String fecha_finalizacion) {
        this.fecha_finalizacion = fecha_finalizacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Agente getCedula_agente() {
        return cedula_agente;
    }

    public void setCedula_agente(Agente cedula_agente) {
        this.cedula_agente = cedula_agente;
    }

    public Inmueble getCodigo_imnueble() {
        return codigo_imnueble;
    }

    public void setCodigo_imnueble(Inmueble codigo_imnueble) {
        this.codigo_imnueble = codigo_imnueble;
    }

    public Cliente getCedula_cliente() {
        return cedula_cliente;
    }

    public void setCedula_cliente(Cliente cedula_cliente) {
        this.cedula_cliente = cedula_cliente;
    }
}
