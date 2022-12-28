package lotto.domain;

import java.util.List;

public class Result {
    private final List<Integer> rankingResult;

    public Result(List<Integer> rankingResult) {
        for (int i = 0; i < 7; i++)
            rankingResult.add(0);
        this.rankingResult = rankingResult;
    }

    public List<Integer> getResult() {
        return rankingResult;
    }

    public void increase(int index) {
        int count = rankingResult.get(index);
        rankingResult.set(index, count + 1);
    }
}
