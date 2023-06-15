package com.example.binusmon_project;

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import static javafx.scene.paint.Color.rgb;

public class Main_Menu extends Application {
    //Settings
    public static int screen_height = 750;
    public static int screen_width = 1000;
    public VBox menu = new VBox();
    public VBox vBox = new VBox();
    public static Reader read = new Reader();
    public Tile tile = new Tile();
    public Main_Menu() throws IOException {
    }
    @Override
    public void start(Stage stage) throws FileNotFoundException {
        Label PressAny = new Label();
        Scene scene1 = new Scene(vBox, screen_width, screen_height);

        vBox.getChildren().add(PressAny);
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setBackground(new Background(new BackgroundFill(rgb(0, 0, 1), CornerRadii.EMPTY, Insets.EMPTY)));

        PressAny.setTextFill(Color.WHITE);
        PressAny.setFont(new Font("Times New Roman", 30));
        PressAny.setPadding(new Insets(30, 30 ,30 ,30));
        PressAny.setText("Press Any Key to Continue.....");
        blink(PressAny);

        stage.setTitle("Start");
        stage.setScene(scene1);
        stage.show();

        InputStream stream_back = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/background-compress.jpg");
        Image background_view = new Image(stream_back);
        menu.setBackground(new Background(new BackgroundImage(background_view, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        Scene menu_scene = new Scene(menu, screen_width, screen_height);

        menu.setOpacity(0.0);
        menu.setAlignment(Pos.CENTER);


        Label binusmon_title = new Label("Binusmon");
        binusmon_title.setFont(Font.font("Serif", FontWeight.EXTRA_BOLD, 60));
        binusmon_title.setPadding(new Insets(30, 30 ,50 ,30));
        binusmon_title.setBackground(null);


        Button start = new Button("Start");
        start.setFont(Font.font("Serif", FontWeight.EXTRA_BOLD, 30));
        start.setPadding(new Insets(30, 30 ,30 ,30));
        start.setBackground(null);
        start.addEventFilter(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            start.setFont(Font.font("Serif", 40));
            start.setPadding(new Insets(30, 30 ,20 ,30));
        });
        start.addEventFilter(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            start.setFont(Font.font("Serif", FontWeight.EXTRA_BOLD, 30));
            start.setPadding(new Insets(30, 30 ,30 ,30));
        });
        start.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
            try {
                openWorld(menu, stage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Button new_game = new Button("New Game");
        new_game.setFont(Font.font("Serif", FontWeight.EXTRA_BOLD, 30));
        new_game.setPadding(new Insets(30, 30 ,30 ,30));
        new_game.setBackground(null);
        new_game.addEventFilter(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            new_game.setFont(Font.font("Serif", 40));
            new_game.setPadding(new Insets(30, 30 ,20 ,30));
        });
        new_game.addEventFilter(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            new_game.setFont(Font.font("Serif", FontWeight.EXTRA_BOLD, 30));
            new_game.setPadding(new Insets(30, 30 ,30 ,30));
        });

        Button settings = new Button("Settings");
        settings.setFont(Font.font("Serif", FontWeight.EXTRA_BOLD, 30));
        settings.setPadding(new Insets(30, 30 ,30 ,30));
        settings.setBackground(null);
        settings.addEventFilter(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            settings.setFont(Font.font("Serif", 40));
            settings.setPadding(new Insets(30, 30 ,20 ,30));
        });
        settings.addEventFilter(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            settings.setFont(Font.font("Serif", FontWeight.EXTRA_BOLD, 30));
            settings.setPadding(new Insets(30, 30 ,30 ,30));
        });

        Button exit = new Button("Exit");
        exit.setFont(Font.font("Serif", FontWeight.EXTRA_BOLD, 30));
        exit.setPadding(new Insets(30, 30 ,30 ,30));
        exit.setBackground(null);
        exit.addEventFilter(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            exit.setFont(Font.font("Serif", 40));
            exit.setPadding(new Insets(30, 30 ,20 ,30));
        });
        exit.addEventFilter(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            exit.setFont(Font.font("Serif", FontWeight.EXTRA_BOLD, 30));
            exit.setPadding(new Insets(30, 30 ,30 ,30));
        });
        exit.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> stage.close());

        menu.getChildren().addAll(binusmon_title, start, new_game, settings, exit);

        scene1.addEventHandler(KeyEvent.ANY, keyEvent -> {
            FadeTransition menu_fade = new FadeTransition(Duration.seconds(2.0), vBox);
            menu_fade.setFromValue(1.0);
            menu_fade.setToValue(0.0);
            menu_fade.play();

            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), bruh -> {
                stage.setScene(menu_scene);
                FadeTransition menu_fade2 = new FadeTransition(Duration.seconds(2.0), menu);
                menu_fade2.setFromValue(0.0);
                menu_fade2.setToValue(1.0);
                menu_fade2.play();
            }));
            timeline.play();
        });
    }
    public void openWorld(VBox vBox, Stage stage) throws IOException {
        Pane world = new Pane();
        tile.tileCreator(world);
        Scene world_scene = new Scene(world, screen_width, screen_height);

        FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(1.0), vBox);
        fadeTransition1.setToValue(0.0);
        fadeTransition1.setFromValue(1.0);

        FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(2.0), world);
        fadeTransition2.setToValue(1.0);
        fadeTransition2.setFromValue(0.0);

        fadeTransition1.play();
        Timeline timeline1 = new Timeline(new KeyFrame(Duration.seconds(1), bruh -> {
            stage.setScene(world_scene);
            fadeTransition2.play();
        }));
        timeline1.play();

        world_scene.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.UP) {
                tile.movePlayer("Up");
                try {
                    tile.tileCreator(world);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (keyEvent.getCode() == KeyCode.DOWN) {
                tile.movePlayer("Down");
                try {
                    tile.tileCreator(world);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (keyEvent.getCode() == KeyCode.RIGHT) {
                tile.movePlayer("Right");
                try {
                    tile.tileCreator(world);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (keyEvent.getCode() == KeyCode.LEFT) {
                tile.movePlayer("Left");
                try {
                    tile.tileCreator(world);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (keyEvent.getCode() == KeyCode.SPACE) {
                if (tile.checkOpponent().equals("b")) {
                    try {
                        battle(stage, world, read.players_list.get(0), read.opponents_list.get(1));
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                } else if (tile.checkOpponent().equals("j")) {
                    try {
                        battle(stage, world, read.players_list.get(0), read.opponents_list.get(0));
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }
    public void battle(Stage stage,Pane pane, Player player, Opponent opponent) throws FileNotFoundException {
        Pane battle = new Pane();

        Scene battle_scene = new Scene(battle, screen_width, screen_height);
        FadeTransition battle_start_fade_1 = new FadeTransition(Duration.seconds(0.5), pane);
        battle_start_fade_1.setToValue(0.0);
        battle_start_fade_1.setFromValue(1.0);

        FadeTransition battle_start_fade_2 = new FadeTransition(Duration.seconds(0.5), pane);
        battle_start_fade_2.setToValue(1.0);
        battle_start_fade_2.setFromValue(0.0);

        FadeTransition battle_start_fade_3 = new FadeTransition(Duration.seconds(0.5), pane);
        battle_start_fade_3.setToValue(0.0);
        battle_start_fade_3.setFromValue(1.0);

        SequentialTransition full_transition = new SequentialTransition(battle_start_fade_1, battle_start_fade_2, battle_start_fade_3);
        full_transition.play();

        InputStream stream_1 = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Main_Arena.png");
        Image menu_option = new Image(stream_1);
        ImageView menu_option_view = new ImageView(menu_option);
        battle.getChildren().add(menu_option_view);
        menu_option_view.setVisible(false);

        InputStream stream_2 = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Text_Box_Main.png");
        Image text_box = new Image(stream_2);
        ImageView text_box_view = new ImageView(text_box);
        battle.getChildren().add(text_box_view);
        text_box_view.setVisible(false);

        InputStream stream_3 = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Text_Box_Options.png");
        Image text_option = new Image(stream_3);
        ImageView text_option_view = new ImageView(text_option);
        battle.getChildren().add(text_option_view);
        text_option_view.setVisible(false);

        InputStream stream_10 = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/hp_bar_you.png");
        Image hp_bar_you = new Image(stream_10);
        ImageView hp_bar_you_view = new ImageView(hp_bar_you);
        battle.getChildren().add(hp_bar_you_view);
        hp_bar_you_view.setVisible(false);

        InputStream stream_11 = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/hp_bar_opponent.png");
        Image hp_bar_opponent = new Image(stream_11);
        ImageView hp_bar_opponent_view = new ImageView(hp_bar_opponent);
        battle.getChildren().add(hp_bar_opponent_view);
        hp_bar_opponent_view.setVisible(false);

        InputStream stream_4 = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Hp_menu_you.png");
        Image Hp_menu_you = new Image(stream_4);
        ImageView Hp_menu_you_view = new ImageView(Hp_menu_you);
        battle.getChildren().add(Hp_menu_you_view);
        Hp_menu_you_view.setVisible(false);

        InputStream stream_5 = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Hp_menu_opponent.png");
        Image Hp_menu_opponent = new Image(stream_5);
        ImageView Hp_menu_opponent_view = new ImageView(Hp_menu_opponent);
        battle.getChildren().add(Hp_menu_opponent_view);
        Hp_menu_opponent_view.setVisible(false);

        InputStream stream_12 = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/white_cover.png");
        Image cover = new Image(stream_12);
        ImageView cover_view = new ImageView(cover);
        battle.getChildren().add(cover_view);
        cover_view.setVisible(false);

        InputStream stream_6 = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/1_Option_Arrow.png");
        Image one_arrow = new Image(stream_6);
        ImageView one_arrow_view = new ImageView(one_arrow);
        battle.getChildren().add(one_arrow_view);
        one_arrow_view.setVisible(false);

        InputStream stream_7 = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/2_Option_Arrow.png");
        Image two_arrow = new Image(stream_7);
        ImageView two_arrow_view = new ImageView(two_arrow);
        battle.getChildren().add(two_arrow_view);
        two_arrow_view.setVisible(false);

        InputStream stream_8 = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/3_Option_Arrow.png");
        Image three_arrow = new Image(stream_8);
        ImageView three_arrow_view = new ImageView(three_arrow);
        battle.getChildren().add(three_arrow_view);
        three_arrow_view.setVisible(false);

        InputStream stream_9 = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/4_Option_Arrow.png");
        Image four_arrow = new Image(stream_9);
        ImageView four_arrow_view = new ImageView(four_arrow);
        battle.getChildren().add(four_arrow_view);
        four_arrow_view.setVisible(false);

        InputStream stream_13 = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/covermyass.png");
        Image covermyass = new Image(stream_13);
        ImageView covermyass_view = new ImageView(covermyass);
        battle.getChildren().add(covermyass_view);
        covermyass_view.setVisible(false);

        InputStream stream_14 = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/covermyass2.png");
        Image covermyass2 = new Image(stream_14);
        ImageView covermyass2_view = new ImageView(covermyass2);
        battle.getChildren().add(covermyass2_view);
        covermyass2_view.setVisible(false);

        ArrayList<ImageView> player_sprite_list = new ArrayList<>();
        ArrayList<ImageView> opponent_sprite_list = new ArrayList<>();

        InputStream stream_15 = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Player/Boy_you_1.png");
        Image boy1 = new Image(stream_15);
        ImageView boy1_view = new ImageView(boy1);
        battle.getChildren().add(boy1_view);
        boy1_view.setVisible(false);
        player_sprite_list.add(boy1_view);

        InputStream stream_16 = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Player/Boy_you_2.png");
        Image boy2 = new Image(stream_16);
        ImageView boy2_view = new ImageView(boy2);
        battle.getChildren().add(boy2_view);
        boy2_view.setVisible(false);
        player_sprite_list.add(boy2_view);

        InputStream stream_17 = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Player/Boy_you_3.png");
        Image boy3 = new Image(stream_17);
        ImageView boy3_view = new ImageView(boy3);
        battle.getChildren().add(boy3_view);
        boy3_view.setVisible(false);
        player_sprite_list.add(boy3_view);

        InputStream stream_18 = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Player/Boy_you_4.png");
        Image boy4 = new Image(stream_18);
        ImageView boy4_view = new ImageView(boy4);
        battle.getChildren().add(boy4_view);
        boy4_view.setVisible(false);
        player_sprite_list.add(boy4_view);

        InputStream stream_19 = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Player/Girl_you_1.png");
        Image girl1 = new Image(stream_19);
        ImageView girl1_view = new ImageView(girl1);
        battle.getChildren().add(girl1_view);
        girl1_view.setVisible(false);
        player_sprite_list.add(girl1_view);

        InputStream stream_20 = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Player/Girl_you_2.png");
        Image girl2 = new Image(stream_20);
        ImageView girl2_view = new ImageView(girl2);
        battle.getChildren().add(girl2_view);
        girl2_view.setVisible(false);
        player_sprite_list.add(girl2_view);

        InputStream stream_21 = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Opponent/Girl_they_1.png");
        Image girl_they_1 = new Image(stream_21);
        ImageView girl_they_1_view = new ImageView(girl_they_1);
        battle.getChildren().add(girl_they_1_view);
        girl_they_1_view.setVisible(false);
        opponent_sprite_list.add(girl_they_1_view);

        InputStream stream_22 = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Opponent/Girl_they_2.png");
        Image girl_they_2 = new Image(stream_22);
        ImageView girl_they_2_view = new ImageView(girl_they_2);
        battle.getChildren().add(girl_they_2_view);
        girl_they_2_view.setVisible(false);
        opponent_sprite_list.add(girl_they_2_view);

        InputStream stream_23 = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Opponent/Boy_they_1.png");
        Image boy_they_1 = new Image(stream_23);
        ImageView boy_they_1_view = new ImageView(boy_they_1);
        battle.getChildren().add(boy_they_1_view);
        boy_they_1_view.setVisible(false);
        opponent_sprite_list.add(boy_they_1_view);

        InputStream stream_24 = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Opponent/Boy_they_2.png");
        Image boy_they_2 = new Image(stream_24);
        ImageView boy_they_2_view = new ImageView(boy_they_2);
        battle.getChildren().add(boy_they_2_view);
        boy_they_2_view.setVisible(false);
        opponent_sprite_list.add(boy_they_2_view);

        InputStream stream_25 = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Opponent/Jude.png");
        Image jude = new Image(stream_25);
        ImageView jude_view = new ImageView(jude);
        battle.getChildren().add(jude_view);
        jude_view.setVisible(false);
        opponent_sprite_list.add(jude_view);

        setAllSprite(opponent_sprite_list, player_sprite_list, read.students_list);

        ArrayList<Image> alphabet = new ArrayList<>();

        InputStream A = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Keys/A.png");
        Image a = new Image(A);
        alphabet.add(a);

        InputStream B = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Keys/B.png");
        Image b = new Image(B);
        alphabet.add(b);

        InputStream C = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Keys/C.png");
        Image c = new Image(C);
        alphabet.add(c);

        InputStream D = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Keys/D.png");
        Image d = new Image(D);
        alphabet.add(d);

        InputStream E = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Keys/E.png");
        Image e = new Image(E);
        alphabet.add(e);

        InputStream F = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Keys/F.png");
        Image f = new Image(F);
        alphabet.add(f);

        InputStream G = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Keys/G.png");
        Image g = new Image(G);
        alphabet.add(g);

        InputStream H = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Keys/H.png");
        Image h = new Image(H);
        alphabet.add(h);

        InputStream I = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Keys/I.png");
        Image i = new Image(I);
        alphabet.add(i);

        InputStream J = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Keys/J.png");
        Image j = new Image(J);
        alphabet.add(j);

        InputStream K = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Keys/K.png");
        Image k = new Image(K);
        alphabet.add(k);

        InputStream L = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Keys/L.png");
        Image l = new Image(L);
        alphabet.add(l);

        InputStream M = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Keys/M.png");
        Image m = new Image(M);
        alphabet.add(m);

        InputStream N = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Keys/N.png");
        Image n = new Image(N);
        alphabet.add(n);

        InputStream O = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Keys/O.png");
        Image o = new Image(O);
        alphabet.add(o);

        InputStream P = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Keys/P.png");
        Image p = new Image(P);
        alphabet.add(p);

        InputStream Q = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Keys/Q.png");
        Image q = new Image(Q);
        alphabet.add(q);

        InputStream R = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Keys/R.png");
        Image r = new Image(R);
        alphabet.add(r);

        InputStream S = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Keys/S.png");
        Image s = new Image(S);
        alphabet.add(s);

        InputStream T = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Keys/T.png");
        Image t = new Image(T);
        alphabet.add(t);

        InputStream U = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Keys/U.png");
        Image u = new Image(U);
        alphabet.add(u);

        InputStream V = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Keys/V.png");
        Image v = new Image(V);
        alphabet.add(v);

        InputStream W = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Keys/W.png");
        Image w = new Image(W);
        alphabet.add(w);

        InputStream X = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Keys/X.png");
        Image x = new Image(X);
        alphabet.add(x);

        InputStream Y = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Keys/Y.png");
        Image y = new Image(Y);
        alphabet.add(y);

        InputStream Z = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Keys/Z.png");
        Image z = new Image(Z);
        alphabet.add(z);

        InputStream Non = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/Keys/Non.png");
        Image non = new Image(Non);
        alphabet.add(non);

        ArrayList<ImageView> text_one = new ArrayList<>();
        ArrayList<ImageView> text_two = new ArrayList<>();
        ArrayList<ImageView> text_three = new ArrayList<>();
        ArrayList<ImageView> text_four = new ArrayList<>();

        ImageView one_one = new ImageView(non);
        one_one.setX(580);
        one_one.setY(608);
        battle.getChildren().add(one_one);
        one_one.setVisible(false);
        text_one.add(one_one);

        ImageView two_one = new ImageView(non);
        two_one.setX(600);
        two_one.setY(608);
        battle.getChildren().add(two_one);
        two_one.setVisible(false);
        text_one.add(two_one);

        ImageView three_one = new ImageView(non);
        three_one.setX(620);
        three_one.setY(608);
        battle.getChildren().add(three_one);
        three_one.setVisible(false);
        text_one.add(three_one);

        ImageView four_one = new ImageView(non);
        four_one.setX(640);
        four_one.setY(608);
        battle.getChildren().add(four_one);
        four_one.setVisible(false);
        text_one.add(four_one);

        ImageView five_one = new ImageView(non);
        five_one.setX(660);
        five_one.setY(608);
        battle.getChildren().add(five_one);
        five_one.setVisible(false);
        text_one.add(five_one);

        ImageView six_one = new ImageView(non);
        six_one.setX(680);
        six_one.setY(608);
        battle.getChildren().add(six_one);
        six_one.setVisible(false);
        text_one.add(six_one);

        ImageView seven_one = new ImageView(non);
        seven_one.setX(700);
        seven_one.setY(608);
        battle.getChildren().add(seven_one);
        seven_one.setVisible(false);
        text_one.add(seven_one);

        ImageView eight_one = new ImageView(non);
        eight_one.setX(720);
        eight_one.setY(608);
        battle.getChildren().add(eight_one);
        eight_one.setVisible(false);
        text_one.add(eight_one);

        ImageView nine_one = new ImageView(non);
        nine_one.setX(740);
        nine_one.setY(608);
        battle.getChildren().add(nine_one);
        nine_one.setVisible(false);
        text_one.add(nine_one);

        ImageView one_two = new ImageView(non);
        one_two.setX(790);
        one_two.setY(608);
        battle.getChildren().add(one_two);
        one_two.setVisible(false);
        text_two.add(one_two);

        ImageView two_two = new ImageView(non);
        two_two.setX(810);
        two_two.setY(608);
        battle.getChildren().add(two_two);
        two_two.setVisible(false);
        text_two.add(two_two);

        ImageView three_two = new ImageView(non);
        three_two.setX(830);
        three_two.setY(608);
        battle.getChildren().add(three_two);
        three_two.setVisible(false);
        text_two.add(three_two);

        ImageView four_two = new ImageView(non);
        four_two.setX(850);
        four_two.setY(608);
        battle.getChildren().add(four_two);
        four_two.setVisible(false);
        text_two.add(four_two);

        ImageView five_two = new ImageView(non);
        five_two.setX(870);
        five_two.setY(608);
        battle.getChildren().add(five_two);
        five_two.setVisible(false);
        text_two.add(five_two);

        ImageView six_two = new ImageView(non);
        six_two.setX(890);
        six_two.setY(608);
        battle.getChildren().add(six_two);
        six_two.setVisible(false);
        text_two.add(six_two);

        ImageView seven_two = new ImageView(non);
        seven_two.setX(910);
        seven_two.setY(608);
        battle.getChildren().add(seven_two);
        seven_two.setVisible(false);
        text_two.add(seven_two);

        ImageView eight_two = new ImageView(non);
        eight_two.setX(930);
        eight_two.setY(608);
        battle.getChildren().add(eight_two);
        eight_two.setVisible(false);
        text_two.add(eight_two);

        ImageView nine_two = new ImageView(non);
        nine_two.setX(950);
        nine_two.setY(608);
        battle.getChildren().add(nine_two);
        nine_two.setVisible(false);
        text_two.add(nine_two);

        ImageView one_three = new ImageView(non);
        one_three.setX(580);
        one_three.setY(679);
        battle.getChildren().add(one_three);
        one_three.setVisible(false);
        text_three.add(one_three);

        ImageView two_three = new ImageView(non);
        two_three.setX(600);
        two_three.setY(679);
        battle.getChildren().add(two_three);
        two_three.setVisible(false);
        text_three.add(two_three);

        ImageView three_three = new ImageView(non);
        three_three.setX(620);
        three_three.setY(679);
        battle.getChildren().add(three_three);
        three_three.setVisible(false);
        text_three.add(three_three);

        ImageView four_three = new ImageView(non);
        four_three.setX(640);
        four_three.setY(679);
        battle.getChildren().add(four_three);
        four_three.setVisible(false);
        text_three.add(four_three);

        ImageView five_three = new ImageView(non);
        five_three.setX(660);
        five_three.setY(679);
        battle.getChildren().add(five_three);
        five_three.setVisible(false);
        text_three.add(five_three);

        ImageView six_three = new ImageView(non);
        six_three.setX(680);
        six_three.setY(679);
        battle.getChildren().add(six_three);
        six_three.setVisible(false);
        text_three.add(six_three);

        ImageView seven_three = new ImageView(non);
        seven_three.setX(700);
        seven_three.setY(679);
        battle.getChildren().add(seven_three);
        seven_three.setVisible(false);
        text_three.add(seven_three);

        ImageView eight_three = new ImageView(non);
        eight_three.setX(720);
        eight_three.setY(679);
        battle.getChildren().add(eight_three);
        eight_three.setVisible(false);
        text_three.add(eight_three);

        ImageView nine_three = new ImageView(non);
        nine_three.setX(740);
        nine_three.setY(679);
        battle.getChildren().add(nine_three);
        nine_three.setVisible(false);
        text_three.add(nine_three);

        ImageView one_four = new ImageView(non);
        one_four.setX(790);
        one_four.setY(679);
        battle.getChildren().add(one_four);
        one_four.setVisible(false);
        text_four.add(one_four);

        ImageView two_four = new ImageView(non);
        two_four.setX(810);
        two_four.setY(679);
        battle.getChildren().add(two_four);
        two_four.setVisible(false);
        text_four.add(two_four);

        ImageView three_four = new ImageView(non);
        three_four.setX(830);
        three_four.setY(679);
        battle.getChildren().add(three_four);
        three_four.setVisible(false);
        text_four.add(three_four);

        ImageView four_four = new ImageView(non);
        four_four.setX(850);
        four_four.setY(679);
        battle.getChildren().add(four_four);
        four_four.setVisible(false);
        text_four.add(four_four);

        ImageView five_four = new ImageView(non);
        five_four.setX(870);
        five_four.setY(679);
        battle.getChildren().add(five_four);
        five_four.setVisible(false);
        text_four.add(five_four);

        ImageView six_four = new ImageView(non);
        six_four.setX(890);
        six_four.setY(679);
        battle.getChildren().add(six_four);
        six_four.setVisible(false);
        text_four.add(six_four);

        ImageView seven_four = new ImageView(non);
        seven_four.setX(910);
        seven_four.setY(679);
        battle.getChildren().add(seven_four);
        seven_four.setVisible(false);
        text_four.add(seven_four);

        ImageView eight_four = new ImageView(non);
        eight_four.setX(930);
        eight_four.setY(679);
        battle.getChildren().add(eight_four);
        eight_four.setVisible(false);
        text_four.add(eight_four);

        ImageView nine_four = new ImageView(non);
        nine_four.setX(950);
        nine_four.setY(679);
        battle.getChildren().add(nine_four);
        nine_four.setVisible(false);
        text_four.add(nine_four);

        Rectangle transition_block_1 = new Rectangle(1000, 187.5, Color.rgb(86, 121, 136));
        transition_block_1.setX(-1000);
        transition_block_1.setY(0);

        TranslateTransition transition_move_block_1 = new TranslateTransition(Duration.seconds(0.5), transition_block_1);
        transition_move_block_1.setFromX(-1000);
        transition_move_block_1.setToX(0);

        Rectangle transition_block_2 = new Rectangle(1000, 187.5, Color.rgb(87, 192, 234));
        transition_block_2.setX(1000);
        transition_block_2.setY(187.5);
        transition_block_2.setRotate(180);

        TranslateTransition transition_move_block_2 = new TranslateTransition(Duration.seconds(0.5), transition_block_2);
        transition_move_block_2.setFromX(1000);
        transition_move_block_2.setToX(0);

        Rectangle transition_block_3 = new Rectangle(1000, 187.5, Color.rgb(86, 121, 136));
        transition_block_3.setX(-1000);
        transition_block_3.setY(375);

        TranslateTransition transition_move_block_3 = new TranslateTransition(Duration.seconds(0.5), transition_block_3);
        transition_move_block_3.setFromX(-1000);
        transition_move_block_3.setToX(0);

        Rectangle transition_block_4 = new Rectangle(1000, 187.5,  Color.rgb(87, 192, 234));
        transition_block_4.setX(1000);
        transition_block_4.setY(562.5);
        transition_block_4.setRotate(180);

        TranslateTransition transition_move_block_4 = new TranslateTransition(Duration.seconds(0.5), transition_block_4);
        transition_move_block_4.setFromX(1000);
        transition_move_block_4.setToX(0);

        SequentialTransition full_block = new SequentialTransition(transition_move_block_1, transition_move_block_2, transition_move_block_3, transition_move_block_4);

        battle.getChildren().addAll(transition_block_1, transition_block_2, transition_block_3, transition_block_4);

        TranslateTransition transition_move_block_1_reverse = new TranslateTransition(Duration.seconds(0.5), transition_block_1);
        transition_move_block_1_reverse.setFromX(0);
        transition_move_block_1_reverse.setToX(-1000);

        TranslateTransition transition_move_block_2_reverse = new TranslateTransition(Duration.seconds(0.5), transition_block_2);
        transition_move_block_2_reverse.setFromX(0);
        transition_move_block_2_reverse.setToX(1000);

        TranslateTransition transition_move_block_3_reverse = new TranslateTransition(Duration.seconds(0.5), transition_block_3);
        transition_move_block_3_reverse.setFromX(0);
        transition_move_block_3_reverse.setToX(-1000);

        TranslateTransition transition_move_block_4_reverse = new TranslateTransition(Duration.seconds(0.5), transition_block_4);
        transition_move_block_4_reverse.setFromX(0);
        transition_move_block_4_reverse.setToX(1000);

        SequentialTransition full_block_reverse = new SequentialTransition(transition_move_block_4_reverse, transition_move_block_3_reverse, transition_move_block_2_reverse, transition_move_block_1_reverse);

        final int[] current_arrow = {1};
        final int[] current_status_you = {0, 0};
        final int[] current_status_opponent = {0, 0};
        blinkArrow(one_arrow_view);
        blinkArrow(two_arrow_view);
        blinkArrow(three_arrow_view);
        blinkArrow(four_arrow_view);
        Timeline timeline_battle_2 = new Timeline(new KeyFrame(Duration.seconds(2.5), bruh -> {
            menu_option_view.setVisible(true);
            text_box_view.setVisible(true);
            text_option_view.setVisible(true);
            Hp_menu_you_view.setVisible(true);
            Hp_menu_opponent_view.setVisible(true);
            hp_bar_you_view.setVisible(true);
            hp_bar_opponent_view.setVisible(true);
            full_block_reverse.play();

            covermyass_view.setVisible(true);
            covermyass2_view.setVisible(true);
            one_arrow_view.setVisible(true);
        }));
        final int[] hp_player = {0, 0, 0, 0};
        final int[] hp_opponent = {0, 0, 0, 0};
        final int[] player_count = {0};
        final int[] opponent_count = {0};
        for (int xl = 0; xl < player.party.size(); xl++) {
            hp_player[xl] = player.getParty(xl).hit_points;
        }
        for (int xll = 0; xll < opponent.party.size(); xll++) {
            hp_opponent[xll] = opponent.getParty(xll).hit_points;
        }
        final Students[] current_students = {player.getParty(player_count[0]), opponent.getParty(opponent_count[0])};
        final String[] status = {"Main"};
        Timeline check = new Timeline(new KeyFrame(Duration.seconds(5), bruh2 -> {
            current_students[0].trueSprite_back.setVisible(true);
            current_students[1].trueSprite_front.setVisible(true);
            battle_scene.setOnKeyPressed(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.UP) {
                    if (current_arrow[0] == 3) {
                        current_arrow[0] = 1;
                        three_arrow_view.setVisible(false);
                        one_arrow_view.setVisible(true);
                    } else if (current_arrow[0] == 4) {
                        current_arrow[0] = 2;
                        four_arrow_view.setVisible(false);
                        two_arrow_view.setVisible(true);
                    }
                } else if (keyEvent.getCode() == KeyCode.DOWN) {
                    if (current_arrow[0] == 1) {
                        current_arrow[0] = 3;
                        three_arrow_view.setVisible(true);
                        one_arrow_view.setVisible(false);
                    } else if (current_arrow[0] == 2) {
                        current_arrow[0] = 4;
                        four_arrow_view.setVisible(true);
                        two_arrow_view.setVisible(false);
                    }
                } else if (keyEvent.getCode() == KeyCode.RIGHT) {
                    if (current_arrow[0] == 1) {
                        current_arrow[0] = 2;
                        one_arrow_view.setVisible(false);
                        two_arrow_view.setVisible(true);
                    } else if (current_arrow[0] == 3) {
                        current_arrow[0] = 4;
                        three_arrow_view.setVisible(false);
                        four_arrow_view.setVisible(true);
                    }
                } else if (keyEvent.getCode() == KeyCode.LEFT) {
                    if (current_arrow[0] == 2) {
                        current_arrow[0] = 1;
                        two_arrow_view.setVisible(false);
                        one_arrow_view.setVisible(true);
                    } else if (current_arrow[0] == 4) {
                        current_arrow[0] = 3;
                        four_arrow_view.setVisible(false);
                        three_arrow_view.setVisible(true);
                    }
                } else if (keyEvent.getCode() == KeyCode.SPACE && status[0].equals("Main") && current_arrow[0] == 1) {
                    status[0] = "Fight";
                    cover_view.setVisible(true);
                    textBuilder(text_one, alphabet, current_students[0].move_1.name);
                    for (ImageView imageView : text_one) {
                        imageView.setVisible(true);
                    }
                    textBuilder(text_two, alphabet, current_students[0].move_2.name);
                    for (ImageView imageView : text_two) {
                        imageView.setVisible(true);
                    }
                    textBuilder(text_three, alphabet, current_students[0].move_3.name);
                    for (ImageView imageView : text_three) {
                        imageView.setVisible(true);
                    }
                    textBuilder(text_four, alphabet, current_students[0].move_4.name);
                    for (ImageView imageView : text_four) {
                        imageView.setVisible(true);
                    }
                } else if (keyEvent.getCode() == KeyCode.SPACE && status[0].equals("Main") && current_arrow[0] == 2) {
                    status[0] = "Commend";
                    cover_view.setVisible(true);
                    textBuilder(text_one, alphabet, player.commend);
                    for (ImageView imageView : text_one) {
                        imageView.setVisible(true);
                    }
                } else if (keyEvent.getCode() == KeyCode.SPACE && status[0].equals("Main") && current_arrow[0] == 3) {
                    status[0] = "Student";
                    cover_view.setVisible(true);
                    textBuilder(text_one, alphabet, player.getParty(0).name);
                    for (ImageView imageView : text_one) {
                        imageView.setVisible(true);
                    }
                    textBuilder(text_two, alphabet, player.getParty(1).name);
                    for (ImageView imageView : text_two) {
                        imageView.setVisible(true);
                    }
                    textBuilder(text_three, alphabet, player.getParty(2).name);
                    for (ImageView imageView : text_three) {
                        imageView.setVisible(true);
                    }
                    textBuilder(text_four, alphabet, player.getParty(3).name);
                    for (ImageView imageView : text_four) {
                        imageView.setVisible(true);
                    }
                } else if (keyEvent.getCode() == KeyCode.SPACE && status[0].equals("Main") && current_arrow[0] == 4) {
                    status[0] = "Forfeit";
                    try {
                        openWorld(vBox, stage);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                } else if (keyEvent.getCode() == KeyCode.ESCAPE && (status[0].equals("Fight") || status[0].equals("Commend") || status[0].equals("Student") || status[0].equals("Forfeit"))) {
                    status[0] = "Main";
                    cover_view.setVisible(false);
                    textBuilder(text_one, alphabet, "Non");
                    for (ImageView imageView : text_one) {
                        imageView.setVisible(false);
                    }
                    textBuilder(text_two, alphabet, "Non");
                    for (ImageView imageView : text_two) {
                        imageView.setVisible(false);
                    }
                    textBuilder(text_three, alphabet, "Non");
                    for (ImageView imageView : text_three) {
                        imageView.setVisible(false);
                    }
                    textBuilder(text_four, alphabet, "Non");
                    for (ImageView imageView : text_four) {
                        imageView.setVisible(false);
                    }
                } else if (keyEvent.getCode() == KeyCode.SPACE && status[0].equals("Student") && current_arrow[0] == 1) {
                    current_students[0].trueSprite_back.setVisible(false);
                    current_students[0] = player.getParty(0);
                    current_status_you[0] = 0;
                    current_status_you[1] = 0;
                    player_count[0] = 0;
                    current_students[0].trueSprite_back.setVisible(true);
                    hp_bar_you_view.setX(0);
                    hpBarMove(hp_bar_you_view, current_students[0], 0, hp_player[player_count[0]]);
                    status[0] = "Main";
                    cover_view.setVisible(false);
                    textBuilder(text_one, alphabet, "Non");
                    for (ImageView imageView : text_one) {
                        imageView.setVisible(false);
                    }
                    textBuilder(text_two, alphabet, "Non");
                    for (ImageView imageView : text_two) {
                        imageView.setVisible(false);
                    }
                    textBuilder(text_three, alphabet, "Non");
                    for (ImageView imageView : text_three) {
                        imageView.setVisible(false);
                    }
                    textBuilder(text_four, alphabet, "Non");
                    for (ImageView imageView : text_four) {
                        imageView.setVisible(false);
                    }
                } else if (keyEvent.getCode() == KeyCode.SPACE && status[0].equals("Student") && current_arrow[0] == 2) {
                    current_students[0].trueSprite_back.setVisible(false);
                    current_students[0] = player.getParty(1);
                    current_status_you[0] = 0;
                    current_status_you[1] = 0;
                    player_count[0] = 1;
                    current_students[0].trueSprite_back.setVisible(true);
                    hp_bar_you_view.setX(0);
                    hpBarMove(hp_bar_you_view, current_students[0], 0, hp_player[player_count[0]]);
                    status[0] = "Main";
                    cover_view.setVisible(false);
                    textBuilder(text_one, alphabet, "Non");
                    for (ImageView imageView : text_one) {
                        imageView.setVisible(false);
                    }
                    textBuilder(text_two, alphabet, "Non");
                    for (ImageView imageView : text_two) {
                        imageView.setVisible(false);
                    }
                    textBuilder(text_three, alphabet, "Non");
                    for (ImageView imageView : text_three) {
                        imageView.setVisible(false);
                    }
                    textBuilder(text_four, alphabet, "Non");
                    for (ImageView imageView : text_four) {
                        imageView.setVisible(false);
                    }
                } else if (keyEvent.getCode() == KeyCode.SPACE && status[0].equals("Student") && current_arrow[0] == 3) {
                    current_students[0].trueSprite_back.setVisible(false);
                    current_students[0] = player.getParty(2);
                    current_status_you[0] = 0;
                    current_status_you[1] = 0;
                    player_count[0] = 2;
                    current_students[0].trueSprite_back.setVisible(true);
                    hp_bar_you_view.setX(0);
                    hpBarMove(hp_bar_you_view, current_students[0], 0, hp_player[player_count[0]]);
                    status[0] = "Main";
                    cover_view.setVisible(false);
                    textBuilder(text_one, alphabet, "Non");
                    for (ImageView imageView : text_one) {
                        imageView.setVisible(false);
                    }
                    textBuilder(text_two, alphabet, "Non");
                    for (ImageView imageView : text_two) {
                        imageView.setVisible(false);
                    }
                    textBuilder(text_three, alphabet, "Non");
                    for (ImageView imageView : text_three) {
                        imageView.setVisible(false);
                    }
                    textBuilder(text_four, alphabet, "Non");
                    for (ImageView imageView : text_four) {
                        imageView.setVisible(false);
                    }
                } else if (keyEvent.getCode() == KeyCode.SPACE && status[0].equals("Student") && current_arrow[0] == 4) {
                    current_students[0].trueSprite_back.setVisible(false);
                    current_students[0] = player.getParty(3);
                    current_status_you[0] = 0;
                    current_status_you[1] = 0;
                    player_count[0] = 3;
                    current_students[0].trueSprite_back.setVisible(true);
                    hp_bar_you_view.setX(0);
                    hpBarMove(hp_bar_you_view, current_students[0], 0, hp_player[player_count[0]]);
                    status[0] = "Main";
                    cover_view.setVisible(false);
                    textBuilder(text_one, alphabet, "Non");
                    for (ImageView imageView : text_one) {
                        imageView.setVisible(false);
                    }
                    textBuilder(text_two, alphabet, "Non");
                    for (ImageView imageView : text_two) {
                        imageView.setVisible(false);
                    }
                    textBuilder(text_three, alphabet, "Non");
                    for (ImageView imageView : text_three) {
                        imageView.setVisible(false);
                    }
                    textBuilder(text_four, alphabet, "Non");
                    for (ImageView imageView : text_four) {
                        imageView.setVisible(false);
                    }
                } else if (keyEvent.getCode() == KeyCode.SPACE && status[0].equals("Fight") && current_arrow[0] == 1 && hp_player[player_count[0]] > 0) {
                    status[0] = "Main";
                    int output = damageCalculation(current_students[0],current_students[1],current_students[0].move_1, current_status_you, current_status_opponent);
                    if (output == 0) {
                        if (current_students[0].move_1.name.equals("Study")) {
                            current_status_you[0] += (current_students[0].attack / 2);
                        } else if (current_students[0].move_1.name.equals("Prstnte")) {
                            if (hp_player[player_count[0]] + 50 > current_students[0].hit_points) {
                                hp_player[player_count[0]] = current_students[0].hit_points;
                            } else {
                                hp_player[player_count[0]] += 50;
                            }
                        } else if (current_students[0].move_1.name.equals("Fortitude")) {
                            current_status_you[1] += (current_students[0].defense / 2);
                        }
                    }
                    int dmgTaken = RandomTakenDmg(current_students[1], current_students[0], current_status_opponent , current_status_you);
                    if (dmgTaken < 1) {
                        dmgTaken = 1;
                    }
                    hpBarMove(hp_bar_opponent_view, current_students[1], output, hp_opponent[opponent_count[0]]);
                    hpBarMove(hp_bar_you_view, current_students[0], dmgTaken, hp_player[player_count[0]]);
                    hp_opponent[opponent_count[0]] -= output;
                    hp_player[player_count[0]] -= dmgTaken;
                    if (hp_opponent[opponent_count[0]] <= 0) {
                        for (int hk = 0; hk <hp_opponent.length; hk++) {
                            current_status_opponent[0] = 0;
                            current_status_opponent[1] = 0;
                            if (hp_opponent[hk] > 0)  {
                                opponent_count[0] = hk;
                                current_students[1].trueSprite_front.setVisible(false);
                                current_students[1] = opponent.getParty(hk);
                                current_students[1].trueSprite_front.setVisible(true);
                                hp_bar_opponent_view.setX(0);
                                hpBarMove(hp_bar_opponent_view, current_students[1], 0, hp_opponent[opponent_count[0]]);
                                hk += 4;
                            }
                        }
                    }
                    String check_2 = check(hp_player, hp_opponent);
                    if (check_2.equals("Lose")) {
                        try {
                            loseScreen(stage, battle);
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    } else if (check_2.equals("Win")) {
                        try {
                            winScreen(stage, battle);
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    cover_view.setVisible(false);
                    textBuilder(text_one, alphabet, "Non");
                    for (ImageView imageView : text_one) {
                        imageView.setVisible(false);
                    }
                    textBuilder(text_two, alphabet, "Non");
                    for (ImageView imageView : text_two) {
                        imageView.setVisible(false);
                    }
                    textBuilder(text_three, alphabet, "Non");
                    for (ImageView imageView : text_three) {
                        imageView.setVisible(false);
                    }
                    textBuilder(text_four, alphabet, "Non");
                    for (ImageView imageView : text_four) {
                        imageView.setVisible(false);
                    }
                } else if (keyEvent.getCode() == KeyCode.SPACE && status[0].equals("Fight") && current_arrow[0] == 2 && hp_player[player_count[0]] > 0) {
                    status[0] = "Main";
                    int output = damageCalculation(current_students[0],current_students[1],current_students[0].move_2, current_status_you, current_status_opponent);
                    if (output == 0) {
                        if (current_students[0].move_2.name.equals("Study")) {
                            current_status_you[0] += (current_students[0].attack / 2);
                        } else if (current_students[0].move_2.name.equals("Prstnte")) {
                            if (hp_player[player_count[0]] + 50 > current_students[0].hit_points) {
                                hp_player[player_count[0]] = current_students[0].hit_points;
                            } else {
                                hp_player[player_count[0]] += 50;
                            }
                        } else if (current_students[0].move_2.name.equals("Fortitude")) {
                            current_status_you[1] += (current_students[0].defense / 2);
                        }
                    }
                    int dmgTaken = RandomTakenDmg(current_students[1], current_students[0], current_status_opponent , current_status_you);
                    if (dmgTaken < 1) {
                        dmgTaken = 1;
                    }
                    hpBarMove(hp_bar_opponent_view, current_students[1], output, hp_opponent[opponent_count[0]]);
                    hpBarMove(hp_bar_you_view, current_students[0], dmgTaken, hp_player[player_count[0]]);
                    hp_opponent[opponent_count[0]] -= output;
                    hp_player[player_count[0]] -= dmgTaken;
                    if (hp_opponent[opponent_count[0]] <= 0) {
                        current_status_opponent[0] = 0;
                        current_status_opponent[1] = 0;
                        for (int hk = 0; hk <hp_opponent.length; hk++) {
                            if (hp_opponent[hk] > 0)  {
                                opponent_count[0] = hk;
                                current_students[1].trueSprite_front.setVisible(false);
                                current_students[1] = opponent.getParty(hk);
                                current_students[1].trueSprite_front.setVisible(true);
                                hp_bar_opponent_view.setX(0);
                                hpBarMove(hp_bar_opponent_view, current_students[1], 0, hp_opponent[opponent_count[0]]);
                                hk += 4;
                            }
                        }
                    }
                    String check_2 = check(hp_player, hp_opponent);
                    if (check_2.equals("Lose")) {
                        try {
                            loseScreen(stage, battle);
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    } else if (check_2.equals("Win")) {
                        try {
                            winScreen(stage, battle);
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    cover_view.setVisible(false);
                    textBuilder(text_one, alphabet, "Non");
                    for (ImageView imageView : text_one) {
                        imageView.setVisible(false);
                    }
                    textBuilder(text_two, alphabet, "Non");
                    for (ImageView imageView : text_two) {
                        imageView.setVisible(false);
                    }
                    textBuilder(text_three, alphabet, "Non");
                    for (ImageView imageView : text_three) {
                        imageView.setVisible(false);
                    }
                    textBuilder(text_four, alphabet, "Non");
                    for (ImageView imageView : text_four) {
                        imageView.setVisible(false);
                    }
                } else if (keyEvent.getCode() == KeyCode.SPACE && status[0].equals("Fight") && current_arrow[0] == 3 && hp_player[player_count[0]] > 0) {
                    status[0] = "Main";
                    int output = damageCalculation(current_students[0],current_students[1],current_students[0].move_3, current_status_you, current_status_opponent);
                    if (output == 0) {
                        if (current_students[0].move_3.name.equals("Study")) {
                            current_status_you[0] += (current_students[0].attack / 2);
                        } else if (current_students[0].move_3.name.equals("Prstnte")) {
                            if (hp_player[player_count[0]] + 50 > current_students[0].hit_points) {
                                hp_player[player_count[0]] = current_students[0].hit_points;
                            } else {
                                hp_player[player_count[0]] += 50;
                            }
                        } else if (current_students[0].move_3.name.equals("Fortitude")) {
                            current_status_you[1] += (current_students[0].defense / 2);
                        }
                    }
                    int dmgTaken = RandomTakenDmg(current_students[1], current_students[0], current_status_opponent , current_status_you);
                    if (dmgTaken < 1) {
                        dmgTaken = 1;
                    }
                    hpBarMove(hp_bar_opponent_view, current_students[1], output, hp_opponent[opponent_count[0]]);
                    hpBarMove(hp_bar_you_view, current_students[0], dmgTaken, hp_player[player_count[0]]);
                    hp_opponent[opponent_count[0]] -= output;
                    hp_player[player_count[0]] -= dmgTaken;
                    if (hp_opponent[opponent_count[0]] <= 0) {
                        current_status_opponent[0] = 0;
                        current_status_opponent[1] = 0;
                        for (int hk = 0; hk <hp_opponent.length; hk++) {
                            if (hp_opponent[hk] > 0)  {
                                opponent_count[0] = hk;
                                current_students[1].trueSprite_front.setVisible(false);
                                current_students[1] = opponent.getParty(hk);
                                current_students[1].trueSprite_front.setVisible(true);
                                hp_bar_opponent_view.setX(0);
                                hpBarMove(hp_bar_opponent_view, current_students[1], 0, hp_opponent[opponent_count[0]]);
                                hk += 4;
                            }
                        }
                    }
                    String check_2 = check(hp_player, hp_opponent);
                    if (check_2.equals("Lose")) {
                        try {
                            loseScreen(stage, battle);
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    } else if (check_2.equals("Win")) {
                        try {
                            winScreen(stage, battle);
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    cover_view.setVisible(false);
                    textBuilder(text_one, alphabet, "Non");
                    for (ImageView imageView : text_one) {
                        imageView.setVisible(false);
                    }
                    textBuilder(text_two, alphabet, "Non");
                    for (ImageView imageView : text_two) {
                        imageView.setVisible(false);
                    }
                    textBuilder(text_three, alphabet, "Non");
                    for (ImageView imageView : text_three) {
                        imageView.setVisible(false);
                    }
                    textBuilder(text_four, alphabet, "Non");
                    for (ImageView imageView : text_four) {
                        imageView.setVisible(false);
                    }
                } else if (keyEvent.getCode() == KeyCode.SPACE && status[0].equals("Fight") && current_arrow[0] == 4 && hp_player[player_count[0]] > 0) {
                    status[0] = "Main";
                    int output = damageCalculation(current_students[0],current_students[1],current_students[0].move_4, current_status_you, current_status_opponent);
                    if (output == 0) {
                        if (current_students[0].move_4.name.equals("Study")) {
                            current_status_you[0] += (current_students[0].attack / 2);
                        } else if (current_students[0].move_4.name.equals("Prstnte")) {
                            if (hp_player[player_count[0]] + 50 > current_students[0].hit_points) {
                                hp_player[player_count[0]] = current_students[0].hit_points;
                            } else {
                                hp_player[player_count[0]] += 50;
                            }
                        } else if (current_students[0].move_4.name.equals("Fortitude")) {
                            current_status_you[1] += (current_students[0].defense / 2);
                        }
                    }
                    int dmgTaken = RandomTakenDmg(current_students[1], current_students[0], current_status_opponent , current_status_you);
                    if (dmgTaken < 1) {
                        dmgTaken = 1;
                    }
                    hpBarMove(hp_bar_opponent_view, current_students[1], output, hp_opponent[opponent_count[0]]);
                    hpBarMove(hp_bar_you_view, current_students[0], dmgTaken, hp_player[player_count[0]]);
                    hp_opponent[opponent_count[0]] -= output;
                    hp_player[player_count[0]] -= dmgTaken;
                    if (hp_opponent[opponent_count[0]] <= 0) {
                        current_status_opponent[0] = 0;
                        current_status_opponent[1] = 0;
                        for (int hk = 0; hk <hp_opponent.length; hk++) {
                            if (hp_opponent[hk] > 0)  {
                                opponent_count[0] = hk;
                                current_students[1].trueSprite_front.setVisible(false);
                                current_students[1] = opponent.getParty(hk);
                                current_students[1].trueSprite_front.setVisible(true);
                                hp_bar_opponent_view.setX(0);
                                hpBarMove(hp_bar_opponent_view, current_students[1], 0, hp_opponent[opponent_count[0]]);
                                hk += 4;
                            }
                        }
                    }
                    String check_2 = check(hp_player, hp_opponent);
                    if (check_2.equals("Lose")) {
                        try {
                            loseScreen(stage, battle);
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    } else if (check_2.equals("Win")) {
                        try {
                            winScreen(stage, battle);
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    cover_view.setVisible(false);
                    textBuilder(text_one, alphabet, "Non");
                    for (ImageView imageView : text_one) {
                        imageView.setVisible(false);
                    }
                    textBuilder(text_two, alphabet, "Non");
                    for (ImageView imageView : text_two) {
                        imageView.setVisible(false);
                    }
                    textBuilder(text_three, alphabet, "Non");
                    for (ImageView imageView : text_three) {
                        imageView.setVisible(false);
                    }
                    textBuilder(text_four, alphabet, "Non");
                    for (ImageView imageView : text_four) {
                        imageView.setVisible(false);
                    }
                } else if (keyEvent.getCode() == KeyCode.SPACE && status[0].equals("Commend") && current_arrow[0] == 1 && hp_player[player_count[0]] > 0) {
                    status[0] = "Main";
                    current_status_you[0] += 100;
                    cover_view.setVisible(false);
                    textBuilder(text_one, alphabet, "Non");
                    for (ImageView imageView : text_one) {
                        imageView.setVisible(false);
                    }
                    textBuilder(text_two, alphabet, "Non");
                    for (ImageView imageView : text_two) {
                        imageView.setVisible(false);
                    }
                    textBuilder(text_three, alphabet, "Non");
                    for (ImageView imageView : text_three) {
                        imageView.setVisible(false);
                    }
                    textBuilder(text_four, alphabet, "Non");
                    for (ImageView imageView : text_four) {
                        imageView.setVisible(false);
                    }
                }
            });
        }));

        Timeline timeline_transition = new Timeline(new KeyFrame(Duration.seconds(1.5), bruh -> {
            stage.setScene(battle_scene);
            full_block.play();
            transition_block_1.setX(0);
            transition_block_2.setX(0);
            transition_block_3.setX(0);
            transition_block_4.setX(0);
            timeline_battle_2.play();
            check.play();
        }));
        timeline_transition.play();
    }
    public void blink(Label label) {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1.5), label);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);

        FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(1.5), label);
        fadeTransition2.setFromValue(0.0);
        fadeTransition2.setToValue(1.0);

        SequentialTransition DoubleFade = new SequentialTransition(fadeTransition, fadeTransition2);
        DoubleFade.setCycleCount(Animation.INDEFINITE);
        DoubleFade.play();
    }
    public void blinkArrow(ImageView image) {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.3), image);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);

        FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(0.3), image);
        fadeTransition2.setFromValue(0.0);
        fadeTransition2.setToValue(1.0);

        SequentialTransition DoubleFade = new SequentialTransition(fadeTransition, fadeTransition2);
        DoubleFade.setCycleCount(Animation.INDEFINITE);
        DoubleFade.play();
    }
    public void textBuilder(ArrayList<ImageView> text, ArrayList<Image> alphabet, String string) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '_') {
                text.get(i).setImage(alphabet.get(26));
            } else if (string.charAt(i) == '-'){
                text.get(i).setImage(alphabet.get(26));
            } else {
                int j = string.toLowerCase().charAt(i) - 97;
                text.get(i).setImage(alphabet.get(j));
            }
        }
        if (string.equals("Non")) {
            for (ImageView imageView : text) {
                imageView.setImage(alphabet.get(26));
            }
        }
    }
    public int damageCalculation(Students player, Students opponent, Moves move, int[] buff_you, int[] buff_opponent) {
        Random rand = new Random();
        int max_random = 5;
        int hold;
        int pure_defense = (opponent.defense + buff_opponent[1]) / 2;
        int pure_power = move.Power;
        if (move.Power == 0) {
            if (move.name.equals("Raucous")) {
                pure_power = rand.nextInt(20, 80);
            } else if (move.name.equals("Show_Off")) {
                pure_power = rand.nextInt(30, 70);
            }
        }
        hold = ((((player.attack + buff_you[0]) - pure_defense) + rand.nextInt(max_random)) * pure_power / 80 );
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
    public void setAllSprite(ArrayList<ImageView> front, ArrayList<ImageView> back, ArrayList<Students> students) {
        for (Students student : students) {
            switch (student.sprite) {
                case "Girl1" -> {
                    student.trueSprite_front = front.get(0);
                    student.trueSprite_back = back.get(4);
                }
                case "Girl2" -> {
                    student.trueSprite_front = front.get(1);
                    student.trueSprite_back = back.get(5);
                }
                case "Boys1" -> {
                    student.trueSprite_front = front.get(2);
                    student.trueSprite_back = back.get(0);
                }
                case "Boys2" -> {
                    student.trueSprite_front = front.get(3);
                    student.trueSprite_back = back.get(1);
                }
                case "Jude1" -> student.trueSprite_front = front.get(4);
            }
        }
    }
    public String check(int[] hp_player, int[] hp_opponent) {
        if (hp_player[0] <= 0 && hp_player[1] <= 0 && hp_player[2] <= 0 && hp_player[3] <= 0) {
            return "Lose";
        } else if (hp_opponent[0] <= 0 && hp_opponent[1] <= 0 && hp_opponent[2] <= 0 && hp_opponent[3] <= 0) {
            return "Win";
        } else {
            return "Continue";
        }
    }
    public int RandomTakenDmg(Students opponent, Students player, int[] buff_opponent, int[] buff_you) {
        Random random = new Random();
        return damageCalculation(opponent, player, opponent.getMove(random.nextInt(1, 5)), buff_opponent, buff_you);
    }
    public void hpBarMove(ImageView hpBar, Students students, int Dmg, int currentHp) {
        int fullHp = students.hit_points;
        double times = 113.0 / fullHp;
        double resultingHp = currentHp - Dmg;
        double x = hpBar.getX();
        double translatedBar = -(113 - resultingHp * times);
        if (resultingHp <= 0 || x <= -112) {
            translatedBar = -113;
            x = -113;
        }

        TranslateTransition moveBar = new TranslateTransition(Duration.seconds(2), hpBar);
        moveBar.setFromX(x);
        moveBar.setToX(translatedBar);

        hpBar.setX(translatedBar);
        moveBar.play();
    }
    public void winScreen(Stage stage, Pane pane) throws FileNotFoundException {
        VBox win = new VBox();
        Scene win_scene = new Scene(win, screen_width, screen_height);
        Label label = new Label();
        win.getChildren().add(label);

        InputStream stream_background = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/win_img.png");
        Image background_view = new Image(stream_background);
        win.setBackground(new Background(new BackgroundImage(background_view, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        win.setVisible(false);

        FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(1.0), pane);
        fadeTransition1.setToValue(0.0);
        fadeTransition1.setFromValue(1.0);

        FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(2.0), win);
        fadeTransition2.setToValue(1.0);
        fadeTransition2.setFromValue(0.0);

        fadeTransition1.play();
        Timeline timeline1 = new Timeline(new KeyFrame(Duration.seconds(1), bruh -> {
            stage.setScene(win_scene);
            win.setVisible(true);
            fadeTransition2.play();
        }));
        timeline1.play();
        win_scene.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.SPACE) {
                try {
                    openWorld(win, stage);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
    public void loseScreen(Stage stage, Pane pane) throws FileNotFoundException {
        VBox lose = new VBox();
        Scene lose_scene = new Scene(lose, screen_width, screen_height);
        Label label = new Label();
        lose.getChildren().add(label);

        InputStream stream_background = new FileInputStream("C:/Users/micha/Downloads/Binusmon_Project/src/main/java/com/example/binusmon_project/img/lose_img.png");
        Image background_view = new Image(stream_background);
        lose.setBackground(new Background(new BackgroundImage(background_view, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        lose.setVisible(false);

        FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(1.0), pane);
        fadeTransition1.setToValue(0.0);
        fadeTransition1.setFromValue(1.0);

        FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(2.0), lose);
        fadeTransition2.setToValue(1.0);
        fadeTransition2.setFromValue(0.0);

        fadeTransition1.play();
        Timeline timeline1 = new Timeline(new KeyFrame(Duration.seconds(1), bruh -> {
            stage.setScene(lose_scene);
            lose.setVisible(true);
            fadeTransition2.play();
        }));
        timeline1.play();
        lose_scene.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.SPACE) {
                try {
                    openWorld(lose, stage);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
    public static void main(String[] args) throws IOException {
        read.createAll();
        // player character
        read.players_list.get(0).party.add(read.students_list.get(0));
        read.students_list.get(0).setMove(1, read.moves_list.get(0));
        read.students_list.get(0).setMove(2, read.moves_list.get(1));
        read.students_list.get(0).setMove(3, read.moves_list.get(3));

        read.players_list.get(0).party.add(read.students_list.get(1));
        read.students_list.get(1).setMove(1, read.moves_list.get(2));
        read.students_list.get(1).setMove(2, read.moves_list.get(8));
        read.students_list.get(1).setMove(3, read.moves_list.get(4));

        read.players_list.get(0).party.add(read.students_list.get(4));
        read.students_list.get(4).setMove(1, read.moves_list.get(4));
        read.students_list.get(4).setMove(2, read.moves_list.get(5));

        // Opponent Jude
        read.opponents_list.get(0).party.add(read.students_list.get(2));
        read.students_list.get(2).setMove(1, read.moves_list.get(8));
        read.students_list.get(2).setMove(2, read.moves_list.get(4));

        read.opponents_list.get(0).party.add(read.students_list.get(3));
        read.students_list.get(3).setMove(1, read.moves_list.get(10));
        read.students_list.get(3).setMove(2, read.moves_list.get(7));
        read.students_list.get(3).setMove(3, read.moves_list.get(6));

        read.opponents_list.get(0).party.add(read.students_list.get(5));
        read.students_list.get(5).setMove(1, read.moves_list.get(6));
        read.students_list.get(5).setMove(2, read.moves_list.get(1));

        read.opponents_list.get(0).party.add(read.students_list.get(7));
        read.students_list.get(7).setMove(1, read.moves_list.get(13));
        read.students_list.get(7).setMove(2, read.moves_list.get(13));
        read.students_list.get(7).setMove(3, read.moves_list.get(13));
        read.students_list.get(7).setMove(4, read.moves_list.get(3));

        // Opponent Bagus
        read.opponents_list.get(1).party.add(read.students_list.get(3));

        read.opponents_list.get(1).party.add(read.students_list.get(6));
        read.students_list.get(6).setMove(1, read.moves_list.get(3));
        read.students_list.get(6).setMove(2, read.moves_list.get(0));

        read.opponents_list.get(1).party.add(read.students_list.get(5));
        launch(args);
    }

}