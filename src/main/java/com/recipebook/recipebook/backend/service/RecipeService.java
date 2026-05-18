package com.recipebook.recipebook.backend.service;

import com.recipebook.recipebook.backend.entity.Recipe;
import com.recipebook.recipebook.backend.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository repository;

    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }

    // =========================
    // LISTAR RECEITAS
    // =========================
    public List<Recipe> listar() {
        return repository.findAllByOrderByDataCadastroDesc();
    }

    // =========================
    // BUSCAR POR ID
    // =========================
    public Recipe buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Receita não encontrada"));
    }

    // =========================
    // SALVAR RECEITA
    // =========================
    public Recipe salvar(Recipe recipe) {

        boolean nomeExiste = repository.existsByNome(recipe.getNome());

        if (nomeExiste) {
            throw new RuntimeException("Já existe uma receita com esse nome");
        }

        return repository.save(recipe);
    }

    // =========================
    // EXCLUIR RECEITA
    // =========================
    public void excluir(Long id) {

        Recipe recipe = buscarPorId(id);

        repository.delete(recipe);
    }
}