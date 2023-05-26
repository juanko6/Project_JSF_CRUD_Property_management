package cloud.juanko.beans;

import cloud.juanko.models.Agente;
import cloud.juanko.models.Cliente;
import cloud.juanko.models.ClientePotencial;
import cloud.juanko.models.Inmueble;
import cloud.juanko.services.AgenteService;
import cloud.juanko.services.ClientePotencialService;
import cloud.juanko.services.ClienteService;
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

public class clientePotencialBean implements Serializable {
    private ClientePotencialService clientePotencialService;
    private ClientePotencial clientePotencial;
    private String inusuario;
    private String incontrasena ;
    private ClientePotencial selectedProduct;
    private Inmueble inmueble;
    private Cliente cliente;
    private Agente agente;
    private ClienteService clienteService;
    private InmuebleService inmuebleService;
    private AgenteService agenteService;
    private List<ClientePotencial> selectedProducts;
    private List<ClientePotencial> clientes = new ArrayList<>();




    public clientePotencialBean() {
        selectedProducts = new ArrayList<>();
        clientePotencial = new ClientePotencial();
        clientePotencialService = new ClientePotencialService();
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
        public List<ClientePotencial> listar(){
        return clientePotencialService.listar();
    }

    public String guardar(){

        if(clientePotencialService.guardar(clientePotencial, inmueble, cliente, agente)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente Potencial Creado"));
            PrimeFaces.current().ajax().update("form:messages", "form:dtclientepotencial");

            return "listar-cliente-potencial.xhtml";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló creando Cliente Potencial"));

        return "listar-cliente-potencial.xhtml";

    }

    public String irCrear() {
        this.cliente = new Cliente();
       return "crear-agente.xhtml";
    }

    public String eliminar(){
        if(clientePotencialService.eliminar(clientePotencial.getId())){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente Potencial Eliminado"));
            PrimeFaces.current().ajax().update("form:messages", "form:dtclientepotencial");
            return "listar-cliente-potencial.xhtml";

        }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló eliminando Cliente Potencial"));
        return "listar-cliente-potencial.xhtml";
    }

    public String actualizar(){
        if(clientePotencialService.actualizar(clientePotencial, inmueble, cliente, agente)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente Potencial Actualizado"));
            PrimeFaces.current().ajax().update("form:messages", "form:dtclientepotencial");

            return "listar-cliente-potencial.xhtml";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló Actualizando Cliente Potencial"));

        return "listar-cliente-potencial.xhtml";
    }

    public ClientePotencialService getClientePotencialService() {
        return clientePotencialService;
    }

    public void setClientePotencialService(ClientePotencialService clientePotencialService) {
        this.clientePotencialService = clientePotencialService;
    }

    public ClientePotencial getClientePotencial() {
        return clientePotencial;
    }

    public void setClientePotencial(ClientePotencial clientePotencial) {
        this.clientePotencial = clientePotencial;
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

    public ClientePotencial getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(ClientePotencial selectedProduct) {
        this.selectedProduct = selectedProduct;
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

    public List<ClientePotencial> getSelectedProducts() {
        return selectedProducts;
    }

    public void setSelectedProducts(List<ClientePotencial> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }

    public List<ClientePotencial> getClientes() {
        return clientes;
    }

    public void setClientes(List<ClientePotencial> clientes) {
        this.clientes = clientes;
    }
}
