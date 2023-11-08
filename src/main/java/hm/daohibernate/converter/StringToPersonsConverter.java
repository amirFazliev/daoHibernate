package hm.daohibernate.converter;

import hm.daohibernate.domain.Persons;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToPersonsConverter implements Converter<String, Persons> {
    @Override
    public Persons convert(String source) {
        String[] params = source.split(",");
        if (params.length == 5) {
            return new Persons(params[0], params[1], Integer.parseInt(params[2]), params[3], params[4]);
        }
        return null;
    }
}