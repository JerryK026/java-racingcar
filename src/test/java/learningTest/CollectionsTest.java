package learningTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CollectionsTest {

  @Test
  @DisplayName("clear 메서드는 컬렉션을 empty로 만든다")
  void clearTest() {
    // given
    List<Integer> numbers = new ArrayList<>();
    Collections.addAll(numbers, 1, 2, 3);

    // when
    numbers.clear();

    // then
    assertThat(numbers).isEmpty();
  }

  @Test
  @DisplayName("List.of 메서드는 불변 컬렉션을 생성한다")
  void listOfTest() {
    // given
    List<Integer> numbers = List.of(1, 2, 3);

    // when & then
    assertThatThrownBy(() -> numbers.add(4))
        .isInstanceOf(UnsupportedOperationException.class);
  }
}
