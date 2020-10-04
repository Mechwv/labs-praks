package praktika.Prak7;

import java.util.Queue;

public class Game {
    public int upd_turn(Player player1, Player player2, int turn) {
        int firstCard, secondCard;
        firstCard = player1.get_card();
        secondCard = player2.get_card();
        if ((secondCard == 9 && firstCard == 0) || ((firstCard > secondCard) && !(secondCard == 0 && firstCard == 9))) {
            player1.put_card(firstCard);
            player1.put_card(secondCard);
        } else if ((secondCard == 0 && firstCard == 9) ^ ((firstCard < secondCard))) {
            player2.put_card(firstCard);
            player2.put_card(secondCard);
        }
        return turn + 1;
    }

    public String simulate(Player player1, Player player2, int turns) {
        int firstCard, secondCard;
        for (int i = turns; i < 106; i++) {
            firstCard = player1.get_card();
            secondCard = player2.get_card();
            if ((secondCard == 9 && firstCard == 0) || ((firstCard > secondCard) && !(secondCard == 0 && firstCard == 9))) {
                player1.put_card(firstCard);
                player1.put_card(secondCard);
            } else if ((secondCard == 0 && firstCard == 9) ^ ((firstCard < secondCard))) {
                player2.put_card(firstCard);
                player2.put_card(secondCard);
            }
            if (player1.isEmpty()) {
                return ("Второй игрок победил. Ходы: " + (i+1));
            } else if (player2.isEmpty()) {
                return ("Первый игрок победил. Ходы: " + (i+1));
            }
        }
        return "Ботва!";
    }
}
//1 3 5 7 9 2 4 6 8 0