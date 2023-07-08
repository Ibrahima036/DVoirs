package edu.ci.jpa.repository;

import edu.ci.jpa.entity.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CoursRepository extends JpaRepository<Cours, Long>{

}