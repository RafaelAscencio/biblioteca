/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itschapala.sistemas.biblioteca.dao;

import java.util.List;
import javax.ejb.Local;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Usuario;

/**
 *
 * @author Estudiante
 */
@Local
public interface UsuarioDaoLocal {

    void crear(Usuario usuario);

    void editar(Usuario usuario);

    void remover(Usuario usuario);

    Usuario buscarPorId(Object id);

    List<Usuario> buscarTodos();

    List<Usuario> buscarRango(int[] range);

    int contar();
    
}
