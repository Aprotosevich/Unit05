package by.epam.finance;

import by.epam.finance.controller.Controller;

/* Программа может логиниться, аутентификация проходит через текстовый файл, который хранит данные о логинах и паролях.
* Настроена сериализация, при создании юзера он сохраняется в папку resourses в файл свой логин.dat. Методы обновления юзера,
* добавления ему счета и удаления счета добавлю в течении понедельника. Прощу прощения, не успел все сделать, сейчас на работе нужно
* быть 7 днуй в неделю, у нас начался сезон, 2 месяца в году не хватает времени ни на что.*/

public class Main {

    public static void main(String[] args) {
        String command = "LOGIN maryJ 123qwerty";
        Controller controller = Controller.getInstance();
        String result = controller.execute(command);
        System.out.println(result);

        String commandCreate = "CREATE_USER maryJ 123qwerty";
        String result1 = controller.execute(commandCreate);
        System.out.println(result1);

        String commandUpdate = "UPDATE_USER maryJ ADD_ACCOUNT myAccount 500";
    }

}
