package Controlador;

import Modelo.Examen;
import Modelo.ExamenDAO;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;

public class clsExamen {

    ExamenDAO dao = new ExamenDAO();

    // 🔹 INSERTAR
    public void insertar(String nombre, String descripcion) {
        Examen ex = new Examen();
        ex.setNombre(nombre);
        ex.setDescripcion(descripcion);

        dao.insertar(ex);
    }

    // 🔹 ACTUALIZAR
    public void actualizar(int id, String nombre, String descripcion) {
        Examen ex = new Examen();
        ex.setId(id);
        ex.setNombre(nombre);
        ex.setDescripcion(descripcion);

        dao.actualizar(ex);
    }

    // 🔹 ELIMINAR
    public void eliminar(int id) {
        dao.eliminar(id);
    }

    // 🔹 MOSTRAR EN TABLA (JTable)
    public void listar(JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripción");

        tabla.setModel(modelo);

        try {
            ResultSet rs = dao.listar();

            while (rs.next()) {
                Object[] fila = new Object[3];
                fila[0] = rs.getInt("id_examen");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("descripcion");

                modelo.addRow(fila);
            }

        } catch (Exception e) {
            System.out.println("Error al listar: " + e);
        }
    }
}