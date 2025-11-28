package org.iesalandalus.programacion.robot.vista;

import org.iesalandalus.programacion.robot.modelo.ControladorRobot;
import org.iesalandalus.programacion.robot.modelo.Coordenada;
import org.iesalandalus.programacion.robot.modelo.Orientacion;
import org.iesalandalus.programacion.robot.modelo.Zona;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

    private Consola() {
    }

    public static void mostrarMenuPrincipal() {
        System.out.println("Programa");
    }

    public static int elegirOpcion() {
        int opcion;
        do {
            System.out.println();
            opcion = Entrada.entero();
        } while (opcion)
    }

    public static Zona elegirZona() {
        Zona zona = null;
        do {
            System.out.println("Indica el ancho de la zona: ");
            int ancho = Entrada.entero();
            System.out.println("Indica el alto de la zona: ");

        }
    }

    public static Orientacion elegirOrientacion() {
        int orientacion;
        do {
            System.out.println("Elige la orientación (0-7): ");
            orientacion = Entrada.entero();
        } while (orientacion < 0 || orientacion > 7);
        return switch (orientacion) {
            case NORTE -> Orientacion.NORTE;
            case NORESTE -> Orientacion.NORESTE;
            case ESTE -> Orientacion.ESTE;
            case SURESTE -> Orientacion.SURESTE;
            case SUR -> Orientacion.SUR;
            case SUROESTE -> Orientacion.SUROESTE;
            case OESTE -> Orientacion.OESTE;
            case NOROESTE -> Orientacion.NOROESTE;
            default -> null;
        };
    }

    public static Coordenada elegirCoordenada() {
        System.out.println("Indica la X de la coordenada: ");
        int x = Entrada.entero();
        System.out.println("Indica la Y de la coordenada: ");
        int y = Entrada.entero();
    }

    public static char elegirComando() {
        System.out.println("Indica el comando a ejecutar: ");
        return Entrada.caracter();
    }

    public static void mostrarRobot(ControladorRobot controladorRobot){
        System.out.println();
        Objects.requireNonNull(controladorRobot, "Aun no se ha creado ningún robot que controla");
        System.out.println(controladorRobot.getRobot());
        System.out.println();
    }

    public static void despedirse() {
        System.out.println();
        System.out.println("Hasta luego lucas!!!");
    }

}
