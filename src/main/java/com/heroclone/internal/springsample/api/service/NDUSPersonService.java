package com.heroclone.internal.springsample.api.service;

import com.heroclone.internal.springsample.api.domain.NDUSPerson;

public interface NDUSPersonService {
    public NDUSPerson fetchByEmpl(long id);
}
