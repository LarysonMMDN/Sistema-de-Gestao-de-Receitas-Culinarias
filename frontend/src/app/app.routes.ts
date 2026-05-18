import { Routes } from '@angular/router';
import { RecipeListComponent } from './pages/recipe-list/recipe-list.component';
import { RecipeFormComponent } from './pages/recipe-form/recipe-form.component';
import { RecipeDetailComponent } from './pages/recipe-detail/recipe-detail.component';

export const routes: Routes = [
  { path: '', component: RecipeListComponent },
  { path: 'receitas/nova', component: RecipeFormComponent },
  { path: 'receitas/:id', component: RecipeDetailComponent }
];