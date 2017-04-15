package cn.kanyun.cpa.pojo;

import java.sql.Timestamp;


/**
 * CpaUser entity. @author MyEclipse Persistence Tools
 */

public class CpaUser  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String username;
     private String password;
     private String petname;
     private String gender;
     private String email;
     private Timestamp regdate;
     private Timestamp lastlogindate;
     private String petName;
     private Timestamp regDate;
     private Timestamp lastLoginDate;


    // Constructors

    /** default constructor */
    public CpaUser() {
    }

	/** minimal constructor */
    public CpaUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    /** full constructor */
    public CpaUser(String username, String password, String petname, String gender, String email, Timestamp regdate, Timestamp lastlogindate, String petName, Timestamp regDate, Timestamp lastLoginDate) {
        this.username = username;
        this.password = password;
        this.petname = petname;
        this.gender = gender;
        this.email = email;
        this.regdate = regdate;
        this.lastlogindate = lastlogindate;
        this.petName = petName;
        this.regDate = regDate;
        this.lastLoginDate = lastLoginDate;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPetname() {
        return this.petname;
    }
    
    public void setPetname(String petname) {
        this.petname = petname;
    }

    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getRegdate() {
        return this.regdate;
    }
    
    public void setRegdate(Timestamp regdate) {
        this.regdate = regdate;
    }

    public Timestamp getLastlogindate() {
        return this.lastlogindate;
    }
    
    public void setLastlogindate(Timestamp lastlogindate) {
        this.lastlogindate = lastlogindate;
    }

    public String getPetName() {
        return this.petName;
    }
    
    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Timestamp getRegDate() {
        return this.regDate;
    }
    
    public void setRegDate(Timestamp regDate) {
        this.regDate = regDate;
    }

    public Timestamp getLastLoginDate() {
        return this.lastLoginDate;
    }
    
    public void setLastLoginDate(Timestamp lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
   








}