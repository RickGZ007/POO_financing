package main;

import model.*;
import util.InterfaceUsuario;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String ARQUIVO_TEXTO_FINANCIAMENTOS = "financiamentos.txt";
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.00");

    public static void main(String[] args) throws ValorNegativoException {
        List<Financiamento> financiamentos = new ArrayList<>();
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        System.out.println("Digite os dados para um financiamento personalizado de casa:");

        double valorImovel = interfaceUsuario.pedirValorImovel();
        int prazoFinanciamento = interfaceUsuario.pedirPrazoFinanciamento();
        double taxaJurosAnual = interfaceUsuario.pedirTaxaJurosAnual();

        // Adicionando financiamentos predefinidos
        financiamentos.add(new Casa(450000, 25, 5.5, 200, 400));
        Financiamento financiamentoPersonalizado = new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual, 200, 400);
        financiamentos.add(new Apartamento(350000, 15, 7.0, 2, 5));
        financiamentos.add(new Apartamento(500000, 30, 4.5, 3, 10));
        financiamentos.add(new Terreno(200000, 10, 8.0, "Residencial"));
        financiamentos.add(financiamentoPersonalizado);
        // Adicionando financiamento personalizado
        
        

        // Mostrar financiamentos predefinidos
        System.out.println("Modelos de Financiamento Predefinidos:");
        mostrarFinanciamentos(financiamentos.subList(0, financiamentos.size() - 1));

        System.out.println("+==============================+");
        System.out.println("Financiamento Personalizado:");
        financiamentoPersonalizado.mostrarDados();
        System.out.println("+==============================+");

        salvarFinanciamentos(financiamentos);

        double somaValoresImoveis = calcularSomaValoresImoveis(financiamentos);
        double somaTotalFinanciamentos = calcularSomaTotalFinanciamentos(financiamentos);

        System.out.println("Soma dos Valores dos Imóveis: R$ " + DECIMAL_FORMAT.format(somaValoresImoveis));
        System.out.println("Soma dos Valores dos Financiamentos: R$ " + DECIMAL_FORMAT.format(somaTotalFinanciamentos));
    }

    private static void salvarFinanciamentos(List<Financiamento> financiamentos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_TEXTO_FINANCIAMENTOS))) {
            for (Financiamento financiamento : financiamentos) {
                writer.write(financiamento.toString());
                writer.newLine();
                writer.write("+==============================+");
                writer.newLine();
            }
            System.out.println("Dados de financiamentos salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados de financiamentos: " + e.getMessage());
        }
    }

    private static void mostrarFinanciamentos(List<Financiamento> financiamentos) {
        for (Financiamento financiamento : financiamentos) {
            financiamento.mostrarDados();
            System.out.println("+==============================+");
        }
    }

    private static double calcularSomaValoresImoveis(List<Financiamento> financiamentos) {
        double soma = 0;
        for (Financiamento financiamento : financiamentos) {
            soma += financiamento.getValorImovel();
        }
        return soma;
    }

    private static double calcularSomaTotalFinanciamentos(List<Financiamento> financiamentos) {
        double soma = 0;
        for (Financiamento financiamento : financiamentos) {
            soma += financiamento.calcularTotalPagamento();
        }
        return soma;
    }
}
