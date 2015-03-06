/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itschapala.sistemas.biblioteca.dao;

import java.util.List;
import javax.ejb.Local;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Autor;

/**
 *
 * @author Estudiante
 */
@Local
public interface AutorDaoLocal {

    void crear(Autor autor);

    void editar(Autor autor);

    void remover(Autor autor);

    Autor buscarPorId(Object id);

    List<Autor> buscarTodos();

    List<Autor> buscarRango(int[] range);

    int contar();
    
}
