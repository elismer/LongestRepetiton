package app;

public class App {
    public static void main(String[] args) throws Exception {
        String resultado = LongestRepetition.repetitionDc(args[0]);
        System.out.println("Main Lorenzt");
        System.out.println("Resultado: " + resultado);
        int ubic = LongestRepetition.WhereIsIt(args[0]);
        switch (ubic) {
        case -1:
            System.out.println("Esta a la izquierda");
            break;
        case 0:
            System.out.println("Esta al centro");
            break;
        case 1:
            System.out.println("Esta a la derecha");
            break;
        }
    }
}