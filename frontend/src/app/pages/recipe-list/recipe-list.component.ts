import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { RecipeService } from '../../services/recipe.service';
import { Recipe } from '../../models/recipe.model';
@Component({
  selector: 'app-recipe-list',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.css']
})
export class RecipeListComponent implements OnInit {

  recipes: Recipe[] = [];

  constructor(private service: RecipeService) {}

  ngOnInit(): void {
    this.load();
  }

  load() {
    this.service.listar().subscribe(data => {
      this.recipes = data;
    });
  }

  delete(id: number) {
    this.service.excluir(id).subscribe(() => {
      this.load();
    });
  }
}