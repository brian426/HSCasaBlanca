/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponenteReportes;

import ComponenteAdministracion.BD;
import java.sql.Connection;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.*;
import java.util.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author BADY RICHARD
 */
public class ReporteClienteParametro {
    
    private Connection cnn;

    public ReporteClienteParametro() {
        cnn = BD.getConnection();
    }
    
    public void runClienteParametro(int codCliente) {
        try {

            String master = System.getProperty("user.dir") + "/src/ComponenteReportes/ReporteCliente.jasper";
            //System.out.println("master" + master);
            if (master == null) {
                System.out.println("no encuentro el archivo de reporte maestro");
                System.exit(2);
            }
            JasperReport masterReport = null;
            try {
               masterReport = (JasperReport) JRLoader.loadObjectFromFile(master);
            } catch (JRException e) {
                System.out.println("error cargando el reporte maestro:" + e.getMessage());
                System.exit(3);
            }
            Map parametro = new HashMap();
            parametro.put("CodCliente",codCliente);
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, cnn);
            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setTitle("REPORTE REGISTRO CLIENTE");
            jviewer.setVisible(true);
            cnn.close();
        } catch (Exception j) {
            System.out.println("mensaje de error:" + j.getMessage());
        }
    }
}
