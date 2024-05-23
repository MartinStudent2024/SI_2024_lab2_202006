# Втора лабораториска вежба по Софтверско инженерство 
## Мартин Цветаноски, бр. на индекс: 202006
Група: ИМБ

### Control Flow Graph

![Слика](https://github.com/MartinStudent2024/SI_2024_lab2_202006/blob/master/cfg/cfg.png)

### Цикломатска комплексност 
Цикломатската комплексност е дефинирана со формулата `M = E - N + 2`, каде E е бројот на ребра, додека N е бројот на јазли во кодот. <br>
- Број на ребра: 36 <br>
- Број на јазли: 27 <br>
Решение: `M = 36 - 27 + 2 = 11` <br>

Цикломатската комплексност на кодот е 11.

### Тест случаеви според критериумот на Every Branch:
Целта на овој тест е да се провери функционалноста на кодот преку изминување на сите негови разгранувања што ги има. <br>

Тест случаеви: <br>
  1. `List<Item> list = null;` <br>
     Result: All items list can't be null! <br>
  2. `List<Item> list2 = List.of(new Item("Coca-Cola", "123$$56789", 85, 5));` <br>
     Result: Invalid character in item barcode! <br>
  3. `List<Item> list3 = List.of(new Item("Fanta", null, 65, 3));` <br>
    Result: No barcode! <br>
  4. `List<Item> list5 = List.of(new Item("Milkshake", "5555555555", 185, 10));` <br>
    Result: False, што е успешен можен резултат. <br>

### Тест случаеви според критериумот на Multiple Condition:
Целта на овие тестови е да се провери дали самиот код може да ги изврши сите можни негови правци, односно дали успешно ќе резултира со точната или неточната гранка. <br>

Тест случаеви: <br>
  1. `List<Item> list = null;` <br>
    Result: All items list can't be null! <br>
  2. `List<Item> list2 = List.of(new Item("Coca-Cola", "123$$56789", 85, 5));` <br>
    Result: Invalid character in item barcode! <br>
  3. `List<Item> list3 = List.of(new Item("Fanta", null, 65, 3));` <br>
    Result: No barcode! <br>
  4. `List<Item> list5 = List.of(new Item("Milkshake", "5555555555", 185, 10));` <br>
    Result: False, што е успешен можен резултат. <br>
  5. `List<Item> list4 = List.of(new Item("PowerBar", "0124356789", 350, 3), new Item(null, "5252525252", 100, 10), new Item("GranolaBar", "1357924680", 77, 0));` <br>
    Result: True што е успешен можен резултат. <br>
(Креирани се Items така што ќе поминат низ понудените гранки.) <br>

На овој начин ги изминуваме сите правци во кодот. <br>

### Објаснување на напишаните Unit Tests

Случаевите се вкупно 9 поделени на: <br>
  1. Во `everyBranchTest` тестот се наоѓаат четири assert случаеви. <br>
  2. Во `multipleConditionTest` се наоѓаат пет assert случаеви. <br>

Тестирањето го постигнувам со 5 различни assert сличаеви. За секоја од нив е користна посебна Items листа. <br>
  - Со првиот assert се тестира можноста листата Items да е празна. Повратно ни враќа RuntimeException. <br>
  - Со вториот се тестира можноста да постои невалиден карактер во баркодот на Item. Повратнo добиваме RuntimeException. <br>
  - Третиот тестира дали воопшто поседува Itemot баркод. Доколку нема, ќе фрли RuntimeException. <br>
  - Во четвртиот assert искреиран е Item кој треба да ги помине сите услови успешно и да врати повратно соодветен Boolean одговор, што во случајот е `false`. <br>
  - Последниот assert е наменет за MultipleConditions тестот во кој се искреирани неколку различни Items, со цел да произлезе резултат во секој од можните услови соодветно. <br>
