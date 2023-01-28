package br.com.ada.views;

import java.util.Scanner;

public abstract class View {
    public Scanner sc = new Scanner(System.in);

    public double getDouble () {
        double valor = 0;

        try {
            valor = Double.parseDouble(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Valor inválido, tente novamente.");
            getDouble();
        }

        return valor;
    }
    public int getInt () {
        int valor = 0;

        try {
            valor = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Valor inválido, tente novamente.");
            getInt();
        }

        return valor;
    }

    public String getString () {
        return sc.nextLine();
    }
}
