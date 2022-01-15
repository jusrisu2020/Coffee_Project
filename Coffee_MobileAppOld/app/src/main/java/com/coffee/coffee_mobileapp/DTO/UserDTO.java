package com.coffee.coffee_mobileapp.DTO;

public class UserDTO {
    int Id, Gender, TypeUser, Status;
    String FullName, UserName, Password;
    byte[] Avatar;

    public UserDTO() {
    }

    public UserDTO(int id, int gender, int typeUser, int status, String fullName, String userName, String password, byte[] avatar) {
        Id = id;
        Gender = gender;
        TypeUser = typeUser;
        Status = status;
        FullName = fullName;
        UserName = userName;
        Password = password;
        Avatar = avatar;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getGender() {
        return Gender;
    }

    public void setGender(int gender) {
        Gender = gender;
    }

    public int getTypeUser() {
        return TypeUser;
    }

    public void setTypeUser(int typeUser) {
        TypeUser = typeUser;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public byte[] getAvatar() {
        return Avatar;
    }

    public void setAvatar(byte[] avatar) {
        Avatar = avatar;
    }
}
