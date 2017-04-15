package cn.kanyun.cpa.pojo;



/**
 * CpaOption entity. @author MyEclipse Persistence Tools
 */

public class CpaOption  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private CpaRepertory cpaRepertory;
     private String selectData;
     private String optionData;


    // Constructors

    /** default constructor */
    public CpaOption() {
    }

    
    /** full constructor */
    public CpaOption(CpaRepertory cpaRepertory, String selectData, String optionData) {
        this.cpaRepertory = cpaRepertory;
        this.selectData = selectData;
        this.optionData = optionData;
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

    public String getSelectData() {
        return this.selectData;
    }
    
    public void setSelectData(String selectData) {
        this.selectData = selectData;
    }

    public String getOptionData() {
        return this.optionData;
    }
    
    public void setOptionData(String optionData) {
        this.optionData = optionData;
    }
   








}