package stockEx;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Transaction {
    private int id;
    private String date;
    private int amount;//
    private Float price;//
    private int id_Order;

    @Override
    public String toString() {
        return "Transaction { " + id + " "
                + date + " " + amount
                + " " + price + " "
                +id_Order + "  } ";
    }
}
