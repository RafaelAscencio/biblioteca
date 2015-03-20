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
import mx.edu.itschapala.sistemas.biblioteca.bl.PuestoBLLocal;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Puesto;

/**
 *
 * @author Estudiante
 */
@ManagedBean
@SessionScoped
public class PuestoBean {
    @EJB
    private PuestoBLLocal puestoBL;
    
    private Puesto puesto;
    private Accion accion;

   private List<Puesto> lista;
   
    public PuestoBean() {
    }
    
    public List<Puesto> getLista(){
    lista=puestoBL.getLista();
    return lista;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }
    
    
       
        //Acciones
    public String procesarPeticion() {
        switch (accion) {
            case NUEVO:
                puestoBL.registrar(puesto);
                break;
            case EDITAR:
                puestoBL.modificar(puesto);
                break;
            case ELIMINAR:
                puestoBL.eliminar(puesto);
                break;

        }
        accion = Accion.NADA;
        return "PuestoLista";
    }

    public String procesarCancelar() {
        if (accion == Accion.ELIMINAR) {
            return "PuestoLista";
        } else {
            return "PuestoCrearEditar";

        }
    }
//eventos

    public void limpiarNuevo(ActionEvent evt) {
        puesto = new Puesto();
        accion = Accion.NUEVO;

    }

    public void prepararEditar(ActionEvent evt) {
        accion = Accion.EDITAR;

    }

    public void prepararEliminar(ActionEvent evt) {
        accion = Accion.ELIMINAR;

    }
    
}
