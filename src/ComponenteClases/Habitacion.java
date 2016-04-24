/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponenteClases;

/**
 *
 * @author Toshib
 */
public class Habitacion {
    private int codHabitacion;
    private int numNivel;
    private int numHabitacion;
    private EstadoHabitacion Estado;
    private String HorarioOcupado;

    public int getCodHabitacion() {
        return codHabitacion;
    }

    public void setCodHabitacion(int codHabitacion) {
        this.codHabitacion = codHabitacion;
    }

    public int getNumNivel() {
        return numNivel;
    }

    public void setNumNivel(int numNivel) {
        this.numNivel = numNivel;
    }

    public int getNumHabitacion() {
        return numHabitacion;
    }

    public void setNumHabitacion(int numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public EstadoHabitacion getEstado() {
        return Estado;
    }

    public void setEstado(EstadoHabitacion Estado) {
        this.Estado = Estado;
    }

    public String getHorarioOcupado() {
        return HorarioOcupado;
    }

    public void setHorarioOcupado(String HorarioOcupado) {
        this.HorarioOcupado = HorarioOcupado;
    }
    
    
}
