package hello.typeconverter.converter;


import hello.typeconverter.IpPort;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConverterTest {
    @Test
    void stringToInteger(){
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer result = converter.convert("10");
        assertThat(result).isEqualTo(10);
    }
    @Test
    void IntegerToString(){
        IntegerToStringConverter converter = new IntegerToStringConverter();
        String result = converter.convert(10);
        assertThat(result).isEqualTo("10");
    }
    @Test
    void ipPortToString(){
        StringToIntegerConverter converter = new StringToIntegerConverter();
        String source = "127.0.0.1:8080";
        Integer result = converter.convert(source);
        assertThat(result).isEqualTo(new IpPort("127.0.0.1",8080));
    }

}