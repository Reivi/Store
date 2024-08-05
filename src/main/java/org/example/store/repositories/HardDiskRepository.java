package org.example.store.repositories;

import org.example.store.models.HardDisk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardDiskRepository extends JpaRepository<HardDisk, Integer> { }
