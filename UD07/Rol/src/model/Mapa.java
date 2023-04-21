package model;

public class Mapa {
        public static int[][] MAPA_10x20 = {
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                        { 1, 0, 8, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 1 },
                        { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                        { 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                        { 6, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                        { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 9 },
                        { 1, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1 },
                        { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, };

        public static int[][] MAPA_10x12 = {
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                        { 1, 0, 8, 1, 0, 0, 0, 0, 0, 8, 0, 1 },
                        { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1 },
                        { 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1 },
                        { 6, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1 },
                        { 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1 },
                        { 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 9 },
                        { 1, 8, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1 },
                        { 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, };

        public static int[][] MAPA_13x14 = {
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                        { 1, 0, 8, 1, 0, 0, 0, 0, 0, 8, 0, 0, 0, 1 },
                        { 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1 },
                        { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
                        { 1, 0, 8, 1, 0, 0, 0, 0, 0, 8, 1, 0, 0, 1 },
                        { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1 },
                        { 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1 },
                        { 6, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1 },
                        { 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1 },
                        { 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1 },
                        { 1, 8, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1 },
                        { 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9, 1, 1, 1 }, };

        // Mapa de 8x8:
        public static int[][] MAPA_8x8 = {
                        { 1, 1, 1, 1, 1, 1, 1, 1 },
                        { 1, 0, 0, 8, 0, 0, 0, 1 },
                        { 1, 0, 1, 1, 1, 0, 0, 1 },
                        { 1, 0, 0, 0, 1, 0, 1, 1 },
                        { 1, 1, 1, 0, 1, 0, 0, 1 },
                        { 1, 0, 1, 0, 1, 0, 8, 1 },
                        { 6, 0, 0, 0, 1, 1, 0, 1 },
                        { 1, 1, 1, 1, 1, 0, 9, 1 }, };

        // Mapa de 15x10:
        public static int[][] MAPA_15x10 = {
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                        { 1, 0, 0, 0, 1, 0, 8, 0, 0, 0, 0, 0, 0, 0, 1 },
                        { 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
                        { 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
                        { 1, 0, 8, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
                        { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1 },
                        { 6, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1 },
                        { 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 9 },
                        { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1 }, };

        // Mapa de 10x10:
        public static int[][] MAPA_10x10 = {
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                        { 1, 6, 0, 0, 0, 0, 0, 0, 8, 1 },
                        { 1, 0, 1, 1, 1, 1, 1, 0, 0, 1 },
                        { 1, 8, 1, 0, 0, 0, 1, 0, 1, 1 },
                        { 1, 0, 1, 0, 1, 0, 1, 0, 1, 1 },
                        { 1, 0, 1, 0, 1, 0, 1, 0, 0, 1 },
                        { 1, 0, 0, 0, 1, 0, 1, 0, 1, 1 },
                        { 1, 1, 1, 1, 1, 0, 1, 0, 0, 1 },
                        { 9, 0, 0, 0, 0, 8, 0, 0, 0, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, };

        // Mapa de 12x12:
        public static int[][] MAPA_12x12 = {
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                        { 1, 6, 0, 0, 0, 0, 0, 0, 0, 0, 8, 1 },
                        { 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1 },
                        { 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1 },
                        { 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1 },
                        { 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1 },
                        { 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1 },
                        { 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1 },
                        { 1, 8, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                        { 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
                        { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9, 1 }, };

        public static int[][][] mapas = {
                        MAPA_10x10,
                        MAPA_12x12,
                        MAPA_15x10,
                        MAPA_8x8,

                        MAPA_13x14,
                        MAPA_10x20,
                        MAPA_10x12
        };
}