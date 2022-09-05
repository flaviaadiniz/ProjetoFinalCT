import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        initialize();

        UnityTemp unityInput = getUnityTemp("entrada");
        UnityTemp unityOutput = getUnityTemp("saída");

        int quantidade;
        do {
            Scanner quant = new Scanner(System.in);
            System.out.print("Digite a quantidade de temperaturas que deseja converter: ");
            quantidade = quant.nextInt();
            if (quantidade == 0) {
                System.out.println("A quantidade de temperaturas a serem convertidas não pode ser igual a zero!");
            } else if (quantidade < 0) {
                System.out.println("A quantidade de temperaturas a serem convertidas não pode ser um número negativo!");
            }
        } while (quantidade < 1);


        double[] aTransformar = new double[quantidade];
        double[] transformado = new double[quantidade];

        double totalEntrada = 0;
        double totalSaida = 0;

        for (int i = 0; i < aTransformar.length; i++) {
            Scanner tempDesejada = new Scanner(System.in);
            System.out.print("Digite a temperatura que deseja converter: ");
            aTransformar[i] = tempDesejada.nextDouble();
            totalEntrada = totalEntrada + aTransformar[i];
        }

        System.out.println(" ");
        System.out.println("RESULTADOS:");

        ToCelsius transformCelsius = new ToCelsius();
        ToFahrenheit transformFahrenheit = new ToFahrenheit();
        ToKelvin transformKelvin = new ToKelvin();

        switch (unityOutput) {
            case CELSIUS:
                for (int i = 0; i < aTransformar.length; i++) {
                    transformado[i] = transformCelsius.toCelsiusTransform(unityInput, aTransformar[i]);
                    System.out.println("------------------------------------------------------------");
                    System.out.printf("%.2f graus %s é igual a %.2f graus %s. \n", aTransformar[i], unityInput, transformado[i], unityOutput);
                    totalSaida = totalSaida + transformado[i];
                }
                break;

            case FAHRENHEIT:
                for (int i = 0; i < aTransformar.length; i++) {
                    transformado[i] = transformFahrenheit.toFahrenheitTransform(unityInput, aTransformar[i]);
                    System.out.println("------------------------------------------------------------");
                    System.out.printf("%.2f graus %s é igual a %.2f graus %s. \n", aTransformar[i], unityInput, transformado[i], unityOutput);
                    totalSaida = totalSaida + transformado[i];
                }
                break;

            case KELVIN:
                for (int i = 0; i < aTransformar.length; i++) {
                    transformado[i] = transformKelvin.toKelvinTransform(unityInput, aTransformar[i]);
                    System.out.println("------------------------------------------------------------");
                    System.out.printf("%.2f graus %s é igual a %.2f graus %s. \n", aTransformar[i], unityInput, transformado[i], unityOutput);
                    totalSaida = totalSaida + transformado[i];
                }
                break;

            default:
                System.out.println("Erro!");
                break;
        }

        double mediaEntrada = totalEntrada / quantidade;
        double mediaSaida = totalSaida / quantidade;

        System.out.println("------------------------------------------------------------");
        System.out.println(" ");
        System.out.printf("A média de temperaturas em %s é igual a %.2f graus. \n", unityInput, mediaEntrada);
        System.out.printf("A média de temperaturas em %s é igual a %.2f graus. \n", unityOutput, mediaSaida);

    }


    private static void initialize() {
        System.out.println(" ");
        System.out.println("|---------------------------------------------------|");
        System.out.println("|   BEM VINDA AO NOSSO CONVERSOR DE TEMPERATURAS!   |");
        System.out.println("|---------------------------------------------------|");
        System.out.println("|       Você pode converter temperaturas em:        |");
        System.out.println("|           CELSIUS, FAHRENHEIT e KELVIN            |");
        System.out.println("|---------------------------------------------------|");
        System.out.println(" ");
    }

    private static UnityTemp getUnityTemp(String temperaturaDesejada) {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite a unidade de temperatura de " + temperaturaDesejada + " (CELSIUS, FAHRENHEIT ou KELVIN): ");
        String typeString = input.nextLine();
        try {
            return UnityTemp.valueOf(typeString.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("A unidade de temperatura foi digitada incorretamente. Tente novamente!");
            return getUnityTemp(temperaturaDesejada);
        }
    }
}