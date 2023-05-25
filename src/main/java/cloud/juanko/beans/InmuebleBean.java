package cloud.juanko.beans;

import cloud.juanko.models.Inmueble;
import cloud.juanko.models.Propietario;
import cloud.juanko.services.InmuebleService;
import cloud.juanko.services.PropietarioService;
import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.*;

@Named
@ViewScoped

public class InmuebleBean implements Serializable {
    private InmuebleService inmuebleService;
    private Inmueble inmueble;
    private Inmueble selectedProduct;
    private String labeled;
    private List<Inmueble> selectedProducts;
    private List<Inmueble> inmuebles = new ArrayList<>();
    private List<Propietario> propietarios;

    private Propietario propietario;

    private PropietarioService propietarioService;
    private Map<String, String> cities = new HashMap<>();


    public InmuebleBean() {
        selectedProducts = new ArrayList<>();
        inmueble = new Inmueble();
        inmuebleService = new InmuebleService();
        propietarioService = new PropietarioService();
        propietario = new Propietario();
        this.propietarios = propietarioService.listar();

    }




    public String logout(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

        if (session != null) {
            session.invalidate();
        }
        return "index.xhtml";
    }

    public List<Inmueble> listar(){
        return inmuebleService.listar();
    }

    public String guardar(){

        System.out.println("Nombre Inmueble ");
        if(inmuebleService.guardar(inmueble, propietario)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Inmueble Creado"));
            PrimeFaces.current().ajax().update("form:messages", "form:dtinmueble");

            return "listar-inmueble.xhtml";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló creando Inmueble"));

        return "listar-inmueble.xhtml";

    }

    public String irCrear() {
        this.inmueble = new Inmueble();
       return "crear-propietario.xhtml";
    }

    public String eliminar(){
        if(inmuebleService.eliminar(inmueble.getCodigo())){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Inmueble Eliminado"));
            PrimeFaces.current().ajax().update("form:messages", "form:dtinmueble");
            return "listar-inmueble.xhtml";

        }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló eliminando Inmueble"));
        return "listar-inmueble.xhtml";
    }

    public String actualizar(){
        System.out.println("Actualizar "+this.inmueble.getCodigo());
        if(inmuebleService.actualizar(inmueble, propietario)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Inmueble Actualizado"));
            PrimeFaces.current().ajax().update("form:messages", "form:dtinmueble");

            return "listar-inmueble.xhtml";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló Actualizando Propietario"));

        return "listar-inmueble.xhtml";
    }

    public InmuebleService getInmuebleService() {
        return inmuebleService;
    }

    public void setInmuebleService(InmuebleService inmuebleService) {
        this.inmuebleService = inmuebleService;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public Inmueble getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Inmueble selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public String getLabeled() {
        return labeled;
    }

    public void setLabeled(String labeled) {
        this.labeled = labeled;
    }

    public List<Inmueble> getSelectedProducts() {
        return selectedProducts;
    }

    public void setSelectedProducts(List<Inmueble> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }

    public List<Inmueble> getInmuebles() {
        return inmuebles;
    }

    public void setInmuebles(List<Inmueble> inmuebles) {
        this.inmuebles = inmuebles;
    }

    public List<Propietario> getPropietarios() {
        return propietarios;
    }

    public void setPropietarios(List<Propietario> propietarios) {
        this.propietarios = propietarios;
    }

    public PropietarioService getPropietarioService() {
        return propietarioService;
    }

    public void setPropietarioService(PropietarioService propietarioService) {
        this.propietarioService = propietarioService;
    }

    public Map<String, String> getCities() {
        return cities;
    }

    public void setCities(Map<String, String> cities) {
        this.cities = cities;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
}
