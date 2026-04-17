package Modelo;

import java.sql.*;

public class ExamenDAO {

    // 🔹 INSERTAR
    public void insertar(Examen ex) {
        String sql = "INSERT INTO examen(nombre, descripcion) VALUES (?, ?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, ex.getNombre());
            ps.setString(2, ex.getDescripcion());
            ps.executeUpdate();

            registrarBitacora("INSERT", "Se agregó un registro en Examen");

        } catch (Exception e) {
            System.out.println("Error insertar: " + e);
        }
    }

    // 🔹 ACTUALIZAR
    public void actualizar(Examen ex) {
        String sql = "UPDATE examen SET nombre=?, descripcion=? WHERE id_examen=?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, ex.getNombre());
            ps.setString(2, ex.getDescripcion());
            ps.setInt(3, ex.getId());
            ps.executeUpdate();

            registrarBitacora("UPDATE", "Se modificó un registro en Examen");

        } catch (Exception e) {
            System.out.println("Error actualizar: " + e);
        }
    }

    // 🔹 ELIMINAR
    public void eliminar(int id) {
        String sql = "DELETE FROM examen WHERE id_examen=?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            registrarBitacora("DELETE", "Se eliminó un registro en Examen");

        } catch (Exception e) {
            System.out.println("Error eliminar: " + e);
        }
    }

    // 🔹 LISTAR
    public ResultSet listar() {
        try {
            Connection con = Conexion.getConexion();
            Statement st = con.createStatement();
            return st.executeQuery("SELECT * FROM examen");
        } catch (Exception e) {
            System.out.println("Error listar: " + e);
            return null;
        }
    }

    // 🔹 BITÁCORA
private void registrarBitacora(String accion, String descripcion) {
    String sql = "INSERT INTO bitacora(accion, descripcion) VALUES (?, ?)";

    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, accion);
        ps.setString(2, descripcion);
        ps.executeUpdate();

    } catch (Exception e) {
        System.out.println("Error bitácora: " + e);
    }
}