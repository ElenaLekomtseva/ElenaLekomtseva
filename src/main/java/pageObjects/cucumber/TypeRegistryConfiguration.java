package pageObjects.cucumber;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterType;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class TypeRegistryConfiguration implements TypeRegistryConfigurer {
    @Override
    public Locale locale() {
        // требуется только для определения формата разделителя в float и double
        return new Locale("en");
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineParameterType(
                new ParameterType<>("values", ".*?",
                        List.class, (String s) -> Arrays.asList(s.split(","))));
    }
}