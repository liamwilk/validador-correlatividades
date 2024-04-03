package domain.entidades;

import java.util.*;

public class Materia {
    private String nombre;
    private Integer codigo;
    private Set<Materia> correlativas;

    public Materia() {
        this.correlativas = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Set<Materia> getCorrelativas() {
        return correlativas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void agregarCorrelativa(Materia ... unaMateria){
        Collections.addAll(this.correlativas, unaMateria);
    }
}
