/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traductorfx.repository;

import java.util.ArrayList;
import java.util.List;
import traductorfx.obj.Idioma;

/**
 *
 * @author ander
 */
public class IdiomaRepository {
    
    private List<Idioma> idiomas;

    public IdiomaRepository() {
        
        idiomas = new ArrayList<>();
        
        idiomas.add(new Idioma(1, "Español"));
        idiomas.add(new Idioma(2, "Inglés"));
        idiomas.add(new Idioma(3, "Portugués"));
    }

    public List<Idioma> getIdiomas() {
        return idiomas;
    }
}
