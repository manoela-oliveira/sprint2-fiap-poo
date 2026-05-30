package br.com.sistemamotiva.model;
/*Criando relacionamento/associação entre Manutencao + EquipeManutencao + TrechoRodovia

  Para uma manutenção acontecer precisamos saber:
  - Data marcada
  - Equipe responsável
  - Local*/

public class Manutencao {
    private String data;

    private EquipeManutencao responsavel;
    private TrechoRodovia localizador;

    public Manutencao(String data, EquipeManutencao responsavel, TrechoRodovia localizador) {
        this.setData(data);
        this.responsavel = responsavel;
        this.localizador = localizador;
    }

    public String getData(){
        return this.data;
    }

    private void setData(String data){
        if (data != null){
        this.data = data;
        }
        else{
            System.out.println("Erro! Por favor, defina uma data válida para que a manutenção da rodovia seja realizada. Utilize o padrão: dd/mm/aaaa.");
        }
    }

    public EquipeManutencao getResponsavel(){
        return this.responsavel;
    }

    public TrechoRodovia getLocalizador(){
        return this.localizador;
    }

    public void executarManutencao() {
        System.out.println("\n--- EXECUTANDO MANUTENÇÃO ---");
        System.out.println("Data: " + this.data);
        this.responsavel.realizarTrabalho(this.localizador);
    }
    
}
