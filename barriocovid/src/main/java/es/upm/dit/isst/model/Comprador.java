package es.upm.dit.isst.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Comprador {
@Id
private String id;
private String nombre;
private String email;
private String contraseña;
private String direccion;
private int CP;
private boolean vulnerable;



public Comprador() {
}

public Comprador (String id, String nombre, String email, String contraseña, String direccion, int CP, boolean vulnerable){
this.id = id;
this.nombre=nombre;
this.email=email;
this.contraseña=contraseña;
this.direccion=direccion;
this.CP=CP;
this.vulnerable=vulnerable;
}

 // Métodos accesores
 public String getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public String getEmail() {
    return email;
  }

  public String getContraseña() {
    return contraseña;
  }

  public String getDireccion() {
    return direccion;
  }

  public int getCP() {
    return CP;
  }

  public boolean isVulnerable() {
    return vulnerable;
  }

  // Métodos modificadores
  public void setId(String id) {
    this.id = id;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setContraseña(String contraseña) {
    this.contraseña = contraseña;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public void setCP(int CP) {
    this.CP = CP;
  }

  public void setVulnerable(boolean vulnerable) {
    this.vulnerable = vulnerable;
  }

@Override
public String toString() {
    return "Comprador [id=" + id + ", nombre=" + nombre + ", email=" + email + ", contraseña=" + contraseña
            + ", direccion=" + direccion + ", CP=" + CP + ", vulnerable=" + vulnerable + "]";
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
    Comprador other = (Comprador) obj;
    if (id == null) {
        if (other.id != null)
            return false;
    } else if (!id.equals(other.id))
        return false;
    return true;
}





}
