/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itschapala.sistemas.biblioteca.bl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mx.edu.itschapala.sistemas.biblioteca.dao.PuestoDaoLocal;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Puesto;

/**
 *
 * @author Estudiante
 */
@Stateless
public class PuestoBL implements PuestoBLLocal {
    @EJB
    private PuestoDaoLocal puestoDao;

    @Override
    public boolean registrar(Puesto puesto) {
       puestoDao.crear(puesto);
        return true;
    }

    @Override
    public boolean eliminar(Puesto puesto) {
        puestoDao.remover(puesto);
        return true;
    }

    @Override
    public boolean modificar(Puesto puesto) {
        puestoDao.editar(puesto);
        return true;
    }

    @Override
    public List<Puesto> getLista() {
        return puestoDao.buscarTodos();
    }

    @Override
    public Puesto getPorId(int id) {
        return puestoDao.buscarPorId(id);
    }



}
