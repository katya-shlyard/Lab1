4# Lab1
## Отчет по лабораторной работе № 1

#### № группы: `ПМ-2101`

#### Выполнил: `Шлярд Екатерина Владимровна`

#### Вариант: `30`

### Cодержание:

- [Постановка задачи](#1-постановка-задачи)
- [Входные и выходные данные](#2-входные-и-выходные-данные)
- [Выбор структуры данных](#3-выбор-структуры-данных)
- [Алгоритм](#4-алгоритм)
- [Программа](#5-программа)
- [Анализ правильности решения](#6-анализ-правильности-решения)

### 1. Постановка задачи

> Дано неравенство:
(x · a − 1)/
b · x
< 0
Где a и b — параметры (вводятся с клавиатуры). Решите его для x.

Решение неравенства, подходящий промежуток для х, зависит от значений параметров а и b. Нужно написать программу, которая для любой пары а и b выведет промежуток для х, удовлетворяющий условию неравенства.
Для решения неравенства прогрaмма должна рассмотреть все возможные случаи значений для а и b, а именно когда:
1. b>0 и a>0
2. b>0 и a=0
3. b>0 и a<0
4. b=0
5. b<0 и a>0
6. b<0 и a=0
7. b<0 и a<0
Таким образом, всего существует 7 возможных случаев.

### 2. Входные и выходные данные

#### Данные на вход

На вход программа должна получать 2 числа, при этом в условии не сказано, к какому множеству
принадлежат получаемые числа, поэтому будем считать их вещественными. Верхняя и нижняя границы получаемых
чисел есть диапазон допустимых значений типа double.

|             | Тип                | min значение    | max значение   |
|-------------|--------------------|-----------------|----------------|
| a (Число 1) | Вещественное число |-(1.79<sup>308</sup>)|1.79<sup>308</sup>|
| b (Число 2) | Вещественное число |-(1.79<sup>308</sup>)|1.79<sup>308</sup>|

#### Данные на выход

Программа в зависимости от введенных параметров выводит решение неравенства.   
Решение выводится в виде строчки(множества решений). 

|         | Тип                                | min  | max значение   |
|---------|------------------------------------|--------------|----------------|
| Логическое выражение | Строка | -        | - |

### 3. Выбор структуры данных

Программа получает 2 вещественных числа. Поэтому для их хранения
можно выделить 2 переменных (`a` и `b`) типа `double`.

|             | название переменной | Тип (в Java) | 
|-------------|---------------------|--------------|
| a (Число 1) | `a`                 | `double`     |
| b (Число 2) | `a`                 | `double`     | 

Для вывода результата необязательно его хранить в отдельной переменной.

### 4. Алгоритм

#### Алгоритм выполнения программы:
-Если b > 0:
 *Если a = 0, то x ∈ (0; +∞)*   
 *Если a < 0, то x ∈ (-∞ ; 1/a] ∪ (0 ; +∞)*    
 *Если a > 0, то x ∈  (0; 1/a)*

-Если b = 0:
 *x ∈ Ø"*      
   
  
 -Если b < 0:    
 *Если a = 0, то x ∈ (-∞;0).*   
 *Если a < 0, то x ∈ (1/a ; 0)*    
 *Если a > 0, то x ∈ (-∞ ; 0) ∪ (1/a ; +∞)*

1. **Ввод данных:**  
   Программа считывает два вещественных числа, обозначенные как `a` и `b`.

2. **Решение неравенства:**  
   Программа определяет, какие знаки у каждого из параметров а и b, рассматривая все возможные их вариации посредством использования условных операторов. Если переменные попадают под условие, то выводится результат. В противном же случае программа продолжает работу, переходит к следующему шагу до тех пор, пока переменные а и b не попадут под условие. 

3. **Вывод результата:**  
   В зависимости от того, под какой из 7и описанных выше случаев попадают переменные а и b, выводится результат - итоговй промежкток для х, являющийся решением неравенства. 

#### Блок-схема

```mermaid
graph TD
    A([Начало]) --> B[/Ввести: a, b/]
    B --> C{b > 0}
    C -- Да --> D{a > 0}
    D -- Да --> E[/"Вывод: x ∈ (0;1/a)"/]
    D -- Нет --> S{a=0}
    S -- Да --> E5[/"Вывод: x ∈ (0; +∞)"/]
    S -- Нет --> E1[/"Вывод: x ∈ (-∞;1/a) ⋃ (0;+∞)"/]
    C -- Нет --> I{b = 0}
    I -- Нет --> J{a>0}
    I -- Да --> K[/Вывод: x∈ Ø/]
    J -- Да --> E2[/"Вывод: x ∈ (-∞;0) ⋃ (1/a;+∞)"/]
    J -- Нет --> M{a=0}
    M -- Да --> E3[/"Вывод: x ∈ (-∞;0)"/]
    M -- Нет --> E4[/"Вывод: x ∈ (1/a;0)"/]
    K --> Z
    E1 --> Z
    E2 --> Z
    E3 --> Z
    E4 --> Z
    E5 --> Z
    E --> Z([Конец])

```

### 5. Программа

```java
import java.io.PrintStream;
import java.util.Scanner;
public class Main {
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;
    public static void main(String[] args) {
        double a = in.nextDouble();//вводим с клавиатуры вещественные числа а и b//
        double b = in.nextDouble();
        if (b>0){ //начинаю рассматривать врианты. Первый - если  b >0//
           if (a >0){ //при b >0 рассматриваю первый случай -  а - положительный//
               out.println("x ∈ (0;");
               out.print(1/a);
               out.print(")");
            }
           else if (a == 0){ // второй случай при b>0 -  а равно нулю//
               out.println("x ∈ (0; +∞)");
           }
           else { // третий случай при b>0 - а - отрицательный //
               out.println("x ∈ (-∞;");
               out.print(1/a);
               out.print(") ⋃ (0;+∞)");
           }
        }
        else if (b==0){ //второй случай для коэф. b - если он равен нулю. В такой ситуации нет решений у неравенства//
            out.println("x ∈ Ø");
        }
        else { //последний возможный случай для коэф. b - если он отрицательный//
            if (a >0){ //случай b<0  и a>0//
                out.println("x ∈ (-∞;0) ⋃ (");
                out.print(1/a);
                out.print(";+∞)");
            }
            else if(a ==0){//случай: b<0 и a=0//
                out.println("x ∈ (-∞;0)");
            }
            else{ //случай: b<0 и a<0//
                out.println("x ∈ (");
                out.print(1/a);
                out.print(";0)");
            }
        }
    }
}
           
```

### 6. Анализ правильности решения

Программа работает корректно на всем множестве решений с учетом ограничений.

1. Тест на `b > 0 и a > 0`:

    - **Input**:
        ```
        5 1.3
        ```

    - **Output**:
        ```
        x ∈ (0;0.2)
        ```

2. Тест на `b > 0 и  a = 0`:

    - **Input**:
        ```
        0 8.9
        ```

    - **Output**:
        ```
        x ∈ (0; +∞)
        ```

3. Тест на `b > 0 и a < 0`:

    - **Input**:
        ```
        -4 5
        ```

    - **Output**:
        ```
        x ∈ (-∞;-0.25) ⋃ (0;+∞)
        ```

4. Тест на `b = 0`:

    - **Input**:
        ```
        9 0
        ```

    - **Output**:
        ```
        x ∈ Ø
        ```

5. Тест на `b < 0 и a > 0`::

    - **Input**:
        ```
        5.8 -9
        ```

    - **Output**:
        ```
        x ∈ (-∞;0) ⋃ (0.1724137931034483;+∞)
        ```
6. Тест на `b < 0 и a = 0`::

    - **Input**:
        ```
        0 -9888
        ```

    - **Output**:
        ```
        x ∈ (-∞;0)
        ```
7. Тест на `b < 0 и a < 0`::

    - **Input**:
        ```
        -8 -99999
        ```

    - **Output**:
        ```
        x ∈ (-0.125;0)
        ```
