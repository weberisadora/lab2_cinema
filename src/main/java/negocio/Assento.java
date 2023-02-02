package negocio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Assento {
    @Getter
    private char linha;

    @Getter
    private String coluna;

    @Getter
    @Setter
    private boolean disponivel;
}
