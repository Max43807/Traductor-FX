/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traductorfx.service;

import java.util.List;
import traductorfx.obj.Idioma;
import traductorfx.obj.Palabra;

/**
 *
 * @author ander
 */
public interface ITraductorService {
    
    public List<Idioma> listarIdiomas();
    
    public String traducir(Palabra palabra, Idioma idiomaDestino);
}
