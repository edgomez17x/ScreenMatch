package com.aluracursos.screenmatch.modelos;

public class Serie extends Titulo{
    private int temporadas;
    private int episodiosTemporada;
    private int minutosEpisodio;

    public Serie(String nombre, int fechaDeLanzamiento) {
        super(nombre, fechaDeLanzamiento);
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getEpisodiosTemporada() {
        return episodiosTemporada;
    }

    public void setEpisodiosTemporada(int episodiosTemporada) {
        this.episodiosTemporada = episodiosTemporada;
    }

    public int getMinutosEpisodio() {
        return minutosEpisodio;
    }

    public void setMinutosEpisodio(int minutosEpisodio) {
        this.minutosEpisodio = minutosEpisodio;
    }

    @Override
    public int getDuracionMinutos() {
        return temporadas * episodiosTemporada * minutosEpisodio;
    }

    @Override
    public String toString() {
        return "Serie: " + getNombre() + " (" + getFechaDeLanzamiento() + ")";
    }
}
