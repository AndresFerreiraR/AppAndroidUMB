package com.example.androidapp.datos.entidades;

import com.google.firebase.database.PropertyName;

public class AgendaDto {
    private int idAgenda;
    private String fecha;
    private String asunto;
    private String actividad;

    @PropertyName("IdAgenda")
    public int getIdAgenda() {
        return idAgenda;
    }

    @PropertyName("IdAgenda")
    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
    }

    @PropertyName("Fecha")
    public String getFecha() {
        return fecha;
    }

    @PropertyName("Fecha")
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @PropertyName("Asunto")
    public String getAsunto() {
        return asunto;
    }

    @PropertyName("Asunto")
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    @PropertyName("Actividad")
    public String getActividad() {
        return actividad;
    }

    @PropertyName("Actividad")
    public void setActividad(String actividad) {
        this.actividad = actividad;
    }
}
