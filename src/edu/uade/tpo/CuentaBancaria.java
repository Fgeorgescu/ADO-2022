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
        new LogUtil().logMessage("se agreg\u00f3 $%.2f al saldo. Salto total: $%.2f", monto, this.saldo);
    }

    public void restarSaldo(double monto) {
        this.saldo -= monto;
        new LogUtil().logMessage("se rest\u00f3 $%.2f al saldo. Salto total: $%.2f", monto, this.saldo);

    }
}
