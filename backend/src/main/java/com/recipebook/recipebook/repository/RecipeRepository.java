package com.recipebook.recipebook.repository;

import com.recipebook.recipebook.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findAllByOrderByDataCadastroDesc();

    boolean existsByNome(String nome);

}