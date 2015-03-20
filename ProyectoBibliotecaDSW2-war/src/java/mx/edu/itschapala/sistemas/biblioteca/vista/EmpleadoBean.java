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
import mx.edu.itschapala.sistemas.biblioteca.bl.EmpleadoBLLocal;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Empleado;

/**
 *
 * @author Estudiante
 */
@ManagedBean
@SessionScoped
public class EmpleadoBean {
    @EJB
    private EmpleadoBLLocal empleadoBL;
    
       private Empleado empleado;// no autoadministrado
    private Accion accion;//objeto accion a realizar

    private List<Empleado> lista;
    
    public EmpleadoBean() {
    }
    
       public List<Empleado> getLista(){
        lista=empleadoBL.getLista();
    return lista;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
             
       
       
        //Acciones
    public String procesarPeticion() {
        switch (accion) {
            case NUEVO:
                empleadoBL.registrar(empleado);
                break;
            case EDITAR:
                empleadoBL.modificar(empleado);
                break;
            case ELIMINAR:
                empleadoBL.eliminar(empleado);
                break;

        }
        accion = Accion.NADA;
        return "EmpleadoLista";
    }

    public String procesarCancelar() {
        if (accion == Accion.ELIMINAR) {
            return "EmpleadoLista";
        } else {
            return "EmpleadoCrearEditar";

        }
    }
//eventos

    public void limpiarNuevo(ActionEvent evt) {
        empleado = new Empleado();
        accion = Accion.NUEVO;

    }

    public void prepararEditar(ActionEvent evt) {
        accion = Accion.EDITAR;

    }

    public void prepararEliminar(ActionEvent evt) {
        accion = Accion.ELIMINAR;

    }
    
}
