package model.game;

public class HangmanLogic {

    private String wort;
    private char[] buchstaben;
    private boolean[] sichtbar;
    private int fehler;

    public HangmanLogic(String wort){
        this.wort = wort.toLowerCase();
        this.buchstaben = this.wort.toCharArray();
        this.sichtbar = new boolean[buchstaben.length];
        this.fehler = 0;
    }

    public boolean pruefe(String input){

        input = input.toLowerCase();
        boolean allesRichtig = true;

        for(int j = 0; j < input.length(); j++){

            char c = input.charAt(j);
            boolean buchstabeGefunden = false;

            for(int i = 0; i < buchstaben.length; i++){
                if(buchstaben[i] == c){
                    sichtbar[i] = true;
                    buchstabeGefunden = true;
                }
            }

            if(!buchstabeGefunden){
                allesRichtig = false;
            }
        }

        // Wenns nicht genau das Wort ist, dann zählt es als Felhler
        if(!input.equals(wort)){
            fehler++;
        }

        return allesRichtig;
    }

    public String getAnzeige(){

        String text = "";

        for(int i = 0; i < buchstaben.length; i++){

            if(buchstaben[i] == ' '){
                text += "  ";
            }
            else if(sichtbar[i]){
                text += buchstaben[i] + " ";
            }
            else{
                text += "_ ";
            }
        }

        return text;
    }

    public boolean geloest(){

        for(int i = 0; i < buchstaben.length; i++){
            if(buchstaben[i] != ' ' && !sichtbar[i]){
                return false;
            }
        }

        return true;
    }

    public int getFehler(){
        return fehler;
    }

    public boolean gameOver(){
        return fehler >= 6;
    }

    public String getWort(){
        return wort;
    }
}
