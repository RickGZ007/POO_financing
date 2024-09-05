package model;

import java.text.DecimalFormat;

public class Apartamento extends Financiamento {
    private int numeroVagasGaragem;
    private int numeroAndar;
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.00");

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int numeroVagasGaragem, int numeroAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.numeroVagasGaragem = numeroVagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = this.taxaJurosAnual / 12 / 100;
        int prazoMeses = this.prazoFinanciamento * 12;
        return (this.valorImovel * Math.pow(1 + taxaMensal, prazoMeses) * taxaMensal) /
                (Math.pow(1 + taxaMensal, prazoMeses) - 1);
    }

    @Override
    public String toString() {
        return "Apartamento:" +
                " Valor do Imóvel: R$ " + DECIMAL_FORMAT.format(valorImovel) +
                ", Prazo de Financiamento: " + prazoFinanciamento + " anos" +
                ", Taxa de Juros Anual: " + taxaJurosAnual + "%" +
                ", Número de Vagas na Garagem: " + numeroVagasGaragem +
                ", Número do Andar: " + numeroAndar;
    }

    @Override
    public void mostrarDados() {
        System.out.println("Tipo: Apartamento");
        System.out.println("Valor do Imóvel: R$ " + DECIMAL_FORMAT.format(this.valorImovel));
        System.out.println("Taxa de Juros Anual: " + this.taxaJurosAnual + "%");
        System.out.println("Prazo de Financiamento: " + this.prazoFinanciamento + " anos");
        System.out.println("Número de Vagas na Garagem: " + this.numeroVagasGaragem);
        System.out.println("Número do Andar: " + this.numeroAndar);
        System.out.println("Pagamento Mensal: R$ " + DECIMAL_FORMAT.format(this.calcularPagamentoMensal()));
        System.out.println("Total a Pagar: R$ " + DECIMAL_FORMAT.format(this.calcularTotalPagamento()));
    }
    
}
