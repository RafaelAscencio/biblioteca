/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itschapala.sistemas.biblioteca.dao;

import java.util.List;
import javax.ejb.Local;
import mx.edu.itschapala.sistemas.biblioteca.modelo.AutorLibro;

/**
 *
 * @author Estudiante
 */
@Local
public interface AutorLibroDaoLocal {

    void crear(AutorLibro autorLibro);

    void editar(AutorLibro autorLibro);

    void remover(AutorLibro autorLibro);

    AutorLibro buscarPorId(Object id);

    List<AutorLibro> buscarTodos();

    List<AutorLibro> buscarRango(int[] range);

    int contar();
    
}
