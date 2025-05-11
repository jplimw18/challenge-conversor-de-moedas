package challenge.conversor.moedas;

import challenge.conversor.moedas.controller.ExchangeController;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        byte action = 0;
        ExchangeController exchange = new ExchangeController();

        do {

            System.out.println("""
                    ******************************************************************
                    SEJA BEM VINDO(A) AO CONVERSOR DE MOEDAS
                    
                    
                    SELECIONE UMA OPÇÃO (EX: 3):
                    
                    1 - REAL BRASILEIRO ---> DÓlAR
                    2 -           DÓLAR ---> REAL BRASILEIRO
                    3 - PESO COLOMBIANO ---> REAL BRASILEIRO
                    4 - REAL BRASILEIRO ---> PESO COLOMBIANO
                    5 -           DÓLAR ---> LIBRA EGÍPCIA
                    6 -   LIBRA EGÍPCIA ---> DÓLAR
                    7 - SAIR 
                    
                    *******************************************************************
                    
                    
                    """);

            System.out.print(">>> ");
            action = scanner.nextByte();

            System.out.print("""
                    
                    
                    valor a converter >>> 
                    """);
            double amount = scanner.nextDouble();

            if (action == 1) {
                System.out.println(exchange.convert("BRL", "USD", amount).toString());
            } else if (action == 2) {
                System.out.println(exchange.convert("USD", "BRL", amount).toString());
            } else if (action == 3) {
                System.out.println(exchange.convert("COP", "BRL", amount).toString());
            } else if (action == 4) {
                System.out.println(exchange.convert("BRL", "COP", amount).toString());
            } else if (action == 5) {
                System.out.println(exchange.convert("USD", "EGP", amount).toString());
            } else if (action == 6) {
                System.out.println(exchange.convert("EGP", "USD", amount).toString());
            }

        } while (action != 7);
    }

}
