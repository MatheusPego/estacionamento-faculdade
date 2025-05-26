import java.time.Duration;
import java.time.LocalDateTime;

public class Estacionamento {
    private Veiculo[] vagas;

    public Estacionamento() {
        vagas = new Veiculo[60];
    }

    public boolean haVagas() {
        for (Veiculo vaga : vagas) {
            if (vaga == null) {
                return true; // Achou vaga livre
            }
        }
        return false; // Nenhuma vaga livre
    }

    public boolean registrarVeiculo(Veiculo v) {
        for (int i = 0; i < vagas.length; i++) {
            if (vagas[i] == null) {
                vagas[i] = v;
                return true; // Registrou com sucesso
            }
        }
        return false; // Estacionamento cheio
    }

    // Remove veículo pela placa e calcula o valor a pagar
    public double removerVeiculo(String placa) {
        for (int i = 0; i < vagas.length; i++) {
            Veiculo v = vagas[i];
            if (v != null && v.getPlaca().equalsIgnoreCase(placa)) {
                LocalDateTime entrada = v.getEntrada();
                LocalDateTime agora = LocalDateTime.now();

                // Tempo em minutos entre entrada e agora
                long minutos = Duration.between(entrada, agora).toMinutes();

                // Arredonda para cima para cobrar pelo menos 1 hora
                long horas = (minutos == 0) ? 1 : (minutos + 59) / 60;

                double precoHora;

                // Define preço por porte do veículo
                switch (v.getPorte()) {
                    case Pequeno:
                        precoHora = 8.0;
                        break;
                    case Medio:
                        precoHora = 16.0;
                        break;
                    case Grande:
                        precoHora = 25.0;
                        break;
                    default:
                        precoHora = 0.0;
                }

                double total = precoHora * horas;

                vagas[i] = null; // Libera a vaga

                return total; // Retorna o valor calculado
            }
        }
        return -1; // Veículo não encontrado
    }
}
