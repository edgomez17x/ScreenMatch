package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;
import com.aluracursos.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalConListas {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Deadpool",2015);
        miPelicula.evalua(9);
        Pelicula matrix = new Pelicula("Matrix",1998);
        matrix.evalua(8);
        var peliculaDrama = new Pelicula("El señor de los anillos", 2001);
        peliculaDrama.evalua(10);
        Serie casaDragon = new Serie("La casa del dragón", 2022);
        Serie lost = new Serie("Lost", 2000);

        ArrayList<Titulo> listaTitulos = new ArrayList<Titulo>();
        listaTitulos.add(miPelicula);
        listaTitulos.add(peliculaDrama);
        listaTitulos.add(matrix);
        listaTitulos.add(casaDragon);
        listaTitulos.add(lost);

        for(Titulo item : listaTitulos){
            System.out.println("Titulo: " + item.getNombre());
            if (item instanceof Pelicula peli && peli.getClasificacion() > 2){
                System.out.println("Clasificación: " + peli.getClasificacion());
            }
        }

        ArrayList<String> listaArtistas = new ArrayList<>();
        listaArtistas.add("Penélope Cruz");
        listaArtistas.add("Antonio Banderas");
        listaArtistas.add("Ricardo Darín");

        System.out.println("Lista de artistas no ordenada: " + listaArtistas);
        Collections.sort(listaArtistas);
        System.out.println("Lista de artistas ordenada: " + listaArtistas);

        Collections.sort(listaTitulos);
        System.out.println("Lista ordenada de titulos: " + listaTitulos);

        listaTitulos.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("Lista ordenada por año: " + listaTitulos);


    }

}
