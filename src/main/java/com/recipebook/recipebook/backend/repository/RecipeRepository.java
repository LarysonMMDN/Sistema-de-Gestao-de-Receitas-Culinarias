package com.recipebook.recipebook.backend.repository;

import com.recipebook.recipebook.backend.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findAllByOrderByDataCadastroDesc();

    boolean existsByNome(String nome);

}