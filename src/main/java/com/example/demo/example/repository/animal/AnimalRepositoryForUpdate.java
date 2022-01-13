package com.example.demo.example.repository.animal;

import com.example.demo.example.model.datadase.Animal;
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

  public void Delete(Animal animal) {

    try {
      em.remove(animal);
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value = "3000")})
  public Integer Insert(Animal entity) {
    System.out.println(entity);
    try {
      em.persist(entity);
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }

    return null;
  }



}
