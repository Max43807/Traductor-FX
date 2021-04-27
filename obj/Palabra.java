/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traductorfx.obj;

/**
 *
 * @author ander
 */
public class Palabra {
    
    private int id;
    private String palabra;
    private Idioma idioma;

    public Palabra() {
    }

    public Palabra(int id, String palabra, Idioma idioma) {
        this.id = id;
        this.palabra = palabra;
        this.idioma = idioma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return palabra;
    }
}
