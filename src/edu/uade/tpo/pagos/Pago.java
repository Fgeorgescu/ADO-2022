package edu.uade.tpo.pagos;

import java.util.Date;

public class Pago {
    private double monto;
    private PagoState estado;
    private Date fechaEmision;


    private Date fechaPago;

    public Pago(double monto) {
        this.monto = monto;
        this.fechaEmision = new Date();
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public void agregarIntereses(double intereses) {
        monto += intereses;
    }
    public void cambiarEstado(PagoState estado) {
        this.estado = estado;
    }

    public PagoState getEstado() {
        return estado;
    }
    public double getMonto() {
        return monto;
    }

}
