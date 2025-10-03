package co.edu.udistrital.model;

import java.util.ArrayList;

public class Nodo {
    
    private String nombre;
    private String tipo;
    private ArrayList<Nodo> hijos;
    

    public Nodo(String nombre , String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        
        if (tipo.equals("DIRECTORIO")){
            this.hijos = new ArrayList<>();
            
        } else {
            this.hijos = null;
            
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }
    
    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    public int getNumHijos() {
        return (hijos != null) ? hijos.size() : 0;
    }

    public ArrayList<Nodo> getHijos() {
        return hijos;
    }

    public boolean agregarHijo(Nodo hijo) {
        if (!this.tipo.equals("DIRECTORIO")) {
            return false; 
        }
        return hijos.add(hijo);
    }

    public void eliminarHijoDeNodo(int indice) {
        if (hijos != null && indice >= 0 && indice < hijos.size()) {
            hijos.remove(indice);
        }
    }
    

    
}