import java.util.Scanner;
import java.util.ArrayList;
public class Main {
static Scanner read_n = new Scanner(System.in);
static Scanner read_s = new Scanner(System.in);
    public static void main(String[] args) throws Exception {

        cleanScreen();
        int opCrud = 0;
        ArrayList<Contacts> players = new ArrayList<>();
        boolean out = false;
        players.add(new Contacts("Bellingham", 6, "Masculine", "Real Madrid"));
        players.add(new Contacts("Yamal", 19, "Masculine", "FC Barcelona"));
        players.add(new Contacts("Putellas", 11, "Femenine", "FC Barcelona"));
    
        while (!out) {
            cleanScreen();
            System.out.println("|| OPTIONS ||");
            System.out.println("1. Add player.");
            System.out.println("2. List players.");
            System.out.println("3. Update player.");
            System.out.println("4. Delete player.");
            System.out.println("5. Get out of the system.");
            System.out.print("Choose an option please: ");
            do{
                while (!read_n.hasNextInt()) {
                    System.out.println("Enter a number, not characters.");
                    read_n.next();
                }
                opCrud = read_n.nextInt();
                if (opCrud < 0) {
                    System.out.println("The option can't be negative.");
                } if (opCrud == 0) {
                    System.out.println("The option can't be equal to zero.");
                }
            }while(opCrud <= 0);    


            switch (opCrud) {

                case 1:
                addPlayer(players);
                pauseScreen();
                break; 
            
                case 2:
                toListPlayers(players);
                pauseScreen();
                break;
                
                case 3:
                updatePlayer(players);
                pauseScreen();
                break;

                case 4:
                deletePlayer(players);
                pauseScreen();
                break;

            }
            if (opCrud >= 5) {
                out = true;
                showOut();
            }
        }
    }

    public static void pauseScreen(){
        System.out.println("\t\n ¡PRESS ENTER FOR CONTINUE!");
        read_s.nextLine();
        }

    public static void cleanScreen(){
        try{
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
        Process startProcess = pb.inheritIO().start();
        startProcess.waitFor();
        }catch(Exception e){
        System.out.println(e);
        }
        }

    public static void showOut(){
            cleanScreen();
            System.out.println("    || B Y E , B Y E ||");
            System.out.println("____________________________");
            System.out.println("¡Thanks for used the system!");
            System.out.println("");
        }

    public static void addPlayer(ArrayList<Contacts> players){
        cleanScreen();
        String LastName; String Sex; String soccerTeam;
        int number; int Op = 0;
       
        System.out.println("||  A D D   P L A Y E R ||");
        System.out.println("__________________________");
        System.out.print("1. Enter a last name: ");
        LastName = read_s.nextLine();
        do{
            System.out.print("2. Enter a number shirt: ");
            while (!read_n.hasNextInt()) {
                System.out.println("Enter a number, not character");
                read_n.next();
            }
            number = read_n.nextInt();

        if (number < 0) {
            System.out.println("The number can't be negative!");
        } if (number == 0) {
            System.out.println("The number can't be equal to zero!");
        } if (number > 100) {
            System.out.println("The number can't be older that 100");
        }
        }while(number <= 0 || number >= 100);

        do{
            System.out.print("3. Soccer team: ");
            soccerTeam = read_s.nextLine();
            if (soccerTeam.length() < 4) {
                System.out.println("¡The name is invalid!");
            }
        }while(soccerTeam.length() < 4);

        System.out.print("4. Sex: \nChoose (1) for masculine. \nChoose (2) for femenine.");
        do{
            System.out.println("");
            System.out.print("Option -> ");
            while (!read_n.hasNextInt()) {
                System.out.println("Enter a number, not characters!");
                read_n.next();
            }
            Op = read_n.nextInt();

            if (Op < 0) {
                System.out.println("¡The option can't be negative!");
            } if (Op == 0) {
                System.out.println("¡The option can't be equal to zero!");
            } if (Op > 2) {
                System.out.println("¡The option can't older that 2!");
            }
            }while(Op <= 0 || Op > 2);
            
            if (Op == 1) {
               Sex = "Masculine";
               verifyPlayer(players, LastName, number, soccerTeam, Sex);
            } else {
                Sex = "Femenine";
                verifyPlayer(players, LastName, number, soccerTeam, Sex);
            }
            
    }

    public static void verifyPlayer(ArrayList<Contacts> players, String LastName, int number, String soccerTeam, String Sex){
       boolean playerExist = false;
        for(int i = 0; i < players.size(); i++){
        
        if (players.get(i).GetLastName().equalsIgnoreCase(LastName) && players.get(i).GetNumberSoccer() == number && players.get(i).GetSoccerTeam().equalsIgnoreCase(soccerTeam) && players.get(i).GetSex().equals(Sex)) {
            playerExist = true;
        }
       }

     if (!playerExist) {
        players.add(new Contacts(LastName, number, Sex, soccerTeam));
        System.out.println("__________________________________________");
        System.out.println("¡"+LastName + " was registered at the system!");
     } else {
        System.out.println("¡"+LastName + " already is registered at the system!");
     }

    //Key Method. 
    }

    public static void toListPlayers(ArrayList<Contacts> players){
        cleanScreen();
        System.out.println("          || L I S T  -  P L A Y E R S || ");
        System.out.println("");
        for(Contacts i: players){
            System.out.println(i);
            System.out.println("-----------------------------------------------------------------------------");
        }
    

   

    }

    public static void updatePlayer(ArrayList<Contacts> players){
        cleanScreen();
     String newSoccerTeam; String LastName; String soccerTeam;
       int newNumber = 0; int op = 0; int number = 0; int opSex = 0; int opChange = 0;


        System.out.println(" || S E A R C H  &  U P D A T E   P L A Y E R ||");
        System.out.println("--------------------------------------------------");
        System.out.print("Enter the last name for identify: ");
        LastName = read_s.nextLine();
        do{ 
        System.out.print("Enter the number of the t-shirt: ");
            while (!read_n.hasNextInt()) {
                System.out.println("¡Enter numbers, not characters!");
                read_n.nextLine();
            }
            number = read_n.nextInt();
            
            if (number < 0) {
                System.out.println("The number can't be negative!");
            } if (number == 0) {
                System.out.println("The number can't be equal to zero!");
            } if (number > 100) {
                System.out.println("The number can't be older that 100");
            }
        
        }while(number <= 0 || number > 100);

        System.out.print("Now, enter a soccer team: ");
        soccerTeam = read_s.nextLine();
        System.out.println("Finally, enter the sex:");
        System.out.println("1. Masculine.");
        System.out.println("2. Femenine.");
        System.out.print("Choose an option: ");
        do{
            while (!read_n.hasNextInt()) {
                System.out.println("¡Enter a number, not characters!");
                read_n.next();
            }
        opSex = read_n.nextInt();

        if (opSex < 0) {
            System.out.println("¡The option can't be negative!");
        } if (opSex == 0) {
            System.out.println("¡The option can't be equal to zero!");
        } if (opSex > 2) {
            System.out.println("¡Invalid option!");
        }

        }while(opSex <= 0 || opSex > 2);

        for(int i = 0; i < players.size(); i++){
            cleanScreen();
        if (players.get(i).GetLastName().equalsIgnoreCase(LastName) && players.get(i).GetNumberSoccer() == number && players.get(i).GetSoccerTeam().equalsIgnoreCase(soccerTeam)) {
            System.out.println("THE PLAYER SEARCHED IS " + players.get(i));
            pauseScreen();
            System.out.println("¿Do yo want update?");
            System.out.println("1. Yes\n2. No");
            System.out.print("Enter an option: ");
            do{
                while (!read_n.hasNextInt()) {
                    System.out.println("¡Enter a number, not characters!");
                    read_n.next();
                }
            op = read_n.nextInt();

            if (op < 0) {
                System.out.println("¡The option can't be negative!");
            } if (op == 0) {
                System.out.println("¡The option can't be equal to zero!");
            } if (op > 2) {
                System.out.println("¡Invalid option!");
            }

            }while(op <= 0 || op > 2);

            if (op == 1) {
                System.out.println("¡You'll enter in the system for update!");
                pauseScreen();
                cleanScreen();
                System.out.println(" || U P D A T E  -  D A T A S ||");
                System.out.println("1. Change the soccer team. ");
                System.out.println("2. Change the dorsal or the number of the t-shirt.");
                System.out.print("Note: only there are two option availables! || Choose an option ->");
                do{
                    while (!read_n.hasNextInt()) {
                        System.out.println("¡Enter a number, not characters!");
                        read_n.next();
                    }
                opChange = read_n.nextInt();
    
                if (opChange < 0) {
                    System.out.println("¡The option can't be negative!");
                } if (opChange == 0) {
                    System.out.println("¡The option can't be equal to zero!");
                } if (opChange > 2) {
                    System.out.println("¡Invalid option!");
                }
    
                }while(opChange <= 0 || opChange > 2);

                switch (opChange) {

                    case 1:
                    do{
                        cleanScreen();
                        System.out.println("    || M O D I F Y ||" );
                        System.out.println("");

                    System.out.print("Enter a new soccer team: ");
                    newSoccerTeam = read_s.nextLine();
                    }while(newSoccerTeam.length() < 4);
                    players.get(i).SetSoccerTeam(newSoccerTeam);
                    System.out.println("¡THE SOCCER TEAM WAS CHANGED!");
                    break;
                
                    case 2:
                    cleanScreen();
                    System.out.println("    || M O D I F Y ||" );
                    System.out.println("");
                    System.out.println("Enter a new dorsal or number:");
                    do{
                        System.out.print("2. Enter a number shirt: ");
                        while (!read_n.hasNextInt()) {
                            System.out.println("Enter a number, not character");
                            read_n.next();
                        }
                        newNumber = read_n.nextInt();
            
                    if (newNumber < 0) {
                        System.out.println("The number can't be negative!");
                    } if (newNumber == 0) {
                        System.out.println("The number can't be equal to zero!");
                    } if (newNumber > 100) {
                        System.out.println("The number can't be older that 100");
                    }
                    }while(newNumber <= 0 || newNumber >= 100);
                    players.get(i).SetNumberSoccer(newNumber);
                    System.out.println("¡THE NUMBER WAS CHANGED!");
                    break;
                }
                } else {
                cleanScreen();
                System.out.println("||  C A N C E L E D  - P R O C E S S ||");
                System.out.println("¡You canceled the step for enter a update, try again!");
            }
            return;

            } else{
                System.out.println("    || E R R O R - 404: NOT FOUND ||");
                System.out.println("___________________________________________");
               System.out.println("¡"+LastName + " NOT REGISTERED IN THE SYSTEM!"); 
            }
       }//For key
    }

    public static void deletePlayer(ArrayList<Contacts> players){
        String lastName, soccerTeam; String Sex; int OpSex = 0;
        int number  = 0;
        cleanScreen();
        System.out.println("    || D E L E T E  || ");
        System.out.println("--------------------------------");
        System.out.print("1. Enter a last name for delete: ");
        lastName = read_s.nextLine();
        do{
            System.out.print("2. Enter a soccer team: ");
            soccerTeam = read_s.nextLine();
        
            if (soccerTeam.length() < 4) {
                System.out.println("¡The name is invalid!");
            }

        }while(soccerTeam.length() < 4);
        do{ 
            System.out.print("3. Enter the number of the t-shirt: ");
                while (!read_n.hasNextInt()) {
                    System.out.println("¡Enter numbers, not characters!");
                    read_n.nextLine();
                }
                number = read_n.nextInt();
                
                if (number < 0) {
                    System.out.println("The number can't be negative!");
                } if (number == 0) {
                    System.out.println("The number can't be equal to zero!");
                } if (number > 100) {
                    System.out.println("The number can't be older that 100");
                }
            
            }while(number <= 0 || number > 100);
            System.out.println("4. Confirm with the sex:");
            System.out.println("(1) Masculine.");
            System.out.println("(2) Femenine");
            System.out.print("Choose an option: ");;
            do{
                while (!read_n.hasNextInt()) {
                        System.out.println("¡Enter number, not characters!");
                        read_n.nextInt();
                }
                OpSex = read_n.nextInt();

                if (OpSex < 0) {
                    System.out.println("¡The option can't be negative!");
                } if (OpSex == 0) {
                    System.out.println("¡The option can't be equal to zero!");
                } if (OpSex > 2) {
                    System.out.println("¡The option can't older that 2!");
                }

            }while(OpSex <= 0 || OpSex > 2);

            if (OpSex == 1) {
                Sex = "Masculine";
            } else {
                Sex = "Femenine";
            }
            removePlayer(players, lastName, soccerTeam, number, Sex);
    }

    public static void removePlayer(ArrayList<Contacts> player, String LastName, String SoccerTeam, int Number, String Sex){
        Scanner r = new Scanner(System.in);
        int answer = 0;
        for(int i = 0; i < player.size(); i++){
            if (player.get(i).GetLastName().equalsIgnoreCase(LastName) && player.get(i).GetSoccerTeam().equalsIgnoreCase(SoccerTeam) && player.get(i).GetSex().equalsIgnoreCase(Sex) && player.get(i).GetNumberSoccer() == Number) {
                System.out.println("DATA PLAYERS || " + LastName + "|| " + SoccerTeam + "|| " + Number + "|| " + Sex + "||.");
                System.out.println("¿Do you want eliminate? (Y/N)");
                System.out.println("1. Yes");
                System.out.println("2. No");
                do{
                    System.out.print("Choose an option ->");
                    while (!r.hasNextInt()) {
                        System.out.println("¡Enter a number, not characters!");
                        r.next();
                    }
                answer = r.nextInt();

                if (answer <= 0) {
                    System.out.println("¡The option can't be negative or equal to zero!");
                } if (answer > 2) {
                    System.out.println("¡The option can't be older than 2!");
                }
                }while(answer <= 0 || answer > 2);
                switch (answer) {
                    case 1:
                    cleanScreen();
                    System.out.println("  || S U C C E S S F U L  -  P R O C  E S S ||");
                    System.out.println("_______________________________________________");
                    player.remove(i);
                    System.out.println(LastName + " was eliminated.");
                    break;
                
                    case 2:
                    System.out.println("  || C A N C E L E D  -  P R O C E S S  ||");
                    System.out.println("_______________________________________________");
                    break;
                }
            }
            }
            }
/////////////////////////////////////////////////////////////////////////////////////////////////////
}
