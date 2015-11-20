package com.hotfixs.thinkinginjava.annotations;

import java.util.List;

/**
 * @author wangjunwei
 */
public class PasswordUtils {
    @UseCase(id = 47, description = "Password must conatins at least on numeric")
    public boolean validatePassword(String password) {
        return password.matches("\\w*\\d\\w*");
    }

    @UseCase(id = 48)
    public String encryptPassword(String password) {
        return new StringBuffer(password).reverse().toString();
    }

    @UseCase(id = 49, description = "New passwords can't equal to previously used ones")
    public boolean checkForNewPassword(List<String> prevPasswords, String password) {
        return !prevPasswords.contains(password);
    }
}
