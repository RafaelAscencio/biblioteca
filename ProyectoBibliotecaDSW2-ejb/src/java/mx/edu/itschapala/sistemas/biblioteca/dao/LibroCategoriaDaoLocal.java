/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itschapala.sistemas.biblioteca.dao;

import java.util.List;
import javax.ejb.Local;
import mx.edu.itschapala.sistemas.biblioteca.modelo.LibroCategoria;

/**
 *
 * @author Estudiante
 */
@Local
public interface LibroCategoriaDaoLocal {

    void crear(LibroCategoria libroCategoria);

    void editar(LibroCategoria libroCategoria);

    void remover(LibroCategoria libroCategoria);

    LibroCategoria buscarPorId(Object id);

    List<LibroCategoria> buscarTodos();

    List<LibroCategoria> buscarRango(int[] range);

    int contar();
    
}
