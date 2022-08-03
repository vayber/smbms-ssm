package com.vayber.smbms.pojo;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public class User {

        private long id;
        private String userCode;
        private String userName;
        private String userPassword;
        private int gender;
        private String userGender;
        private Date birthday;
        private int age;
        private String phone;
        private String address;
        private long createdBy;
        private String creationDate;
        private long modifyBy;
        private String modifyDate;
        private Role role;
        private int userRole;
        private String userRoleName;


        public User() {
        }

        public User(long id, String userCode, String userPassword) {
            this.id = id;
            this.userCode = userCode;
            this.userPassword = userPassword;
        }

        public User(long id, String userCode, String userName, String userPassword, int gender, String userGender, Date birthday, int age, String phone, String address, int userRole, long createdBy, String creationDate, long modifyBy, String modifyDate, Role role) {
            this.id = id;
            this.userCode = userCode;
            this.userName = userName;
            this.userPassword = userPassword;
            this.gender = gender;
            this.userGender = userGender;
            this.birthday = birthday;
            this.age = age;
            this.phone = phone;
            this.address = address;
            this.userRole = userRole;
            this.createdBy = createdBy;
            this.creationDate = creationDate;
            this.modifyBy = modifyBy;
            this.modifyDate = modifyDate;
            this.role = role;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

         public void setUserGender(int gender ) {

             if (gender == 1){
                 this.userGender = "女";
             }
             if (gender == 2)
             {
                 this.userGender = "男";
             }

        }

        public String getUserGender() {
            return userGender;
        }



        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getUserCode() {
            return userCode;
        }

        public void setUserCode(String userCode) {
            this.userCode = userCode;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserPassword() {
            return userPassword;
        }

        public void setUserPassword(String userPassword) {
            this.userPassword = userPassword;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {



            this.gender = gender;
        }

        public Date getBirthday() {
            return birthday;
        }

        public void setBirthday(Date birthday) {
            this.birthday = birthday;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getUserRole() {
            return userRole;
        }

        public void setUserRole(int userRole) {
            this.userRole = userRole;
        }

        public long getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(long createdBy) {
            this.createdBy = createdBy;
        }

        public String getCreationDate() {
            return creationDate;
        }

        public void setCreationDate(String creationDate) {
            this.creationDate = creationDate;
        }

        public long getModifyBy() {
            return modifyBy;
        }

        public void setModifyBy(long modifyBy) {
            this.modifyBy = modifyBy;
        }

        public String getModifyDate() {
            return modifyDate;
        }

        public void setModifyDate(String modifyDate) {
            this.modifyDate = modifyDate;
        }

        public Role getRole() {
            return role;
        }

        public void setRole(Role role) {
            this.role = role;
        }

    public String getRoleName() {
        return userRoleName;
    }

    public void setRoleName(String roleName){
            this.userRoleName = roleName;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", gender=" + gender +
                ", userGender='" + userGender + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", createdBy=" + createdBy +
                ", creationDate=" + creationDate +
                ", modifyBy=" + modifyBy +
                ", modifyDate=" + modifyDate +
                ", role=" + role +
                ", userRole=" + userRole +
                ", userRoleName='" + userRoleName + '\'' +
                '}';
    }
}

