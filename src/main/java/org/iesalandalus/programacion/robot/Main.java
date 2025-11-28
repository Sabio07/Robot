package org.iesalandalus.programacion.robot;

import org.iesalandalus.programacion.robot.modelo.*;
import org.iesalandalus.programacion.robot.vista.Consola;

public class Main {
    public static ControladorRobot controladorRobot;

    public static void main(String[] args) {
        int opcion;
        do {
            Consola.mostrarMenuPrincipal();
            opcion = Consola.elegirOpcion();
            if (opcion != 0) {
                ejecutarOpcion(opcion);
                Consola.mostrarRobot(controladorRobot);
            }
        } while (opcion != 0);
        Consola.despedirse();
    }

    public static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> controladorRobotDefecto();
            case 2 -> controladorRobotZona();
            case 3 -> controladorRobotZonaOrientacion();
            case 4 -> controladorRobotZonaOrientacionCoordenada();
            case 5 -> ejecutarComando();
            default -> {/*No hacer nada*/}
        }
    }

    private static void controladorRobotDefecto() { controladorRobot = new ControladorRobot(new Robot());}

    private static void controladorRobotZona() {
        controladorRobot = new ControladorRobot(new Robot(Consola.elegirZona()));
    }

    private static void controladorRobotZonaOrientacion() {
        Zona zona = Consola.elegirZona();
        //Consola.mostrarMenuOrientacion();
        Orientacion orientacion = Consola.elegirOrientacion();
        Coordenada coordenada = Consola.elegirCoordenada();
        try {
            controladorRobot = new ControladorRobot(new Robot(zona, orientacion, coordenada));
        } catch (IllegalArgumentException iae) {
            System.out.println("ERROR: "+ iae.getMessage());
        }
    }

    private static void controladorRobotZonaOrientacionCoordenada() {
        Zona zona = Consola.elegirZona();
        //Consola.mostrarMenuOrientacion();
        Orientacion orientacion = Consola.elegirOrientacion();
        Coordenada coordenada = Consola.elegirCoordenada();
        try {
            controladorRobot = new ControladorRobot(new Robot(zona, orientacion, coordenada));
        } catch (IllegalArgumentException iae) {
            System.out.println("ERROR: "+ iae.getMessage());
        }
    }

    private static void ejecutarComando() {
        if (controladorRobot != null) {
            try {
                controladorRobot.ejecutar(Consola.elegirComando());
            } catch (RobotExcepcion re) {
                System.out.println("Error: " + re.getMessage());
            }
        }
    }
}
