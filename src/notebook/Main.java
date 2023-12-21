package notebook;
/**
 * Реализуйте удаление пользователей.
 * Подумать, где должен находиться метод createUser из UserView и если получится, вынести его в нужный слой.
 * Вынести логику dao в нужный слой (репозиторий), а от слоя dao избавится физически. ВАЖНО: ознакомиться с статьей:
 * https://habr.com/ru/articles/263033/
 * На выбор (не обязательно):
 * 1)подумайте как оптимизировать код приложения (например, хэшировать все данные, а в файл писать только при выходе из приложения)
 * 2) Дописать код для оставшихся команд в Commands (в NONE можно реализовать сохранение списка USer)
 * ИЛИ ВНЕСИТЕ СВОИ ИЗМЕНЕНИЯ В ПРОЕКТ, КОТОРЫЕ КАЖУТСЯ ЛОГИЧНЫМИ ВАМ.
 * Пожалуйста о том что изменили, напишите в комментариях(например в ридми)
 */
import notebook.controller.UserController;
import notebook.model.repository.GBRepository;
import notebook.model.repository.impl.UserRepository;
import notebook.view.UserView;

import static notebook.util.DBConnector.DB_PATH;
import static notebook.util.DBConnector.createDB;

public class Main {
    public static void main(String[] args) {
        createDB();
//        FileOperation fileOperation = new FileOperation(DB_PATH);
        GBRepository repository = new UserRepository(DB_PATH);
        UserController controller = new UserController(repository);
        UserView view = new UserView(controller);
        view.run();

    }
}
