package notebook.controller;

import notebook.util.Proper;
import notebook.model.User;
import notebook.model.repository.GBRepository;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UserController {
    private final GBRepository repository;

    public UserController(GBRepository repository) {
        this.repository = repository;
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
    public User properUser() {
        Proper proper = new Proper();
        String firstName = prompt("First name: ");
        String lastName = prompt("Last name: ");
        String phone = prompt("Phone number: ");
        User user = new User(firstName, lastName, phone);
        if (proper.noEmpty(user))
            return user;
        else
            throw new IllegalArgumentException("Incorrect data has been entered!");
    }
    public void saveUser(User user) {
        repository.create(user);
    }

    public User readUser(Long userId) throws Exception {
        List<User> users = repository.findAll();
        for (User user : users) {
            if (Objects.equals(user.getId(), userId)) {
                return user;
            }
        }

        throw new RuntimeException("User not found");
    }
    public void deleteRecord(String id){
        repository.delete(Long.parseLong(id));
    }
    public void updateUser(String userId, User update) {
        update.setId(Long.parseLong(userId));
        repository.update(Long.parseLong(userId), update);
    }

    public List<User> readAll() {
        return repository.findAll();
    }

    public void printList(){
        List<User> userList= readAll();
        for (User user: userList) {
            System.out.println(user);
        }
    }

    public List<User> updateAll() {
        return repository.updateAll();
    }
}
