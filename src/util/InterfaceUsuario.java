package util;

import model.ValorNegativoException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {
    private Scanner scanner;

    public InterfaceUsuario() {
        this.scanner = new Scanner(System.in);
    }

    public double pedirValorImovel() throws ValorNegativoException {
        while (true) {
            try {
                System.out.print("Digite o valor do imóvel: ");
                double valor = scanner.nextDouble();
                if (valor <= 0) {
                    throw new ValorNegativoException("O valor deve ser positivo.");
                }
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
            } catch (ValorNegativoException e) {
                System.out.println(e.getMessage());
            } finally {
                scanner.nextLine(); // limpar a entrada inválida
            }
        }
    }

    public int pedirPrazoFinanciamento() {
        while (true) {
            try {
                System.out.print("Digite o prazo do financiamento (em anos): ");
                int prazo = scanner.nextInt();
                if (prazo <= 0) {
                    throw new ValorNegativoException("O prazo deve ser positivo.");
                }
                return prazo;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
            } catch (ValorNegativoException e) {
                System.out.println(e.getMessage());
            } finally {
                scanner.nextLine(); // limpar a entrada inválida
            }
        }
    }

    public double pedirTaxaJurosAnual() {
        while (true) {
            try {
                System.out.print("Digite a taxa de juros anual: ");
                double taxa = scanner.nextDouble();
                if (taxa < 0) {
                    throw new ValorNegativoException("A taxa de juros não pode ser negativa.");
                }
                return taxa;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
            } catch (ValorNegativoException e) {
                System.out.println(e.getMessage());
            } finally {
                scanner.nextLine(); // limpar a entrada inválida
            }
        }
    }






}
