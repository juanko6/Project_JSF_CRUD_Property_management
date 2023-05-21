package cloud.juanko.beans;

import cloud.juanko.models.Menu;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class HomeBean{

    private String welcome = "Bienvenido";
    private List<Menu> menuList;

    public HomeBean() {
        this.menuList = new ArrayList<>();
        this.menuList.add(new Menu(1,"Agente", "/ProyectoIntegrador-1.0/faces/listar-agente.xhtml"));
        this.menuList.add(new Menu(2,"Propietario", "/ProyectoIntegrador-1.0/faces/listar-propietario.xhtml"));
        this.menuList.add(new Menu(3,"Cliente", "/ProyectoIntegrador-1.0/faces/listar-cliente.xhtml"));
        this.menuList.add(new Menu(4,"Inmueble", "/ProyectoIntegrador-1.0/faces/listar-inmueble.xhtml"));


    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public String getWelcome() {
        return welcome;
    }

    public void setWelcome(String welcome) {
        this.welcome = welcome;
    }
}
