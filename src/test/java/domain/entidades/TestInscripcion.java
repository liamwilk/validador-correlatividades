package domain.entidades;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class TestInscripcion{
    private Alumno juan;
    private Materia discreta;
    private Materia ayed;
    private Materia pdep;
    private Materia dds;

    @BeforeEach
    public void inicializar(){
        discreta = new Materia();
        ayed = new Materia();
        pdep = new Materia();
        dds = new Materia();
        juan = new Alumno();

        discreta.setNombre("Matematica Discreta");
        discreta.setCodigo(1001);

        ayed.setNombre("Algoritmos y Estructura de Datos");
        ayed.setCodigo(1002);

        pdep.setNombre("Paradigmas de Programacion");
        pdep.setCodigo(2001);
        pdep.agregarCorrelativa(discreta, ayed);

        dds.setNombre("Disenio de Sistemas");
        dds.setCodigo(3001);
        dds.agregarCorrelativa(discreta, ayed, pdep);

        juan.setNombre("Juan");
        juan.setApellido("Perez");
        juan.setLegajo(2094157);
        juan.agregarMateriaAprobada(discreta, ayed);
    }

    @Test
    @DisplayName("La inscripcion del alumno es aceptada")
    public void inscripcionAceptada(){
        this.inicializar();
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setAlumno(this.juan);
        inscripcion.agregarMateria(pdep);

        Assertions.assertTrue(inscripcion.aprobada());
    }

    @Test
    @DisplayName("La inscripcion del alumno es rechazada")
    public void inscripcionRechazada(){
        this.inicializar();
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setAlumno(this.juan);
        inscripcion.agregarMateria(dds);

        Assertions.assertFalse(inscripcion.aprobada());
    }


}
