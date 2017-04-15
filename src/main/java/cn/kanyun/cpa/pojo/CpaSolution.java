package cn.kanyun.cpa.pojo;



/**
 * CpaSolution entity. @author MyEclipse Persistence Tools
 */

public class CpaSolution  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private CpaRepertory cpaRepertory;
     private String result;


    // Constructors

    /** default constructor */
    public CpaSolution() {
    }

    
    /** full constructor */
    public CpaSolution(CpaRepertory cpaRepertory, String result) {
        this.cpaRepertory = cpaRepertory;
        this.result = result;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public CpaRepertory getCpaRepertory() {
        return this.cpaRepertory;
    }
    
    public void setCpaRepertory(CpaRepertory cpaRepertory) {
        this.cpaRepertory = cpaRepertory;
    }

    public String getResult() {
        return this.result;
    }
    
    public void setResult(String result) {
        this.result = result;
    }
   








}