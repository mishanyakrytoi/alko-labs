public class lab1_2 {
    public static int removeElementInplace(int[] arr, int val){
        int wrIndex = 0; // запись эл-тов не равных val

        for (int num : arr) { // фурычим для перебора всех значений массива
            if (num != val) { // если текущий эл-нт не равен val
                arr[wrIndex] = num; // то мы его записываем на текущую позицию
                wrIndex++; // сдвигаем указатель на след. ячейку
            }
        }
        return wrIndex;
    }
}
