/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itschapala.sistemas.biblioteca.dao;

import java.util.List;
import javax.ejb.Local;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Categoria;

/**
 *
 * @author Estudiante
 */
@Local
public interface CategoriaDaoLocal {

    void crear(Categoria categoria);

    void editar(Categoria categoria);

    void remover(Categoria categoria);

    Categoria buscarPorId(Object id);

    List<Categoria> buscarTodos();

    List<Categoria> buscarRango(int[] range);

    int contar();
    
}
