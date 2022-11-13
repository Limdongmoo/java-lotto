package domain;

import java.util.Arrays;
import java.util.List;

public class Result {

    public Rank getRank(int matchingCount, boolean isMatchingBonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchingCount)
                .filter(rank -> rank.checkBonusNumber == isMatchingBonusNumber)
                .findAny()
                .orElse(Rank.nothing);
    }

    public Prize getPrize(Rank rank) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.ranking == rank.ranking)
                .findAny()
                .get();
    }

    public int countMatchingNumber(List<Integer> winningLottoNumbers, List<Integer> userNumbers) {
        int matchingCount = 0;
        for (int number : winningLottoNumbers) {
            if (userNumbers.contains(number)) {
                matchingCount++;
            }
        }
        return matchingCount;
    }

    public boolean isMatchingBonusNumber(List<Integer> userNumbers, int bonusNumber) {
        return userNumbers.contains(bonusNumber);
    }
}
