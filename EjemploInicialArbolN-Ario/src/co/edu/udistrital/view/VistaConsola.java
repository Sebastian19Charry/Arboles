package co.edu.udistrital.view;

import java.util.Scanner;

import co.edu.udistrital.model.Nodo;

public class VistaConsola {

	private Scanner sc;
	
	public VistaConsola() {
		sc = new Scanner(System.in);
	}
	
	public void mostrarInformacion(String mensaje) {
		System.out.println(mensaje);
	}
	
	public String leerDato(String mensaje) {
		System.out.println(mensaje);
		String dato = sc.nextLine();
		return dato;
	}
	
	public void mostrarArbol(Nodo nodo, String prefijo) {
        if (nodo != null) {
            System.out.println(prefijo + "[" + nodo.getTipo().charAt(0) + "] " + nodo.getNombre());
            
			if (nodo.getHijos() != null){

				for (int i = 0; i <nodo.getNumHijos(); i++) {
					mostrarArbol(nodo.getHijos().get(i), prefijo + " |--  ");

				}
			}
        }
    }

    public void imprimirRecorrido(String tipo, String recorrido) {
        System.out.println("Recorrido " + tipo + ": " + recorrido);
    }
	
}
