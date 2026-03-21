package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    void 유효한_이름을_전달하면_Name이_생성된다() {
        String name = "handa";
        assertThat(Name.of(name)).isNotNull();
    }

    @Test
    void 공백의_이름을_전달하면_Name생성시_오류가_발생한다() {
        String name = "";
        assertThatThrownBy(() -> Name.of(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 긴_이름을_전달하면_Name생성시_오류가_발생한다() {
        String name = "loooooooooooooong";
        assertThatThrownBy(() -> Name.of(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void null을_전달하면_Name생성시_오류가_발생한다() {
        String name = null;
        assertThatThrownBy(() -> Name.of(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

}