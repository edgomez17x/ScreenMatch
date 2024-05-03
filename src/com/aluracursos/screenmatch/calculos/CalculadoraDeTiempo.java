package com.aluracursos.screenmatch.calculos;

import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Titulo;

public class CalculadoraDeTiempo {
    private int tiempoTotal;
    public void incluye(Titulo titulo){
        tiempoTotal += titulo.getDuracionMinutos();
    }
    public int getTiempoTotal() {
        return tiempoTotal;
    }

}
