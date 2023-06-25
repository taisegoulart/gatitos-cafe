package dev.ifrs.model;

import java.util.List;


public class User {
      
    private String name;
    private String login;
    private String email;
    private String phone;
    private String password;
    private boolean isAdmin;
    private List<Booking> bookings; //TODO: dúvida, eu posso importar a classe do outro projeto, ou preciso fazer um booking novo no model? (acho que sim)
   
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
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
    public List<Booking> getBookings() {
        return bookings;
    }
    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
    public User(String name, String login, String email, String phone, String password, boolean isAdmin,
            List<Booking> bookings) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.isAdmin = isAdmin;
        this.bookings = bookings;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((phone == null) ? 0 : phone.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + (isAdmin ? 1231 : 1237);
        result = prime * result + ((bookings == null) ? 0 : bookings.hashCode());
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
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (phone == null) {
            if (other.phone != null)
                return false;
        } else if (!phone.equals(other.phone))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (isAdmin != other.isAdmin)
            return false;
        if (bookings == null) {
            if (other.bookings != null)
                return false;
        } else if (!bookings.equals(other.bookings))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "User [name=" + name + ", login=" + login + ", email=" + email + ", phone=" + phone + ", password="
                + password + ", isAdmin=" + isAdmin + ", bookings=" + bookings + "]";
    }


    //TODO dúvida: adicionar a lista de booking aqui?
    
}
