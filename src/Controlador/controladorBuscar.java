package Controlador;

import Modelo.ConsultasLibro;
import Modelo.Libro;
import Vista.frmBuscar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class controladorBuscar implements ActionListener {

    private Libro libros;
    private ConsultasLibro conLibro;
    private frmBuscar frmB;

    public controladorBuscar(Libro libros, ConsultasLibro conLibro, frmBuscar frmB) {
        this.libros = libros;
        this.conLibro = conLibro;
        this.frmB = frmB;
        this.frmB.btnBuscar.addActionListener((ActionListener) this);
    }

    public void iniciar() {
        frmB.setTitle("Buscar Libro");
        frmB.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

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
    }

    public void limpiar() {
        frmB.txtBuscar.setText(null);
    }

}
