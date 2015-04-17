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
import mx.edu.itschapala.sistemas.biblioteca.bl.AutorBLLocal;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Autor;

/**
 *
 * @author Estudiante
 */
@ManagedBean
@SessionScoped
public class AutorBean {

    //llamadas a los EJB
    @EJB
    private AutorBLLocal autorBL;

    //caracteristicas
    private List<Autor> lista;
    private Autor autor;// no autoadministrado
    private Accion accion;//objeto accion a realizar

    //constructor Obligatorio
    public AutorBean() {
        autor = new Autor();
    }

    //metodos get y set nesesarios
    public List<Autor> getLista() {
        lista = autorBL.getLista();
        return lista;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    //Acciones
    public String procesarPeticion() {
        switch (accion) {
            case NUEVO:
                autorBL.registrar(autor);
                break;
            case EDITAR:
                autorBL.modificar(autor);
                break;
            case ELIMINAR:
                autorBL.eliminar(autor);
                break;

        }
        accion = Accion.NADA;
        return "AutorListaV2";
    }

    public String procesarCancelar() {
        if (accion == Accion.ELIMINAR) {
            return "AutorListaV2";
        } else {
            return "AutorCrearEditarV2";

        }
    }
//eventos

    public void limpiarNuevo(ActionEvent evt) {
        autor = new Autor();
        accion = Accion.NUEVO;

    }

    public void prepararEditar(ActionEvent evt) {
        accion = Accion.EDITAR;

    }

    public void prepararEliminar(ActionEvent evt) {
        accion = Accion.ELIMINAR;

    }

}
