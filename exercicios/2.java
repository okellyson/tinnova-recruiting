public class BubbleSort{

    private Integer[] array = {5, 3, 2, 4, 7, 1, 0, 6};

    private void ordenar() {

        for(int i = 0; i < array.length; i++) {

            for(int j = 0; j < array.length - 1 - i; j++) {

                if(array[j] > array[j+1]) {

                    int s = array[j + 1];
                    array[j+1] = array[j];
                    array[j] = s;

                }

            }

        }
    }

}