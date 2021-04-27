/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traductorfx.service;

import java.util.List;
import traductorfx.obj.Idioma;
import traductorfx.obj.Palabra;
import traductorfx.repository.IdiomaRepository;
import traductorfx.repository.PalabraRepository;

/**
 *
 * @author ander
 */
public class TraductorServiceImpl implements ITraductorService {

    //Crear instancia de repositorio...
    IdiomaRepository idiomaRepo = new IdiomaRepository();
    PalabraRepository palabraRepo = new PalabraRepository();

    @Override
    public List<Idioma> listarIdiomas() {
        return idiomaRepo.getIdiomas();
    }

    @Override
    public String traducir(Palabra palabra, Idioma idiomaDestino) {

        String traduccion = "Palabra no encontrada";

        //Bucle de colecciones...
        for (Palabra p : palabraRepo.getPalabrasEsp()) {

            //Buscar la palabra ingresada en la colección de palabras esp...
            if (p.getPalabra().toLowerCase().equals(palabra.getPalabra().toLowerCase())) {
                palabra.setId(p.getId());  //Obtener su ID para buscar equivalencias en otros idiomas...

                //Según el idioma destino, buscar la traducción...
                switch (idiomaDestino.getId()) {
                    case 2:
                        traduccion = palabraRepo.getPalabrasIng().get(palabra.getId() - 1).getPalabra();
                        break;
                    case 3:
                        traduccion = palabraRepo.getPalabrasPor().get(palabra.getId() - 1).getPalabra();
                        break;
                    case 1:
                        traduccion = palabra.getPalabra();
                        break;
                    default:
                        break;
                }
            }

        }

        return traduccion;
    }

}
