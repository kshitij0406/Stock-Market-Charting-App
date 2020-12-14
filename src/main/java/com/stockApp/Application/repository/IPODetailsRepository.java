package com.stockApp.Application.repository;

import com.stockApp.Application.dao.IPODetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPODetailsRepository extends JpaRepository<IPODetails,Integer> {
}
