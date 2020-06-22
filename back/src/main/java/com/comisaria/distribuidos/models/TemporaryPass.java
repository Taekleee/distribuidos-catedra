package com.comisaria.distribuidos.models;

import java.util.Calendar;
import java.util.Date;

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
    private Date date;
    private Date finalDate;

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
    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }

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
    public String getAddress(){
        return this.address;
    }
    public String getReason(){
        return this.reason;
    }
    public Date getDate(){
        return this.date;
    }
    public void setDate(Date date){
        Calendar calendar = Calendar.getInstance();
        this.date = calendar.getTime();
    }
    public Date getFinalDate(){
        return this.finalDate;
    }
    public void setFinalDate(Date finalDate){
        this.finalDate = finalDate;
    }

    public Date sumarRestarHorasFecha(Date fecha, int horas){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha); 
        calendar.add(Calendar.HOUR, horas);  
        return calendar.getTime(); 
   }
}