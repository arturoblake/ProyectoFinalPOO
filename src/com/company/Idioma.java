// selecciona el idioma entre el ingles y el espniol
package com.company;

public class Idioma {
    public String idioma;
    public Idioma(String idioma) {
        this.idioma = idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getBienvenida() {
        String cadena = "Rock, Paper, Scissors!  This game is fairly simple.\nSimply pick your hands whenever you are ready.";
        if (idioma == "espaniol") {
            cadena = "¡Piedra, Papel o tijeras! Este juego es bastante simple.\n Simplemente elija sus manos cuando estés listo.";
        }
        return cadena;
    }
    public String getTitulo() {
        String cadena = "Rock Paper or Sciccors";
        if (idioma == "espaniol") {
            cadena = "Piedra Papel o Tijera";
        }
        return cadena;
    }
    public String getModoLuz() {
        String cadena = "Light Mode";
        if (idioma == "espaniol") {
            cadena = "Modo Luz";
        }
        return cadena;
    }
    public String getModoObscuro() {
        String cadena = "Dark Mode";
        if (idioma == "espaniol") {
            cadena = "Obscuro Luz";
        }
        return cadena;
    }
    public String getEmpate() {
        String cadena = "Tie: ";
        if (idioma == "espaniol") {
            cadena = "Empate: ";
        }
        return cadena;
    }
    public String getTotal() {
        String cadena = "Win / Total : ";
        if (idioma == "espaniol") {
            cadena = "Total: ";
        }
        return cadena;
    }
    public String getEleccionMaquina() {
        String cadena = "Computer's Choice";
        if (idioma == "espaniol") {
            cadena = "Eleccion Maquina";
        }
        return cadena;
    }
    public String getEleccionHumano() {
        String cadena = "Human's Choice";
        if (idioma == "espaniol") {
            cadena = "Eleccion Humano";
        }
        return cadena;
    }
    public String getComoJugar() {
        String cadena = "How to play!";
        if (idioma == "espaniol") {
            cadena = "Como Jugar";
        }
        return cadena;
    }
    public String getPapelGana() {
        String cadena = "Paper wins!";
        if (idioma == "espaniol") {
            cadena = "El papel gana!";
        }
        return cadena;
    }
    public String getPiedraGana() {
        String cadena = "Rock wins!";
        if (idioma == "espaniol") {
            cadena = "Piedra gana!";
        }
        return cadena;
    }
    public String getTijeraGana() {
        String cadena = "Scissors wins!";
        if (idioma == "espaniol") {
            cadena = "La Tijera gana!";
        }
        return cadena;
    }
    public String getEsEmpate() {
        String cadena = "It is a tie!";
        if (idioma == "espaniol") {
            cadena = "Es un empate!";
        }
        return cadena;
    }
    public String getJugadoGana() {
        String cadena = "   Human wins!";
        if (idioma == "espaniol") {
            cadena = "   El Jugador gana!";
        }
        return cadena;
    }
    public String getNadieGana() {
        String cadena = "   Nobody wins!";
        if (idioma == "espaniol") {
            cadena = "   El nadie gana!";
        }
        return cadena;
    }
    public String getMaquinaGana() {
        String cadena = "   Computer wins!";
        if (idioma == "espaniol") {
            cadena = "   La Computadora gana!";
        }
        return cadena;
    }
    public String getIdioma() {
        String cadena = "Español";
        if (idioma == "espaniol") {
            cadena = "English";
        }
        return cadena;
    }
}
