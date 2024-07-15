import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {
    private static HeroArena arena;

    public static void main(String[] args) throws IOException {
        // Setup program to read user input.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input; // The user's input.
        String heroChoice1; // The first Hero chosen by the user.
        String heroChoice2; // The second Hero chosen by the user.
        int menuChoice; // The menu option chosen by the user.

        // Set up the hero arena:
        arena = new HeroArena();

        //print the menu options
        System.out.println("As master of the intergalactic arena, you may choose two superheroes to fight against each"
                + " other. You may also view their hero information.\nPlease select an option:");

        System.out.println("1: Choose two Superheroes to battle");
        System.out.println("2: List all Superhero");
        System.out.println("3: EXIT");

        while (true) // Loop until the user chooses a valid menu option.
        {
            try {
                input = br.readLine();
                menuChoice = Integer.parseInt(input);

                if (menuChoice <= 0 || menuChoice > 2) {
                    System.out.println("Please choose either 1 or 2 or 3.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer.");
            }
        }

        do {
            switch (menuChoice) {
                case 1: {
                    // List the Superheroes that the user can choose from.
                    System.out.println(
                            "Please choose from the following Superheroes: " +
                                    arena.getHeroAbbreviations());

                    heroChoice1 = br.readLine().toUpperCase();
                    Superhero hero1 = arena.getHero(heroChoice1);

                    // Loop until the user has entered a valid abbreviated heros' name.
                    while (hero1 == null) {
                        System.out.println(
                                "Please choose one of the Superheroes listed.");

                        heroChoice1 = br.readLine().toUpperCase();
                        hero1 = arena.getHero(heroChoice1);
                    }

                    System.out.printf("You choose %s.\n", hero1);

                    // List the Superheroes that the user can choose from.
                    System.out.println(
                            "Please choose another hero from the following Superheroes: " +
                                    arena.getHeroAbbreviations());

                    heroChoice2 = br.readLine().toUpperCase();
                    Superhero hero2 = arena.getHero(heroChoice2);

                    // Loop until the user has entered a valid abbreviated heros' name.
                    while (hero2 == null) {
                        System.out.println(
                                "Please choose one of the Superheroes listed.");

                        heroChoice2 = br.readLine().toUpperCase();
                        hero2 = arena.getHero(heroChoice2);
                    }

                    System.out.printf("You choose %s.\n", hero2);

                    // Battle the superheroes and print the result:

                    Superhero victor = (arena.battleHeroes(hero1, hero2));

                    if (victor == null) {
                        System.out.println("The battle was a tie!");
                    } else {
                        System.out.printf("%s was the victor!", victor.name().toLowerCase());
                    }

                    break;
                }

                case 2: {
                    //List the superheroes:
                    System.out.println(arena.listHeroes());

                    break;
                }
                case 3:
                    break;
            }
        } while (menuChoice == 3);
    }
}