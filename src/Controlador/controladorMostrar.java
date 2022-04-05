
package Controlador;

import Modelo.ConsultasLibro;
import Modelo.Libro;
import Vista.frmBiblioteca;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class controladorMostrar implements ActionListener{
    private Libro libros;
    private ConsultasLibro conLibro;
    private frmBiblioteca biblioteca;
    
    
    public controladorMostrar(Libro libros, ConsultasLibro conLibro, frmBiblioteca biblioteca){
        this.libros = libros;
        this.conLibro = conLibro;
        this.biblioteca = biblioteca;
        this.biblioteca.btnMostrar.addActionListener((ActionListener)this);
    }
    
    public void iniciar(){
        biblioteca.setTitle("Su biblioteca");
        biblioteca.setLocationRelativeTo(null);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == biblioteca.btnMostrar) {
            if (conLibro.mostrarLibros(libros)) {
                JOptionPane.showMessageDialog(null, "Se muestran los libros");
                
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar el libro");
            }
        }
    }
}
