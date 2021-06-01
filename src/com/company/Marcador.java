package com.company;
public class Marcador {
    private int puntuacion_jugador;
    private int puntuacion_ganadora = 0;
    private int puntuacion_total = 0;
    private int puntuacion_empate = 0;
    public Marcador() {}

    public int getPuntuacion_jugador() {
        return puntuacion_jugador;
    }

    public void setPuntuacion_jugador(int puntuacion_jugador) {
        this.puntuacion_jugador = puntuacion_jugador;
    }

    public int getPuntuacion_ganadora() {
        return puntuacion_ganadora;
    }

    public void setPuntuacion_ganadora(int puntuacion_ganadora) {
        this.puntuacion_ganadora = puntuacion_ganadora;
    }

    public int getPuntuacion_total() {
        return puntuacion_total;
    }

    public void setPuntuacion_total(int puntuacion_total) {
        this.puntuacion_total = puntuacion_total;
    }

    public int getPuntuacion_empate() {
        return puntuacion_empate;
    }

    public void setPuntuacion_empate(int puntuacion_empate) {
        this.puntuacion_empate = puntuacion_empate;
    }

    public void addPuntuacion_empate(int puntuacion_empate) {
        this.puntuacion_empate += puntuacion_empate;
    }

    public void addPuntuacion_ganadora(int puntuacion_ganadora) {
        this.puntuacion_ganadora += puntuacion_ganadora;
    }

    public void addPuntuacion_total(int puntuacion_total) {
        this.puntuacion_total += puntuacion_total;
    }
}
