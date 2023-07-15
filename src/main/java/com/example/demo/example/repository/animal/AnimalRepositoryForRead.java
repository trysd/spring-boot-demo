package com.example.demo.example.repository.animal;

import com.example.demo.example.model.datadase.Animal;

import org.hibernate.SessionFactory;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;
// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.inject.Singleton;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Singleton
@Repository
public class AnimalRepositoryForRead {

  @PersistenceContext
  private EntityManager em;

  @Lock(LockModeType.PESSIMISTIC_READ)
  @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value = "3000")})
  public Animal findById(Integer id) {
    Animal result = em.find(Animal.class, id);
    return result;
  }

  @Lock(LockModeType.PESSIMISTIC_READ)
  @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value = "3000")})
  public List<Animal> findList() {

    // -----
    // java -Xmx50m -Xms50m -jar ./target/demo.example-0.0.1.jar
    System.out.println("### Statistics ###");
    SessionFactory sessionFactory = em.getEntityManagerFactory().unwrap(SessionFactory.class);
    sessionFactory.getStatistics().setStatisticsEnabled(true);
    long hitCount = sessionFactory.getStatistics().getQueryPlanCacheHitCount();
    long missCount = sessionFactory.getStatistics().getQueryPlanCacheMissCount();
    System.out.println("Query Plan Cache Hit Count: " + hitCount);
    System.out.println("Query Plan Cache miss Count: " + missCount);
    // -----

    CriteriaBuilder builder = em.getCriteriaBuilder();
    CriteriaQuery<Animal> query = builder.createQuery(Animal.class);

    Root<Animal> qFrom = query.from(Animal.class);
    query.select(qFrom);

    List<Predicate> whereList = new ArrayList<>();

    List<String> grpList = new ArrayList<String>(Arrays.asList("aaa", "mmm"));
    List<Integer> ageTargetList = new ArrayList<Integer>(Arrays.asList(2, 3, 5, 6, 10));

    whereList.add(qFrom.get("age").in(ageTargetList));
    whereList.add(qFrom.get("grp").in(grpList));

    query.where(builder.and(whereList.toArray(new Predicate[]{})));

    query.orderBy(builder.asc(qFrom.get("id")));

    List<Animal> result = em.createQuery(query).getResultList();

    return result;
  }

}
