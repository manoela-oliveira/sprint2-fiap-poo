package br.com.sistemamotiva.model;

public class Autoestrada extends TrechoRodovia {
    private int quantidadeFaixas;

    public Autoestrada(IdentificacaoTrecho identificador, double nivelVegetacao, int quantidadeFaixas) {
        super(identificador, nivelVegetacao);
        this.setQuantidadeFaixas(quantidadeFaixas);
    }

    public int getQuantidadeFaixas() {
        return quantidadeFaixas;
    }

    private void setQuantidadeFaixas(int valor){
        if (valor >= 1) {
            this.quantidadeFaixas = valor;
        } else {
            System.out.println("Erro! Uma Autoestrada é composta de ao menos duas pistas, ou seja, é obrigatório que haja pelo menos uma faixa no trecho rodoviário para que o mesmo se encaixe na categoria.");
        }
    }

    @Override
    public String calcularPrioridade() {
        if (getNivelVegetacaoCm() > 30){
            return "CRITICA";
        }
        if (getNivelVegetacaoCm() > 20 && quantidadeFaixas > 3){
            return "ALTA";
        }
        return "BAIXA";
    }
}