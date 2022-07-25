
package stockEx;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Stock {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Stock { " +  id + " " +name + "  } ";
    }
}
