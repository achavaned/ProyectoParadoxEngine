package Controlador;

import Modelo.ConsultasLibro;
import Modelo.Libro;
import Vista.frmEliminar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class controladorEliminar implements ActionListener {

    private Libro libros;
    private ConsultasLibro conLibro;
    private frmEliminar frmE;

    public controladorEliminar(Libro libros, ConsultasLibro conLibro, frmEliminar frmE) {
        this.libros = libros;
        this.conLibro = conLibro;
        this.frmE = frmE;
        this.frmE.btnEliminar.addActionListener((ActionListener) this);
    }

    public void iniciar() {
        frmE.setTitle("Buscar Libro");
        frmE.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

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

    public void limpiar() {
        frmE.txtEliminarTitulo.setText(null);
    }

}
