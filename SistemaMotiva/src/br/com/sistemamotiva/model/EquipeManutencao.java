package br.com.sistemamotiva.model;

public class EquipeManutencao {
    private String identificadorEquipe;
    private int quantidadeMembros;

    public EquipeManutencao(String identificadorEquipe, int quantidadeMembros) {
        this.setIdentificadorEquipe(identificadorEquipe);
        this.setQuantidadeMembros(quantidadeMembros);
    }

    public String getIdentificadorEquipe() {
        return identificadorEquipe;
    }

    private void setIdentificadorEquipe(String nome) {
        if (nome != null) {
            this.identificadorEquipe = nome;
        } else {
            System.out.println("Erro! Informe o nome para que a equipe de manutenção seja identificada.");
        }
    }

    public int getQuantidadeMembros() {
        return quantidadeMembros;
    }

    private void setQuantidadeMembros(int valor) {
        if (valor >= 2) {
            this.quantidadeMembros = valor;
        } else {
            System.out.println("Erro! Por questões de segurança, a equipe de manutenção deve ser composta por ao menos 2 membros.");
            this.quantidadeMembros = 2;
        }
    }

    public void realizarTrabalho(TrechoRodovia vegetacao) {
        System.out.println("Equipe" + this.identificadorEquipe + " realizando a manutenção...");
        vegetacao.atualizarNivelVegetacao();
    }
}