package Trabajo;

import java.util.Vector;

public class ListaPersonas {

    Vector listaPersonas;

    public ListaPersonas() {
        listaPersonas=new Vector();
    }
    public void agregarPersona(Persona p) {
        listaPersonas.add(p);
    }
    public void eliminarPersona(int i) {
        listaPersonas.removeElement(i);
    }
    public void borrarLista() {
        listaPersonas.removeAllElements();
    }

}