import java.util.Scanner;
import java.util.Random;

public class game {
    public static Random rand = new Random();
    public static Scanner scanner = new Scanner(System.in);
    public static String name;
    public static int hp = 20, attack = 6, potions = 2, defense = 1, crit = 1, spellPower = 0, defCounter = 2;
    public static int enemyHp = 25, enemyAttack = 10;
    public static int critRoll = 0, turn = 0;

    public static void main(String[] args) {


//        start
        System.out.println("         -|                  [-_-_-_-_-_-_-_-]                  |-\n" +
                "         [-_-_-_-_-]          |             |          [-_-_-_-_-]\n" +
                "          | o   o |           [  0   0   0  ]           | o   o |\n" +
                "           |     |    -|       |           |       |-    |     |\n" +
                "           |     |_-___-___-___-|         |-___-___-___-_|     |\n" +
                "           |  o  ]              [    0    ]              [  o  |\n" +
                "           |     ]   o   o   o  [ _______ ]  o   o   o   [     | ----__________\n" +
                "_____----- |     ]              [ ||||||| ]              [     |\n" +
                "           |     ]              [ ||||||| ]              [     |\n" +
                "       _-_-|_____]--------------[_|||||||_]--------------[_____|-_-_\n" +
                "      ( (__________------------_____________-------------_________) )\n");
        System.out.println("Walking out of the forest you come upon a castle. Do you want to enter? (y/n)");
        while (true) {
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                break;
            } else {
                System.out.println("Come back when you're ready for a challenge... ");
                System.out.println("Enter? (y/n)");
            }
        }

//        enter name
        System.out.println("As you push the heavy wooden door open, a voice booms from within... WHAT IS THY HERO'S NAME?");

        name = scanner.nextLine();


        System.out.print("\n" +
                "                                   ,','  >','  \\\\                  ,        \n" +
                "                                 ,','  ,','     \\\\            ,             \n" +
                "                               ,','  ,','        \\\\       ,                 \n" +
                "                             ,' /  ,' /           \\\\  ,                     \n" +
                "                            /  /  /  /             \\`<                      \n" +
                "                           /  /,-/  /,--------------\\/                      \n" +
                "                          /__'--/  (/--.                                    \n" +
                "          .-.     ____, '<.  / '   '   '----.                               \n" +
                "         ( . `. ,'    \\  '     .-------.  ` '--,                            \n" +
                "          \\_) ,'  (_.  \\      /         `-----<\\                            \n" +
                "          \\'   ,'', `.  \\   ,'   ,  '          `\\                           \n" +
                "         _/ _/',O)>   )  )_            ,'        >                          \n" +
                "     \\  (o /o) \\` )  /  /'\\`   `------<___   ,   )                          \n" +
                "      \\`-)| (/`,)\\`-'  /   `.          /   >-'    \\                         \n" +
                "       `-VvvV ,/( `---'\\     `       ,'   /`.      )                        \n" +
                "           / ,/\\    \\   `.    `          ' ,'`.   '\\                        \n" +
                "         (^^(/`      \\    `--<, ` --------' ,' `.   )                       \n" +
                "          ``` ________>  ,'   `-')  `      /     \\  |                       \n" +
                "     ,-------'        `  )   .--'     ,   /       \\  |_                     \n" +
                "   ,'/ _,--,--,,,-,______>   )     \\,    (_.-.     \\   ),---.               \n" +
                "  / ,\\ )                   ,'     ,'          \\ .--.\\,  .__, \\-.            \n" +
                " /_/ /\\)                  /      /             / )-.    /--`--) \\           \n" +
                "( )\\ ) `                 .      /             (-'   `--'      `--)          \n" +
                " \\' \\'                  ,      .                 )                          \n" +
                "                        ,     ,                ,'                           \n" +
                "                         `.  .               ,'`.                           \n" +
                "                        ,',` |              /-.  `.                         \n" +
                "                       ( (   |              \\  \\   `._                      \n" +
                "                        \\ \\  /             \\    \\     \\.                    \n" +
                "                         \\ \\  /          ,\\`-.   \\  ,'  )                   \n" +
                "                          \\ \\  /`--,--,-')   /    \\'   /                    \n" +
                "                           \\ `---------,'   /-.    \\\\,'                     \n" +
                "                            `--------,'    /-. \\                            \n" +
                "                                    /     /   ) )              \n" +
                "                                   (      > ,/ (_                           \n" +
                "                                  /`-,---'\\ |, ,'                           \n" +
                "                                  `-^-----' |,'\n");

        if (name.trim().equals("")) {
            System.out.println("Thou has taken a vow of silence... a formidable foe indeed.");
            name = "(angry stare)";
        } else {
            System.out.printf("Welcome, warrior %s!\n", name);
            System.out.println("Welcome to your DOOM!\n");
        }

        System.out.println("An enemy appears: Castle Guardian!\n");
        weapon();
        easy();
    }
//end of main

    //  attack
    public static void attack() {
        int dmg = rand.nextInt(attack);
        critRoll = rand.nextInt(11);

        if (dmg > 0 && critRoll <= crit) {
            dmg += 3;
            System.out.print(("\n" +
                    "       .-------.    ______\n" +
                    "      /   o   /|   /\\     \\\n" +
                    "     /_______/o|  /o \\  o  \\\n" +
                    "     | o     | | /   o\\_____\\\n" +
                    "     |   o   |o/ \\o   /o    /\n" +
                    "     |     o |/   \\ o/  o  /\n" +
                    "     '-------'     \\/____o/"));
            System.out.println("\nFortune has favored you! Critical damage inflicted.");
        } else if (dmg > 0) {
            System.out.println(name + " did " + dmg + " damage!");
        } else {
            System.out.println(name + "'s attack missed!");
        }

        enemyHp -= dmg;
    }

    public static void enemyAttack() {
        if (enemyHp < 10) {
            System.out.println("Castle Guardian is enraged! Enemy attack power increased.");
            enemyAttack = 13;
        }

        int dmg = rand.nextInt(enemyAttack) - defense;

        if (dmg > 0) {
            System.out.println("\nCastle Guardian did " + dmg + " damage!");
        } else {
            System.out.println("\nCastle Guardian's attack missed!");
        }

        hp -= dmg;
    }

    //defend
    public static void defend() {
        if (defCounter > 0) {
            defCounter--;
        }

        System.out.print("\n" +
                "  |`-._/\\_.-`|\n" +
                "  |    ||    |\n" +
                "  |___o()o___|\n" +
                "  |__((<>))__|\n" +
                "  \\   o\\/o   /\n" +
                "   \\   ||   /\n" +
                "    \\  ||  /\n" +
                "     '.||.'\n" +
                "       ``\n");
        System.out.println("Anticipating the enemy's moves, you raise your shield to defend.");

        if (enemyHp < 10) {
            System.out.println("Castle Guardian is enraged! Enemy attack power increased.");
            enemyAttack = 13;
        }

        int dmg = (rand.nextInt(enemyAttack) - defense) - 4;

        if (dmg > 0) {
            System.out.println("\nCastle Guardian did " + dmg + " damage!");
        } else {
            System.out.println("\nCastle Guardian's attack missed!");
        }

        hp -= dmg;
    }


    //    potion
    public static void potion() {
        if (potions == 0) {
            System.out.println("\nYour potions are empty! Pay attention to your inventory!");
        } else {
            hp += 10;
            potions--;
            System.out.print("\n" +
                    "      _____\n" +
                    "     `.___,'\n" +
                    "      (___)\n" +
                    "      <   >\n" +
                    "       ) (\n" +
                    "      /`-.\\\n" +
                    "     /     \\\n" +
                    "    / _    _\\\n" +
                    "   :,' `-.' `:\n" +
                    "   |         |\n" +
                    "   :         ;\n" +
                    "    \\       /\n" +
                    "     `.___.'\n");
            System.out.printf("\nYou consumed a healing potion. Your HP is increased by 10! %s's HP is now %d.\n", name, hp);
        }

    }

    //weapon
    public static void weapon() {
        System.out.println("Quick! Arm yourself!\n");
        System.out.printf("|%-13s|%-13s|%-13s|%n", "a.  Sword (+atk)", "b.  Axe (+HP)", "c. Mace (+def)");

        switch (scanner.nextLine().toLowerCase()) {
            case "a":
                crit += 1;
                System.out.print(
                        "         /|\\\n" +
                                "         |||\n" +
                                "         |||\n" +
                                "         |||\n" +
                                "         |||\n" +
                                "         |||\n" +
                                "         |||\n" +
                                "      ~-[{o}]-~\n" +
                                "         |/|\n" +
                                "         |/|\n" +
                                "         `0`\n");
                System.out.println("\nYou selected the sword. Strike true valiant hero!\n");
                break;
            case "b":
                attack += 2;
                System.out.print("\n" +
                        "   _    _\n" +
                        " //'-||-'\\\n" +
                        "(| -=||=- |)\n" +
                        " \\.-||-.//\n" +
                        "  '  ||  '\n" +
                        "     ||\n" +
                        "     ||\n" +
                        "     ||\n" +
                        "     ||\n" +
                        "     ||\n");
                System.out.println("You equipped the axe. Enemies be wary of your bloodlust!\n");
                break;
            case "c":
                defense += 1;
                System.out.print("\n" +
                        "          |\\\n" +
                        "          | \\        /|\n" +
                        "          |  \\____  / |\n" +
                        "         /|__/AMMA\\/  |\n" +
                        "       /AMMMMMMMMMMM\\_|\n" +
                        "   ___/AMMMMMMMMMMMMMMA\n" +
                        "   \\   |MVKMMM/ .\\MMMMM\\\n" +
                        "    \\__/MMMMMM\\  /MMMMMM---\n" +
                        "    |MMMMMMMMMMMMMMMMMM|  /\n" +
                        "    |MMMM/. \\MM.--MMMMMM\\/\n" +
                        "    /\\MMM\\  /MM\\  |MMMMMM   ___\n" +
                        "   /  |MMMMMMMMM\\ |MMMMMM--/   \\-.\n" +
                        "  /___/MMMMMMMMMM\\|MM--M/___/_|   \\\n" +
                        "       \\VMM/\\MMMMMMM\\  |      /\\ \\/\n" +
                        "        \\V/  \\MMMMMMM\\ |     /_  /\n" +
                        "          |  /MMMV'   \\|    |/ _/\n" +
                        "          | /              _/  /\n" +
                        "          |/              /| \\'\n" +
                        "                         /_  /\n" +
                        "                         /  / ");
                System.out.println("\nYou slowly raise your mace. Make each heavy blow count!\n");
                break;
            default:
                weapon();
                break;
        }

    }

    public static void defeat() {
        System.out.println("                                             ,--,  ,.-.\n" +
                "               ,                   \\,       '-,-`,'-.' | ._\n" +
                "              /|           \\    ,   |\\         }  )/  / `-,',\n" +
                "              [ ,          |\\  /|   | |        /  \\|  |/`  ,`\n" +
                "              | |       ,.`  `,` `, | |  _,...(   (      .',\n" +
                "              \\  \\  __ ,-` `  ,  , `/ |,'      Y     (   /_L\\\n" +
                "               \\  \\_\\,``,   ` , ,  /  |         )         _,/\n" +
                "                \\  '  `  ,_ _`_,-,<._.<        /         /\n" +
                "                 ', `>.,`  `  `   ,., |_      |         /\n" +
                "                   \\/`  `,   `   ,`  | /__,.-`    _,   `\\\n" +
                "               -,-..\\  _  \\  `  /  ,  / `._) _,-\\`       \\\n" +
                "                \\_,,.) /\\    ` /  / ) (-,, ``    ,        |\n" +
                "               ,` )  | \\_\\       '-`  |  `(               \\\n" +
                "              /  /```(   , --, ,' \\   |`<`    ,            |\n" +
                "             /  /_,--`\\   <\\  V /> ,` )<_/)  | \\      _____)\n" +
                "       ,-, ,`   `   (_,\\ \\    |   /) / __/  /   `----`\n" +
                "      (-, \\           ) \\ ('_.-._)/ /,`    /\n" +
                "      | /  `          `/ \\\\ V   V, /`     /\n" +
                "   ,--\\(        ,     <_/`\\\\     ||      /\n" +
                "  (   ,``-     \\/|         \\-A.A-`|     /\n" +
                " ,>,_ )_,..(    )\\          -,,_-`  _--`\n" +
                "(_ \\|`   _,/_  /  \\_            ,--`\n" +
                " \\( `   <.,../`     `-.._   _,-`\n");
        System.out.println("The beast has overtaken you, your journey has reached its end!");
    }

    public static void win() {
        System.out.print("\n" +
                "      __/\\__ \n" +
                "      \\    /   \n" +
                "__/\\__/    \\__/\\__\n" +
                "\\                /\n" +
                "/_              _\\\n" +
                "  \\  VICTORY!!  /\n" +
                "__/            \\__ \n" +
                "\\                /\n" +
                "/_  __      __  _\\\n" +
                "  \\/  \\    /  \\/\n" +
                "      /_  _\\\n" +
                "        \\/");
        System.out.println("Enemy has been slain! You are victorious!");
    }

    //  easy enemy
    public static void easy() {
        turn++;
        spellPower++;
        String choice;


        System.out.println("Enter an action.");
        if (spellPower >= 6) {
            System.out.printf("|%-13s|%-13s|%-13s|%-13s|%n", "a.  Attack", "d.  Defend (" + defCounter + ")", "p. Potion (" + potions + ")", "s.  Kiss of Death!");
        } else {
            System.out.printf("|%-13s|%-13s|%-13s|%n", "a.  Attack", "d.  Defend (" + defCounter + ")", "p. Potion (" + potions + ")");
        }

        choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("a")) {
            enemyAttack();
            if (hp <= 0) {
                defeat();
            } else {
                System.out.println("Your HP is: " + hp + "\n");
                attack();
                if (enemyHp <= 0) {
                    win();
                } else {
                    System.out.println("Enemy HP is: " + enemyHp + "\n");
                    easy();
                }
            }
        } else if (choice.equalsIgnoreCase("p")) {
            potion();
            enemyAttack();
            if (hp <= 0) {
                defeat();
            } else {
                System.out.println("Your HP is: " + hp + "\n");
                easy();
            }

        } else if (choice.equalsIgnoreCase("d") && defCounter > 0) {
            defend();
            if (hp <= 0) {
                defeat();
            } else {
                System.out.println("Your HP is: " + hp + "\n");
                easy();
            }
        } else if (choice.equalsIgnoreCase("s") && spellPower >= 6) {
            enemyHp = 1;
            spellPower = 0;
            System.out.println("              ...                            \u0003\n" +
                    "             ;::::;                           \u0003\n" +
                    "           ;::::; :;                          \u0003\n" +
                    "         ;:::::'   :;                         \u0003\n" +
                    "        ;:::::;     ;.                        \u0003\n" +
                    "       ,:::::'       ;           OOO\\         \u0003\n" +
                    "       ::::::;       ;          OOOOO\\        \u0003\n" +
                    "       ;:::::;       ;         OOOOOOOO       \u0003\n" +
                    "      ,;::::::;     ;'         / OOOOOOO      \u0003\n" +
                    "    ;:::::::::`. ,,,;.        /  / DOOOOOO    \u0003\n" +
                    "  .';:::::::::::::::::;,     /  /     DOOOO   \u0003\n" +
                    " ,::::::;::::::;;;;::::;,   /  /        DOOO  \u0003\n" +
                    ";`::::::`'::::::;;;::::: ,#/  /          DOOO \u0003\n" +
                    ":`:::::::`;::::::;;::: ;::#  /            DOOO\u0003\n" +
                    "::`:::::::`;:::::::: ;::::# /              DOO\u0003\n" +
                    "`:`:::::::`;:::::: ;::::::#/               DOO\u0003\n" +
                    " :::`:::::::`;; ;:::::::::##                OO\u0003\n" +
                    " ::::`:::::::`;::::::::;:::#                OO\u0003\n" +
                    " `:::::`::::::::::::;'`:;::#                O \u0003\n" +
                    "  `:::::`::::::::;' /  / `:#                  \u0003\n" +
                    "   ::::::`:::::;'  /  /   `#              ");
            System.out.println("This fight has gone on long enough... KISS OF DEATH!!!");
            System.out.println("ENEMY HP HAS BEEN REDUCED TO 1! FINISH HIM!\n");
            enemyAttack();
            if (hp <= 0) {
                defeat();
            } else {
                System.out.println("Your HP is: " + hp + "\n");
                easy();
            }
        } else {
            System.out.println("Misfire! You fumbled your spell.");
            enemyAttack();
            if (hp <= 0) {
                defeat();
            } else {
                System.out.println("Your HP is: " + hp + "\n");
                easy();
            }
        }
    }
}
