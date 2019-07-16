public class A {
    static int[] array = new int[]{9,7,5,8,2};

    public static void main(String [] args) {
        for (int i = 0; i < array.length; i++ )
        System.out.print(array[i] + " " );
        System.out.println();
        // bubbleSort(array);
        selectSort(array);
        System.out.println("Sort : ");
        for (int i = 0; i < array.length; i++ )
        System.out.print(array[i] + " ");
    }

    public static void bubbleSort (int[] array) {
        for ( int i = 0; i < array.length - 1; i++ ) {
            boolean isSort = true;
            for ( int j = 0; j < array.length - 1 - i; j++ ) {
                if (array[ j ] > array[ j + 1 ]) {
                    int temp = array[ j ];
                    array[ j ] = array[ j + 1 ];
                    array[ j + 1 ] = temp;
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
    }

    private static void selectSort (int[] array) {
        for ( int i = 0; i < array.length - 1; i++ ) {
            int min = i;
            for (int j = i; j < array.length; j++ ) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
    }
}