/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponenteAdministracion;

import ComponenteClases.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author BADY RICHARD
 */
public abstract class BDUsuario {

   /* public static void insertarUsuario(Usuario u) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("insert into usuario (cUsuId,cUsuClave,nPerCodigo,cUsuEstado) values (?,?,?,?)");
        ps.setString(1, u.getcUsuId());
        ps.setString(2, u.getcUsuClave());
        ps.setInt(3, u.getPersonal().getnPerCodigo());
        ps.setString(4, u.getcUsuEstado());
        ps.executeUpdate();
        cnn.close();
        ps.close();
    }*/
    
    public static Usuario buscarUsuario(int codigo) throws SQLException {
        return buscarUsuario("select CB_idUser,CB_UserNick,CB_UserPass,CB_UserNombre,CB_UserApellidos,CB_UserEdad,CB_UserDNI,CB_UserCelular,CB_UserTelefono,CB_UserCorreo,CB_idEstado FROM t_cbusuario where CB_idUser=" + codigo, null);
    }
    
   public static Usuario buscarUsuario(String id) throws SQLException {
        return buscarUsuario("select CB_idUser,CB_UserNick,CB_UserPass,CB_UserNombre,CB_UserApellidos,CB_UserEdad,CB_UserDNI,CB_UserCelular,CB_UserTelefono,CB_UserCorreo,CB_idEstado FROM t_cbusuario where CB_UserNick=" + id, null);
    }

    public static Usuario buscarUsuario(String sql, Usuario u) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (u == null) {
                u = new Usuario() {
                };
            }
            u.setIdUsuario(rs.getInt("CB_idUser"));
            u.setLogin(rs.getString("CB_UserNick"));
            u.setPass(rs.getString("CB_UserPass"));
            u.setNombre(rs.getString("CB_UserNombre"));
            u.setApellidos(rs.getString("CB_UserApellidos"));
            u.setNacimiento(rs.getDate("CB_UserEdad"));
            u.setDni(rs.getString("CB_UserDNI"));
            u.setCelular(rs.getString("CB_UserCelular"));
             u.setTelefono(rs.getString("CB_UserTelefono"));
              u.setCorreo(rs.getString("CB_UserCorreo"));
               u.setEstado(rs.getInt("CB_idEstado"));
        }
        cnn.close();
        ps.close();
        return u;
    }

    /*public static boolean eliminarUsuario(String iduser) throws SQLException {
    Connection cnn = BD.getConnection();
    PreparedStatement ps = null;
    ps = cnn.prepareStatement("delete from USUARIO WHERE id=?");
    ps.setString(1, iduser);
    int rowsUpdated = ps.executeUpdate();
    cnn.close();
    ps.close();
    if (rowsUpdated > 0) {
    return true;
    } else {
    return false;
    }
    }*/
    /*public static boolean actualizarUsuario(Usuario u) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("update usuario set cUsuId=?,cUsuClave=?,nPerCodigo=?,cUsuEstado=? where nUsuCodigo=" + u.getnUsuCodigo());
        ps.setString(1, u.getcUsuId());
        ps.setString(2, u.getcUsuClave());
        ps.setInt(3, u.getPersonal().getnPerCodigo());
        ps.setString(4, u.getcUsuEstado());
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }*/
    
    public static Usuario login(String usuario, String clave) throws SQLException {
        return realizarbusqueda(null,"select CB_idUser,CB_UserNick,CB_UserPass,CB_UserNombre,CB_UserApellidos,CB_UserEdad,CB_UserDNI,CB_UserCelular,CB_UserCorreo,CB_idEstado from t_cbusuario where CB_UserNick='"+usuario+"' and CB_UserPass='"+clave+"'");
    }

    public static Usuario realizarbusqueda(Usuario u, String sql) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (u == null) {
                u = new Usuario(){};
            }
            u.setIdUsuario(rs.getInt("CB_idUser"));
            u.setLogin(rs.getString("CB_UserNick"));
            u.setPass(rs.getString("CB_UserPass"));
            u.setNombre(rs.getString("CB_UserNombre"));
            u.setApellidos(rs.getString("CB_UserApellidos"));
            u.setNacimiento(rs.getDate("CB_UserEdad"));
            u.setDni(rs.getString("CB_UserDNI"));
            u.setCelular(rs.getString("CB_UserCelular"));
            u.setCorreo(rs.getString("CB_UserCorreo"));
            u.setEstado(rs.getInt("CB_idEstado"));
        }
        cnn.close();
        ps.close();
        return u;
    }

    public static ArrayList<Usuario> mostrarUsuario() throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<Usuario> lista = new ArrayList<Usuario>();

        ps = cnn.prepareStatement("select CB_idUser,CB_UserNick,CB_UserPass,CB_UserNombre,CB_UserApellidos,CB_UserCelular,CB_idEstado from t_cbusuario");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Usuario u = new Usuario() {
            };
            u.setIdUsuario(rs.getInt("CB_idUser"));
            u.setLogin(rs.getString("CB_UserNick"));
            u.setPass(rs.getString("CB_UserPass"));
            u.setNombre(rs.getString("CB_UserNombre"));
            u.setApellidos(rs.getString("CB_UserApellidos"));
            u.setCelular(rs.getString("CB_UserCelular"));
            u.setEstado(rs.getInt("CB_idEstado"));
            lista.add(u);
        }
        cnn.close();
        ps.close();
        return lista;
    }

    public static ArrayList<Usuario> listarUsuarioPorId(String nombre) {
        return listar("CB_UserNombre", nombre + "%", "like");
    }

    public static ArrayList<Usuario> listarUsuarioPorCodigo(String codigo) {
        return listar("CB_UserNick", codigo + "%", "like");
    }

    private static ArrayList<Usuario> listar(String atributo, String parametro, String comparador) {
        return consultarSQL("select CB_idUser,CB_UserNick,CB_UserPass,CB_UserNombre,CB_UserApellidos,CB_UserCelular,CB_idEstado from t_cbusuario where " + atributo + " " + comparador + " '" + parametro + "'");
    }

    private static ArrayList<Usuario> consultarSQL(String sql) {
        ArrayList<Usuario> list = new ArrayList<Usuario>();
        Connection cn = BD.getConnection();
        try {
            Usuario u;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                u = new Usuario();
                 u.setIdUsuario(rs.getInt("CB_idUser"));
            u.setLogin(rs.getString("CB_UserNick"));
            u.setPass(rs.getString("CB_UserPass"));
            u.setNombre(rs.getString("CB_UserNombre"));
            u.setApellidos(rs.getString("CB_UserApellidos"));
            u.setCelular(rs.getString("CB_UserCelular"));
            u.setEstado(rs.getInt("CB_idEstado"));
                list.add(u);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return list;
    }
}