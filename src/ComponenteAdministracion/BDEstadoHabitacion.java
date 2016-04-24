/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponenteAdministracion;

import ComponenteClases.EstadoHabitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Toshib
 */
public class BDEstadoHabitacion {

    public static EstadoHabitacion buscarEstadoHabitacion(int codigo) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        EstadoHabitacion c = null;
        ps = cnn.prepareStatement("select CB_DescEstadoHab from t_cbestadohabitacion where CB_idEstadoHab=?");
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            c = new EstadoHabitacion() {
            };
            c.setCodEstado(codigo);
            c.setDescEstado(rs.getString("CB_DescEstadoHab"));
        }
        cnn.close();
        ps.close();
        return c;
    }
    
     public static EstadoHabitacion buscarEstadoName(String nombre) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        EstadoHabitacion c = null;
        ps = cnn.prepareStatement("select CB_idEstadoHab from t_cbestadohabitacion where CB_DescEstadoHab=?");
        ps.setString(1, nombre);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            c = new EstadoHabitacion() {
            };
            c.setCodEstado(rs.getInt("CB_idEstadoHab"));
            c.setDescEstado(nombre);
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
