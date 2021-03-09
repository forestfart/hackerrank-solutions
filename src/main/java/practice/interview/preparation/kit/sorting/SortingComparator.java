package practice.interview.preparation.kit.sorting;

import java.util.Comparator;
import java.util.Objects;

public class SortingComparator implements Comparator<Player> {
    public int compare(Player a, Player b) {
        if (a.score > b.score) return -1;
        if (a.score < b.score) return 1;

        if (a.name.equals(b.name)) return 0;

        int n = a.name.length() < b.name.length() ? b.name.length() : a.name.length();
        for (int i = 0; i < n; i++) {
            if (a.name.length() == i) return -1;
            if (b.name.length() == i) return 1;
            if (a.name.charAt(i) < b.name.charAt(i)) return -1;
            if (a.name.charAt(i) > b.name.charAt(i)) return 1;
        }
        return 0;
    }
}

class Player {
    String name;
    int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public static Player createPlayer(String name, int score) {
        return new Player(name, score);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return score == player.score && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }

}
