package es.upm.dit.isst.model;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Producto {
@Id
private String nombre;
private int stock;
private double precio;
@Lob
private Blob foto;
private String descripcion;
public Producto() {
}
public Producto(String nombre, int stock, double precio, Blob foto, String descripcion) {
    this.nombre = nombre;
    this.stock = stock;
    this.precio = precio;
    this.foto = foto;
    this.descripcion = descripcion;
}
public String getNombre() {
    return nombre;
}
public int getStock() {
    return stock;
}
public double getPrecio() {
    return precio;
}
public Blob getFoto() {
    return foto;
}
public String getDescripcion() {
    return descripcion;
}
public void setNombre(String nombre) {
    this.nombre = nombre;
}
public void setStock(int stock) {
    this.stock = stock;
}
public void setPrecio(double precio) {
    this.precio = precio;
}
public void setFoto(Blob foto) {
    this.foto = foto;
}
public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
}
@Override
public String toString() {
    return "Producto [nombre=" + nombre + ", stock=" + stock + ", precio=" + precio + ", foto=" + foto
            + ", descripcion=" + descripcion + "]";
}
@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
    Producto other = (Producto) obj;
    if (nombre == null) {
        if (other.nombre != null)
            return false;
    } else if (!nombre.equals(other.nombre))
        return false;
    return true;
}


}
