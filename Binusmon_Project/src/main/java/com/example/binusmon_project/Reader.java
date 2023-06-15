package com.example.binusmon_project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public ArrayList<Students> students_list = new ArrayList<>();
    public ArrayList<Moves> moves_list = new ArrayList<>();
    public ArrayList<Player> players_list = new ArrayList<>();
    public ArrayList<Opponent> opponents_list = new ArrayList<>();

    public void createAll() throws IOException {
        File file = new File("src/main/java/com/example/binusmon_project/Character.txt");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String allString;
        ArrayList<String> fullArray = new ArrayList<>();
        while ((allString = buffer.readLine()) != null) {
            fullArray.add(allString);
        }
        int player_min = 0;
        int player_max = 0;

        int opponent_min = 0;
        int opponent_max = 0;

        int student_min = 0;
        int student_max = 0;

        int moves_min = 0;
        int moves_max = 0;

        for (int i = 0; i < fullArray.size(); i++) {
            if (fullArray.get(i).equals("Player")) {
                player_min = i;
            } else if (fullArray.get(i).equals("Opponent")) {
                player_max = i;
                opponent_min = i;
            } else if (fullArray.get(i).equals("Students")) {
                opponent_max = i;
                student_min = i;
            } else if (fullArray.get(i).equals("Moves")) {
                student_max = i;
                moves_min = i;
                moves_max = fullArray.size();
            }
        }

        List<String> player = fullArray.subList(player_min, player_max);
        List<String> opponent = fullArray.subList(opponent_min, opponent_max);
        List<String> student = fullArray.subList(student_min, student_max);
        List<String> moves = fullArray.subList(moves_min, moves_max);

        for (int i = 2; i < player.size(); i++) {
            String fullAttribute = player.get(i);
            String name = "";
            String commend = "";
            int first_point = 0;
            int second_point = 0;
            int third_point = 0;
            int check = 0;
            for (int j = 0; j < fullAttribute.length(); j++) {
                if (fullAttribute.charAt(j) == ':' && check == 0) {
                    first_point = j + 1;
                    check++;
                } else if (fullAttribute.charAt(j) == ' ') {
                    second_point = j;
                } else if (check == 1 && fullAttribute.charAt(j) == ':') {
                    third_point = j + 1;
                }
            }
            name = fullAttribute.substring(first_point, second_point);
            commend = fullAttribute.substring(third_point);
            Player players = new Player(name, commend);
            players_list.add(players);
        }
        for (int i = 2; i < opponent.size(); i++) {
            String fullAttribute = opponent.get(i);
            String name = "";
            String commend = "";
            int first_point = 0;
            int second_point = 0;
            int third_point = 0;
            int check = 0;
            for (int j = 0; j < fullAttribute.length(); j++) {
                if (fullAttribute.charAt(j) == ':' && check == 0) {
                    first_point = j + 1;
                    check++;
                } else if (fullAttribute.charAt(j) == ' ') {
                    second_point = j;
                } else if (check == 1 && fullAttribute.charAt(j) == ':') {
                    third_point = j + 1;
                }
            }
            name = fullAttribute.substring(first_point, second_point);
            commend = fullAttribute.substring(third_point);
            Opponent opponents = new Opponent(name, commend);
            opponents_list.add(opponents);
        }
        for (int i = 2; i < student.size(); i++) {
            String fullAttribute = student.get(i);
            String name = fullAttribute.substring(5, student.get(i).length() - student.get(1).length() + 5);
            int hp = (((fullAttribute.charAt(student.get(i).length() - student.get(1).length() + 9)) - 48) * 100) + (((fullAttribute.charAt(student.get(i).length() - student.get(1).length() + 10)) - 48 )* 10) + ((fullAttribute.charAt(student.get(i).length() - student.get(1).length() + 11)) - 48);
            int def = (((fullAttribute.charAt(student.get(i).length() - student.get(1).length() + 17)) - 48) * 100) + (((fullAttribute.charAt(student.get(i).length() - student.get(1).length() + 18)) - 48 )* 10) + ((fullAttribute.charAt(student.get(i).length() - student.get(1).length() + 19)) - 48);
            int atk = (((fullAttribute.charAt(student.get(i).length() - student.get(1).length() + 25)) - 48) * 100) + (((fullAttribute.charAt(student.get(i).length() - student.get(1).length() + 26)) - 48 )* 10) + ((fullAttribute.charAt(student.get(i).length() - student.get(1).length() + 27)) - 48);
            int spd = (((fullAttribute.charAt(student.get(i).length() - student.get(1).length() + 33)) - 48) * 100) + (((fullAttribute.charAt(student.get(i).length() - student.get(1).length() + 34)) - 48 )* 10) + ((fullAttribute.charAt(student.get(i).length() - student.get(1).length() + 35)) - 48);
            String typeOne = fullAttribute.substring(((student.get(i).length() - student.get(1).length() + 52)) , ((student.get(i).length() - student.get(1).length() + 55)));
            String typeTwo = fullAttribute.substring(((student.get(i).length() - student.get(1).length() + 56)) , ((student.get(i).length() - student.get(1).length() + 59)));
            String sprite = fullAttribute.substring(((student.get(i).length() - student.get(1).length() + 67)) , ((student.get(i).length() - student.get(1).length() + 72)));
            Students students = new Students(name, hp, def, atk, spd, typeOne, typeTwo, sprite);
            students_list.add(students);
        }
        for (int i = 2; i < moves.size(); i++) {
            String fullAttribute = moves.get(i);
            String name = fullAttribute.substring(5, moves.get(i).length() - moves.get(1).length() + 5);
            String type = fullAttribute.substring(((moves.get(i).length() - moves.get(1).length() + 11)) , ((moves.get(i).length() - moves.get(1).length() + 14)));
            int power = (((fullAttribute.charAt(moves.get(i).length() - moves.get(1).length() + 21)) - 48) * 100) + (((fullAttribute.charAt(moves.get(i).length() - moves.get(1).length() + 22)) - 48 )* 10) + ((fullAttribute.charAt(moves.get(i).length() - moves.get(1).length() + 23)) - 48);
            Moves move = new Moves(name, type, power);
            moves_list.add(move);
        }
    }
}
