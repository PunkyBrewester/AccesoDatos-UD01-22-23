package org.example;

import com.thoughtworks.xstream.XStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class Main {

    public static Cancion getCancion1(){
        Discografica discografia = new Discografica("MTV", "1234", "America", 1000);
        Cancion cancion = new Cancion(1, "Sara", "Jose", 6, 2020, true, discografia);

        List<String> paises = List.of("España", "Francia", "Colombia");

        cancion.setPaises(paises);

        return cancion;



    }

    public static Cancion getCancion2(){
        Discografica discografia = new Discografica("MTV", "567", "Francia", 2000);
        Cancion cancion = new Cancion(2, "Pepe", "Paco", 3, 2021, true, discografia);
        return cancion;

    }

    public static void generateXML(ListaCanciones lista) throws FileNotFoundException {
        XStream xstream = new XStream();

        xstream.processAnnotations(Cancion.class);
        xstream.processAnnotations(Discografica.class);
        xstream.processAnnotations(ListaCanciones.class);

        xstream.addImplicitCollection(ListaCanciones.class, "lista");

        xstream.toXML(lista, new FileOutputStream("src/main/resources/canciones.xml"));

    }

    public static void ReadXML() throws FileNotFoundException {
        XStream xstream = new XStream();

        xstream.processAnnotations(Cancion.class);
        xstream.processAnnotations(Discografica.class);
        xstream.processAnnotations(ListaCanciones.class);

        xstream.addImplicitCollection(ListaCanciones.class, "lista");
        xstream.allowTypes(new Class[] {
                org.example.Cancion.class,
                org.example.ListaCanciones.class,
                org.example.Discografica.class

        });

        ListaCanciones lista = (ListaCanciones) xstream.fromXML(new FileInputStream("src/main/resources/canciones.xml"));

        for ( Cancion cancion: lista.getCancion()){
            System.out.println(cancion);
        }

    }


    public static void main(String[] args) throws FileNotFoundException {
        ListaCanciones lista = new ListaCanciones();
        lista.add(getCancion1());
        lista.add(getCancion2());

        generateXML(lista);

        //ReadXML();

        System.out.println("XML generado correctamente");


    }


}