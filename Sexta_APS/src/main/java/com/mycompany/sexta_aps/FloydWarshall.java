/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sexta_aps;

/**
 *
 * @author Vinicius
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import static java.lang.String.format;
import java.util.Arrays;
import static java.lang.String.format;
import java.util.Arrays;
import java.util.Arrays;

import java.util.Arrays;


public class FloydWarshall {
 public static void main(String[] args) {
        int[][] peso = {{1, 3, -2}, {2, 1, 4}, {2, 3, 3}, {3, 4, 2}, {4, 2, -1}};
        int numVertices = 4;

        floydWarshall(peso, numVertices);
    }

    static void floydWarshall(int[][] peso, int numVertices) {

        double[][] dist = new double[numVertices][numVertices];
        for (double[] row : dist) {
            Arrays.fill(row, Double.POSITIVE_INFINITY);
        }

        for (int[] p : peso) {
            dist[p[0] - 1][p[1] - 1] = p[2];
        }

        int[][] prox = new int[numVertices][numVertices];
        for (int i = 0; i < prox.length; i++) {
            for (int j = 0; j < prox.length; j++) {
                if (i != j) {
                    prox[i][j] = j + 1;
                }
            }
        }

        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        prox[i][j] = prox[i][k];
                    }
                }
            }
        }

        mostraResultado(dist, prox);
    }

    static void mostraResultado(double[][] dist, int[][] prox) {
        System.out.println("Par     dist    caminho");
        for (int i = 0; i < prox.length; i++) {
            for (int j = 0; j < prox.length; j++) {
                if (i != j) {
                    int u = i + 1;
                    int v = j + 1;
                    String caminho = format("%d -> %d    %2d     %s", u, v,
                            (int) dist[i][j], u);
                    do {
                        u = prox[u - 1][v - 1];
                        caminho += " -> " + u;
                    } while (u != v);
                    System.out.println(caminho);
                }
            }
        }
    }
}
