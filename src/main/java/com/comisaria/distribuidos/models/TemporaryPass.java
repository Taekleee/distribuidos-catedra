package com.comisaria.distribuidos.models;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TemporaryPass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname; 
    private String identifier;
    private String address;
    private String reason;

    public TemporaryPass(){
       
    }
    public TemporaryPass(String name, String surname, String identifier, String address, String reason){
        this.name = name;
        this.surname = surname;
        this.identifier = identifier;
        this.address = address;
        this.reason = reason;


    }
    /*public SimpleDateFormat getTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatter;

    }
    */

    public void setName(String name){
        this.name = name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public void setIdentifier(String identifier){
        this.identifier = identifier;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setReason(String reason){
        this.reason = reason;
    }
    public String getName(){
        return this.name;
    }
    public String getSurname(){
        return this.surname;
    }
    public String getIdentifier(){
        return this.identifier;
    }
    public String getAddres(){
        return this.address;
    }
    public String getReason(){
        return this.reason;
    }


}