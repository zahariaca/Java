import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTest {

    @DisplayName("Should aggregate lines from csv")
    @ParameterizedTest(name = "{index} => description={0}, typeOfInput={1}")
    @CsvFileSource(resources = "/test.csv", numLinesToSkip = 1)
    public void testTEst(@AggregateWith(TestCaseAggregator.class) TestCasePojo testCase) {
        testCsvEntry(testCase);
    }

    private void testCsvEntry(@AggregateWith(TestCaseAggregator.class) TestCasePojo testCase) {
        if (testCase.isValidInput) {
            System.out.println(testCase);
            assertTrue(true);
        } else {
            assertThrows(Exception.class, () -> {
                throw new Exception("testing");
            });
        }
    }

}
