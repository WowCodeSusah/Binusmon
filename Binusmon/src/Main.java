import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static String Check_Effectiveness(Moves move, Students opponent) {
        int checker = 0;
        String effectiveness;
        checker= switch (move.type) {
            case "Smart" -> switch (opponent.type_primary) {
                case "Disinterested", "Diligent" -> checker + 1;
                case "Noisy", "Quiet" -> checker - 1;
                default -> checker;
            };
            case "Lazy" -> switch (opponent.type_primary) {
                case "Quiet", "Ambitious" -> checker + 1;
                case "Diligent", "Noisy" -> checker - 1;
                default -> checker;
            };
            case "Diligent" -> switch (opponent.type_primary) {
                case "Lazy" -> checker + 1;
                case "Smart", "Quiet" -> checker - 1;
                case "Disinterested" ->  checker - 9999;
                default -> checker;
            };
            case "Noisy" -> switch (opponent.type_primary) {
                case "Ambitious", "Smart", "Lazy" -> checker + 1;
                case "Quiet" -> checker - 1;
                case "Diligent" ->  checker - 9999;
                default -> checker;
            };
            case "Quiet" -> switch (opponent.type_primary) {
                case "Diligent", "Noisy" -> checker + 1;
                case "Lazy", "Ambitious" -> checker - 1;
                default -> checker;
            };
            case "Ambitious" -> switch (opponent.type_primary) {
                case "Smart", "Noisy" -> checker + 1;
                case "Disinterested", "Quiet" -> checker - 1;
                default -> checker;
            };
            case "Disinterested" -> switch (opponent.type_primary) {
                case "Diligent" -> checker + 1;
                case "Smart", "Quiet" -> checker - 1;
                default -> checker;
            };
            case "Teacher" -> switch (opponent.type_primary) {
                case "Ambitious", "Smart", "Lazy", "Disinterested", "Quiet", "Diligent", "Noisy" -> checker + 1;
                case "Teacher" -> checker - 9999;
                default -> checker;
            };
            default -> checker;
        };
        checker= switch (move.type) {
            case "Smart" -> switch (opponent.type_secondary) {
                case "Disinterested", "Diligent" -> checker + 1;
                case "Noisy", "Quiet" -> checker - 1;
                default -> checker;
            };
            case "Lazy" -> switch (opponent.type_secondary) {
                case "Quiet", "Ambitious" -> checker + 1;
                case "Diligent", "Noisy" -> checker - 1;
                default -> checker;
            };
            case "Diligent" -> switch (opponent.type_secondary) {
                case "Lazy" -> checker + 1;
                case "Smart", "Quiet" -> checker - 1;
                case "Disinterested" ->  checker - 9999;
                default -> checker;
            };
            case "Noisy" -> switch (opponent.type_secondary) {
                case "Ambitious", "Smart", "Lazy" -> checker + 1;
                case "Quiet" -> checker - 1;
                case "Diligent" ->  checker - 9999;
                default -> checker;
            };
            case "Quiet" -> switch (opponent.type_secondary) {
                case "Diligent", "Noisy" -> checker + 1;
                case "Lazy", "Ambitious" -> checker - 1;
                default -> checker;
            };
            case "Ambitious" -> switch (opponent.type_secondary) {
                case "Smart", "Noisy" -> checker + 1;
                case "Disinterested", "Quiet" -> checker - 1;
                default -> checker;
            };
            case "Disinterested" -> switch (opponent.type_secondary) {
                case "Diligent" -> checker + 1;
                case "Smart", "Quiet" -> checker - 1;
                default -> checker;
            };
            case "Teacher" -> switch (opponent.type_secondary) {
                case "Ambitious", "Smart", "Lazy", "Disinterested", "Quiet", "Diligent", "Noisy" -> checker + 1;
                case "Teacher" -> checker - 9999;
                default -> checker;
            };
            default -> checker;
        };
        if (checker == 0) {
            effectiveness = "Normal_Damage";
        } else if (checker < -100) {
            effectiveness = "Immune";
        } else if (checker > 0) {
            effectiveness = "Super_Effective";
        } else {
            effectiveness = "Not_Very_Effective";
        }
        return effectiveness;
    }
    public static int Damage_Calculation(Students player, Students opponent, Moves move) {
        Random rand = new Random();
        int max_random = 5;
        int hold;
        int pure_defense = opponent.defense / 3;
        hold = ((player.attack - pure_defense) * move.Power / 80) + rand.nextInt(max_random);
        hold = switch (move.type) {
            case "Smart" -> switch (opponent.type_primary) {
                case "Disinterested", "Diligent" -> hold * 2;
                case "Noisy", "Quiet" -> hold / 2;
                default -> hold;
            };
            case "Lazy" -> switch (opponent.type_primary) {
                case "Quiet", "Ambitious" -> hold * 2;
                case "Diligent", "Noisy" -> hold / 2;
                default -> hold;
            };
            case "Diligent" -> switch (opponent.type_primary) {
                case "Lazy" -> hold * 2;
                case "Smart", "Quiet" -> hold / 2;
                case "Disinterested" -> 0;
                default -> hold;
            };
            case "Noisy" -> switch (opponent.type_primary) {
                case "Ambitious", "Smart", "Lazy" -> hold * 2;
                case "Quiet" -> hold / 2;
                case "Diligent" -> 0;
                default -> hold;
            };
            case "Quiet" -> switch (opponent.type_primary) {
                case "Diligent", "Noisy" -> hold * 2;
                case "Lazy", "Ambitious" -> hold / 2;
                default -> hold;
            };
            case "Ambitious" -> switch (opponent.type_primary) {
                case "Smart", "Noisy" -> hold * 2;
                case "Disinterested", "Quiet" -> hold / 2;
                default -> hold;
            };
            case "Disinterested" -> switch (opponent.type_primary) {
                case "Diligent" -> hold * 2;
                case "Smart", "Quiet" -> hold / 2;
                default -> hold;
            };
            case "Teacher" -> switch (opponent.type_primary) {
                case "Ambitious", "Smart", "Lazy", "Disinterested", "Quiet", "Diligent", "Noisy" -> hold * 2;
                case "Teacher" -> 0;
                default -> hold;
            };
            default -> hold;
        };
        hold = switch (move.type) {
            case "Smart" -> switch (opponent.type_secondary) {
                case "Disinterested", "Diligent" -> hold * 2;
                case "Noisy", "Quiet" -> hold / 2;
                default -> hold;
            };
            case "Lazy" -> switch (opponent.type_secondary) {
                case "Quiet", "Ambitious" -> hold * 2;
                case "Diligent", "Noisy" -> hold / 2;
                default -> hold;
            };
            case "Diligent" -> switch (opponent.type_secondary) {
                case "Lazy" -> hold * 2;
                case "Smart", "Quiet" -> hold / 2;
                case "Disinterested" -> 0;
                default -> hold;
            };
            case "Noisy" -> switch (opponent.type_secondary) {
                case "Ambitious", "Smart", "Lazy" -> hold * 2;
                case "Quiet" -> hold / 2;
                case "Diligent" -> 0;
                default -> hold;
            };
            case "Quiet" -> switch (opponent.type_secondary) {
                case "Diligent", "Noisy" -> hold * 2;
                case "Lazy", "Ambitious" -> hold / 2;
                default -> hold;
            };
            case "Ambitious" -> switch (opponent.type_secondary) {
                case "Smart", "Noisy" -> hold * 2;
                case "Disinterested", "Quiet" -> hold / 2;
                default -> hold;
            };
            case "Disinterested" -> switch (opponent.type_secondary) {
                case "Diligent" -> hold * 2;
                case "Smart", "Quiet" -> hold / 2;
                default -> hold;
            };
            case "Teacher" -> switch (opponent.type_secondary) {
                case "Ambitious", "Smart", "Lazy", "Disinterested", "Quiet", "Diligent", "Noisy" -> hold * 2;
                case "Teacher" -> 0;
                default -> hold;
            };
            default -> hold;
        };
        return hold;
    }
    public static String hp_builder(int hp_current, int hp_original) {
        String hp_bar = "";
        String hp_bar_second = "";
        int check = 15;
        float hp_current_float;
        hp_current_float = hp_current;
        float hp_original_float;
        hp_original_float = hp_original;
        float hold = hp_current_float / hp_original_float;
        hold = hold * 15;
        for (float x = 0.00f; x < hold;x++) {
            hp_bar = hp_bar + "/";
            check--;
        }
        hp_bar = ANSI_GREEN + hp_bar + ANSI_RESET;
        for (int x = 0; x < check; x++) {
            hp_bar_second = hp_bar_second + "/";
        }
        hp_bar_second = ANSI_BLACK + hp_bar_second + ANSI_RESET;
        hp_bar = hp_bar + hp_bar_second;
        hp_bar = "(" + hp_bar + ")";
        return hp_bar;
    }
    public static String option_builder(String moves) {
        String name = moves;
        int length = name.length();
        length = (18 - length) / 2;
        for (int x = 0; x < length; x++) {
            name = " " + name + " ";
        }
        if (name.length() % 2 == 1) {
            name = name + " ";
        }
        return name;
    }
    public static String Battle(Player player, Opponent opponent) {
        int x = 0;
        String End_Result = "";
        int hp = 0;
        int hp2 = 0;
        int hp3 = 0;
        int hp4 = 0;
        int hp_opponent = 0;
        int hp2_opponent = 0;
        int hp3_opponent = 0;
        int hp4_opponent = 0;
        ArrayList<Integer> hp_player_list = new ArrayList<>();
        ArrayList<Integer> hp_opponent_list = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        switch (player.party.size()) {
            case 1 -> {
                hp = player.getParty_One().hit_points;
            }
            case 2 -> {
                hp = player.getParty_One().hit_points;
                hp2 = player.getParty_Two().hit_points;
            }
            case 3 -> {
                hp = player.getParty_One().hit_points;
                hp2 = player.getParty_Two().hit_points;
                hp3 = player.getParty_Three().hit_points;
            }
            case 4 -> {
                hp = player.getParty_One().hit_points;
                hp2 = player.getParty_Two().hit_points;
                hp3 = player.getParty_Three().hit_points;
                hp4 = player.getParty_Four().hit_points;
            }
        }
        switch (opponent.party.size()) {
            case 1 -> {
                hp_opponent = opponent.getParty_One().hit_points;
            }
            case 2 -> {
                hp_opponent = opponent.getParty_One().hit_points;
                hp2_opponent = opponent.getParty_Two().hit_points;
            }
            case 3 -> {
                hp_opponent = opponent.getParty_One().hit_points;
                hp2_opponent = opponent.getParty_Two().hit_points;
                hp3_opponent = opponent.getParty_Three().hit_points;
            }
            case 4 -> {
                hp_opponent = opponent.getParty_One().hit_points;
                hp2_opponent = opponent.getParty_Two().hit_points;
                hp3_opponent = opponent.getParty_Three().hit_points;
                hp4_opponent = opponent.getParty_Four().hit_points;
            }
        }
        hp_player_list.add(hp);
        hp_player_list.add(hp2);
        hp_player_list.add(hp3);
        hp_player_list.add(hp4);
        hp_opponent_list.add(hp_opponent);
        hp_opponent_list.add(hp2_opponent);
        hp_opponent_list.add(hp3_opponent);
        hp_opponent_list.add(hp4_opponent);
        System.out.println("Teacher " + opponent.name + " challenges you to a battle");
        int current_party_player = 0;
        int current_party_opponent = 0;
        int damage_dealt = 0;
        int damage_taken = 0;
        String option_1 = option_builder("Battle");
        String option_2 = option_builder("Commend");
        String option_3 = option_builder("Switch");
        String option_4 = option_builder("Forfeit");
        String status = "First";
        while (x == 0) {
            String player_hp = hp_builder(hp_player_list.get(current_party_player), player.party.get(current_party_player).hit_points);
            String opponent_hp = hp_builder(hp_opponent_list.get(current_party_opponent), opponent.party.get(current_party_opponent).hit_points);
            System.out.println("=======================================================================================================================================");
            System.out.println("                                                                                                                                       ");
            System.out.println("    --------------------------                                                                                                         ");
            System.out.println("   |                          |                                              (                  )                                      ");
            System.out.println("   |  HP = "+player_hp+"  |                                                    -----                                               ");
            System.out.println("   |                          |                                                    |                                                   ");
            System.out.println("    --------------------------                                                     -----                                               ");
            System.out.println("                                                                                       |                                               ");
            System.out.println("                                                                                   -----                                               ");
            System.out.println("                                                                                ___________                                            ");
            System.out.println("                     (                  )                                                                                              ");
            System.out.println("                            _____                                                                                                      ");
            System.out.println("                            |                                                        --------------------------                        ");
            System.out.println("                            -----                                                   |                          |                       ");
            System.out.println("                                |                                                   |  HP = "+opponent_hp+"  |                       ");
            System.out.println("                            -----                                                   |                          |                       ");
            System.out.println("        _________        ___________                                                 --------------------------                        ");
            System.out.println("       |         |                                                                                                                     ");
            System.out.println("       |   UwU   |                                                                                                                     ");
            System.out.println("       |         |                                                                                                                     ");
            System.out.println("=======================================================================================================================================");
            System.out.println("                                                                                                                                       ");
            System.out.println("      ------------------------        ------------------------        ------------------------        ------------------------         ");
            System.out.println("     |                        |      |                        |      |                        |      |                        |        ");
            System.out.println("     |  ("+option_1+")  |      |  ("+option_2+")  |      |  ("+option_3+")  |      |  ("+option_4+")  |        ");
            System.out.println("     |                        |      |                        |      |                        |      |                        |        ");
            System.out.println("      ------------------------        ------------------------        ------------------------        ------------------------         ");
            System.out.println("                                                                                                                                       ");
            System.out.println("=======================================================================================================================================");
            System.out.print("Choose your move (1 / 2 / 3 / 4) : ");
            String chosen_option = scan.nextLine();
            switch (status) {
                case "First" -> {
                    option_1 = option_builder("Battle");
                    option_2 = option_builder("Commend");
                    option_3 = option_builder("Switch");
                    option_4 = option_builder("Forfeit");
                    switch (chosen_option) {
                        case "1" -> {
                            status = "Battle";
                            option_1 = option_builder(player.party.get(current_party_player).move_1.name);
                            option_2 = option_builder(player.party.get(current_party_player).move_2.name);
                            option_3 = option_builder(player.party.get(current_party_player).move_3.name);
                            option_4 = option_builder(player.party.get(current_party_player).move_4.name);
                        }
                        case "2" -> {
                            status = "Commend";
                            option_1 = option_builder("Praise");
                            option_2 = option_builder(player.commend);
                            option_3 = option_builder("--");
                            option_4 = option_builder("--");
                        }
                        case "3" -> {
                            status = "Switch";
                            option_1 = option_builder(player.party.get(0).name);
                            option_2 = option_builder(player.party.get(1).name);
                            option_3 = option_builder(player.party.get(2).name);
                            option_4 = option_builder(player.party.get(3).name);
                        }
                        case "4" -> {
                            status = "Forfeit";
                            End_Result = "You Lose";
                            x++;
                        }
                        default -> {
                            status = "First";
                        }
                    }
                }
                case "Battle" -> {
                    switch (chosen_option) {
                        case "1":
                            int hold = 0;
                            damage_dealt = Damage_Calculation(player.party.get(current_party_player), opponent.party.get(current_party_opponent), player.party.get(current_party_player).move_1);
                            hold = hp_opponent_list.get(current_party_opponent) - damage_dealt;
                            hp_opponent_list.set(current_party_opponent, hold);
                            status = "First";
                        case "2":
                            damage_dealt = Damage_Calculation(player.party.get(current_party_player), opponent.party.get(current_party_opponent), player.party.get(current_party_player).move_2);
                            hold = hp_opponent_list.get(current_party_opponent) - damage_dealt;
                            hp_opponent_list.set(current_party_opponent, hold);
                            status = "First";
                        case "3":
                            damage_dealt = Damage_Calculation(player.party.get(current_party_player), opponent.party.get(current_party_opponent), player.party.get(current_party_player).move_3);
                            hold = hp_opponent_list.get(current_party_opponent) - damage_dealt;
                            hp_opponent_list.set(current_party_opponent, hold);
                            status = "First";
                        case "4":
                            damage_dealt = Damage_Calculation(player.party.get(current_party_player), opponent.party.get(current_party_opponent), player.party.get(current_party_player).move_4);
                            hold = hp_opponent_list.get(current_party_opponent) - damage_dealt;
                            hp_opponent_list.set(current_party_opponent, hold);
                            status = "First";
                        default:
                            status = "First";
                    }
                    status = "First";
                }
                case "Commend" -> {
                    switch (chosen_option) {
                        case "1":
                            status = "First";
                        case "2":
                            status = "First";
                        default:
                            status = "First";
                    }
                    status = "First";
                }
                case "Switch"-> {
                    switch (chosen_option) {
                        case "1":
                            current_party_player = 0;
                        case "2":
                            current_party_player = 1;
                        case "3":
                            current_party_player = 2;
                        case "4":
                            current_party_player = 3;
                        default:
                            status = "First";
                    }
                    status = "First";
                }
            }
            if (hp_player_list.get(0) <= 0 && hp_player_list.get(1) <= 0 && hp_player_list.get(2) <= 0 && hp_player_list.get(3) <= 0) {
                x++;
                End_Result = "You Lose";
            } else if (hp_opponent_list.get(0) <= 0 && hp_opponent_list.get(1) <= 0 && hp_opponent_list.get(2) <= 0 && hp_opponent_list.get(3) <= 0) {
                x++;
                End_Result = "You Win";
                System.out.println(hp_opponent);
            }
            System.out.println(hp_player_list);
            System.out.println(hp_opponent_list);
        }
        return End_Result;
    }
    public static void Start() {
        Player player = new Player();
        Opponent Jude = new Opponent("Jude");
        Students Alya = new Students("Alya", 50, 50, 100, 70, "Ambitious", "Diligent");
        Students Brandon = new Students("Brandon", 90, 90, 80, 20, "Quiet", "Smart");
        Students Raihan = new Students("Raihan", 50, 70, 70, 100, "Lazy", "Ambitious");
        Students Owen = new Students("Owen", 70, 70, 80, 70, "Disinterested", "None");
        Students Vania = new Students("Vania", 70, 60, 70, 90, "Lazy" , "None");
        Moves Profanity = new Moves("Profanity", "Lazy", 20, 50);
        Moves Ignore = new Moves("Ignore", "Quiet", 20, 60);
        Moves Do_Assignment = new Moves("Do Assignment", "Diligent", 20, 40);
        Moves Criticize = new Moves("Criticize", "Ambitious", 20, 40);
        Moves D_Care = new Moves("Don't Care", "Disinterested", 20, 80);
        Jude.addParty(Vania);
        Vania.setMove(1, Profanity);
        Alya.setMove(1, Ignore);
        Raihan.setMove(1, Criticize);
        Owen.setMove(1, D_Care);
        Brandon.setMove(1, Do_Assignment);
        Scanner scan = new Scanner(System.in);
        System.out.println("Starting.....................");
        System.out.println("----------------------------Welcome to Binusmon----------------------------");
        int x = 0;
        int check_variable = 0;
        String Player_Choice;
        while (x == 0) {
            System.out.print("Type X to start : ");
            String start = scan.nextLine();
            if (start.equals("X")) {
                System.out.println("Pick your Player Character : ");
                System.out.println("1. Philip");
                System.out.println("2. Arish");
                System.out.println("3. Alvin");
                System.out.print("Your Choice : ");
                Player_Choice = scan.nextLine();
                switch (Player_Choice) {
                    case "Philip" -> {
                        player.setName("Philip");
                        player.setCommend("Atk Increase");
                    }
                    case "Arish" -> {
                        player.setName("Arish");
                        player.setCommend("Spd Increase");
                    }
                    case "Alvin" -> {
                        player.setName("Alvin");
                        player.setCommend("Def Increase");
                    }
                }
                int y = 0;
                while (y == 0) {
                    System.out.print("You have Chosen : " + Player_Choice + " is that correct ? ");
                    String correct_choice = scan.nextLine();
                    if (correct_choice.equals("Yes")||correct_choice.equals("yes")) {
                        y++;
                        x++;
                        check_variable++;
                    } else if (correct_choice.equals("No")||correct_choice.equals("no")) {
                        System.out.print("Do you wish to re-pick your character you will be sent back to the start : ");
                        String re_pick = scan.nextLine();
                        if (re_pick.equals("Yes")||re_pick.equals("yes")) {
                            y++;
                        }
                    } else {
                        System.out.println("Please choose yes or no as your input");
                    }
                }
            } else if (start.equals("Q")) {
                x++;
            } else {
                System.out.println("X not Chosen if you wish to quit Type Q");
            }
        }
        if (check_variable > 0) {
            System.out.println("Congrats You Have Chosen : "+ player.name +" as your Character");
        } else if (check_variable == 0) {
            System.out.println("Thank you : )");
        }
        String character = "";
        while (x == 1) {
            character = "";
            System.out.println("And now choose one of the following Students : ");
            System.out.println("1. Alya");
            System.out.println("2. Brandon");
            System.out.println("3. Raihan");
            System.out.println("4. Owen");
            System.out.print("Your Choice : ");
            character = scan.nextLine();
            int y = 0;
            while (y == 0) {
                System.out.print("You choose "+ character + " is that correct ? ");
                String answer = scan.nextLine();
                if (answer.equals("Yes")) {
                    y++;
                    x++;
                } else if (answer.equals("No")) {
                    y++;
                } else {
                    System.out.println("Please choose Yes or No as your answer");
                }
            }
        }
        switch (character) {
            case "Alya", "1" -> player.addParty(Alya);
            case "Brandon", "2" -> player.addParty(Brandon);
            case "Raihan", "3" -> player.addParty(Raihan);
            case "Owen", "4" -> player.addParty(Owen);
        }
        System.out.println("Congrats You have chosen "+ character + " as your first student");
        System.out.println(Battle(player, Jude));

}
    public static void main(String[] args) {
        Start();
        /*
                System.out.println("=======================================================================================================================================");
                System.out.println("                                                                                                                                       ");
                System.out.println("    --------------------------                                                                                                         ");
                System.out.println("   |                          |                                                                                                        ");
                System.out.println("   |  HP = (///////////////)  |                                                    -----                                               ");
                System.out.println("   |                          |                                                    |                                                   ");
                System.out.println("    --------------------------                                                     -----                                               ");
                System.out.println("                                                                                       |                                               ");
                System.out.println("                                                                                   -----                                               ");
                System.out.println("                                                                                ___________                                            ");
                System.out.println("                                                                                                                                       ");
                System.out.println("                            _____                                                                                                      ");
                System.out.println("                            |                                                        --------------------------                        ");
                System.out.println("                            -----                                                   |                          |                       ");
                System.out.println("                                |                                                   |  HP = (///////////////)  |                       ");
                System.out.println("                            -----                                                   |                          |                       ");
                System.out.println("        _________        ___________                                                 --------------------------                        ");
                System.out.println("       |         |                                                                                                                     ");
                System.out.println("       |   UwU   |                                                                                                                     ");
                System.out.println("       |         |                                                                                                                     ");
                System.out.println("=======================================================================================================================================");
                System.out.println("                                                                                                                                       ");
                System.out.println("      ------------------------        ------------------------        ------------------------        ------------------------         ");
                System.out.println("     |                        |      |                        |      |                        |      |                        |        ");
                System.out.println("     |  (                  )  |      |  (                  )  |      |  (                  )  |      |  (                  )  |        ");
                System.out.println("     |                        |      |                        |      |                        |      |                        |        ");
                System.out.println("      ------------------------        ------------------------        ------------------------        ------------------------         ");
                System.out.println("                                                                                                                                       ");
                System.out.println("=======================================================================================================================================");
        */
    }
}