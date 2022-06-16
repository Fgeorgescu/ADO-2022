package edu.uade.tpo;

import edu.uade.tpo.personas.Persona;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Consorcio consorcio = new Consorcio("consorsio_1", "CBU");

        Persona propietario1 = new Persona("Propietario","Primero","propietario1@uade.edu.ar", "+5411111111");
        Persona inquilino1 = new Persona("Inquilino","Primero", "inquilino1@uade.edu.ar", "+5411112222");

        UnidadFuncional uf1 = new UnidadFuncional(0.1, Arrays.asList(propietario1));
        uf1.agregarInquilino(inquilino1);


    }
}
