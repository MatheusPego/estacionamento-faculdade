## Sistema Simples de Estacionamento em Java

É um programinha básico em Java que controla um estacionamento com 60 vagas fixas. Você pode:

Ver se ainda tem vaga.

Registrar um veículo com placa, marca, modelo e porte.

Fazer a saída do veículo, calculando o valor que tem que pagar.

Só isso, bem simples. Também disponibilizei um diagrama UML feito por mim no LucidChart para ajudar na compreensão.

### Como funciona o projeto:
Tem 4 classes principais, sendo: 

AppSistema.java — É o menu, onde você escolhe o que fazer.

Estacionamento.java — Aqui fica o controle das vagas e veículos.

Veiculo.java — A classe que representa os veículos, com placa, marca, modelo, porte e hora de entrada.

PorteVeiculo.java — Enum pra dizer se o carro é pequeno, médio ou grande

### Detalhes importantes:

O valor é calculado com base no tempo que o veículo ficou estacionado.
Motos (Pequeno): R$8,00 por hora, Carros (Médio): R$16,00 por hora, Caminhão, ônibus (Grande): R$25,00 por hora.

São 60 vagas, se lotar, não tem como registrar mais veículo.

Pra saída do veículo, você precisa digitar a placa.

Se não achar a placa, avisa que não tem no estacionamento.Tudo pelo terminal mesmo.

### O que devo melhorar: 

Talvez uma interface.

Guardar os dados em arquivo ou banco (pra não perder quando fechar o programa).

Mostrar lista dos veículos que estão estacionados.

Cobrar por minuto ou fração de hora (porque cobrar hora cheia é meio ruim).

É isso aí... projeto simples, mas que ensina bastante coisa de Java e orientação a objetos. 
