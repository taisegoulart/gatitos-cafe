package dev.ifrs.model;

import java.util.List;


public class User {
    private String name; 
    private String login;
    //private String email; para a Taíse do futuro: não precisa de email, só login e senha
    private String password;
    private boolean isAdmin;

    //TODO: dúvida, eu posso importar a classe do outro projeto, ou preciso fazer um booking novo no model? (acho que sim)
   
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
   
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isAdmin() {
        return isAdmin;
    }
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public User() {
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + (isAdmin ? 1231 : 1237);
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (login == null) {
            if (other.login != null)
                return false;
        } else if (!login.equals(other.login))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (isAdmin != other.isAdmin)
            return false;
        return true;
    }
    public User(String name, String login, String password, boolean isAdmin) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;
    }
    @Override
    public String toString() {
        return "User [name=" + name + ", login=" + login + ", password=" + password + ", isAdmin=" + isAdmin + "]";
    }
    
}