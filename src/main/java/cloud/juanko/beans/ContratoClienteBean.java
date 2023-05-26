package cloud.juanko.beans;

import cloud.juanko.models.*;
import cloud.juanko.services.*;
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

public class ContratoClienteBean implements Serializable {
    private ContratoClienteService contratoClienteService;
    private ContratoCliente contratoCliente;
    private ContratoCliente selectedProduct;
    private List<ContratoCliente> selectedProducts;
    private List<ContratoCliente> contratosClientes = new ArrayList<>();
    private Inmueble inmueble;
    private Cliente cliente;
    private Agente agente;
    private ClienteService clienteService;
    private InmuebleService inmuebleService;
    private AgenteService agenteService;



    public ContratoClienteBean() {
        selectedProducts = new ArrayList<>();
        contratoCliente = new ContratoCliente();
        contratoClienteService = new ContratoClienteService();
        inmueble = new Inmueble();
        cliente = new Cliente();
        agente = new Agente();
        clienteService = new ClienteService();
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

    public List<ContratoCliente> listar(){
        return contratoClienteService.listar();
    }

    public String guardar(){

        System.out.println("Nombre Contrato ");
        if(contratoClienteService.guardar(contratoCliente, cliente, inmueble, agente)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contrato Creado"));
            PrimeFaces.current().ajax().update("form:messages", "form:dtcontrato");

            return "crear-contrato-cliente.xhtml";        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló creando Contrato"));

        return "crear-contrato-cliente.xhtml";
    }

    public String irCrear() {
        this.contratoCliente = new ContratoCliente();
       return "crear-contrato-cliente.xhtml";
    }


    public void eliminar(){
        if(contratoClienteService.eliminar(contratoCliente.getCodigo())){
            System.out.println("Eliminación correcta");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contrato Eliminado"));
        }else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló eliminando Contrato"));
        }

        PrimeFaces.current().ajax().update("form:messages", "form:dtpropietario");
    }

    public String actualizar(){
        System.out.println("Actualizar "+this.contratoCliente.getCodigo());
        if(contratoClienteService.actualizar(contratoCliente, cliente, inmueble, agente)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contrato Actualizado"));
            PrimeFaces.current().ajax().update("form:messages", "form:dtContrato");

            return "crear-contrato-cliente.xhtml";        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló Actualizando Contrato"));

        return "crear-contrato-cliente.xhtml";    }

    public ContratoClienteService getContratoClienteService() {
        return contratoClienteService;
    }

    public void setContratoClienteService(ContratoClienteService contratoClienteService) {
        this.contratoClienteService = contratoClienteService;
    }

    public ContratoCliente getContratoCliente() {
        return contratoCliente;
    }

    public void setContratoCliente(ContratoCliente contratoCliente) {
        this.contratoCliente = contratoCliente;
    }

    public ContratoCliente getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(ContratoCliente selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public List<ContratoCliente> getSelectedProducts() {
        return selectedProducts;
    }

    public void setSelectedProducts(List<ContratoCliente> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }

    public List<ContratoCliente> getContratosClientes() {
        return contratosClientes;
    }

    public void setContratosClientes(List<ContratoCliente> contratosClientes) {
        this.contratosClientes = contratosClientes;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    public ClienteService getClienteService() {
        return clienteService;
    }

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
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
