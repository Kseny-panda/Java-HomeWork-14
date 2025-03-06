package ru.netology.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game = new Game();

    Player player1 = new Player(1, "Anya", 15);
    Player player2 = new Player(2, "Petya", 11);
    Player player3 = new Player(7, "Oleg", 19);
    Player player4 = new Player(16, "Bond_007", 15);
    Player player5 = new Player(22, "Petya", 25);
    Player player6 = new Player(28, "Master", 1);

    // Должен быть пустой ArrayList
    @Test
    public void shouldEmptyArrayList() {
        Assertions.assertEquals(0, game.players.size());
    }

    // Должна пройти регистрация одного пользователя
    @Test
    public void shouldRegisterOnePlayer() {
        game.register(player1);

        Assertions.assertEquals(1, game.getPlayers().size()); // проверка по длине списка
        Assertions.assertTrue(game.getPlayers().contains(player1)); // подтверждение наличия игрока в списке
    }

    // Должна пройти регистрация двух пользователей
    @Test
    public void shouldRegisterTwoPlayer() {
        game.register(player1);
        game.register(player2);

        assertEquals(2, game.players.size()); // проверка по длине списка
        assertTrue(game.getPlayers().containsAll(List.of(player1, player2))); // подтверждение наличия игроков в списке
    }

    // Должен выиграть первый игрок
    @Test
    public void shouldWinFirstPlayer() {
        game.register(player2);
        game.register(player6);

        int actual = game.round(player2.getName(), player6.getName());
        Assertions.assertEquals(1, actual);

    }

    // Должен выиграть второй игрок
    @Test
    public void shouldWinSecondPlayer() {
        game.register(player3);
        game.register(player5);

        int actual = game.round(player3.getName(), player5.getName());
        Assertions.assertEquals(2, actual);
    }

    // Оба игрока должны сыграть в ничью
    @Test
    public void shouldBeDraw() {
        game.register(player1);
        game.register(player4);

        int actual = game.round(player1.getName(), player4.getName());
        Assertions.assertEquals(0, actual);
    }

    // Должна отсутствовать регистрация у первого игрока
    @Test
    public void shouldNotRegisterFirstPlayer() {
        game.register(player6);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("GM", player6.getName()));
    }

    // Должна отсутствовать регистрация у второго игрока
    @Test
    public void shouldNotRegisterSecondPlayer() {
        game.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round(player4.getName(), "Ivan"));
    }
}