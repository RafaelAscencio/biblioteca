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
import mx.edu.itschapala.sistemas.biblioteca.bl.LibroBLLocal;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Libro;

/**
 *
 * @author Estudiante
 */
@ManagedBean
@SessionScoped
public class LibroBean {
    @EJB
    private LibroBLLocal libroBL;
    
    private Accion accion;
    private Libro libro;

    private List<Libro> lista;
    
    public LibroBean() {
    }
    
       public List<Libro> getLista(){
        lista=libroBL.getLista();
    return lista;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
      
       
        //Acciones
    public String procesarPeticion() {
        switch (accion) {
            case NUEVO:
                libroBL.registrar(libro);
                break;
            case EDITAR:
                libroBL.modificar(libro);
                break;
            case ELIMINAR:
                libroBL.eliminar(libro);
                break;

        }
        accion = Accion.NADA;
        return "LibroListaV2";
    }

    public String procesarCancelar() {
        if (accion == Accion.ELIMINAR) {
            return "LibroListaV2";
        } else {
            return "LibroCrearEditarV2";

        }
    }
//eventos

    public void limpiarNuevo(ActionEvent evt) {
        libro = new Libro();
        accion = Accion.NUEVO;

    }

    public void prepararEditar(ActionEvent evt) {
        accion = Accion.EDITAR;

    }

    public void prepararEliminar(ActionEvent evt) {
        accion = Accion.ELIMINAR;

    }
    
}
