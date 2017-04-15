package cn.kanyun.cpa.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * CpaRepertory entity. @author MyEclipse Persistence Tools
 */

public class CpaRepertory  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String testStem;
     private String testType;
     private Timestamp insertDate;
     private Set cpaOptions = new HashSet(0);
     private Set cpaSolutions = new HashSet(0);


    // Constructors

    /** default constructor */
    public CpaRepertory() {
    }

    
    /** full constructor */
    public CpaRepertory(String testStem, String testType, Timestamp insertDate, Set cpaOptions, Set cpaSolutions) {
        this.testStem = testStem;
        this.testType = testType;
        this.insertDate = insertDate;
        this.cpaOptions = cpaOptions;
        this.cpaSolutions = cpaSolutions;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTestStem() {
        return this.testStem;
    }
    
    public void setTestStem(String testStem) {
        this.testStem = testStem;
    }

    public String getTestType() {
        return this.testType;
    }
    
    public void setTestType(String testType) {
        this.testType = testType;
    }

    public Timestamp getInsertDate() {
        return this.insertDate;
    }
    
    public void setInsertDate(Timestamp insertDate) {
        this.insertDate = insertDate;
    }

    public Set getCpaOptions() {
        return this.cpaOptions;
    }
    
    public void setCpaOptions(Set cpaOptions) {
        this.cpaOptions = cpaOptions;
    }

    public Set getCpaSolutions() {
        return this.cpaSolutions;
    }
    
    public void setCpaSolutions(Set cpaSolutions) {
        this.cpaSolutions = cpaSolutions;
    }
   








}