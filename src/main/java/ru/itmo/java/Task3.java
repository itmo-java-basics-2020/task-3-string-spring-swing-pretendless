package ru.itmo.java;

import java.util.Arrays;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray)
    {
        if(inputArray == null || inputArray.length == 0)
            return new int[]{};
        else
        {
            int for0 = inputArray[inputArray.length - 1];
            for(int i = inputArray.length - 1; i > 0; i--)
                inputArray[i] = inputArray[i - 1];
            inputArray[0] = for0;
            return inputArray;
        }
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     *
     * Если входной массив пуст или равен null - вернуть 0
     *
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if((inputArray == null) || (inputArray.length == 0))
            return 0;
        else
            if(inputArray.length == 1)
                return inputArray[0];
            else
            {
                int mx1 = inputArray[0], mx2 = inputArray[1];
                if(mx1 < mx2)
                {
                    int temp = mx1;
                    mx1 = mx2; mx2 = temp;
                }

                for(int i = 2; i < inputArray.length; i++)
                    if(inputArray[i] > mx2)
                    {
                        mx2 = inputArray[i];
                        if(mx1 < mx2)
                        {
                            int temp = mx1;
                            mx1 = mx2; mx2 = temp;
                        }
                    }
                return mx1 * mx2;
            }
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     *
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if(input == null || input.length() == 0)
            return 0;
        int cnt = 0;
        input = input.toUpperCase();
        for(int i = 0; i < input.length(); i++)
            if(input.charAt(i) == 'A' || input.charAt(i) == 'B')
                cnt++;

        return ((cnt * 100) / input.length());
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if(input == null)
            return false;
        boolean t = true;
        for(int i = 0; i < input.length() / 2; i++)
            if(input.charAt(i) != input.charAt(input.length() - i - 1))
                t = false;
        return t;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if(input == null)
            return "";
        int k = 0;
        String ans = "";
        while(k < input.length()) {
            char cur = input.charAt(k);
            int cnt = 0;
            while (k < input.length() && input.charAt(k) == cur)
            {
                cnt++;
                k++;
            }
            String s = cur + Integer.toString(cnt);
            ans += s;
        }
        return ans;
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if(one == null || two == null || one.length() == 0 || two.length() == 0)
            return false;


        int[] cntone = new int[10000];
        int[] cnttwo = new int[10000];
        Arrays.fill(cntone, 0);
        Arrays.fill(cnttwo, 0);

        if(one.length() != two.length())
            return false;
        else
        {
            for(int i = 0; i < one.length(); i++)
                cntone[(int)one.charAt(i)]++;

            for(int i = 0; i < two.length(); i++)
                cnttwo[(int)two.charAt(i)]++;

            boolean t = true;
            for(int i = 0; i < 10000; i++)
                if(cntone[i] != cnttwo[i])
                    t = false;

            return t;
        }
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if(s == null || s.length() == 0)
            return false;

        for(int i = 0; i < s.length(); i++)
            for(int j = i + 1; j < s.length(); j++)
                if(s.charAt(i) == s.charAt(j))
                    return false;

        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     *
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if(m == null || m.length == 0)
            return new int[][]{{}, {}};
        else {
            for (int i = 0; i < m.length; i++)
                for (int j = 0; j < Math.min(i, m[i].length); j++) {
                    int temp = m[i][j];
                    m[i][j] = m[j][i];
                    m[j][i] = temp;
                }
            return m;
        }
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     *
     * Запрещается пользоваться функций join
     *
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if (separator == null)
                separator = ' ';
        String ans = "";
        if (inputStrings == null || inputStrings.length == 0)
            return ans;
        else {
            ans = inputStrings[0];
            for (int i = 1; i < inputStrings.length; i++)
                ans += separator + inputStrings[i];

            return ans;
        }

    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if(inputStrings == null || prefix == null)
            return 0;
        int cnt = 0;
        for(int i = 0; i < inputStrings.length; i++)
            if(inputStrings[i].startsWith(prefix))
                cnt++;

        return cnt;
    }
}
