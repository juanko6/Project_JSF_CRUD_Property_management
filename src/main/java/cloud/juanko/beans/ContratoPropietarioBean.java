package cloud.juanko.beans;

import cloud.juanko.models.ContratoPropietario;
import cloud.juanko.services.ContratoPropietarioService;
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


    public ContratoPropietarioBean() {
        selectedProducts = new ArrayList<>();
        contratoPropietario = new ContratoPropietario();
        contratoPropietarioService = new ContratoPropietarioService();

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

        System.out.println("Nombre Contrato ");
        if(contratoPropietarioService.guardar(contratoPropietario)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contrato Creado"));
            PrimeFaces.current().ajax().update("form:messages", "form:dtcontrato");

            return "crear-contrato-propietario.xhtml";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló creando Contrato"));

        return "crear-contrato-propietario.xhtml";

    }

    public String irCrear() {
        this.contratoPropietario = new ContratoPropietario();
       return "crear-contrato-propietario.xhtml";
    }


    public void eliminar(){
        System.out.println("Eliminar "+ contratoPropietario.getCodigo());
        if(contratoPropietarioService.eliminar(contratoPropietario.getCodigo())){
            System.out.println("Eliminación correcta");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contrato Eliminado"));
        }else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló eliminando Contrato"));
        }

        PrimeFaces.current().ajax().update("form:messages", "form:dtpropietario");
    }

    public String actualizar(){
        System.out.println("Actualizar "+this.contratoPropietario.getCodigo());
        if(contratoPropietarioService.actualizar(contratoPropietario)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contrato Actualizado"));
            PrimeFaces.current().ajax().update("form:messages", "form:dtContrato");

            return "listar-propietario.xhtml";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló Actualizando Propietario"));

        return "listar-propietario.xhtml";
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
}
