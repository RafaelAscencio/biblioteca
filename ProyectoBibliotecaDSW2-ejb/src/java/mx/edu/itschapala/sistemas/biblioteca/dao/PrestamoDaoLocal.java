/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itschapala.sistemas.biblioteca.dao;

import java.util.List;
import javax.ejb.Local;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Prestamo;

/**
 *
 * @author Estudiante
 */
@Local
public interface PrestamoDaoLocal {

    void crear(Prestamo prestamo);

    void editar(Prestamo prestamo);

    void remover(Prestamo prestamo);

    Prestamo buscarPorId(Object id);

    List<Prestamo> buscarTodos();

    List<Prestamo> buscarRango(int[] range);

    int contar();
    
}
