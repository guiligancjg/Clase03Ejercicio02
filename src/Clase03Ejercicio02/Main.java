package Clase03Ejercicio02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
 /*2. Genere una clase que tenga los métodos para realizar la ?codificación? y decodificación de un string,
      dado un número de desplazamiento. */

        Scanner ingreso = new Scanner(System.in);

        System.out.print("Ingrese la cadena : ");
        String cadena = ingreso.nextLine();

        System.out.print("Ingrese el Desplazamiento: ");
        int desplazamiento = ingreso.nextInt();

        System.out.print("Ingresar si es Codificación 'c' o Descodificación 'd' : ");
        char codigo = ingreso.next().charAt(0);


        switch(codigo){
            case 'c':
                System.out.println(codificacion(cadena,desplazamiento));
                break;
            case 'd':
                System.out.println(decodificacion(cadena,desplazamiento));
                break;
            default:
                System.out.println("Ingrese 'c' para Codificación o 'd' para Decodificación...");
                break;
        }
    }

    public static String codificacion(String cadena, int desplazamiento){
        String abecedario = "abcdefghijklmnñopqrstuvwxyz";
        char[] partcadena = cadena.toCharArray();

        for (int i = 0; i < partcadena.length; i++) {
            for (int j = 0; j < abecedario.length(); j++) {
                if (abecedario.charAt(j) == partcadena[i]) {
                    partcadena[i] = abecedario.charAt(j + desplazamiento);
                    break;
                }
            }
        }

        if(desplazamiento == 1)
            return String.valueOf(partcadena).replace(" ", "a");
        else
            return String.valueOf(partcadena).replace(" ", "b");
    }


    public static String decodificacion(String cadena, int desplazamiento){
        String abecedario = "abcdefghijklmnñopqrstuvwxyz";
        char[] partcadena = cadena.toCharArray();
        char letra = ' ';

        if(desplazamiento == 1)
            letra = 'a'; else letra = 'b';

        for (int i = 0; i < partcadena.length; i++) {
            for (int j = 0; j < abecedario.length(); j++) {
                if (abecedario.charAt(j) == partcadena[i]) {
                    if (abecedario.charAt(j) == letra) {
                        partcadena[i] = ' ';
                        break;
                    } else {
                        partcadena[i] = abecedario.charAt(j - desplazamiento);
                        break;
                    }
                }
            }
        }
        return String.valueOf(partcadena);
    }
}
