/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itschapala.sistemas.biblioteca.bl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mx.edu.itschapala.sistemas.biblioteca.dao.LibroDaoLocal;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Libro;

/**
 *
 * @author Estudiante
 */
@Stateless
public class LibroBL implements LibroBLLocal {
    @EJB
    private LibroDaoLocal libroDao;

    @Override
    public boolean registrar(Libro libro) {
        libroDao.crear(libro);
        return true;
    }

    @Override
    public boolean eliminar(Libro libro) {
        libroDao.remover(libro);
        return true;
    }

    @Override
    public boolean modificar(Libro libro) {
        libroDao.editar(libro);
        return true;
    }

    @Override
    public List<Libro> getLista() {
        return libroDao.buscarTodos();
    }

    @Override
    public Libro getPorId(int id) {
        return libroDao.buscarPorId(id);
    }
    
    
    
    
    
    

   
}
