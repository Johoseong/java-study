package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Integer money = Integer.parseInt(Console.readLine());

        if (money % 1000 != 0)
            throw new IllegalArgumentException();

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money / 1000; i++)
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));

        for (int i = 0; i < lottos.size(); i++)
            System.out.println(lottos.get(i).getNumbers());

        String number = Console.readLine();
        int bonusNumber = Integer.parseInt(Console.readLine());
        WinningLotto winningLotto = new WinningLotto(Arrays.stream(number.split(", ")).map(Integer::parseInt).collect(Collectors.toList()), bonusNumber);

        Result result = LottoService.checkRank(lottos, winningLotto);
        System.out.println(result.getResult());
    }
}
