package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

@XStreamAlias("cancion")
public class Cancion {
    private int numeroCancion;
    private String nombre;
    private String autor;
    private int duracion;
    private int anyo;
    private boolean single;
    private Discografica discografica;
    @XStreamImplicit(itemFieldName = "pais")
    private List<String> paises;

    public Cancion(int numeroCancion, String nombre, String autor, int duracion, int anyo, boolean single, Discografica discografica) {
        this.numeroCancion = numeroCancion;
        this.nombre = nombre;
        this.autor = autor;
        this.duracion = duracion;
        this.anyo = anyo;
        this.single = single;
        this.discografica = discografica;

    }

    public int getNumeroCancion() {
        return numeroCancion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getAnyo() {
        return anyo;
    }

    public boolean isSingle() {
        return single;
    }

    public void setNumeroCancion(int numeroCancion) {
        this.numeroCancion = numeroCancion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public void setSingle(boolean single) {
        this.single = single;
    }

    public Discografica getDiscografica() {
        return discografica;
    }

    public void setDiscografica(Discografica discografica) {
        this.discografica = discografica;
    }

    public List<String> getPaises(List<String> paises) {
        return this.paises;
    }

    public void setPaises(List<String> paises) {
        this.paises = paises;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "numeroCancion=" + numeroCancion +
                ", nombre='" + nombre + '\'' +
                ", autor='" + autor + '\'' +
                ", duracion=" + duracion +
                ", anyo=" + anyo +
                ", single=" + single +
                ", discografica=" + discografica +
                ", paises=" + paises +
                '}';
    }
}
