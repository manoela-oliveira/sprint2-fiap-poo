package br.com.sistemamotiva.main;

import br.com.sistemamotiva.model.EquipeManutencao;
import br.com.sistemamotiva.model.Autoestrada;
import br.com.sistemamotiva.model.EstradaVicinal;
import br.com.sistemamotiva.model.Manutencao;
import br.com.sistemamotiva.model.TrechoRodovia;
import br.com.sistemamotiva.model.IdentificacaoTrecho;

public class SistemaMonitoramento{

    public static void main(String[] args) {
        System.out.println("\n======= INICIANDO SISTEMA MOTIVA =======");

        System.out.println("\n>>> [TESTE 1] Validando eficácia da proteção de dados");

        //Trecho com identificador nulo, quilometragem negativa e ID nulo
        IdentificacaoTrecho localizacaoErro = new IdentificacaoTrecho(null, -50.0, -10.0);

        //Equipe com identificador nulo e quantidade de membros inválida
        EquipeManutencao equipePequenaErro = new EquipeManutencao(null, 1);

        //Manutenção com data nula
        Manutencao manutencaoErro = new Manutencao(null, equipePequenaErro, null);

        System.out.println("\n>>> [TESTE 2] Verificando cálculo de prioridades conforme");

        //Prioridade ALTA (Vegetação > 20 e Faixas > 3)
        IdentificacaoTrecho localRodoviaRapida = new IdentificacaoTrecho("BR-101", 100, 110);
        TrechoRodovia rodoviaRapida = new Autoestrada(localRodoviaRapida, 25, 4);
        
        //Prioridade ALTA (Vegetação > 20 e não pavimentada)
        IdentificacaoTrecho localEstradaTerra = new IdentificacaoTrecho("VIC-05", 0, 5);
        TrechoRodovia estradaTerra = new EstradaVicinal(localEstradaTerra, 25, false);

        rodoviaRapida.exibirInformacoes();
        estradaTerra.exibirInformacoes();

        System.out.println("\n>>> [TESTE 3] Simulando o crescimento da vegetação e atualização do nível");

        //Criando um trecho crítico para o teste
        IdentificacaoTrecho locCrescimento = new IdentificacaoTrecho("BR-116", 50, 60);
        TrechoRodovia trechoCritico = new Autoestrada(locCrescimento, 15, 2);
        
        System.out.println("--- Estado Inicial ---");
        trechoCritico.exibirInformacoes();

        //Registro de crescimento devido a chuvas
        System.out.println("\n... Chuvas intensas registradas. A vegetação cresceu cerca de 20cm ...");
        trechoCritico.registrarCrescimento(20);
        trechoCritico.exibirInformacoes(); 

        //Envio de equipe para realizar a manutenção
        EquipeManutencao equipeAlfa = new EquipeManutencao("Alfa", 5);
        Manutencao ordemServico = new Manutencao("15/05/2026", equipeAlfa, trechoCritico);

        ordemServico.executarManutencao();

        //Verificar se o nível de vegetação foi atualizado após a manutenção
        System.out.println("\n--- Status pós-manutenção ---");
        trechoCritico.exibirInformacoes(); 

        System.out.println("\n>>> [TESTE 4] Verificando cálculo de prioridades conforme trecho é ou não é pavimentado");

        //Criando duas estradas vicinais com o MESMO nível de vegetação (25cm)
        IdentificacaoTrecho localVicinalAsfalto = new IdentificacaoTrecho("VIC-A", 10, 12);
        TrechoRodovia vicinalAsfalto = new EstradaVicinal(localVicinalAsfalto, 25, true);
        
        IdentificacaoTrecho localVicinalTerra = new IdentificacaoTrecho("VIC-T", 20, 22);
        TrechoRodovia vicinalTerra = new EstradaVicinal(localVicinalTerra, 25, false);
        
        vicinalAsfalto.exibirInformacoes();
        vicinalTerra.exibirInformacoes();

        System.out.println("\n>>> [TESTE 5] Consistência de dados");

        IdentificacaoTrecho localTrechoLongaDuracao = new IdentificacaoTrecho("BR-381", 0, 100);
        TrechoRodovia trechoLongaDuracao = new Autoestrada(localTrechoLongaDuracao, 5, 6);

        //Simulando crescimento em duas etapas
        trechoLongaDuracao.registrarCrescimento(10);
        trechoLongaDuracao.registrarCrescimento(16);
        
        System.out.println("--- Verificando de acúmulo de crescimento ---");
        trechoLongaDuracao.exibirInformacoes();

        //Reutilizando a equipe Alfa para uma nova manutenção
        Manutencao novaOrdem = new Manutencao("17/05/2026", equipeAlfa, trechoLongaDuracao);
        novaOrdem.executarManutencao();

        System.out.println("\n--- Status pós-manutenção ---");
        trechoLongaDuracao.exibirInformacoes();
    }
}