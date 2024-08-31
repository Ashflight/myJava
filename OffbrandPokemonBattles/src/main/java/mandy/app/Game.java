package mandy.app;

public class Game {
    public static void main(String[] args) {
        //this will be place for game loop
        //also looking at my design SCREW ABILITIES they're going to be pain to add

        //testing
        Pokemon sylveon = new Pokemon("Sylveon");
        System.out.println("Sylveon's moves: " + sylveon.getPokemonData().getMoves());
        System.out.println("Sylveon's HP: " + sylveon.getPokemonData().getHp());
    }
}