package model.game;

public class Question {

    private String frage;
    private String antwort;

    public Question(String frage, String antwort) {
        this.frage = frage;
        this.antwort = antwort;
    }

    public String getFrage() {
        return frage;
    }

    public String getAntwort() {
        return antwort;
    }
}
