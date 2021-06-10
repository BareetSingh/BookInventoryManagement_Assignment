package com.bareet.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bareet.models.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

}
