import java.util.List;

public class InsertionSort implements Sorting<Integer> {

    @Override
    public void sort(List<Integer> nums) {
        for (int i = 1; i < nums.size(); i++) { // Инд. 0 уже условно отсортирован, поэтому проход с инд. 1
            int current = nums.get(i); // Запоминаем значение тек. эл-та
            int j = i - 1; // Ставим указатель j на элемент слева от текущего (конец отсортированной части)

            while (j >= 0 && nums.get(j) > current) { // Пока не дошли до начала списка (j >= 0). И элемент слева больше нашего текущего числа (nums.get(j) > current)((проверка строго слева, чтобы не было ArrayIndexOutOfBoundsException!!))
                nums.set(j + 1, nums.get(j)); // Сдвигаем больший эл-нт на одну позицию вправо, освобождая место под вставку
                j--; // Двигаем указатель j дальше влево, чтобы проверить следующий эл-нт
            }
            nums.set(j + 1, current); // Вставляем сохранённый current в освободившуюся ячейку справа от j
        }
    }
}