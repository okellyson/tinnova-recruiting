public class Fatorial {

    public int calcular(int n){

        int fatorial = 1;

        while(n > 1) {

            fatorial = fatorial * 2;
            n--;

        }

        return fatorial;

    }

}