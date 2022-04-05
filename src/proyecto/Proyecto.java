/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import Controlador.controladorAgregar;
import Controlador.controladorBuscar;
import Controlador.controladorEliminar;
import Modelo.ConsultasLibro;
import Modelo.Libro;
import Vista.frmAgregar;
import Vista.frmBuscar;
import Vista.frmEliminar;
import Vista.frmLogin;

/**
 *
 * @author felipealvarezbenitez
 */
public class Proyecto {

    
    public static void main(String[] args) {
        
        ConsultasLibro conLibro = new ConsultasLibro();
        Libro libros = new Libro();
        frmAgregar frmA = new frmAgregar();
        frmBuscar frmB = new frmBuscar();
        frmEliminar frmE = new frmEliminar();
        frmLogin log = new frmLogin();
        
        
        controladorBuscar buscar = new controladorBuscar(libros, conLibro, frmB);
        controladorEliminar eliminar = new controladorEliminar(libros, conLibro, frmE);
        buscar.iniciar();
        eliminar.iniciar();
        log.setVisible(true);
        
    }
    
}
