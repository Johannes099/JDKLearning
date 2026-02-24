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

        // Einzelner Buchstab
        if(input.length() == 1){

            char c = input.charAt(0);
            boolean gefunden = false;

            for(int i = 0; i < buchstaben.length; i++){
                if(buchstaben[i] == c){
                    sichtbar[i] = true;
                    gefunden = true;
                }
            }

            if(!gefunden){
                fehler++;
            }

            return gefunden;
        }

        // Mehrere Buchstaben
        boolean wortRichtig = input.equals(wort);

        for(int j = 0; j < input.length(); j++){

            char c = input.charAt(j);

            for(int i = 0; i < buchstaben.length; i++){
                if(buchstaben[i] == c){
                    sichtbar[i] = true;
                }
            }
        }

        if(!wortRichtig){
            fehler++;
        }

        return wortRichtig;
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
