package dao;

import conexion.ConexionBD;
import modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UsuarioDAO {

    // INSERTAR
    public void insertarUsuario(Usuario usuario) {

        String sql =
        "INSERT INTO usuario(username, userpassword) VALUES (?, ?)";

        try {

            Connection conexion = ConexionBD.conectar();

            PreparedStatement ps =
                    conexion.prepareStatement(sql);

            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getUserpassword());

            ps.executeUpdate();

            System.out.println("Usuario registrado");

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    // CONSULTAR
    public void listarUsuarios() {

        String sql = "SELECT * FROM usuario";

        try {

            Connection conexion = ConexionBD.conectar();

            Statement st = conexion.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                System.out.println(
                        rs.getInt("userid") + " - " +
                        rs.getString("username") + " - " +
                        rs.getString("userpassword")
                );
            }

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    // ACTUALIZAR
    public void actualizarUsuario(Usuario usuario) {

        String sql =
        "UPDATE usuario SET username=?, userpassword=? WHERE userid=?";

        try {

            Connection conexion = ConexionBD.conectar();

            PreparedStatement ps =
                    conexion.prepareStatement(sql);

            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getUserpassword());
            ps.setInt(3, usuario.getUserid());

            ps.executeUpdate();

            System.out.println("Usuario actualizado");

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    // ELIMINAR
    public void eliminarUsuario(int id) {

        String sql =
        "DELETE FROM usuario WHERE userid=?";

        try {

            Connection conexion = ConexionBD.conectar();

            PreparedStatement ps =
                    conexion.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Usuario eliminado");

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}