package co.edu.udistrital.model;

import java.util.ArrayList;

public class ArbolNario {
 
    private Nodo raiz;

    public ArbolNario(String nombreRaiz) {
        this.raiz = new Nodo(nombreRaiz, "DIRECTORIO");
    }

    public Nodo getRaiz() {
        return raiz;
    }
    

    public boolean crearElemento(String nombrePadre, String nombreNuevo, String tipoNuevo){
        Nodo padre = buscarNodoPorNombre(raiz, nombrePadre);
        if (padre != null && padre.getTipo().equals("DIRECTORIO")) {
            Nodo nuevoNodo = new Nodo(nombreNuevo, tipoNuevo);
            return padre.agregarHijo(nuevoNodo);
        }
        return false;
    }

    public boolean eliminarElemento(String nombreEliminar){
        if (raiz.getNombre().equals(nombreEliminar)) {
            return false;
        }
        return eliminarElementoRecursivo(raiz, nombreEliminar); 
    }

    private boolean eliminarElementoRecursivo(Nodo padre, String ValorEliminar) {
        if (padre == null || padre.getHijos()== null) return false;
        
        ArrayList<Nodo> hijos = padre.getHijos();

        for (int i = 0; i < hijos.size(); i++){
            Nodo hijo = hijos.get(i);

            if (hijo.getNombre().equals(ValorEliminar)){
                padre.eliminarHijoDeNodo(i);
                return true;
            } else {
                if (eliminarElementoRecursivo(hijo, ValorEliminar)){
                    return true;
                }
            }
            
        }
        return false;
    }

        public StringBuilder listarContenido(String nombreDirectorio){
            Nodo directorio = buscarNodoPorNombre(raiz, nombreDirectorio);
            StringBuilder contenido = new StringBuilder();

            if(directorio == null || !directorio.getTipo().equals("DIRECTORIO")){
                contenido.append("DIRECTORIO NO ENCONTRADO O NO ES UN DIRECTORIO");
                return contenido;
            }

            if (directorio.getNumHijos() == 0){
                contenido.append("EL DIRECTORIO ESTA VACIO");
                return contenido;
            }

            for (Nodo hijo : directorio.getHijos()) { // Iteración simplificada con for-each
            if (hijo != null) {
                contenido.append(" [").append(hijo.getTipo().charAt(0)).append("] ").append(hijo.getNombre()).append("\n");
            }
        }
        return contenido;
    }
    
    public Nodo buscarNodoPorNombre(Nodo actual, String nombreBuscado) {
        if (actual == null) return null;
        
        if (actual.getNombre().equals(nombreBuscado)) {
            return actual;
        }

        if (actual.getHijos() != null) {
            for (Nodo hijo : actual.getHijos()) { // Iteración simplificada con for-each
                Nodo encontrado = buscarNodoPorNombre(hijo, nombreBuscado);
                if (encontrado != null) {
                    return encontrado;
                }
            }
        }
        return null;
    }

    // --- Recorridos ---
    
    public StringBuilder preOrden(Nodo nodo, StringBuilder recorrido) {
        if (nodo != null) {
            recorrido.append(nodo.getNombre()).append("(").append(nodo.getTipo().charAt(0)).append(") ");
            if (nodo.getHijos() != null) {
                for (Nodo hijo : nodo.getHijos()) {
                    preOrden(hijo, recorrido);
                }
            }
        }
        return recorrido;
    }
}
        


