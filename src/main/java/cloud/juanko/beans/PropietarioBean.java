package cloud.juanko.beans;

import cloud.juanko.models.Agente;
import cloud.juanko.models.Propietario;
import cloud.juanko.services.AgenteService;
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

public class PropietarioBean implements Serializable {
    private PropietarioService propietarioService;
    private Propietario propietario;
    private Propietario selectedProduct;
    private List<Propietario> selectedProducts;
    private List<Propietario> propietarios = new ArrayList<>();


    public PropietarioBean() {
        selectedProducts = new ArrayList<>();
        propietario = new Propietario();
        propietarioService = new PropietarioService();

    }


    public String logout(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

        if (session != null) {
            session.invalidate();
        }
        return "index.xhtml";
    }

    public List<Propietario> listar(){
        return propietarioService.listar();
    }

    public String guardar(){

        System.out.println("Nombre Propietario ");
        if(propietarioService.guardar(propietario)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Propietario Creado"));
            PrimeFaces.current().ajax().update("form:messages", "form:dtpropietarios");

            return "listar-propietario.xhtml";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló creando Propietario"));

        return "listar-propietario.xhtml";

    }

    public String irCrear() {
        this.propietario = new Propietario();
       return "crear-propietario.xhtml";
    }

    public void eliminar(){
        System.out.println("Eliminar "+ propietario.getNombre());
        if(propietarioService.eliminar(propietario.getCedula())){
            System.out.println("Eliminación correcta");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Propietario Eliminado"));
        }else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló eliminando Propietario"));
        }

        PrimeFaces.current().ajax().update("form:messages", "form:dtpropietario");
    }

    public String actualizar(){
        System.out.println("Actualizar "+this.propietario.getNombre());
        if(propietarioService.actualizar(propietario)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Propietario Actualizado"));
            PrimeFaces.current().ajax().update("form:messages", "form:dtpropietario");

            return "listar-propietario.xhtml";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló Actualizando Propietario"));

        return "listar-propietario.xhtml";
    }

    public PropietarioService getPropietarioService() {
        return propietarioService;
    }

    public void setPropietarioService(PropietarioService propietarioService) {
        this.propietarioService = propietarioService;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Propietario getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Propietario selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public List<Propietario> getSelectedProducts() {
        return selectedProducts;
    }

    public void setSelectedProducts(List<Propietario> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }

    public List<Propietario> getPropietarios() {
        return propietarios;
    }

    public void setPropietarios(List<Propietario> propietarios) {
        this.propietarios = propietarios;
    }
}
