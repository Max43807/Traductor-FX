/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traductorfx.repository;

import java.util.ArrayList;
import java.util.List;
import traductorfx.obj.Idioma;
import traductorfx.obj.Palabra;

/**
 *
 * @author ander
 */
public class PalabraRepository {

    private List<Palabra> palabrasIng;  //Inglés
    private List<Palabra> palabrasEsp;  //Español
    private List<Palabra> palabrasPor; //Portugués

    IdiomaRepository repoIdiomas = new IdiomaRepository();

    public PalabraRepository() {

        //Obtener los idiomas...
        List<Idioma> idiomas = repoIdiomas.getIdiomas();

        //Inicializar listas:
        palabrasIng = new ArrayList<>();
        palabrasEsp = new ArrayList<>();
        palabrasPor = new ArrayList<>();

        //Añadir palabras:
        //Implementar base de datos mas adelante...
        palabrasEsp.add(new Palabra(1, "programación", idiomas.get(0)));
        palabrasEsp.add(new Palabra(2, "libro", idiomas.get(0)));
        palabrasEsp.add(new Palabra(3, "hola", idiomas.get(0)));

        palabrasIng.add(new Palabra(1, "programming", idiomas.get(1)));
        palabrasIng.add(new Palabra(2, "book", idiomas.get(1)));
        palabrasIng.add(new Palabra(3, "hello", idiomas.get(1)));

        palabrasPor.add(new Palabra(1, "programação", idiomas.get(2)));
        palabrasPor.add(new Palabra(2, "livro", idiomas.get(2)));
        palabrasPor.add(new Palabra(3, "oi", idiomas.get(2)));
    }

    public List<Palabra> getPalabrasIng() {
        return palabrasIng;
    }

    public List<Palabra> getPalabrasEsp() {
        return palabrasEsp;
    }

    public List<Palabra> getPalabrasPor() {
        return palabrasPor;
    }
    
    

}
