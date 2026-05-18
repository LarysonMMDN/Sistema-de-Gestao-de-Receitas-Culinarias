package com.recipebook.recipebook.backend.config;

import com.recipebook.recipebook.backend.entity.Categoria;
import com.recipebook.recipebook.backend.entity.Recipe;
import com.recipebook.recipebook.backend.repository.RecipeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    private final RecipeRepository repository;

    public DataLoader(RecipeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {

        if (repository.count() > 0) {
            return;
        }

        Recipe r1 = new Recipe();
        r1.setNome("Bolo de Chocolate");
        r1.setCategoria(Categoria.SOBREMESA);
        r1.setTempoPreparo(60);
        r1.setPorcoes(8);
        r1.setIngredientes(Arrays.asList("Farinha", "Chocolate", "Ovos", "Açúcar"));
        r1.setModoPreparo("Misture tudo e asse.");

        Recipe r2 = new Recipe();
        r2.setNome("Suco de Laranja");
        r2.setCategoria(Categoria.BEBIDA);
        r2.setTempoPreparo(10);
        r2.setPorcoes(2);
        r2.setIngredientes(Arrays.asList("Laranja", "Água", "Açúcar"));
        r2.setModoPreparo("Bata tudo no liquidificador.");

        Recipe r3 = new Recipe();
        r3.setNome("Arroz Branco");
        r3.setCategoria(Categoria.SALGADO);
        r3.setTempoPreparo(30);
        r3.setPorcoes(4);
        r3.setIngredientes(Arrays.asList("Arroz", "Água", "Sal"));
        r3.setModoPreparo("Cozinhe até secar a água.");

        repository.saveAll(Arrays.asList(r1, r2, r3));
    }
}