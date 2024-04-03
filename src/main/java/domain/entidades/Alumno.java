package domain.entidades;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Alumno {
    private String nombre;
    private String apellido;
    private Integer legajo;
    private Set<Materia> materiasAprobadas;

    public Alumno() {
        this.materiasAprobadas = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getLegajo() {
        return legajo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public Set<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public void agregarMateriaAprobada(Materia ... unaMateria){
        Collections.addAll(this.materiasAprobadas, unaMateria);
    }

    public Boolean cumpleCorrelativas(Materia unaMateria) {
        Set<Materia> aprobadas = this.getMateriasAprobadas();
        Set<Materia> correlativas = unaMateria.getCorrelativas();

        return aprobadas.containsAll(correlativas);
    }
}
