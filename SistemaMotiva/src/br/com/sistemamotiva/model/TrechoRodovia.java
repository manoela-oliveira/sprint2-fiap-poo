package br.com.sistemamotiva.model;
/*Esta classe é abstrata porque se trata de um termo genérico que não deve existir
  sozinho. O trecho de uma rodovia precisa ser identificado por tipos, especialmente
  em contextos de manutenção, é necessário saber características como; é uma pista dupla ou simples?
  Possui acostamento? É asfaltada? Possui canteiros? Etc.*/

public abstract class TrechoRodovia {
    private double nivelVegetacaoCm;

    /*Conexão entre TrechoRododvia e IdentificacaoTrecho foi realizada através de uma
      associação. Aqui, IdentificacaoTrecho cumpre o papel de identificador, informando
      qual é o trecho, onde ele começa e onde termina. */
    private IdentificacaoTrecho identificador;

    public TrechoRodovia(IdentificacaoTrecho identificador, double nivelVegetacaoCm) {
        this.identificador = identificador;
        this.setNivelVegetacaoCm(nivelVegetacaoCm);
    }

    /*Este método é abstrato porque cada tipo de rodovia possui critérios 
     diferentes para definir o que é uma prioridade, categorizando entre
     CRÍTICA, ALTA ou BAIXA.*/
    public abstract String calcularPrioridade();

    public double getNivelVegetacaoCm() {
        return nivelVegetacaoCm;
    }

    private void setNivelVegetacaoCm(double nivel) {
        if (nivel >= 0) {
            this.nivelVegetacaoCm = nivel;
        } else {
            this.nivelVegetacaoCm = 0;
        }
    }

    public IdentificacaoTrecho getIdentificador() {
        return identificador;
    }

    /*Após a manutenção (roçada) o nível de vegetação deve voltar para 5cm.
      A razão pelo qual apliquei esta regra de negócio seria a legislação sob a qual a empresa
      Motiva é regida. O nível de vegetação não pode ser muito baixo (<5) e muito menos
      inexistente (0), pois a empresa possui um compromisso ambiental de manter uma quantidade
      significativa de vegetação em suas rodovias. */
    public void atualizarNivelVegetacao() {
        this.setNivelVegetacaoCm(5);
        System.out.println("Vegetação do trecho " + this.identificador.getCodigoIdentificacao() + " foi roçada.");
    }

    public void registrarCrescimento(double taxa) {
        if (taxa > 0) {
            this.nivelVegetacaoCm += taxa;
        }
    }

    public void exibirInformacoes() {
        System.out.println("\nTrecho: " + this.identificador.getCodigoIdentificacao() + " | Vai de " + identificador.getQuilometroInicial() + "km até " + identificador.getQuilometroFinal() + "km");
        System.out.println("Nível de vegetação: " + this.nivelVegetacaoCm + "cm | Prioridade: " + this.calcularPrioridade());
    }
}