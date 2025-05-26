// Scanner para entrada de dados
import java.util.Scanner;

public class AppSistema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estacionamento estacionamento = new Estacionamento(); // Cria o estacionamento
        int opcao;

        do {
            System.out.println("\n Sistema de Estacionamento Faseh");
            System.out.println("1 - Consultar se há vagas livres");
            System.out.println("2 - Registrar veículo");
            System.out.println("3 - Dar saída do veículo");
            System.out.println("4 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpa o buffer

            switch (opcao) {
                case 1:
                    // Verifica se há vagas disponíveis
                    if (estacionamento.haVagas()) {
                        System.out.println("Há vagas disponíveis no estacionamento.");
                    } else {
                        System.out.println("Estacionamento cheio.");
                    }
                    break;

                case 2:
                    // Registra um novo veículo no estacionamento
                    if (estacionamento.haVagas()) {
                        System.out.print("Placa do veículo: ");
                        String placa = scanner.nextLine();

                        System.out.print("Marca do veículo: ");
                        String marca = scanner.nextLine();

                        System.out.print("Modelo do veículo: ");
                        String modelo = scanner.nextLine();

                        System.out.println("Informe o porte do veículo (Pequeno, Medio, Grande): ");
                        String porteStr = scanner.nextLine().trim();

                        // Ajusta a string para o padrão do Enum
                        porteStr = porteStr.substring(0, 1).toUpperCase() + porteStr.substring(1).toLowerCase();

                        try {
                            PorteVeiculo porte = PorteVeiculo.valueOf(porteStr); // Converte string para enum

                            Veiculo veiculo = new Veiculo(placa, marca, modelo, porte);

                            // Tenta registrar o veículo no estacionamento
                            if (estacionamento.registrarVeiculo(veiculo)) {
                                System.out.println("Veículo registrado com sucesso!");
                            } else {
                                System.out.println("Não foi possível registrar o veículo. Estacionamento pode estar cheio.");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println("Porte inválido. Use: Pequeno, Medio ou Grande.");
                        }

                    } else {
                        System.out.println("Estacionamento cheio. Não é possível registrar mais veículos.");
                    }
                    break;

                case 3:
                    // Saída de veículo e cálculo do valor a pagar
                    System.out.print("Informe a placa do veículo para saída: ");
                    String placaSaida = scanner.nextLine();

                    double valor = estacionamento.removerVeiculo(placaSaida);

                    if (valor >= 0) {
                        System.out.printf("Veículo removido. Valor a pagar: R$ %.2f\n", valor);
                    } else {
                        System.out.println("Veículo não encontrado no estacionamento.");
                    }
                    break;

                case 4:
                    // Encerra o sistema
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 4);

        scanner.close();
    }
}
