package Controlador;

import Modelo.ConsultasLibro;
import Modelo.Libro;
import Vista.frmAgregar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class controladorAgregar implements ActionListener {

    private Libro libros;
    private ConsultasLibro conLibro;
    private frmAgregar frmA;

    public controladorAgregar(Libro libros, ConsultasLibro conLibro, frmAgregar frmA) {
        this.libros = libros;
        this.conLibro = conLibro;
        this.frmA = frmA;
        this.frmA.btnAgregar.addActionListener((ActionListener)this);
    }

    public void iniciar() {
        frmA.setTitle("Buscar Libro");
        frmA.setLocationRelativeTo(null);
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
    }

    public void limpiar() {
        frmA.txtTitulo.setText(null);
        frmA.txtAutor.setText(null);
        frmA.txtCategoria.setText(null);
    }

}
