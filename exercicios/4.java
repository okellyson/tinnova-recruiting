public class SomaMultiplos {

    public int calcular(int n){

        int soma = 0;

        while(n > 2) {

            if(n % 3 == 0 || n % 5 == 0){
                soma += n;
            }

            n--;

        }

        return soma;

    }

}