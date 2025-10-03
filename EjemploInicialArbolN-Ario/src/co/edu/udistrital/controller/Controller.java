package co.edu.udistrital.controller;

import co.edu.udistrital.model.ArbolNario;
import co.edu.udistrital.model.Nodo;
import co.edu.udistrital.view.VistaConsola;

public class Controller {
    
    private VistaConsola vista;
    private ArbolNario explorador;


    public Controller(){
        vista = new VistaConsola();
        explorador = new ArbolNario("RAIZ");
    }

    public void run(){

        estructuraInicial();

        vista.mostrarInformacion("\n Estrutctura inicial");
        vista.mostrarArbol(explorador.getRaiz(), "");


        ejecutarOperaciones();

    }

    private void estructuraInicial(){
        explorador.crearElemento("RAIZ", "Documentos", "DIRECTORIO");
        explorador.crearElemento("RAIZ", "Imagenes", "DIRECTORIO");
        explorador.crearElemento("RAIZ", "Musica", "DIRECTORIO");

        explorador.crearElemento("Documentos", "Tareas", "DIRECTORIO");
        explorador.crearElemento("Documentos", "Proyecto1.docx", "ARCHIVO");
        explorador.crearElemento("Documentos", "Proyecto2.docx", "ARCHIVO");

        explorador.crearElemento("Imagenes", "Foto1.png", "ARCHIVO");
        explorador.crearElemento("Imagenes", "Foto2.jpg", "ARCHIVO");

        explorador.crearElemento("Musica", "Cancion1.mp3", "ARCHIVO");
        explorador.crearElemento("Musica", "Cancion2.wav", "ARCHIVO");
        
        explorador.crearElemento("Videos", "Video1.mp4", "ARCHIVO");
        explorador.crearElemento("Videos", "Video2.avi", "ARCHIVO");
    }


    private void ejecutarOperaciones(){

        vista.mostrarInformacion("\n Listar contenido de Documentos:");
        vista.mostrarInformacion(explorador.listarContenido("Documentos").toString());

        vista.mostrarInformacion("\n Busqueda de 'Foto1.png':");
        Nodo encontrado = explorador.buscarNodoPorNombre(explorador.getRaiz(), "Foto1.png");
        if (encontrado != null){
            vista.mostrarInformacion("Elemento encontrado: " + encontrado.getNombre() + "  Tipo: " + encontrado.getTipo());

        } else{
            vista.mostrarInformacion("Elemento no encontrado");
        }

        vista.mostrarInformacion("\n Crear nuevo directorio en Musica: ");
        if (explorador.crearElemento("Musica", "Canciones Favoritas", "DIRECTORIO")){
            vista.mostrarInformacion("\n Directorio creado exitosamente");
        }

        vista.mostrarInformacion("\n Mostrar arbol luego de la adicion: ");
        vista.mostrarArbol(explorador.getRaiz(), "");


        vista.mostrarInformacion("\nElimninar directorio: ");
        if (explorador.eliminarElemento("Videos")){
            vista.mostrarInformacion("Directorio eliminado exitosamente");
        } else {
            vista.mostrarInformacion("No se pudo eliminar el directorio");
        }

        vista.mostrarInformacion("\n Arbol luego de eliminacion: ");
        vista.mostrarArbol(explorador.getRaiz(), "");
}
}

    
