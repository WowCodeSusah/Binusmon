package com.example.binusmon_project;

import javafx.scene.image.ImageView;

public class Students {
    public static Moves Place_Holder = new Moves("-", "None", 0);
    public String name;
    public int hit_points;
    public int defense;
    public int attack;
    public int speed;
    public Moves move_1 = Place_Holder;
    public Moves move_2 = Place_Holder;
    public Moves move_3 = Place_Holder;
    public Moves move_4 = Place_Holder;
    public String type_primary;
    public String type_secondary;
    public String sprite;
    public ImageView trueSprite_back;
    public ImageView trueSprite_front;
    public Students(String n, int hp, int def, int atk, int s, String type_p, String type_s, String sprite) {
        this.name = n;
        this.hit_points = hp;
        this.defense = def;
        this.attack = atk;
        this.speed = s;
        this.type_primary = type_p;
        this.type_secondary = type_s;
        this.sprite = sprite;
    }
    public void setMove(int number, Moves move) {
        switch (number) {
            case 1 -> this.move_1 = move;
            case 2 -> this.move_2 = move;
            case 3 -> this.move_3 = move;
            case 4 -> this.move_4 = move;
        }
    }
    public Moves getMove(int number) {
        switch (number) {
            case 1 -> {
                return move_1;
            }
            case 2 -> {
                return move_2;
            }
            case 3 -> {
                return move_3;
            }
            case 4 -> {
                return move_4;
            }
            default -> {
                return move_1;
            }
        }
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", hit_points=" + hit_points +
                ", defense=" + defense +
                ", attack=" + attack +
                ", speed=" + speed +
                ", move_1=" + move_1 +
                ", move_2=" + move_2 +
                ", move_3=" + move_3 +
                ", move_4=" + move_4 +
                ", type_primary='" + type_primary + '\'' +
                ", type_secondary='" + type_secondary + '\'' +
                ", sprite='" + sprite + '\'' +
                '}';
    }
}
