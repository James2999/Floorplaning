import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Block {
    private int number;
    private double x;
    private double y;
    private double width;
    private double height;

    public Block(int number, double width, double height) {
        this.number = number;
        this.width = width;
        this.height = height;
        this.x = 0;
        this.y = 0;
    }
}
