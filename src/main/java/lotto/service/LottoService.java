package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Result;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public static Result checkRank(List<Lotto> lottos, WinningLotto winningLotto) {
        Result result = new Result(new ArrayList<>(7));

        for (Lotto lotto: lottos) {
            int matchingCount = compareNumbers(lotto, winningLotto.getWinningNumbers());
            boolean hasBonus = compareBonusNumber(lotto, winningLotto.getBonusNumber());

            if (matchingCount >= 3) {
                Rank rank = Rank.valueOf(matchingCount, hasBonus);
                result.increase(rank.getRank());
            }
        }
        return result;
    }

    public static int compareNumbers(Lotto lotto, List<Integer> winningNumbers) {
        int count = 0;

        for (Integer num1: lotto.getNumbers()) {
            if (winningNumbers.stream().anyMatch(num2 -> num2.equals(num1)))
                count += 1;
        }
        return count;
    }

    public static boolean compareBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().stream().anyMatch(num -> num == bonusNumber);
    }
}
