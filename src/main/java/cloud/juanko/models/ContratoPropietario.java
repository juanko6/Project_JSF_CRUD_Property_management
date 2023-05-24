package cloud.juanko.models;


public class ContratoPropietario {

    private Long codigo;
    private String tipo;
    private Long valor;
    private String fecha_creacion;
    private String fecha_finalizacion;
    private String descripcion;
    private int comision;


    public ContratoPropietario(Long codigo, String tipo, Long valor, String fecha_creacion, String fecha_finalizacion, String descripcion, int comision) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.valor = valor;
        this.fecha_creacion = fecha_creacion;
        this.fecha_finalizacion = fecha_finalizacion;
        this.descripcion = descripcion;
        this.comision = comision;
    }

    public ContratoPropietario() {

    }

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

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }
}
