package com.heroclone.api.repo.impl;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Repository;

import com.heroclone.api.domain.NDUSPerson;
import com.heroclone.api.repo.NDUSPersonRepo;

@Repository
public class NDUSPersonRepoActiveDirectory implements NDUSPersonRepo {
    private LdapTemplate ldapTemplate;
    
    public static final String BASE_DN = "DC=ad,DC=ndus,DC=edu";
    
    public NDUSPersonRepoActiveDirectory() {}
    
    //@Autowired
    public NDUSPersonRepoActiveDirectory(LdapTemplate ldapTemplate) {
        this.ldapTemplate = ldapTemplate;
    }
    
    public NDUSPerson fetchByEmpl(String empl) {
        NDUSPerson p = new NDUSPerson();
        Object x = ldapTemplate;
        NDUSPersonAttributesMapper n = new NDUSPersonAttributesMapper();
        
        x.equals(n);
        return p;
    }
    
    private class NDUSPersonAttributesMapper implements AttributesMapper<NDUSPerson> {
        @Override
        public NDUSPerson mapFromAttributes(Attributes attrs) throws NamingException {
           NDUSPerson person = new NDUSPerson();
           person.setFirst((String)attrs.get("givenName").get());
           person.setLast((String)attrs.get("sn").get());
           person.setEmail((String)attrs.get("mail").get());
           person.setIdm((String)attrs.get("").get());
           return person;
        }
     }
}
