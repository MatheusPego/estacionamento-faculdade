// Importo uma classe da API java.time, de data e hora
import java.time.LocalDateTime;


// Classe para modelar os Veículos
public class Veiculo {

    // Atributos da classe que guardam os valores para cada veículo:
    private String placa,  marca, modelo;
    // Utilizo um enum para definir o tamanho de veículo:
    private PorteVeiculo porte;
    // Guardo a hora e data nesse atributo:
    private LocalDateTime entrada;


    // Crio um construtor para sempre que chamado, crie um novo objeto com os parâmetros obrigatórios:
    public Veiculo(String placa, String marca, String modelo, PorteVeiculo porte) {
       // Corpo do Construtor:
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.porte = porte;
        this.entrada = LocalDateTime.now(); // <- Para o usuário não ter de informar data e hora de forma manual.
    }

    // Getters para acessar os atributos da Classe
    public String getPlaca(){
        return placa;
    }

    public PorteVeiculo getPorte(){
        return porte;
    }

    public LocalDateTime getEntrada(){
        return entrada;
    }

}
