//package org.example.wildcard.trabajo4Marzo;
//
//import java.util.List;
//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Bienvendio al sistema de entregas de LTDA, por favor digite cuantos productos desea enviar");
//        List<?> productos;
//        sc.nextLine();
//        System.out.println("introducir por favor la dirreción de entrega");
//        String direccion = sc.nextLine();
//        System.out.println("Para paquetes:" + "\n" + "1 para no fragiles" + "\n" + "2 para semi fragiles" + "3 para fragiles");
//        String TipoPaquete = sc.nextLine();
//        TIPODATO tipodato = null;
//        switch (TipoPaquete) {
//            case "1":
//                tipodato = TIPODATO.NO_FRAGILES;
//                break;
//
//            case "2":
//                tipodato = TIPODATO.SEMI_FRAGILES;
//                break;
//
//            case "3":
//                tipodato = TIPODATO.FRAGILES;
//                break;
//        }
//        Carga carga = null;
//        System.out.println("Iniciando la carga...");
//        Camion camion = new Camion(carga);
//        camion.Cargar(productos, direccion, tipodato);
//        System.out.println(camion);
//    }
//}
