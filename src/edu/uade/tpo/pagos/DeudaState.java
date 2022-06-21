package edu.uade.tpo.pagos;

import java.util.Date;

public class DeudaState extends PagoState{
    DeudaState(Pago pago) {
        super(pago);
    }

    @Override
    public void generarIntereses() {
        this.pago.agregarIntereses(this.pago.getMonto() * 0.1);
    }

    @Override
    public void saldar() {
        pago.setFechaPago(new Date());
        pago.cambiarEstado(new PagoRealizadoState(this.pago));
    }
}
