import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Grammar gramatica=new Grammar();
        gramatica.ReadFromFile();
        if(gramatica.Validate())
            System.out.print("Valid\n");
        else
            System.out.print("Nevalid\n");
        gramatica.prod.forEach(e->System.out.print(e.PrintProd()+"\n"));
        System.out.print("Do you want to show path? (true/false): ");
        Scanner input=new Scanner(System.in);
        boolean option=input.nextBoolean();
        gramatica.Generate(option);
    }



}
