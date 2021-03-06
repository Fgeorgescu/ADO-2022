package edu.uade.tpo;

import edu.uade.tpo.gastos.TipoExpensa;
import edu.uade.tpo.gestora.Gestora;
import edu.uade.tpo.gestora.criterios.PagoCompletoConFondosDeReserva;
import edu.uade.tpo.gestora.criterios.PagoCompletoDeGastos;
import edu.uade.tpo.gestora.criterios.PagoCompletoYGenerarFuturosFondosDeReserva;
import edu.uade.tpo.personas.Persona;
import edu.uade.tpo.personas.notificacion.TipoNotificacion;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Main {

    /**
     * Las tres pruebas son similares, pero indicando distintos criterios de pago.
     *
     * Se agregan dos propietarios y un inquilino. Se settean dos unidades funcionales
     *  UF1:
     *      - Inquilino 1 que recibe por Whatsapp y Propeitario 1 que recibe por email.
     *      - % de pago, 0.7
     *  UF2:
     *      - Propietario 2 que recibe por SMS.
     *      - % de pago 0.3%
     *
     * Se crea el consorsio y la gestora. Se selecciona un criterio de pago, se agregan 3 gastos
     *   - "Service ascensor", 2000, Expensa ordinaria
     *   - "Agua", 10000, Expensa ordinaria
     *   - "Plantas para el hall", 1500, Expensa extraordinaria
     *
     *  Se calculan los gastos y se imprimen por pantalla.
     *
     */
    @Test
    void TestCaso1() {

        Persona propietario1 = new Persona("Propietario","Primero","propietario1@uade.edu.ar", "+5411111111");
        Persona inquilino1 = new Persona("Inquilino","Primero", "inquilino1@uade.edu.ar", "+5411112222");
        Persona propietario2 = new Persona("Propietario","Segundo","propietario2@uade.edu.ar", "+5422221111");

        propietario1.agregarNotificacion(true, TipoNotificacion.EMAIL);
        inquilino1.agregarNotificacion(true, TipoNotificacion.WHATSAPP);
        propietario2.agregarNotificacion(true, TipoNotificacion.SMS);

        UnidadFuncional uf1 = new UnidadFuncional(0.7, Arrays.asList(propietario1), "Unidad funcional 1");
        UnidadFuncional uf2 = new UnidadFuncional(0.3, Arrays.asList(propietario2), "Unidad funcional 2");

        uf1.agregarInquilino(inquilino1);


        Consorcio consorcio = new Consorcio("consorcio_1", 123456786, Arrays.asList(uf1, uf2));

        Gestora gestora = new Gestora(consorcio);

        gestora.seleccionarCriterioPago(new PagoCompletoConFondosDeReserva());
        consorcio.getCuentaBancaria().agregarSaldo(5000);
        consorcio.agregarGastoRecurrente("Service ascensor", 2000, TipoExpensa.ORDINARIA);
        consorcio.agregarGastoUnico("Agua", 10000, TipoExpensa.ORDINARIA);
        consorcio.agregarGastoUnico("Plantas para el hall", 1500, TipoExpensa.EXTRAORDINARIA);

        gestora.calcularExpensas();
    }

    @Test
    void TestCaso2() {

        Persona propietario1 = new Persona("Propietario","Primero","propietario1@uade.edu.ar", "+5411111111");
        Persona inquilino1 = new Persona("Inquilino","Primero", "inquilino1@uade.edu.ar", "+5411112222");
        Persona propietario2 = new Persona("Propietario","Primero","propietario1@uade.edu.ar", "+5411111111");

        propietario1.agregarNotificacion(true, TipoNotificacion.EMAIL);
        inquilino1.agregarNotificacion(true, TipoNotificacion.WHATSAPP);
        propietario2.agregarNotificacion(true, TipoNotificacion.SMS);

        UnidadFuncional uf1 = new UnidadFuncional(0.7, Arrays.asList(propietario1), "Unidad funcional 1");
        UnidadFuncional uf2 = new UnidadFuncional(0.3, Arrays.asList(propietario2), "Unidad funcional 2");

        uf1.agregarInquilino(inquilino1);


        Consorcio consorcio = new Consorcio("consorcio_1", 123456786, Arrays.asList(uf1, uf2));

        Gestora gestora = new Gestora(consorcio);

        gestora.seleccionarCriterioPago(new PagoCompletoDeGastos());
        consorcio.getCuentaBancaria().agregarSaldo(5000);
        consorcio.agregarGastoRecurrente("Service ascensor", 2000, TipoExpensa.ORDINARIA);
        consorcio.agregarGastoUnico("Agua", 10000, TipoExpensa.ORDINARIA);
        consorcio.agregarGastoUnico("Plantas para el hall", 1500, TipoExpensa.EXTRAORDINARIA);

        gestora.calcularExpensas();
    }

    @Test
    void TestCaso3() {

        Persona propietario1 = new Persona("Propietario","Primero","propietario1@uade.edu.ar", "+5411111111");
        Persona inquilino1 = new Persona("Inquilino","Primero", "inquilino1@uade.edu.ar", "+5411112222");
        Persona propietario2 = new Persona("Propietario","Primero","propietario1@uade.edu.ar", "+5411111111");

        propietario1.agregarNotificacion(true, TipoNotificacion.EMAIL);
        inquilino1.agregarNotificacion(true, TipoNotificacion.WHATSAPP);
        propietario2.agregarNotificacion(true, TipoNotificacion.SMS);

        UnidadFuncional uf1 = new UnidadFuncional(0.7, Arrays.asList(propietario1), "Unidad funcional 1");
        UnidadFuncional uf2 = new UnidadFuncional(0.3, Arrays.asList(propietario2), "Unidad funcional 2");

        uf1.agregarInquilino(inquilino1);


        Consorcio consorcio = new Consorcio("consorcio_1", 123456786, Arrays.asList(uf1, uf2));

        Gestora gestora = new Gestora(consorcio);

        gestora.seleccionarCriterioPago(new PagoCompletoYGenerarFuturosFondosDeReserva());
        consorcio.getCuentaBancaria().agregarSaldo(5000);
        consorcio.agregarGastoRecurrente("Service ascensor", 2000, TipoExpensa.ORDINARIA);
        consorcio.agregarGastoUnico("Agua", 10000, TipoExpensa.ORDINARIA);
        consorcio.agregarGastoUnico("Plantas para el hall", 1500, TipoExpensa.EXTRAORDINARIA);

        gestora.calcularExpensas();
    }

    public static void main(String[] args) {

    }
}
