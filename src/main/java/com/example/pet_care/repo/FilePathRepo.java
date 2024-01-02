package com.example.pet_care.repo;

import com.example.pet_care.entity.FilePath;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilePathRepo extends JpaRepository<FilePath,Integer> {
}
