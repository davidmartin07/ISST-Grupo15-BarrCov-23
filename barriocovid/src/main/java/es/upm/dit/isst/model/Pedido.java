package es.upm.dit.isst.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pedido {
    @Id
    private String id;
    private String descripcion;
    private String HoraDeRecogida;

    

    public Pedido() {
    }

    public Pedido(String id, String descripcion, String horaDeRecogida) {
        this.id = id;
        this.descripcion = descripcion;
        HoraDeRecogida = horaDeRecogida;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHoraDeRecogida() {
        return HoraDeRecogida;
    }

    public void setHoraDeRecogida(String horaDeRecogida) {
        HoraDeRecogida = horaDeRecogida;
    }

    @Override
    public String toString() {
        return "Pedido [id=" + id + ", descripcion=" + descripcion + ", HoraDeRecogida=" + HoraDeRecogida + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Pedido other = (Pedido) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


    
    


}
