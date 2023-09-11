package com.gestion.empleados.inventario_backend.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table (name = "altas-bajas")
public class Registro {


 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "nombre", length = 60, nullable = false)
    private String nombre;
    
    @Column(name = "apellido", length = 60, nullable = false)
    private String apellido;

    @Column(name = "area", length = 60, nullable = false)
    private String area;

    @Column(name = "nombre herramienta", length = 60, nullable = false)
    private String nombreHerramienta;

    @Column(name = "tipo", length = 60, nullable = false)
    private String tipo;
  
    @Column(name = "cantidad", length = 60, nullable = true)
    private int cantidad;

  // @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
    @Column(name = "fechaSalida", length = 60, nullable = true)

    private Date fechaSalida;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaIngreso")
    private Date fechaIngreso;

    public Registro() {

    }

    public Registro(Long id, String nombre, String apellido, String area, String nombreHerramienta, String tipo,
            int cantidad, Date fechaSalida, Date fechaIngreso) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.area = area;
        this.nombreHerramienta = nombreHerramienta;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.fechaSalida = fechaSalida;
        this.fechaIngreso = fechaIngreso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNombreHerramienta() {
        return nombreHerramienta;
    }

    public void setNombreHerramienta(String nombreHerramienta) {
        this.nombreHerramienta = nombreHerramienta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    

}