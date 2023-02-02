package ui;

import negocio.Assento;
import negocio.Mapa;

import java.util.Scanner;

public class MenuUI {
    private final Scanner teclado;
    private final Mapa mapa;

    public MenuUI() {
        teclado = new Scanner(System.in);
        mapa = new Mapa();
    }

    public void realizaAtendimento() {
        System.out.println("\nSeja bem-vindo(a) ao cinema!");
        int resposta;

        do {
            exibeOpcoes();
            int opcao = solicitaOpcao();

            while (opcao < 1 || opcao > 4) {
                System.out.println("Opção inválida!");
                opcao = solicitaOpcao();
            }

            if (opcao == 2)
                System.out.println(mapa.contabilizaAssentos());

            else {
                mapa.exibeMapa();
                if (opcao == 3 || opcao == 4) {
                    Assento assento;
                    String posicaoAssento = solicitaAssento();
                    assento = mapa.localizaAssento(posicaoAssento);

                    while (assento == null) {
                        System.out.println("O assento informado não existe.");
                        posicaoAssento = solicitaAssento();
                        assento = mapa.localizaAssento(posicaoAssento);
                    }

                    if (opcao == 3)
                        if (assento.isDisponivel()) {
                            assento.setDisponivel(false);
                            System.out.println("Reserva realizada com sucesso!");
                        } else
                            System.out.println("A reserva não foi realiza pois o assento não está disponível.");

                    else {
                        if (assento.isDisponivel())
                            System.out.println("Não existe reserva para o assento informado.");
                        else {
                            assento.setDisponivel(true);
                            System.out.println("Reserva cancelada com sucesso!");
                        }
                    }
                }
            }

            System.out.println("Deseja realizar outra operação? Digite 1 para SIM ou 2 para NÃO.");
            resposta = Integer.parseInt(teclado.nextLine());

            while (resposta < 1 || resposta > 2) {
                System.out.println("Opção inválida.");
                System.out.println("Deseja realizar outra operação? Digite 1 para SIM ou 2 para NÃO.");
                resposta = Integer.parseInt(teclado.nextLine());
            }

        } while (resposta == 1);

        teclado.close();
    }

    private void exibeOpcoes() {
        System.out.println("\nMenu");
        System.out.println("1. Exibir mapa de assentos");
        System.out.println("2. Exibir a quantidade de assentos livres e ocupados");
        System.out.println("3. Fazer uma reserva");
        System.out.println("4. Cancelar uma reserva");
    }

    private int solicitaOpcao() {
        System.out.println("Digite o número correspondente à opção desejada: ");
        String opcao = teclado.nextLine();
        return Integer.parseInt(opcao);
    }

    private String solicitaAssento() {
        System.out.println("Digite a posição do assento. Exemplo: C4");
        return teclado.nextLine().toUpperCase().trim();
    }

}
