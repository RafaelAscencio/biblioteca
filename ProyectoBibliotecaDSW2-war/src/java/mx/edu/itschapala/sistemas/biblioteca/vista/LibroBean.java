/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itschapala.sistemas.biblioteca.vista;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import mx.edu.itschapala.sistemas.biblioteca.bl.AutorBLLocal;
import mx.edu.itschapala.sistemas.biblioteca.bl.CategoriaBLLocal;
import mx.edu.itschapala.sistemas.biblioteca.bl.LibroBLLocal;
import mx.edu.itschapala.sistemas.biblioteca.modelo.AutorLibro;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Libro;
import mx.edu.itschapala.sistemas.biblioteca.modelo.LibroCategoria;

/**
 *
 * @author Estudiante
 */
@ManagedBean
@SessionScoped
public class LibroBean {
    @EJB
    private CategoriaBLLocal categoriaBL;
    @EJB
    private AutorBLLocal autorBL;
    @EJB
    private LibroBLLocal libroBL;
    
    
    
    private Accion accion;
    private Libro libro;
    private List<Libro> lista;
    private List<AutorLibro> listaAutorLibro;
    private AutorLibro autorLibro;
    private int autorSelecionado;
    private List<LibroCategoria> listaLibroCategoria;
    private LibroCategoria libroCategoria;
    private int categoriaSelecionado;
            
    
    
    public LibroBean() {
    }
    
       public List<Libro> getLista(){
        lista=libroBL.getLista();
    return lista;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public AutorLibro getAutorLibro() {
        return autorLibro;
    }

    public void setAutorLibro(AutorLibro autorLibro) {
        this.autorLibro = autorLibro;
    }

    public List<AutorLibro> getListaAutorLibro() {
        return listaAutorLibro;
    }

    public int getAutorSelecionado() {
        return autorSelecionado;
    }

    public void setAutorSelecionado(int autorSelecionado) {
        this.autorSelecionado = autorSelecionado;
    }

    public LibroCategoria getLibroCategoria() {
        return libroCategoria;
    }

    public void setLibroCategoria(LibroCategoria libroCategoria) {
        this.libroCategoria = libroCategoria;
    }

    public List<LibroCategoria> getListaLibroCategoria() {
        return listaLibroCategoria;
    }

    public int getCategoriaSelecionado() {
        return categoriaSelecionado;
    }

    public void setCategoriaSelecionado(int categoriaSelecionado) {
        this.categoriaSelecionado = categoriaSelecionado;
    }
      
    
    public void agregarCategoria(ActionEvent evt){
        libroCategoria = new LibroCategoria();
        libroCategoria.setIdCategoria(categoriaBL.getPorId(categoriaSelecionado));
        listaLibroCategoria.add(libroCategoria);
    
    }
    public  void agregarAutor(ActionEvent evt){
        autorLibro = new AutorLibro();
        autorLibro.setIdAutor(autorBL.getPorId(autorSelecionado));
    listaAutorLibro.add(autorLibro);
    }
       
        //Acciones
    public String procesarPeticion() {
        switch (accion) {
            case NUEVO:
                libroBL.registrar(libro,listaAutorLibro,listaLibroCategoria);
                break;
//            case EDITAR:
//                libroBL.modificar(libro);
//                break;
//            case ELIMINAR:
//                libroBL.eliminar(libro);
//                break;

        }
        accion = Accion.NADA;
        return "LibroListaV2";
    }

    public String procesarCancelar() {
        if (accion == Accion.ELIMINAR) {
            return "LibroListaV2";
        } else {
            return "LibroCrearEditarV2";

        }
    }
//eventos

    public void limpiarNuevo(ActionEvent evt) {
        libro = new Libro();
        accion = Accion.NUEVO;
        autorLibro = new AutorLibro();
        listaAutorLibro = new ArrayList<>(); 
        libroCategoria= new LibroCategoria();
        listaLibroCategoria = new ArrayList<>();

    }

    public void prepararEditar(ActionEvent evt) {
        accion = Accion.EDITAR;

    }

    public void prepararEliminar(ActionEvent evt) {
        accion = Accion.ELIMINAR;

    }
    
}
