package model;

import java.text.DecimalFormat;

public class Casa extends Financiamento {
    private static final double SEGURO_OBRIGATORIO = 80;
    private double areaConstruida;
    private double tamanhoTerreno;
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.00");

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida, double tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    @Override
    public double calcularPagamentoMensal() {
        double pagamentoMensal = super.calcularPagamentoMensal();
        return pagamentoMensal + SEGURO_OBRIGATORIO;
    }



    @Override
    public String toString() {
        return "Casa:" +
                " Valor do Imóvel: R$ " + DECIMAL_FORMAT.format(valorImovel) +
                ", Prazo de Financiamento: " + prazoFinanciamento + " anos" +
                ", Taxa de Juros Anual: " + taxaJurosAnual + "%" +
                ", Área Construída: " + areaConstruida + " m²" +
                ", Tamanho do Terreno: " + tamanhoTerreno + " m²";
        
    }

    @Override
    public void mostrarDados() {
        System.out.println("Tipo: Casa");
        System.out.println("Valor do Imóvel: R$ " + DECIMAL_FORMAT.format(this.valorImovel));
        System.out.println("Taxa de Juros Anual: " + this.taxaJurosAnual + "%");
        System.out.println("Prazo de Financiamento: " + this.prazoFinanciamento + " anos");
        System.out.println("Área Construída: " + this.areaConstruida + " m²");
        System.out.println("Tamanho do Terreno: " + this.tamanhoTerreno + " m²");
        System.out.println("Pagamento Mensal: R$ " + DECIMAL_FORMAT.format(this.calcularPagamentoMensal()));
        System.out.println("Total a Pagar: R$ " + DECIMAL_FORMAT.format(this.calcularTotalPagamento()));
    }
}
