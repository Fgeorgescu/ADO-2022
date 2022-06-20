package edu.uade.tpo;

import edu.uade.tpo.utils.LogUtil;

import java.util.Date;

public class CuentaBancaria {
    private int cbu;
    private static String Token = "ALGMck2120k:A3lkfk20";
    private double saldo;

    public CuentaBancaria(int cbu) {
        this.cbu = cbu;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public void agregarSaldo(double monto) {
        this.saldo += monto;
        new LogUtil().logMessage("se agregó %f al saldo. Salto total: %f", monto, this.saldo);
    }

    public void restarSaldo(double monto) {
        this.saldo -= monto;
        new LogUtil().logMessage("se restó %f al saldo. Salto total: %f", monto, this.saldo);

    }
}
