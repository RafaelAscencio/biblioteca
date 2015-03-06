/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itschapala.sistemas.biblioteca.bl;

import java.util.List;
import javax.ejb.Local;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Empleado;

/**
 *
 * @author Estudiante
 */
@Local
public interface EmpleadoBLLocal {

    boolean registrar(Empleado empleado);

    boolean eliminar(Empleado empleado);

    boolean modificar(Empleado empleado);

    List<Empleado> getLista();

    Empleado getPorId(int id);



   
    
}
