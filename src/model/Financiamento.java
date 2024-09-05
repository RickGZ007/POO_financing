package model;

import java.io.Serializable;

public abstract class Financiamento implements Serializable {
    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public double calcularPagamentoMensal() {
        double taxaMensal = this.taxaJurosAnual / 12 / 100;
        int prazoMeses = this.prazoFinanciamento * 12;
        return (this.valorImovel * taxaMensal) / (1 - Math.pow(1 + taxaMensal, -prazoMeses));
    }

    public double calcularTotalPagamento() {
        return this.calcularPagamentoMensal() * this.prazoFinanciamento * 12;
    }

    public abstract void mostrarDados();
}
