
package Controlador;

import Modelo.ConsultasLibro;
import Modelo.Libro;
import Vista.frmAgregar;
import Vista.frmBuscar;
import Vista.frmEliminar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controlador implements ActionListener{
    
    private Libro libros;
    private ConsultasLibro conLibro;
    private frmAgregar frmA;
    private frmBuscar frmB;
    private frmEliminar frmE;
    
    public Controlador(Libro libros, ConsultasLibro conLibro, frmAgregar frmA, frmBuscar frmB, frmEliminar frmE) {
        this.libros = libros;
        this.conLibro = conLibro;
        this.frmA = frmA;
        this.frmB = frmB;
        this.frmE = frmE;
        this.frmA.btnAgregar.addActionListener((ActionListener)this);
        this.frmB.btnBuscar.addActionListener((ActionListener) this);
        this.frmE.btnEliminar.addActionListener((ActionListener) this);
    }
    
    public void limpiar() {
        frmA.txtTitulo.setText(null);
        frmA.txtAutor.setText(null);
        frmA.txtCategoria.setText(null);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frmA.btnAgregar) {
            libros.setTitulo(frmA.txtTitulo.getText());
            libros.setNombreAutor(frmA.txtAutor.getText());
            libros.setCategoria(frmA.txtCategoria.getText());

            if (conLibro.agregarLibros(libros)) {
                JOptionPane.showMessageDialog(null, "Libro guardado Exitosamente");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar el libro");
                limpiar();
            }
        }
        
        if (e.getSource() == frmB.btnBuscar) {
            libros.setTitulo(frmB.txtBuscar.getText());

            if (conLibro.buscarLibros(libros)) {
                JOptionPane.showMessageDialog(null, "El libro se encuentra en su biblioteca");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Erro al guardar el libro");
                limpiar();
            }
        }
        
        if (e.getSource() == frmE.btnEliminar) {
            libros.setTitulo(frmE.txtEliminarTitulo.getText());

            if (conLibro.eliminarLibros(libros)) {
                JOptionPane.showMessageDialog(null, "Libro Eliminado Exitosamente");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Erro al eliminar el libro");
                limpiar();
            }
        }
    }
}
