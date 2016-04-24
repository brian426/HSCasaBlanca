/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponenteAdministracion;


import ComponenteClases.Habitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Toshib
 */
public class BDHabitacion {
//     public static Cliente insertarCliente(Cliente c) throws SQLException {
//        Connection cnn = BD.getConnection();
//        PreparedStatement ps = null;
//        ps = cnn.prepareStatement("insert into t_cbcliente (CB_CliNombres,CB_CliApellidos,CB_CliNumIdentif,CB_idIdentificacion,CB_CantVisitas,CB_OtrosDatos) values (?,?,?,?,?,?)");
//        ps.setString(1, c.getcCliNombres());
//        ps.setString(2, c.getcCliApellidos());
//        ps.setString(3, c.getcNumeroIdentificacion());
//        ps.setInt(4, c.getTipodocumentocli().getTipCodigo());
//        ps.setInt(5, c.getcCantidadVisitas());
//        ps.setString(6, c.getcOtrosDatos());
//        ps.executeUpdate();
//        PreparedStatement ps2 = cnn.prepareStatement("select max(CB_idCliente) from t_cbcliente");
//        ResultSet r = ps2.executeQuery();
//        if (r.next()) {
//            int lastID = r.getInt(1);
//            c.setnCliCodigo(lastID);
//        }
//        ps2.close();
//        cnn.close();
//        ps.close();
//        return c;
//    }

    
     public static boolean actualizarHabitacion(Habitacion c) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        ps = cnn.prepareStatement("update t_cbhabitacion set CB_HabEstado=? where CB_HabNumero=" + c.getNumHabitacion());
       // ps.setString(1, c.getcCliNombres());
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }
     
        public static boolean actualizarHabitacionEstado(int c,int estado) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        ps = cnn.prepareStatement("update t_cbhabitacion set CB_HabEstado=? where CB_HabNumero=" + c);
        ps.setInt(1,estado);
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public static Habitacion buscarHabitacionxCodigo(int codigo) throws SQLException {
        return buscarHabitacionxCodigo(codigo, null);
    }

    public static Habitacion buscarHabitacionxCodigo(int codigo, Habitacion c) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("select CB_HabNumeroNivel,CB_HabNumero,CB_HabEstado,CB_HabHorarioOcupado from t_cbhabitacion where CB_idHabitacion=?");
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (c == null) {
                c = new Habitacion() {
                };
            }
            c.setCodHabitacion(codigo);
            c.setNumNivel(rs.getInt("CB_HabNumeroNivel"));
            c.setNumHabitacion(rs.getInt("CB_HabNumero"));
            c.setEstado(BDEstadoHabitacion.buscarEstadoHabitacion(rs.getInt("CB_HabEstado")));
            c.setHorarioOcupado(rs.getString("CB_HabHorarioOcupado"));
        }
        cnn.close();
        ps.close();
        return c;
    }

    public static Habitacion buscarHabitacionNumero(int numero) throws SQLException {
        return buscarHabitacionNumero(numero, null);
    }

    public static Habitacion buscarHabitacionNumero(int nombre, Habitacion c) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("select CB_idHabitacion,CB_HabNumeroNivel,CB_HabEstado,CB_HabHorarioOcupado from t_cbhabitacion where CB_HabNumero=?");
        ps.setInt(1, nombre);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            c = c == null ? new Habitacion() {
            } : c;

            c.setNumHabitacion(nombre);
            c.setCodHabitacion(rs.getInt("CB_idHabitacion"));
            c.setNumNivel(rs.getInt("CB_HabNumeroNivel"));
            c.setEstado(BDEstadoHabitacion.buscarEstadoHabitacion(rs.getInt("CB_HabEstado")));
            c.setHorarioOcupado(rs.getString("CB_HabHorarioOcupado"));
        } else {
            c = null;
        }
        cnn.close();
        ps.close();
        return c;
    }
   

    public static ArrayList<Habitacion> mostrarHabitaciones() throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<Habitacion> lista = new ArrayList<Habitacion>();

        ps = cnn.prepareStatement("select CB_idHabitacion,CB_HabNumeroNivel,CB_HabNumero,CB_HabEstado,CB_HabHorarioOcupado from t_cbhabitacion");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Habitacion c = new Habitacion() {
            };
            c.setCodHabitacion(rs.getInt("CB_idHabitacion"));
            c.setNumNivel(rs.getInt("CB_HabNumeroNivel"));
            c.setNumHabitacion(rs.getInt("CB_HabNumero"));
            c.setEstado(BDEstadoHabitacion.buscarEstadoHabitacion(rs.getInt("CB_HabEstado")));
            c.setHorarioOcupado(rs.getString("CB_HabHorarioOcupado"));
            lista.add(c);
        }
        cnn.close();
        ps.close();
        return lista;
    }
public static ArrayList<Habitacion> listarHabPorNivel(String codigo) {
        return listar("CB_HabNumeroNivel", codigo + "%", "like");
    }
    public static ArrayList<Habitacion> listarHabPorNumero(String nombre) {
        return listar("CB_HabNumero", nombre + "%", "like");
    }

    private static ArrayList<Habitacion> listar(String atributo, String parametro, String comparador) {
        return consultarSQL("select CB_idHabitacion,CB_HabNumeroNivel,CB_HabNumero,CB_HabEstado,CB_HabHorarioOcupado from t_cbhabitacion where " + atributo + " " + comparador + " '" + parametro + "'");
    }

    private static ArrayList<Habitacion> consultarSQL(String sql) {
        ArrayList<Habitacion> list = new ArrayList<Habitacion>();
        Connection cn = BD.getConnection();
        try {
            Habitacion c;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
               c = new Habitacion();
                c.setCodHabitacion(rs.getInt("CB_idHabitacion"));
            c.setNumNivel(rs.getInt("CB_HabNumeroNivel"));
            c.setNumHabitacion(rs.getInt("CB_HabNumero"));
            c.setEstado(BDEstadoHabitacion.buscarEstadoHabitacion(rs.getInt("CB_HabEstado")));
            c.setHorarioOcupado(rs.getString("CB_HabHorarioOcupado"));
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
