package edu.uade.tpo;

import edu.uade.tpo.gastos.TipoExpensa;
import edu.uade.tpo.gestora.Gestora;
import edu.uade.tpo.gestora.criterios.PagoCompletoConFondosDeReserva;
import edu.uade.tpo.personas.Persona;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Main {

    @Test
    void TestCaso1() {
        Consorcio consorcio = new Consorcio("consorcio_1", 123456786);

        Gestora gestora = new Gestora(consorcio);

        gestora.seleccionarCriterioPago(new PagoCompletoConFondosDeReserva());
        consorcio.getCuentaBancaria().agregarSaldo(5000);

        Persona propietario1 = new Persona("Propietario","Primero","propietario1@uade.edu.ar", "+5411111111");
        Persona inquilino1 = new Persona("Inquilino","Primero", "inquilino1@uade.edu.ar", "+5411112222");

        UnidadFuncional uf1 = new UnidadFuncional(0.7, Arrays.asList(propietario1));
        uf1.agregarInquilino(inquilino1);

        Persona propietario2 = new Persona("Propietario","Primero","propietario1@uade.edu.ar", "+5411111111");

        UnidadFuncional uf2 = new UnidadFuncional(0.3, Arrays.asList(propietario2));

        consorcio.agregarGastoRecurrente("Service ascensor",2000, TipoExpensa.ORDINARIA);
        consorcio.agregarGastoUnico("Agua", 10000, TipoExpensa.ORDINARIA);
        consorcio.agregarGastoUnico("Plantas para el hall", 1500, TipoExpensa.EXTRAORDINARIA);
    }

    public static void main(String[] args) {

    }
}
