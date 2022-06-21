package edu.uade.tpo.pagos;

import java.util.Date;

public class PendientePagoState extends PagoState{

    PendientePagoState(Pago pago) {
        super(pago);
    }

    @Override
    public void generarIntereses() {
    }

    @Override
    public void saldar() {
        pago.setFechaPago(new Date());
        pago.cambiarEstado(new PagoRealizadoState(this.pago));
    }
}
