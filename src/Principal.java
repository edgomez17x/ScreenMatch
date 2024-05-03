import com.aluracursos.screenmatch.calculos.CalculadoraDeTiempo;
import com.aluracursos.screenmatch.calculos.FiltroRecomendacion;
import com.aluracursos.screenmatch.modelos.Episodio;
import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;

public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula();
        miPelicula.setNombre("Deadpool");
        miPelicula.setFechaDeLanzamiento(2015);
        miPelicula.setDuracionMinutos(123);

        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(8.0);
        miPelicula.evalua(10);
        System.out.println(miPelicula.getTotalEvaluaciones());
        System.out.println(miPelicula.calculaMedia());

        Serie casaDragon = new Serie();
        casaDragon.setTemporadas(1);
        casaDragon.setEpisodiosTemporada(10);
        casaDragon.setMinutosEpisodio(50);
        casaDragon.setNombre("La casa del dragón");
        casaDragon.setFechaDeLanzamiento(2022);

        casaDragon.muestraFichaTecnica();

        CalculadoraDeTiempo cdt = new CalculadoraDeTiempo();

        Pelicula matrix = new Pelicula();
        matrix.setNombre("Matrix");
        matrix.setFechaDeLanzamiento(1998);
        matrix.setDuracionMinutos(180);

        cdt.incluye(miPelicula);
        cdt.incluye(casaDragon);
        cdt.incluye(matrix);
        System.out.println("Tiempo necesario para ver tus títulos favoritos estas vacaciones: " + cdt.getTiempoTotal());

        FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
        filtroRecomendacion.filtra(miPelicula);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setNombre("La casa Targeryan");
        episodio.setSerie(casaDragon);
        episodio.setTotalVisualizaciones(50);

        filtroRecomendacion.filtra(episodio);
    }
}
