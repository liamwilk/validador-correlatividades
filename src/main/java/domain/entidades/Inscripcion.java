package domain.entidades;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class Inscripcion {
    private Alumno alumno;
    private Set<Materia> materias;

    public Inscripcion() {
        this.materias = new HashSet<>();
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public Set<Materia> getMaterias() {
        return materias;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public void agregarMateria(Materia unaMateria) {
        Collections.addAll(this.materias, unaMateria);
    }

    public Boolean aprobada(){
        Set<Materia> materiasInscripcion = this.getMaterias();
        Alumno alumnoInscripcion = this.getAlumno();

        return materiasInscripcion.stream().allMatch(alumnoInscripcion::cumpleCorrelativas);
    }
}
