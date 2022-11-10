package lotto;

import domain.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능

    @DisplayName("중복되지 않는 숫자 6개를 추출하는 기능 테스트")
    @Test
    void createUniqueNumbers() {
        NumberGenerator numberGenerator = new NumberGenerator();
        for (int i = 0; i < 100; i++) {
            List<Integer> randomNumbers = numberGenerator.createUniqueRandomNumbers();
            List<Integer> uniqueRandomNumbers = randomNumbers.stream()
                    .distinct()
                    .collect(Collectors.toList());
            assertThat(uniqueRandomNumbers.size()).isEqualTo(6);
        }
    }
}
