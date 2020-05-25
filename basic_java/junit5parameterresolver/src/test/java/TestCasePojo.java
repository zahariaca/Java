import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TestCasePojo {
    String description;
    boolean isValidInput;
    String output;
    String input;
}
