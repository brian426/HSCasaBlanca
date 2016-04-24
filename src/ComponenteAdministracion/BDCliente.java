/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponenteAdministracion;

import ComponenteClases.Cliente;
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
public abstract class BDCliente {

    public static Cliente insertarCliente(Cliente c) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("insert into t_cbcliente (CB_CliNombres,CB_CliApellidos,CB_CliNumIdentif,CB_idIdentificacion,CB_CantVisitas,CB_OtrosDatos) values (?,?,?,?,?,?)");
        ps.setString(1, c.getcCliNombres());
        ps.setString(2, c.getcCliApellidos());
        ps.setString(3, c.getcNumeroIdentificacion());
        ps.setInt(4, c.getTipodocumentocli().getTipCodigo());
        ps.setInt(5, c.getcCantidadVisitas());
        ps.setString(6, c.getcOtrosDatos());
        ps.executeUpdate();
        PreparedStatement ps2 = cnn.prepareStatement("select max(CB_idCliente) from t_cbcliente");
        ResultSet r = ps2.executeQuery();
        if (r.next()) {
            int lastID = r.getInt(1);
            c.setnCliCodigo(lastID);
        }
        ps2.close();
        cnn.close();
        ps.close();
        return c;
    }

    public static Cliente buscarClienteCodigo(int codigo) throws SQLException {
        return buscarClienteCodigo(codigo, null);
    }

    public static Cliente buscarClienteCodigo(int codigo, Cliente c) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("select CB_CliNombres,CB_CliApellidos,CB_CliNumIdentif,CB_idIdentificacion,CB_CantVisitas,CB_OtrosDatos from t_cbcliente where CB_idCliente=?");
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (c == null) {
                c = new Cliente() {
                };
            }
            c.setnCliCodigo(codigo);
            c.setcCliNombres(rs.getString("CB_CliNombres"));
            c.setcCliApellidos(rs.getString("CB_CliApellidos"));
            c.setcNumeroIdentificacion(rs.getString("CB_CliNumIdentif"));
            c.setTipodocumentocli(BDTipoDocumentoCliente.buscarTipDocCliente(rs.getInt("CB_idIdentificacion")));
            c.setcCantidadVisitas(rs.getInt("CB_CantVisitas"));
            c.setcOtrosDatos(rs.getString("CB_OtrosDatos"));
        }
        cnn.close();
        ps.close();
        return c;
    }

    public static Cliente buscarClienteNombre(String nombre) throws SQLException {
        return buscarClienteNombre(nombre, null);
    }

    public static Cliente buscarClienteNombre(String nombre, Cliente c) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("select CB_idCliente,CB_CliApellidos,CB_CliNumIdentif,CB_idIdentificacion,CB_CantVisitas,CB_OtrosDatos from t_cbcliente where CB_CliNombres=?");
        ps.setString(1, nombre);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            c = c == null ? new Cliente() {
            } : c;

            c.setcCliNombres(nombre);
            c.setnCliCodigo(rs.getInt("CB_idCliente"));
            c.setcCliApellidos(rs.getString("CB_CliApellidos"));
            c.setcNumeroIdentificacion(rs.getString("CB_CliNumIdentif"));
            c.setTipodocumentocli(BDTipoDocumentoCliente.buscarTipDocCliente(rs.getInt("CB_idIdentificacion")));
            c.setcCantidadVisitas(rs.getInt("CB_CantVisitas"));
            c.setcOtrosDatos(rs.getString("CB_OtrosDatos"));
        } else {
            c = null;
        }
        cnn.close();
        ps.close();
        return c;
    }

    /*public static boolean eliminarCliente(String codcliente) throws SQLException {
    Connection cnn = BD.getConnection();
    PreparedStatement ps = null;
    
    ps = cnn.prepareStatement("delete from CLIENTE WHERE codcliente=?");
    ps.setString(1, codcliente);
    int rowsUpdated = ps.executeUpdate();
    cnn.close();
    ps.close();
    if (rowsUpdated > 0) {
    return true;
    } else {
    return false;
    }
    }*/
    public static boolean actualizarCliente(Cliente c) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        ps = cnn.prepareStatement("update t_cbcliente set CB_CliNombres=?,CB_CliApellidos=?, CB_CliNumIdentif=?, CB_idIdentificacion=?, CB_CantVisitas=?, CB_OtrosDatos=? where CB_idCliente=" + c.getnCliCodigo());
        ps.setString(1, c.getcCliNombres());
        ps.setString(2, c.getcCliApellidos());
        ps.setString(3, c.getcNumeroIdentificacion());
        ps.setInt(4, c.getTipodocumentocli().getTipCodigo());
        ps.setInt(5, c.getcCantidadVisitas());
        ps.setString(6, c.getcOtrosDatos());
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<Cliente> mostrarCliente() throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<Cliente> lista = new ArrayList<Cliente>();

        ps = cnn.prepareStatement("select CB_idCliente,CB_CliNombres,CB_CliApellidos,CB_CliNumIdentif,CB_idIdentificacion,CB_CantVisitas,CB_OtrosDatos from t_cbcliente");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Cliente c = new Cliente() {
            };
            c.setnCliCodigo(rs.getInt("CB_idCliente"));
            c.setcCliNombres(rs.getString("CB_CliNombres"));
            c.setcCliApellidos(rs.getString("CB_CliApellidos"));
            c.setcNumeroIdentificacion(rs.getString("CB_CliNumIdentif"));
            c.setTipodocumentocli(BDTipoDocumentoCliente.buscarTipDocCliente(rs.getInt("CB_idIdentificacion")));
            c.setcCantidadVisitas(rs.getInt("CB_CantVisitas"));
            c.setcOtrosDatos(rs.getString("CB_OtrosDatos"));
            lista.add(c);
        }
        cnn.close();
        ps.close();
        return lista;
    }
public static ArrayList<Cliente> listarClientePorCodigo(String codigo) {
        return listar("CB_idCliente", codigo + "%", "like");
    }
    public static ArrayList<Cliente> listarClientePorNombre(String nombre) {
        return listar("CB_CliNombres", nombre + "%", "like");
    }

    private static ArrayList<Cliente> listar(String atributo, String parametro, String comparador) {
        return consultarSQL("select CB_idCliente,CB_CliNombres,CB_CliApellidos,CB_CliNumIdentif,CB_idIdentificacion,CB_CantVisitas,CB_OtrosDatos from t_cbcliente where " + atributo + " " + comparador + " '" + parametro + "'");
    }

    private static ArrayList<Cliente> consultarSQL(String sql) {
        ArrayList<Cliente> list = new ArrayList<Cliente>();
        Connection cn = BD.getConnection();
        try {
            Cliente c;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
               c = new Cliente();
                c.setnCliCodigo(rs.getInt("CB_idCliente"));
            c.setcCliNombres(rs.getString("CB_CliNombres"));
            c.setcCliApellidos(rs.getString("CB_CliApellidos"));
            c.setcNumeroIdentificacion(rs.getString("CB_CliNumIdentif"));
            c.setTipodocumentocli(BDTipoDocumentoCliente.buscarTipDocCliente(rs.getInt("CB_idIdentificacion")));
            c.setcCantidadVisitas(rs.getInt("CB_CantVisitas"));
            c.setcOtrosDatos(rs.getString("CB_OtrosDatos"));
                list.add(c);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return list;
    }
}