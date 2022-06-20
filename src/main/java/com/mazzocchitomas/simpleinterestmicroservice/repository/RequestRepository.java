package com.mazzocchitomas.simpleinterestmicroservice.repository;

import com.mazzocchitomas.simpleinterestmicroservice.model.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
}
