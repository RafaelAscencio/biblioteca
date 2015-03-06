/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itschapala.sistemas.biblioteca.bl;

import java.util.List;
import javax.ejb.Local;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Libro;

/**
 *
 * @author Estudiante
 */
@Local
public interface LibroBLLocal {

    boolean registrar(Libro libro);

    boolean eliminar(Libro libro);

    boolean modificar(Libro libro);

    List<Libro> getLista();

    Libro getPorId(int id);
    
}
