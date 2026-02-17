package model.game;

public class HangmanLogic {

    private String wort;
    private int fehler;

    public HangmanLogic(String wort){
        this.wort = wort.toLowerCase();
        fehler = 0;
    }

    public boolean pruefe(String input){
        if(input.toLowerCase().equals(wort)){
            return true;
        } else {
            fehler++;
            return false;
        }
    }

    public int getFehler(){ return fehler; }

    public boolean gameOver(){ return fehler >= 6; }

    public String getWort(){ return wort; }
}
