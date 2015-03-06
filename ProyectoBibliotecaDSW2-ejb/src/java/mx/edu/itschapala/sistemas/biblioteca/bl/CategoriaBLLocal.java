/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itschapala.sistemas.biblioteca.bl;

import java.util.List;
import javax.ejb.Local;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Categoria;

/**
 *
 * @author Estudiante
 */
@Local
public interface CategoriaBLLocal {

    boolean registrar(Categoria categoria);

    boolean eliminar(Categoria categoria);

    boolean modificar(Categoria categoria);

    List<Categoria> getLista();

    Categoria getPorId(int id);

    
    
}
