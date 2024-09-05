package model;

import java.text.DecimalFormat;

public class Terreno extends Financiamento {
    private static final double ACRÉSCIMO_INADIMPLÊNCIA = 0.02;
    private String tipoZona;
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.00");

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    @Override
    public double calcularPagamentoMensal() {
        double pagamentoMensal = super.calcularPagamentoMensal();
        return pagamentoMensal * (1 + ACRÉSCIMO_INADIMPLÊNCIA);
    }

    @Override
    public String toString() {
        return "Terreno:" +
                " Valor do Imóvel: R$ " + DECIMAL_FORMAT.format(valorImovel) +
                ", Prazo de Financiamento: " + prazoFinanciamento + " anos" +
                ", Taxa de Juros Anual: " + taxaJurosAnual + "%" +
                ", Tipo de Zona: " + tipoZona;
    }

    @Override
    public void mostrarDados() {
        System.out.println("Tipo: Terreno");
        System.out.println("Valor do Imóvel: R$ " + DECIMAL_FORMAT.format(this.valorImovel));
        System.out.println("Taxa de Juros Anual: " + this.taxaJurosAnual + "%");
        System.out.println("Prazo de Financiamento: " + this.prazoFinanciamento + " anos");
        System.out.println("Tipo de Zona: " + this.tipoZona);
        System.out.println("Pagamento Mensal: R$ " + DECIMAL_FORMAT.format(this.calcularPagamentoMensal()));
        System.out.println("Total a Pagar: R$ " + DECIMAL_FORMAT.format(this.calcularTotalPagamento()));
    }
}
