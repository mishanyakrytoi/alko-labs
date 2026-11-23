import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Sorting<Integer> {

    private void slice(List<Integer> nums, int start, int end) {

        if (start >= end) {   // Базовый случай рекурсии: если в куске 1 элемент или меньше — он уже отсортирован
            return;
        }

        int mid = start + (end - start) / 2;  // Находим середину (защита от переполнения int вместо (start + end) / 2)

        slice(nums, start, mid);  // Рекурсивно делим левую половину
        slice(nums, mid + 1, end);  // Рекурсивно делим правую половину

        merge(nums, start, mid, end);  // Сливаем две отсортированные половины в одну
    }

    private void merge(List<Integer> nums, int start, int middle, int end) {

        List<Integer> temp = new ArrayList<>(end - start + 1);  // Временный список для сбора отсортированных элементов текущего отрезка

        int left = start;         // Указатель на начало левой половины
        int right = middle + 1;   // Указатель на начало правой половины

        while (left <= middle && right <= end) {  // Пока в обеих половинах есть элементы, берём меньший из двух
            if (nums.get(left) <= nums.get(right)) {
                temp.add(nums.get(left));
                left++;
            } else {
                temp.add(nums.get(right));
                right++;
            }
        }

        while (left <= middle) {  // Если в левой половине остались элементы, то докидываем их в конец
            temp.add(nums.get(left));
            left++;
        }

        while (right <= end) {  // Если в правой половине остались элементы — докидываем их в конец
            temp.add(nums.get(right));
            right++;
        }

        for (int i = 0; i < temp.size(); i++) {  // Переписываем отсортированный кусок из temp обратно в исходный список nums
            nums.set(start + i, temp.get(i));
        }
    }

    @Override
    public void sort(List<Integer> nums) {
        if (nums == null || nums.size() <= 1) {
            return;
        }
        slice(nums, 0, nums.size() - 1);
    }
}