package co.com.sofka.model.galletas;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Galleta {

    private String id;
    private String name;

    @Override
    public String toString() {
        return "Galleta{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
