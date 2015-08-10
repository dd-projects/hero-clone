package com.heroclone.api.domain;

public class NDUSPerson {
    private String first, last;
    private String email;
    private String devNote;
    private String idm;
    
    public String getFullName() {
        return this.first + ' ' + this.last;
    }
    
    public String getFirst() {
        return this.first;
    }
    
    public String getLast() {
        return this.last;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String getDevNote() {
        return this.devNote;
    }
    
    public String getIdm() {
        return this.idm;
    }
    
    public void setFirst(String first) {
        this.first = first;
    }
    
    public void setLast(String last) {
        this.last = last;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setDevNote(String devNote) {
        this.devNote = devNote;
    }
    
    public void setIdm(String idm) {
        this.idm = idm;
    }
}
