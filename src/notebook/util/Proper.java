package notebook.util;

import notebook.model.User;

public class Proper {
    public boolean noEmpty(User user){
        user.setFirstName(unWhite(user.getFirstName()));
        user.setLastName(unWhite(user.getLastName()));
        return !user.getFirstName().isEmpty() && !user.getLastName().isEmpty();
    }

    private String unWhite (String nameToClear){
        StringBuilder removeSpace = new StringBuilder();
        for (int i = 0; i<nameToClear.length();i++){
            if(!Character.isWhitespace(nameToClear.charAt(i))){
                removeSpace=removeSpace.append(nameToClear.charAt(i));
            }
        }
        return removeSpace.toString();
    }
}
