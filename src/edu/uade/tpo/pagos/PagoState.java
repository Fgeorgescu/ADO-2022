package edu.uade.tpo.pagos;

public abstract class PagoState {
    Pago pago;

    PagoState(Pago pago){
        this.pago = pago;
    }

    public abstract void generarIntereses();
    public abstract void saldar();
}
