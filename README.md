# Sprint 2 POO - Progamação Orientada a Objeto

> **Professor:** Ygor Moraes Martins dos Anjos
---

## Instruções para entrega

O objetivo macro é construir um sistema de monitoramento e priorização de roçada de vegetação nas rodovias. 
<ul>
    <li>Crie diferentes comportamentos de crescimento (ex: trecho úmido cresce mais rápido que trecho seco) e diferentes tipos de intervenção.
    </li>
    <li>Crie um algoritmo que varre um array de trechos e gera um "Relatório de Prioridade" automático, indicando quais KMs precisam de roçada mecanizada ou manual.
    </li>
    <li>Crie a classe IntervencaoOperacional abstrata, contendo um método abstrato executarServico(). As filhas serão RocadaMecanizada e Pulverizacao.
    </li>
    <li>Crie a interface MonitoravelViaIoT com o método transmitirDadosSensor(). Aplicar isso aos TrechoRodovia que possuem tecnologia instalada, permitindo que o sistema os atualize automaticamente sem inspeção visual.
    </li>
</ul>

<i>Sugestão de testes unitários: Garantir a impossibilidade de instanciar a classe base com new, simular um objeto "Mock" que implementa MonitoravelViaIoT e testar a captura de dados de crescimento.
</i>

### Tecnologias Utilizadas
<p>
  <a href="https://skillicons.dev">
    <img src="https://skillicons.dev/icons?i=git,java" />
  </a>
</p>

### Tópicos Avaliados
<ul>
  <li>Encapsulamento</li>
  <li>Herança</li>
  <li>Associação</li>
  <li>Construtores</li>
  <li>Polimorfismo</li>
  <li>Abstração</li>
  <li>Interfaces</li>
  <li>Clean Code</li>
</ul>

### Lógica para desenvolvimento do sistema
<ul>
  <li>A partir do projeto base, entregue no processo avaliativo da Sprint 1, uma nova organização de arquivos foi criada a fim de contemplar as novas solicitações para a entrega da Sprint 2.
  <br>Organização de arquivos da Sprint 1:

```
  sistemamotiva/
  ├── main
  │   └── SistemaMonitoramento.java
  └── model
      ├── Autoestrada.java
      ├── EquipeManutencao.java
      ├── EstradaVicinal.java
      ├── IdentificacaoTrecho.java
      ├── Manutencao.java
      └── TrechoRodovia.java
```
  <br>Organização de arquivos da Sprint 2:

```
  sistemamotiva/
  ├── main
  │   └── SistemaMonitoramento.java
  └── model
      ├── Autoestrada.java
      ├── AutoestradaSensorizada.java
      ├── EquipeManutencao.java
      ├── EstradaVicinal.java
      ├── IdentificacaoTrecho.java
      ├── IntervencaoOperacional.java
      ├── Manutencao.java
      ├── MockTrechoSensorizado.java
      ├── MonitoravelViaIoT.java
      ├── Pulverizacao.java
      ├── RegrasNegocio.java
      ├── RocadaMecanizada.java
      └── TrechoRodovia.java
```
 
## Visualização do sistema no Astah

### Sistema inicial - Sprint 1
<img width="841" height="524" alt="Image" src="https://github.com/user-attachments/assets/236d3b07-05ce-437a-82a5-102a8b0a6fb1" />

### Sistema final - Sprint 2
<img width="818" height="448" alt="Image" src="https://github.com/user-attachments/assets/07e3f291-13c9-4b31-a7f9-b022378f8b12" />


## Perguntas de reflexão
<ul>
    <li>Por que TrechoRodovia é classe e "BR-116 KM 10-15" é objeto?
    <br> TrechoRodovia é o conceito que não pode ser definido sozinho sem suas caracterízticas definidas, assim como o Veículo é um conceito sem definições. A "BR-116 KM 10-15" é a instância real de um objeto, com valores específicos, ocupando um lugar na memória. Eu não posso realizar a manutenção no TrechoRodovia, mas posso realizar a manutenção no trecho "BR-116 KM 10-15".
    </li>
    <li>Como um método difere de uma função solta?
    <br> Um método altera o estado de um objeto específico e interage com outros atributos da mesma classe diferente de uma função que para ser considerada função não precisa deste tipo de interação.
    </li>
    <li>Se nivelVegetacao fosse público, que quebra ocorreria?
    <br> Um programador poderia registrar que a vegetação tem -5cm (o que é fisicamente impossível) ou 5000km de altura. Isso afetaria a lógica de priorização do sistema, e ele enviaria equipes para lugares errados.
    </li>
    <li>Por que não faz sentido para a Motiva que uma equipe execute apenas uma "Intervenção Operacional" genérica sem especificar qual é?
    <br> Não faria sentido executar uma intervenção genérica pois cada cenário de manutenção exige ferramentas, tempo, equipes e métodos diferentes para ser realizada. Permitir no sistema a criação de uma "Intervenção Operacional" sem as devidas especificações poderia gerar retrabalho ao enviar equipes sem os equipamentos necessáriospara a execução da tarefa ou gastos adicionais, por exemplo, ao permitir o envio de equipamentos de grande porte para manutenções que não exigem tais mecânismos.
    </li>
    <li>Qual a diferença arquitetural entre fazer um Trecho herdar de uma classe abstrata vs.implementar uma Interface?
    <br> Uma herança de classe abstrata modela uma relação rígida de atribuições, seguindo a lógica Has-A (Tem-Um), fazendo com que seus herdeiros compartilhem característicasbásicas. Já ao escolher implementar uma Interface, criamos um contrato de capacidade, aquilo que pode ser feito por tal "objeto", totalmente desvinculado da parte de heranças.Desse modo, é possível atribuir capacidades à objetos que não compartilham características básicas herdadas de uma mesma classe-mãe.
    </li>
</ul>

