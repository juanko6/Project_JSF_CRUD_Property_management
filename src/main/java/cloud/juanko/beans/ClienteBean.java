package cloud.juanko.beans;

import cloud.juanko.models.Cliente;

import cloud.juanko.services.ClienteService;

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

public class ClienteBean implements Serializable {
    private ClienteService clienteService;
    private Cliente cliente;
    private Cliente selectedProduct;
    private List<Cliente> selectedProducts;
    private List<Cliente> clientes = new ArrayList<>();


    public ClienteBean() {
        selectedProducts = new ArrayList<>();
        cliente = new Cliente();
        clienteService = new ClienteService();

    }


    public String logout(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

        if (session != null) {
            session.invalidate();
        }
        return "index.xhtml";
    }

    public List<Cliente> listar(){
        return clienteService.listar();
    }

    public String guardar(){

        System.out.println("Nombre Cliente ");
        if(clienteService.guardar(cliente)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente Creado"));
            PrimeFaces.current().ajax().update("form:messages", "form:dtcliente");

            return "listar-propietario.xhtml";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló creando Cliente"));

        return "listar-propietario.xhtml";

    }

    public String irCrear() {
        this.cliente = new Cliente();
       return "crear-propietario.xhtml";
    }

    public void eliminar(){
        System.out.println("Eliminar "+ cliente.getNombre());
        if(clienteService.eliminar(cliente.getCedula())){
            System.out.println("Eliminación correcta");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente Eliminado"));
        }else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló eliminando Cliente"));
        }

        PrimeFaces.current().ajax().update("form:messages", "form:dtpropietario");
    }

    public String actualizar(){
        System.out.println("Actualizar "+this.cliente.getNombre());
        if(clienteService.actualizar(cliente)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente Actualizado"));
            PrimeFaces.current().ajax().update("form:messages", "form:dtcliente");

            return "listar-propietario.xhtml";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló Actualizando Propietario"));

        return "listar-propietario.xhtml";
    }

    public ClienteService getPropietarioService() {
        return clienteService;
    }

    public void setPropietarioService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Cliente selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public List<Cliente> getSelectedProducts() {
        return selectedProducts;
    }

    public void setSelectedProducts(List<Cliente> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }

    public List<Cliente> getPropietarios() {
        return clientes;
    }

    public void setPropietarios(List<Cliente> propietarios) {
        this.clientes = clientes;
    }
}
