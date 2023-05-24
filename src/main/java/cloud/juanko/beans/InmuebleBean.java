package cloud.juanko.beans;

import cloud.juanko.models.Inmueble;
import cloud.juanko.services.InmuebleService;
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

public class InmuebleBean implements Serializable {
    private InmuebleService inmuebleService;
    private Inmueble inmueble;
    private Inmueble selectedProduct;
    private List<Inmueble> selectedProducts;
    private List<Inmueble> inmuebles = new ArrayList<>();


    public InmuebleBean() {
        selectedProducts = new ArrayList<>();
        inmueble = new Inmueble();
        inmuebleService = new InmuebleService();

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
        if(inmuebleService.guardar(inmueble)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Inmueble Creado"));
            PrimeFaces.current().ajax().update("form:messages", "form:dtinmueble");

            return "listar-propietario.xhtml";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló creando Inmueble"));

        return "listar-propietario.xhtml";

    }

    public String irCrear() {
        this.inmueble = new Inmueble();
       return "crear-propietario.xhtml";
    }

    public void eliminar(){
        System.out.println("Eliminar "+ inmueble.getCodigo());
        if(inmuebleService.eliminar(inmueble.getCodigo())){
            System.out.println("Eliminación correcta");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Inmueble Eliminado"));
        }else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló eliminando Inmueble"));
        }

        PrimeFaces.current().ajax().update("form:messages", "form:dtpropietario");
    }

    public String actualizar(){
        System.out.println("Actualizar "+this.inmueble.getCodigo());
        if(inmuebleService.actualizar(inmueble)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Inmueble Actualizado"));
            PrimeFaces.current().ajax().update("form:messages", "form:dtinmueble");

            return "listar-propietario.xhtml";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló Actualizando Propietario"));

        return "listar-propietario.xhtml";
    }

    public InmuebleService getPropietarioService() {
        return inmuebleService;
    }

    public void setPropietarioService(InmuebleService inmuebleService) {
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

    public List<Inmueble> getSelectedProducts() {
        return selectedProducts;
    }

    public void setSelectedProducts(List<Inmueble> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }

    public List<Inmueble> getPropietarios() {
        return inmuebles;
    }

    public void setPropietarios(List<Inmueble> propietarios) {
        this.inmuebles = inmuebles;
    }
}
