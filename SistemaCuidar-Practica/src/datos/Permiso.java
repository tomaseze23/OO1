package datos;

import java.time.LocalDate;
import java.util.Set;

public abstract class Permiso {

    protected int idPermiso;
    protected LocalDate fecha;
    protected int cantDias;
    protected Persona persona;
    protected Set<Lugar> desdeHasta;

    public Permiso() {

    }

    public Permiso(LocalDate fecha, int cantDias, Persona persona, Set<Lugar> desdeHasta) {
        this.fecha = fecha;
        this.cantDias = cantDias;
        this.persona = persona;
        this.desdeHasta = desdeHasta;
    }

    public int getidPermiso() {
        return idPermiso;
    }

    public void setidPermiso(int idPermiso) {
        this.idPermiso = idPermiso;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getCantDias() {
        return cantDias;
    }

    public void setCantDias(int cantDias) {
        this.cantDias = cantDias;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Set<Lugar> getDesdeHasta() {
        return desdeHasta;
    }

    public void setDesdeHasta(Set<Lugar> desdeHasta) {
        this.desdeHasta = desdeHasta;
    }

    public int getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(int idPermiso) {
        this.idPermiso = idPermiso;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idPermiso;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Permiso other = (Permiso) obj;
        if (idPermiso != other.idPermiso)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "\n ** Permiso [cantDias=" + cantDias + ", desdeHasta=" + desdeHasta + ", fecha=" + fecha
                + ", idPermiso=" + idPermiso + ", persona=" + persona + "]\n";
    }


    public abstract boolean activo (LocalDate dia);

}
