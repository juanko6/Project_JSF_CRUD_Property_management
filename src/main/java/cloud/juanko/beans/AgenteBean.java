package cloud.juanko.beans;

import cloud.juanko.models.Agente;
import cloud.juanko.services.AgenteService;
import org.primefaces.PrimeFaces;
import org.primefaces.event.DateViewChangeEvent;
import org.primefaces.model.datepicker.DateMetadataModel;
import org.primefaces.model.datepicker.DefaultDateMetadata;
import org.primefaces.model.datepicker.DefaultDateMetadataModel;
import org.primefaces.model.datepicker.LazyDateMetadataModel;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Named
@ViewScoped

public class AgenteBean implements Serializable {
    private AgenteService agenteService;
    private Agente agente;
    private String inusuario;
    private String incontrasena ;
    private Agente selectedProduct;



    private List<Agente> selectedProducts;
    private List<Agente> agentes = new ArrayList<>();




    public AgenteBean() {
        selectedProducts = new ArrayList<>();
        agente = new Agente();
        agenteService = new AgenteService();

    }


    public String logout(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

        if (session != null) {
            session.invalidate();
        }
        return "index.xhtml";
    }

    public String validar(){


        System.out.println("entra en AgenteBean "+ getInusuario() + getIncontrasena()+"");

        if(agenteService.validar(getInusuario(), getIncontrasena())){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bienvenido"));
            PrimeFaces.current().ajax().update("form:messages", "form:dtagente");

            System.out.println("Validando Agente "+getIncontrasena());

            return "listar-agente.xhtml";
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

        System.out.println("Nombre Agente "+ agente.getNombre());
        if(agenteService.guardar(agente)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agente Creado"));
            PrimeFaces.current().ajax().update("form:messages", "form:dtagente");

            return "listar-agente.xhtml";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló creando Agente"));

        return "listar-agente.xhtml";

    }

    public String irCrear() {
        this.agente = new Agente();
       return "crear-agente.xhtml";
    }

    public String eliminar(){
        System.out.println("Eliminar "+ agente.getNombre());
        if(agenteService.eliminar(agente.getCedula())){
            System.out.println("Eliminación correcta");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agente Eliminado"));
            PrimeFaces.current().ajax().update("form:messages", "form:dtagente");
            return "listar-agente.xhtml";
        }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló eliminando Agente"));
        return "listar-agente.xhtml";
    }

    public String actualizar(){
        System.out.println("Actualizar "+this.agente.getNombre());
        if(agenteService.actualizar(agente)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agente Actualizado"));
            PrimeFaces.current().ajax().update("form:messages", "form:dtagente");

            return "listar-agente.xhtml";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló Actualizando Agente"));

        return "listar-agente.xhtml";
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

    public List<Agente> getAgentes() {
        return agentes;
    }

    public void setAgentes(List<Agente> agentes) {
        this.agentes = agentes;
    }

        public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    public String getInusuario() {
        return inusuario;
    }

    public void setInusuario(String inusuario) {
        this.inusuario = inusuario;
    }

    public String getIncontrasena() {
        return incontrasena;
    }

    public void setIncontrasena(String incontrasena) {
        this.incontrasena = incontrasena;
    }


}
