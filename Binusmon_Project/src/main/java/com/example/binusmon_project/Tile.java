package com.example.binusmon_project;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.*;
import java.util.ArrayList;

public class Tile {
    public Image wallSprite = new Image(new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Tile/wall_tile.png"));
    public Image tileSprite = new Image(new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Tile/tile.png"));
    public Image playerSprite = new Image(new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Tile/Player_tile.png"));
    public Image opponentSprite = new Image(new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Tile/Opponent_tile.png"));
    public ArrayList<ArrayList<String>> tileList;
    public Tile() throws IOException {
        tileImport();
    }
    public void tileCreator(Pane pane) throws IOException {
        ArrayList<ArrayList<ImageView>> fullView = new ArrayList<>();
        for (int tiley = 0; tiley < 15; tiley++) {
            ArrayList<ImageView> halfView = new ArrayList<>();
            for (int tilex = 0; tilex < 20; tilex++) {
                ImageView tilePlacement = new ImageView();
                tilePlacement.setX(tilex * 50);
                tilePlacement.setY(tiley * 50);
                pane.getChildren().add(tilePlacement);
                halfView.add(tilePlacement);
            }
            fullView.add(halfView);
        }
        int x_player = 0;
        int y_player = 0;
        for (int y = 0; y < tileList.size(); y++) {
            for (int x = 0; x <tileList.get(y).size(); x++) {
                if (tileList.get(y).get(x).equals("p")) {
                    x_player = x;
                    y_player = y;
                }
            }
        }
        int startY = 0;
        for (int y = y_player - 7; y < y_player + 8; y++) {
            int startX = 0;
            for (int x = x_player - 9; x < x_player + 11; x++) {
                if (!(x < 0 || y < 0 || y > tileList.size() || x > tileList.get(0).size())) {
                    switch (tileList.get(y).get(x)) {
                        case "x" -> {
                            fullView.get(startY).get(startX).setImage(wallSprite);
                            fullView.get(startY).get(startX).setVisible(true);
                        }
                        case "o" -> {
                            fullView.get(startY).get(startX).setImage(tileSprite);
                            fullView.get(startY).get(startX).setVisible(true);
                        }
                        case "j", "b" -> {
                            fullView.get(startY).get(startX).setImage(opponentSprite);
                            fullView.get(startY).get(startX).setVisible(true);
                        }
                        case "p" -> {
                            fullView.get(startY).get(startX).setImage(playerSprite);
                            fullView.get(startY).get(startX).setVisible(true);
                        }
                    }
                }
                startX++;
            }
            startY++;
        }

    }
    public void tileImport() throws IOException {
        ArrayList<ArrayList<String>> y = new ArrayList<>();
        File file = new File("src/main/java/com/example/binusmon_project/world.txt");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String allString;
        while ((allString = buffer.readLine()) != null) {
            ArrayList<String> x = new ArrayList<>();
            for (int i = 0; i < allString.length(); i++) {
                String hold = String.valueOf(allString.charAt(i));
                if (!hold.equals(" ")) {
                    x.add(hold);
                }
            }
            y.add(x);
        }
        tileList = y;
    }
    public void movePlayer(String move) {
        int x_player = 0;
        int y_player = 0;
        for (int y = 0; y < tileList.size(); y++) {
            for (int x = 0; x <tileList.get(y).size(); x++) {
                if (tileList.get(y).get(x).equals("p")) {
                    x_player = x;
                    y_player = y;
                }
            }
        }
        switch (move) {
            case "Up" -> {
                if (tileList.get(y_player - 1).get(x_player).equals("o")) {
                    tileList.get(y_player).set(x_player, "o");
                    tileList.get(y_player - 1).set(x_player, "p");
                }
            }
            case "Down" -> {
                if (tileList.get(y_player + 1).get(x_player).equals("o")) {
                    tileList.get(y_player).set(x_player, "o");
                    tileList.get(y_player + 1).set(x_player, "p");
                }
            }
            case "Right" -> {
                if (tileList.get(y_player).get(x_player + 1).equals("o")) {
                    tileList.get(y_player).set(x_player, "o");
                    tileList.get(y_player).set(x_player + 1, "p");
                }
            }
            case "Left" -> {
                if (tileList.get(y_player).get(x_player - 1).equals("o")) {
                    tileList.get(y_player).set(x_player, "o");
                    tileList.get(y_player).set(x_player - 1, "p");
                }
            }
        }
    }
    public String checkOpponent(){
        String truth = "Non";
        int x_player = 0;
        int y_player = 0;
        for (int y = 0; y < tileList.size(); y++) {
            for (int x = 0; x <tileList.get(y).size(); x++) {
                if (tileList.get(y).get(x).equals("p")) {
                    x_player = x;
                    y_player = y;
                }
            }
        }
        if (tileList.get(y_player - 1).get(x_player).equals("b")) {
            truth = "b";
        } else if (tileList.get(y_player + 1).get(x_player).equals("b")) {
            truth = "b";
        } else if (tileList.get(y_player).get(x_player - 1).equals("b")) {
            truth = "b";
        } else if (tileList.get(y_player).get(x_player + 1).equals("b")) {
            truth = "b";
        } else if (tileList.get(y_player - 1).get(x_player).equals("j")) {
            truth = "j";
        } else if (tileList.get(y_player + 1).get(x_player).equals("j")) {
            truth = "j";
        } else if (tileList.get(y_player).get(x_player - 1).equals("j")) {
            truth = "j";
        } else if (tileList.get(y_player).get(x_player + 1).equals("j")) {
            truth = "j";
        }
        return truth;
    }
}
