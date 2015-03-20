/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itschapala.sistemas.biblioteca.vista;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import mx.edu.itschapala.sistemas.biblioteca.bl.CategoriaBLLocal;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Categoria;

/**
 *
 * @author Estudiante
 */
@ManagedBean
@SessionScoped
public class CategoriaBean {

    @EJB
    private CategoriaBLLocal categoriaBL;

    private Categoria categoria;// no autoadministrado
    private Accion accion;//objeto accion a realizar

    private List<Categoria> lista;

    public CategoriaBean() {
    }

    public List<Categoria> getLista() {
        lista = categoriaBL.getLista();
        return lista;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    //Acciones
    public String procesarPeticion() {
        switch (accion) {
            case NUEVO:
                categoriaBL.registrar(categoria);
                break;
            case EDITAR:
                categoriaBL.modificar(categoria);
                break;
            case ELIMINAR:
                categoriaBL.eliminar(categoria);
                break;

        }
        accion = Accion.NADA;
        return "CategoriaLista";
    }

    public String procesarCancelar() {
        if (accion == Accion.ELIMINAR) {
            return "CategoriaLista";
        } else {
            return "CategoriaCrearEditar";

        }
    }
//eventos

    public void limpiarNuevo(ActionEvent evt) {
        categoria = new Categoria();
        accion = Accion.NUEVO;

    }

    public void prepararEditar(ActionEvent evt) {
        accion = Accion.EDITAR;

    }

    public void prepararEliminar(ActionEvent evt) {
        accion = Accion.ELIMINAR;

    }
}
