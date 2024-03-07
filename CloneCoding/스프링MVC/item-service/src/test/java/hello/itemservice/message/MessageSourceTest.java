package hello.itemservice.message;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class MessageSourceTest {
    @Autowired
    MessageSource ms;

    @Test
    void helloMessage(){
        String result = ms.getMessage("hello", null, null);
        assertThat(result).isEqualTo("안녕");
    }

    @Test
    void notFoundMessageCode() {
        assertThatThrownBy(() -> ms.getMessage("no_code", null, null ))
                .isInstanceOf(NoSuchMessageException.class);
    }
    @Test
    void notFoundMessageCodeDefaultMessage() {
        String result = ms.getMessage("no_code", null, "기본 메시지", null);
        assertThat(result).isEqualTo("기본 메시지");

    }
    @Test
    void argumentMessage(){
        String message = ms.getMessage("hello.name", new Object[]{"Spring"},null);
        assertThat(message).isEqualTo("안녕 Spring");
    }
    @Test
    void defaultLang(){
        String message2 = ms.getMessage("hello.name", new Object[]{"Spring"}, Locale.KOREA);
        assertThat(message2).isEqualTo("안녕 Spring");
    }
    @Test
    void enLang(){
        String message2 = ms.getMessage("hello.name", new Object[]{"Spring"}, Locale.ENGLISH);
        assertThat(message2).isEqualTo("hello Spring");

    }
}