package org.iesalandalus.programacion.robot.modelo;

import java.util.Objects;

public class Robot {
    private Zona zona;
    private Coordenada coordenada;
    private Orientacion orientacion;

    public Robot() {
        zona = new Zona();
        coordenada = zona.getCentro();
        orientacion = Orientacion.NORTE;
    }

    public Robot(Zona zona) {
        this();
        setZona(zona);
        orientacion = Orientacion.NORTE;
        coordenada = zona.getCentro();
    }

    public Robot(Zona zona, Orientacion orientacion) {
        this(zona);
        setOrientacion(orientacion);
        setCoordenada(zona.getCentro());
    }

    public Robot(Zona zona, Orientacion orientacion, Coordenada coordenada) {
        this(zona, orientacion);
        setCoordenada(coordenada);
    }

    public Robot(Robot robot) {
        Objects.requireNonNull(robot, "El robot no puede ser nulo.");
        zona = robot.getZona();
        coordenada  = robot.getCoordenada();
        orientacion = robot.getOrientacion();
    }

    public Zona getZona() {
        return zona;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }

    private void setZona(Zona zona) {
        Objects.requireNonNull(zona, "La zona no puede ser nula.");
        this.zona = zona;
    }

    private void setOrientacion(Orientacion orientacion) {
        Objects.requireNonNull(orientacion, "La orientación no puede ser nula.");
        this.orientacion = orientacion;
    }

    private void setCoordenada(Coordenada coordenada) {
        Objects.requireNonNull(coordenada, "La coordenada no puede ser nula.");
        if (zona.pertenece(coordenada)) {
            this.coordenada = coordenada;
        } else {
            throw new IllegalArgumentException("La coordenada no pertenece a la zona.");
        }
    }

    public void avanzar() throws RobotExcepcion {
        try {
            switch (orientacion) {
                case NORTE -> setCoordenada(new Coordenada(coordenada.x(), coordenada.y() + 1));
                case NORESTE -> setCoordenada(new Coordenada(coordenada.x() + 1, coordenada.y() + 1));
                case ESTE -> setCoordenada(new Coordenada(coordenada.x() + 1, coordenada.y()));
                case SURESTE -> setCoordenada(new Coordenada(coordenada.x() + 1, coordenada.y() - 1));
                case SUR -> setCoordenada(new Coordenada(coordenada.x(), coordenada.y() - 1));
                case SUROESTE -> setCoordenada(new Coordenada(coordenada.x() - 1, coordenada.y() - 1));
                case OESTE -> setCoordenada(new Coordenada(coordenada.x() - 1, coordenada.y()));
                case NOROESTE -> setCoordenada(new Coordenada(coordenada.x() - 1, coordenada.y() + 1));
            }
        } catch (IllegalArgumentException iae) {
            throw new RobotExcepcion("No se puede avanzar, ya que se sale de la zona.");
        }
    }

    public void girarALaDerecha() {
        switch (orientacion) {
            case NORTE -> orientacion = Orientacion.NORESTE;
            case NORESTE-> orientacion = Orientacion.ESTE;
            case ESTE -> orientacion = Orientacion.SURESTE;
            case SURESTE -> orientacion = Orientacion.SUR;
            case SUR -> orientacion = Orientacion.SUROESTE;
            case SUROESTE -> orientacion = Orientacion.OESTE;
            case OESTE -> orientacion = Orientacion.NOROESTE;
            case NOROESTE -> orientacion = Orientacion.NORTE;
        }
    }

    public void girarALaIzquierda() {
        switch (orientacion) {
            case NORTE -> orientacion = Orientacion.NOROESTE;
            case NOROESTE -> orientacion = Orientacion.OESTE;
            case OESTE -> orientacion = Orientacion.SUROESTE;
            case SUROESTE -> orientacion = Orientacion.SUR;
            case SUR -> orientacion = Orientacion.SURESTE;
            case SURESTE -> orientacion = Orientacion.ESTE;
            case ESTE -> orientacion = Orientacion.NORESTE;
            case NORESTE-> orientacion = Orientacion.NORTE;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Robot robot)) return false;
        return Objects.equals(zona, robot.zona) && Objects.equals(coordenada, robot.coordenada) && orientacion == robot.orientacion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(zona, coordenada, orientacion);
    }

    @Override
    public String toString() {
        return "Robot{" +
                "zona=" + zona +
                ", coordenada=" + coordenada +
                ", orientacion=" + orientacion +
                '}';
    }
}
