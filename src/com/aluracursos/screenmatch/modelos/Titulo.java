package com.aluracursos.screenmatch.modelos;

public class Titulo implements Comparable<Titulo>{
    private String nombre;
    private int fechaDeLanzamiento;
    private int duracionMinutos;
    private boolean incluidoEnElPlan;
    private double sumaEvaluaciones;
    private int totalEvaluaciones;

    public Titulo(String nombre, int fechaDeLanzamiento) {
        this.nombre = nombre;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaDeLanzamiento(int fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public void setIncluidoEnElPlan(boolean incluidoEnElPlan) {
        this.incluidoEnElPlan = incluidoEnElPlan;
    }

    public void muestraFichaTecnica(){
        System.out.println("El nombre del titulo es: " + nombre);
        System.out.println("Su fecha de lanzamiento es: " + fechaDeLanzamiento);
        System.out.println("Duración en minutos: " + getDuracionMinutos());
    }

    public void evalua(double nota){
        sumaEvaluaciones += nota;
        totalEvaluaciones++;
    }

    public double calculaMedia(){
        return sumaEvaluaciones/totalEvaluaciones;
    }

    public int getTotalEvaluaciones(){
        return totalEvaluaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public boolean isIncluidoEnElPlan() {
        return incluidoEnElPlan;
    }

    @Override
    public int compareTo(Titulo titulo2) {
        return this.getNombre().compareTo(titulo2.getNombre());
    }
}
