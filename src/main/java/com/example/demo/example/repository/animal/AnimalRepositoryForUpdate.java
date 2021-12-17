package com.example.demo.example.repository.animal;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.QueryHint;
import javax.transaction.Transactional;

@Singleton
@Component
@Transactional
public class AnimalRepositoryForUpdate {

  @PersistenceContext
  private EntityManager em;

  @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value = "3000")})
  public Integer Insert() {

    return null;
  }

}
