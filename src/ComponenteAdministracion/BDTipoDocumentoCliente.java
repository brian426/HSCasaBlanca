/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponenteAdministracion;

import ComponenteClases.TIpoDocumentoCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author BADY RICHARD
 */
public abstract class BDTipoDocumentoCliente {

    public static void insertarPagoCredito(TIpoDocumentoCliente c) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("insert into t_cbidentificacion (CB_IdentifDescripcion) values (?)");
        ps.setString(1, c.getTipDescripcion());
        ps.executeUpdate();
        cnn.close();
        ps.close();
    }

    public static TIpoDocumentoCliente buscarTipDocCliente(int codigo) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        TIpoDocumentoCliente c = null;
        ps = cnn.prepareStatement("select CB_IdentifDescripcion from t_cbidentificacion where CB_idIdentificacion=?");
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            c = new TIpoDocumentoCliente() {
            };
            c.setTipCodigo(codigo);
            c.setTipDescripcion(rs.getString("CB_IdentifDescripcion"));
        }
        cnn.close();
        ps.close();
        return c;
    }
    
     public static TIpoDocumentoCliente buscarTipDocClienteName(String nombre) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        TIpoDocumentoCliente c = null;
        ps = cnn.prepareStatement("select CB_idIdentificacion from t_cbidentificacion where CB_IdentifDescripcion=?");
        ps.setString(1, nombre);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            c = new TIpoDocumentoCliente() {
            };
            c.setTipCodigo(rs.getInt("CB_idIdentificacion"));
            c.setTipDescripcion(nombre);
        }
        cnn.close();
        ps.close();
        return c;
    }
    
//    public static boolean actualizarCronogramaPago(Credito c) throws SQLException {
//        Connection cnn = BD.getConnection();
//        PreparedStatement ps = null;
//        ps = cnn.prepareStatement("update credito set cCreEstado=? where nVenCodigo="+c.getVenta().getnVenCodigo());
//        ps.setString(1,c.getcCreEstado());
//        int rowsUpdated = ps.executeUpdate();
//        cnn.close();
//        ps.close();
//        if (rowsUpdated > 0) {
//            return true;
//        } else {
//            return false;
//        }
//    }
    
//    public static ArrayList<Credito> mostrarPagoCredito() throws SQLException {
//        Connection cnn = BD.getConnection();
//        PreparedStatement ps = null;
//        ArrayList<Credito> lista = new ArrayList<Credito>();
//
//        ps = cnn.prepareStatement("select nVenCodigo,nCreNroCuotas,nCreMontoPorCuota,cCreEstado,nCreMontoDebito from credito");
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            Credito c = new Credito() {
//            };
//            c.setVenta(BDVenta.buscarVenta(rs.getInt("nVenCodigo")));
//            c.setnCreNroCuotas(rs.getInt("nCreNroCuotas"));
//            c.setNcreMontoPorCuota(rs.getDouble("nCreMontoPorCuota"));
//            c.setcCreEstado(rs.getString("cCreEstado"));
//            c.setnCreMontoDebito(rs.getDouble("nCreMontoDebito"));
//            lista.add(c);
//        }
//        cnn.close();
//        ps.close();
//        return lista;
//    }
}