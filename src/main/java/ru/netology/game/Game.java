package ru.netology.game;

import java.util.ArrayList;

public class Game {

    ArrayList<Player> players = new ArrayList<>();

    public ArrayList<Player> getPlayers() {
        return players;
    }


    public void register(Player player) {

        players.add(player);
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }


    public int round(String playerName1, String playerName2) {
//        Player player1 = null;
//        Player player2 = null;
//        for (Player player : players) {
//            if (player.getName().equals(playerName1)) {
//                player1 = player;
//            }
//            if (player.getName().equals(playerName2)) {
//                player2 = player;
//            }
//        }
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException("Игрок с именем " + playerName1 + " не существует.");
        }

        if (findByName(playerName2) == null) {
            throw new NotRegisteredException("Игрок с именем " + playerName2 + " не существует.");
        }

        if (findByName(playerName1).getStrength() > findByName(playerName2).getStrength()) {
            return 1;
        }

        if (findByName(playerName1).getStrength() < findByName(playerName2).getStrength()) {
            return 2;
        } else return 0;

    }


}