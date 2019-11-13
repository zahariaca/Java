import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.fail;

class TestCaseAggregator implements ArgumentsAggregator {

    @Override
    public Object aggregateArguments(ArgumentsAccessor accessor, ParameterContext context) throws ArgumentsAggregationException {
        // TODO: check accessor
        int numberOfFixedColumns = 3;
        String description = accessor.getString(0);
        boolean isValidInput = "valid".equals(accessor.getString(1));
        String output = accessor.getString(2);
        Optional<String> input = accessor.toList().stream().skip(numberOfFixedColumns).map(o -> (String) o).reduce((s, s2) -> s + s2);
        if(!input.isPresent()) {
            fail("input is empty");
        }
        return new TestCasePojo(description, isValidInput, output, input.get());
    }
}
