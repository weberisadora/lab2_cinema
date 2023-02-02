package negocio;

import lombok.Getter;

public class Mapa {
    @Getter
    private final Assento[][] assentos;

    public Mapa() {
        assentos = new Assento[12][14];
        inicializaMapa();
    }

    private void inicializaMapa() {
        int linha = 65;
        char letraLinha = (char) linha;

        for (int i = 0; i < assentos.length; i++) {
            for (int j = 0; j < assentos[i].length; j++)
                assentos[i][j] = new Assento(letraLinha, String.valueOf(j + 1), true);
            linha++;
            letraLinha = (char) linha;
        }
    }

    public void exibeMapa() {
        int linha = 65;
        char letraLinha = (char) linha;


        for (int i = 0; i < assentos.length; i++) {
            System.out.print(letraLinha + " ");

            for (int j = 0; j < assentos[i].length; j++) {
                if (assentos[i][j].isDisponivel())
                    System.out.print("[ ]");
                else
                    System.out.print("[X]");

                if (j == 6)
                    System.out.print("   ");
            }

            System.out.println(" " + letraLinha);
            linha++;
            letraLinha = (char) linha;
        }
        System.out.println("   1  2  3  4  5  6  7     8  9 10 11 12 13 14");
    }

    public String contabilizaAssentos() {
        int assentosDiponiveis = 0;
        int assentosOcupados = 0;

        for (int i = 0; i < assentos.length; i++)
            for (int j = 0; j < assentos[i].length; j++)
                if (assentos[i][j].isDisponivel())
                    assentosDiponiveis += 1;
                else
                    assentosOcupados += 1;

        return ("Quantidade de assentos disponíveis: " + assentosDiponiveis + "\nQuantidade de assentos ocupados: " + assentosOcupados);
    }

    public Assento localizaAssento(String posicaoAssento) {
        char linha = posicaoAssento.charAt(0);
        String coluna = posicaoAssento.substring(1);
        Assento assento = null;

        for (int i = 0; i < assentos.length; i++)
            for (int j = 0; j < assentos[i].length; j++)
                if (assentos[i][j].getLinha() == linha && assentos[i][j].getColuna().equals(coluna))
                    assento = assentos[i][j];

        return assento;
    }


}