package cloud.juanko.beans;

import cloud.juanko.models.Agente;
import cloud.juanko.services.AgenteService;
import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
@ViewScoped

public class AgenteBean implements Serializable {
    private AgenteService agenteService;
    private Agente agente;
    private Map<String, String> departamentos = new HashMap<>();
    private String labeled;
    private int inid;
    private String innombre ;
    private Agente selectedProduct;

    private List<Agente> selectedProducts;
    private List<Agente> agentes = new ArrayList<>();


    public AgenteBean() {
        selectedProducts = new ArrayList<>();
        agente = new Agente();
        agenteService = new AgenteService();

        departamentos = new HashMap<>();
        departamentos.put("New York", "New York");
        departamentos.put("London", "London");
        departamentos.put("Paris", "Paris");
        departamentos.put("Barcelona", "Barcelona");
        departamentos.put("Istanbul", "Istanbul");
        departamentos.put("Berlin", "Berlin");
    }


    public String logout(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

        if (session != null) {
            session.invalidate();
        }
        return "index.xhtml";
    }

    public String validar(){


        System.out.println("entra en empleadoBean "+ getInid() + getInnombre()+"");

        if(agenteService.validar(getInid(), getInnombre())){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bienvenido " + getInnombre()));
            //PrimeFaces.current().ajax().update("form:messages", "form:dtempleados");

            System.out.println("Validando empleado "+getInnombre());

            return "listar-empleado.xhtml";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("usuario o contraseña no coincide"));

        return "index.xhtml";
    }


    public Agente getEmpleado() {
        return agente;
    }

    public void setEmpleado(Agente agente) {
        this.agente = agente;
    }

    public List<Agente> listar(){
        return agenteService.listar();
    }

    public String guardar(){

        System.out.println("Nombre Empleado "+ agente.getNombre());
        if(agenteService.guardar(agente)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empleado Creado"));
            PrimeFaces.current().ajax().update("form:messages", "form:dtempleados");

            return "listar-empleado.xhtml";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló creando Empleado"));

        return "crear-empleado.xhtml";

    }

    public String irCrear() {
       return null;
    }

    public void eliminar(){
        System.out.println("Eliminar "+ agente.getNombre());
        if(agenteService.eliminar(agente.getId())){
            System.out.println("Eliminación correcta");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empleado Eliminado"));
        }else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló eliminando Empleado"));
        }

        PrimeFaces.current().ajax().update("form:messages", "form:dtempleados");
    }

    public String actualizar(){
        System.out.println("Actualizar "+this.agente.getNombre());
        if(agenteService.actualizar(agente)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empleado Actualizado"));
            PrimeFaces.current().ajax().update("form:messages", "form:dtempleados");

            return "listar-empleado.xhtml";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló Actualizando Empleado"));

        return "listar-empleado.xhtml";
    }

    public Agente getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Agente selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public List<Agente> getSelectedProducts() {
        return selectedProducts;
    }

    public void setSelectedProducts(List<Agente> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }

    public List<Agente> getEmpleados() {
        return agentes;
    }

    public void setEmpleados(List<Agente> agentes) {
        this.agentes = agentes;
    }


    public String getInnombre() {
        return innombre;
    }

    public void setInnombre(String innombre) {
        this.innombre = innombre;
    }

    public int getInid() {
        return inid;
    }

    public void setInid(int inid) {
        this.inid = inid;
    }

    public String getLabeled() {
        return labeled;
    }

    public void setLabeled(String labeled) {
        this.labeled = labeled;
    }

    public Map<String, String> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Map<String, String> departamentos) {
        this.departamentos = departamentos;
    }
}
