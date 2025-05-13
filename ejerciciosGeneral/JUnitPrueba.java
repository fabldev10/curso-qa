package com.egg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class JUnitPrueba {


    @Test
    public void testWithSoftAssertions() throws Throwable {

        List<Throwable> errors = new ArrayList<>();

        try {
            assertEquals(5, suma(2, 2)); // Si falla aquí, se añade a errores
        } catch (Throwable t) {
            errors.add(t);
        }

        try {
            assertEquals("Texto esperado", "Texto actual");
            // Si falla aquí, se añade a errores
        } catch (Throwable t) {
            errors.add(t);
        }
        // Lanza todas las afirmaciones fallidas al final
        if (!errors.isEmpty()) {
            errors.forEach(error -> System.err.println(error.getMessage()));
            throw errors.get(0);
            // Lanza la primera excepción para marcar la prueba como fallida
        }
    } // Método auxiliar para el ejemplo

    private int suma(int a, int b) {
        return a + b;
    }
}

    

