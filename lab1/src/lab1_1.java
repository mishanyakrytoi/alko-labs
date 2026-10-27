import java.util.ArrayDeque;

public class lab1_1 {
    public static boolean isValid(String str) {

        ArrayDeque<Character> stack = new ArrayDeque<>(); // стек arraydeque


        for (int i = 0; i < str.length(); i++) { // проходим по каждому символу
            char che = str.charAt(i);            // ЧАР 0_0


            if (che == '(' || che == '[' || che == '{') { // если открывающая => кладем её в стек
                stack.push(che);
            }

            else if (che == ')' || che == ']' || che == '}') { // если закрывающая

                if (stack.isEmpty()) { // если стек пустой, то закр. скобка идет без откр.
                    return false;
                }

                char opBr = stack.pop(); // открывающая скобка из стека достается

                if (che == ')' && opBr != '(') return false; // сверяем соответствующие скобки
                if (che == ']' && opBr != '[') return false;
                if (che == '}' && opBr != '{') return false;
            }
        }
        return stack.isEmpty(); // Если после проверки всей строки стек пуст — всё сбалансировано
    }
}