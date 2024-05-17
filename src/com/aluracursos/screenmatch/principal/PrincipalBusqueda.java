package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.exceptions.ErrorEnConversionDeDuracionException;
import com.aluracursos.screenmatch.modelos.Titulo;
import com.aluracursos.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.sound.midi.Soundbank;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class PrincipalBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        int option = 0;
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

        while(option == 0){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Escriba el nombre de una película para buscarla o la palabra Salir para cerrar el programa:");
            String nombre = scanner.nextLine();
            if(nombre.toUpperCase().equals("SALIR")){
                option = 1;
                continue;
            }
            String url = "http://www.omdbapi.com/?apikey=d082f63f&t=" + URLEncoder.encode(nombre, StandardCharsets.UTF_8);

            try{
                System.out.println(url);
                System.out.println();
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(response.body());

                TituloOmdb tituloOmbd = gson.fromJson(json, TituloOmdb.class);
                System.out.println(tituloOmbd.toString());

                Titulo titulo = new Titulo(tituloOmbd);
                System.out.println("Titulo convertido: " + titulo);
                titulos.add(titulo);
            }catch(NumberFormatException e){
                System.out.println("Ocurrió un error: ");
                System.out.println(e.getMessage());
            }catch(IllegalArgumentException e){
                System.out.println("Ocurrió un error en la URL: ");
                System.out.println(e.getMessage());
            }catch (Exception e){
                System.out.println("Ocurrió un error inesperdo: ");
                System.out.println(e.getMessage());
            }
        }
        System.out.println(titulos);

        FileWriter fw = new FileWriter("Titulos.json");
        fw.write(gson.toJson(titulos));
        fw.close();
        System.out.println("Finalizó la ejecución del programa.");
    }
}
