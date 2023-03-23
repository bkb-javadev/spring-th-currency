package com.arsen.spring230323.repositories;

import com.arsen.spring230323.models.Changer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChangerRepository extends JpaRepository<Changer, Long> {
}
