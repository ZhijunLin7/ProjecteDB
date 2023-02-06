package com.example.projectedb;

public class Comentario {

    private int id;
    private String titol;
    private String comentario;

    public Comentario() {

    }

    public Comentario(String titol, String comentario) {
        this.titol = titol;
        this.comentario = comentario;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "id=" + id +
                ", titol='" + titol + '\'' +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
