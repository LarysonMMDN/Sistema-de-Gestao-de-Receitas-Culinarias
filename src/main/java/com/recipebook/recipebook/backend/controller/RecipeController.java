package com.recipebook.recipebook.backend.controller;

import com.recipebook.recipebook.backend.entity.Recipe;
import com.recipebook.recipebook.backend.service.RecipeService;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receitas")
@CrossOrigin("*")
public class RecipeController {

    private final RecipeService service;

    public RecipeController(RecipeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Recipe> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Recipe buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Recipe salvar(@RequestBody @Valid Recipe recipe) {
        return service.salvar(recipe);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}