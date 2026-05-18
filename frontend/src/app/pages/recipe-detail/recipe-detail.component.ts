import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { RecipeService } from '../../services/recipe.service';
import { Recipe } from '../../models/recipe.model';

@Component({
  selector: 'app-recipe-detail',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './recipe-detail.component.html'
})
export class RecipeDetailComponent implements OnInit {

  recipe?: Recipe;

  constructor(
    private route: ActivatedRoute,
    private service: RecipeService
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));

    this.service.buscarPorId(id).subscribe(data => {
      this.recipe = data;
    });
  }
}