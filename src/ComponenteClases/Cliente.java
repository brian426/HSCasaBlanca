/*Derechos reservados por Hotel Casa Blanca
 */
package ComponenteClases;

/**
 *
 * @author Hotel Casa Blanca
 */
public class Cliente {
     private int nCliCodigo;
    private String cCliNombres;
    private String cCliApellidos;
    private TIpoDocumentoCliente tipodocumentocli;
    private String cNumeroIdentificacion;
    private int cCantidadVisitas;
    private String cOtrosDatos;

    public int getnCliCodigo() {
        return nCliCodigo;
    }

    public void setnCliCodigo(int nCliCodigo) {
        this.nCliCodigo = nCliCodigo;
    }

    public String getcCliNombres() {
        return cCliNombres;
    }

    public void setcCliNombres(String cCliNombres) {
        this.cCliNombres = cCliNombres;
    }

    public String getcCliApellidos() {
        return cCliApellidos;
    }

    public void setcCliApellidos(String cCliApellidos) {
        this.cCliApellidos = cCliApellidos;
    }

    public TIpoDocumentoCliente getTipodocumentocli() {
        return tipodocumentocli;
    }

    public void setTipodocumentocli(TIpoDocumentoCliente tipodocumentocli) {
        this.tipodocumentocli = tipodocumentocli;
    }

    public String getcNumeroIdentificacion() {
        return cNumeroIdentificacion;
    }

    public void setcNumeroIdentificacion(String cNumeroIdentificacion) {
        this.cNumeroIdentificacion = cNumeroIdentificacion;
    }

    public int getcCantidadVisitas() {
        return cCantidadVisitas;
    }

    public void setcCantidadVisitas(int cCantidadVisitas) {
        this.cCantidadVisitas = cCantidadVisitas;
    }

    public String getcOtrosDatos() {
        return cOtrosDatos;
    }

    public void setcOtrosDatos(String cOtrosDatos) {
        this.cOtrosDatos = cOtrosDatos;
    }

   

   
    
    
}
