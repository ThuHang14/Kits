
package stockEx;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Order {
    private int id;
    private String date;
    private int amount;//
    private Float price;//
    private int type;// 1-- mua, 2-- bán
      private String id_Stock;//
      private String id_Trader;//

    @Override
    public String toString() {
        return "Order { " + id + " "
                + date + " " + amount + " "
                +price + " " +type + " "
                +id_Stock + " " + id_Trader + "  } ";
    }
}
