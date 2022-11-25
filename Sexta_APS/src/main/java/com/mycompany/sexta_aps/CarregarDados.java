/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sexta_aps;

/**
 *
 * @author Vinicius
 */


import java.io.BufferedReader;

import java.io.BufferedReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

 class CarregarDados {

    public static void main(String[] args) throws IOException {
        boolean direcional = false;

        String caminho = "c:/Grafo/dados.txt";

        try ( BufferedReader br = new BufferedReader(new FileReader(caminho))) {

            String line = br.readLine();

            if (line.equals("S") || line.equals("s")) {
                direcional = true;
            }
            line = br.readLine();
            int amountVertices = Integer.parseInt(line);
            //FloydWarshall fw = new FloydWarshall(int[][] peso, int amountVertices);

            
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());

        }

        System.out.println(direcional);
    }

}
