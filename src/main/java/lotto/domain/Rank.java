package lotto.domain;

import java.util.Arrays;

public enum Rank {
    RANK1(1, 6, false, 2000000000),
    RANK2(2, 5, true, 30000000),
    RANK3(3, 5, false, 1500000),
    RANK4(4, 4, false,50000),
    RANK5(5, 3, false,5000),
    NONE(6, 0, false, 0);

    private final int rank;
    private final int match;
    private final boolean hasBonus;
    private final int money;

    Rank(int rank, int match, boolean hasBonus, int money) {
        this.rank = rank;
        this.match = match;
        this.hasBonus = hasBonus;
        this.money = money;
    }

    public int getRank() {
        return rank;
    }

    public static Rank valueOf(int match, boolean hasBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> (rank.match == match && rank.hasBonus == hasBonus))
                .findFirst()
                .orElseThrow(()->new RuntimeException("해당 랭킹 없음"));
    }
}
