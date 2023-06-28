import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
        /*Реализуйте структуру телефонной книги с помощью HashMap.
        Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами,
        их необходимо считать, как одного человека с разными телефонами.
        Вывод должен быть отсортирован по убыванию числа телефонов.

        Пример меню:
        1) Добавить контакт
        2) Вывести всех
        3) Выход
        Иванов 123432
        Иванов 546457
        Иванов 788354

        Map<String, ArrayList> ---- {Иванов:[23145, 456745, 56787], Петров:[4325, 45674]} */
public class Trainee {
    private static Map<String, ArrayList<String>> tele = new HashMap<>();
    ArrayList<String> pNumbers = new ArrayList<>();
    public static void main(String[] args) {
        menu();
    }
    public static void menu () {
        System.out.println("""
                Пример меню:\s
                 1. Добавить контакт\s
                 2. Вывести всех\s
                 3. Выход""");
        Scanner sc = new Scanner(System.in);
        int answer = sc.nextInt();
        func(answer);
    }
    public static void func (int a){
        while (true) {
            if(a == 1 || a == 2 || a ==3){
                if (a == 3) menu();
                if (a == 1){
                    System.out.println("Введите фамилию и номер: \n(или 3 - для выхода)");
                    Scanner add = new Scanner(System.in);
                    String addNew = add.nextLine();
                    String[] parts = addNew.split(" ");
                    if (parts.length == 2) {
                        String surname = parts[0];
                        String phoneNumber = parts[1];
                        if (tele.containsKey(surname)) {
                            ArrayList<String> phoneNumbers = tele.get(surname);
                            phoneNumbers.add(phoneNumber);
                        } else {
                            // Создаем новый ArrayList и добавляем номер телефона
                            ArrayList<String> phoneNumbers = new ArrayList<>();
                            phoneNumbers.add(phoneNumber);
                            // Помещаем ArrayList в HashMap для данного ключа
                            tele.put(surname, phoneNumbers);
                        }
                        System.out.println("Контакт успешно добавлен.");
                    } else {
                        System.out.println("Некорректный ввод. Повторите попытку.");
                        menu();
                    }
                }
                if (a == 2){
                    outHashMap(tele);
                    menu();
                }
            } else menu();
        }
    }
    public static void outHashMap(Map<String, ArrayList<String>> tele) {

        System.out.println(tele);
    }
}
