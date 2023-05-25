package cloud.juanko.beans;

import cloud.juanko.models.Agente;
import cloud.juanko.models.ContratoPropietario;
import cloud.juanko.models.Inmueble;
import cloud.juanko.models.Propietario;
import cloud.juanko.services.AgenteService;
import cloud.juanko.services.ContratoPropietarioService;
import cloud.juanko.services.InmuebleService;
import cloud.juanko.services.PropietarioService;
import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped

public class ContratoPropietarioBean implements Serializable {
    private ContratoPropietarioService contratoPropietarioService;
    private ContratoPropietario contratoPropietario;
    private ContratoPropietario selectedProduct;
    private List<ContratoPropietario> selectedProducts;
    private List<ContratoPropietario> contratoPropietarios = new ArrayList<>();
    private Inmueble inmueble;
    private Propietario propietario;
    private Agente agente;
    private PropietarioService propietarioService;
    private InmuebleService inmuebleService;
    private AgenteService agenteService;

    public ContratoPropietarioBean() {
        selectedProducts = new ArrayList<>();
        contratoPropietario = new ContratoPropietario();
        contratoPropietarioService = new ContratoPropietarioService();
        inmueble = new Inmueble();
        propietario = new Propietario();
        agente = new Agente();
        propietarioService = new PropietarioService();
        inmuebleService = new InmuebleService();
        agenteService = new AgenteService();
    }


    public String logout(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

        if (session != null) {
            session.invalidate();
        }
        return "index.xhtml";
    }

    public List<ContratoPropietario> listar(){
        return contratoPropietarioService.listar();
    }



    public String guardar(){

        System.out.println("Nuevo Contrato ");
        if(contratoPropietarioService.guardar(contratoPropietario, propietario, inmueble, agente)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contrato Creado"));
            PrimeFaces.current().ajax().update("form:messages", "form:dtcontratopropietario");

            return "listar-contrato-propietario.xhtml";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló creando Contrato"));

        return "listar-contrato-propietario.xhtml";

    }

    public String irCrear() {
        this.contratoPropietario = new ContratoPropietario();
        return "listar-contrato-propietario.xhtml";
    }


    public String eliminar(){
        if(contratoPropietarioService.eliminar(contratoPropietario.getCodigo())){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contrato Eliminado"));
            PrimeFaces.current().ajax().update("form:messages", "form:dtcontratopropietario");

            return "listar-contrato-propietario.xhtml";

        }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló eliminando Contrato"));
        return "listar-contrato-propietario.xhtml";
    }

    public String actualizar(){
        System.out.println("Actualizar bean");
        if(contratoPropietarioService.actualizar(contratoPropietario, propietario, inmueble, agente)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contrato Actualizado"));
            PrimeFaces.current().ajax().update("form:messages", "form:dtContrato");

            return "listar-contrato-propietario.xhtml";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló Actualizando Propietario"));

        return "listar-contrato-propietario.xhtml";
    }

    public ContratoPropietarioService getContratoPropietarioService() {
        return contratoPropietarioService;
    }

    public void setContratoPropietarioService(ContratoPropietarioService contratoPropietarioService) {
        this.contratoPropietarioService = contratoPropietarioService;
    }

    public ContratoPropietario getContratoPropietario() {
        return contratoPropietario;
    }

    public void setContratoPropietario(ContratoPropietario contratoPropietario) {
        this.contratoPropietario = contratoPropietario;
    }

    public ContratoPropietario getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(ContratoPropietario selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public List<ContratoPropietario> getSelectedProducts() {
        return selectedProducts;
    }

    public void setSelectedProducts(List<ContratoPropietario> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }

    public List<ContratoPropietario> getContratoPropietarios() {
        return contratoPropietarios;
    }

    public void setContratoPropietarios(List<ContratoPropietario> contratoPropietarios) {
        this.contratoPropietarios = contratoPropietarios;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    public PropietarioService getPropietarioService() {
        return propietarioService;
    }

    public void setPropietarioService(PropietarioService propietarioService) {
        this.propietarioService = propietarioService;
    }

    public InmuebleService getInmuebleService() {
        return inmuebleService;
    }

    public void setInmuebleService(InmuebleService inmuebleService) {
        this.inmuebleService = inmuebleService;
    }

    public AgenteService getAgenteService() {
        return agenteService;
    }

    public void setAgenteService(AgenteService agenteService) {
        this.agenteService = agenteService;
    }


}
