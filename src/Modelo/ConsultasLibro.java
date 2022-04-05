package Modelo;

import Vista.frmBiblioteca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ConsultasLibro extends Conexion {

    public boolean agregarLibros(Libro libros) {
        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "INSERT INTO libros (titulo, nombreAutor, categoria) VALUES (?,?,?)";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, libros.getTitulo());
            ps.setString(2, libros.getNombreAutor());
            ps.setString(3, libros.getCategoria());
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean eliminarLibros(Libro libros) {
        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "DELETE FROM libros WHERE titulo=?";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, libros.getTitulo());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean buscarLibros(Libro libros) {
        PreparedStatement ps;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM libros WHERE titulo=?";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, libros.getTitulo());
            rs = ps.executeQuery();

            if (rs.next()) {

                libros.setIdLibro(Integer.parseInt(rs.getString("idLibro")));
                libros.setTitulo(rs.getString("titulo"));
                libros.setNombreAutor(rs.getString("nombreAutor"));
                libros.setCategoria(rs.getString("categoria"));
                return true;
            }

            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean mostrarLibros(Libro libros){
        
        frmBiblioteca biblioteca = new frmBiblioteca();
        
        try{
            DefaultTableModel model = new DefaultTableModel();
            biblioteca.tablaMostrar.setModel(model);
            PreparedStatement ps;
            ResultSet rs;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion(); 
            
            String sql = "SELECT titulo, nombreAutor,categoria FROM mydb.libros";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            model.addColumn("Titulo");
            model.addColumn("Nombre Autor");
            model.addColumn("Categoria");
            
            while(rs.next()){
                
                Object [] filas = new Object[cantidadColumnas];
                
                for(int i = 0; i < cantidadColumnas; i++){
                    
                    filas[i] = rs.getObject(i + 1);
                    
                }
                model.addRow(filas); 
            }
            return true;
        }catch(SQLException e){            
            System.err.print(e); 
            return false;
        }  
    }
}
