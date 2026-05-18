import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Recipe } from '../models/recipe.model';
import { environment } from '../../environments/environment';

@Injectable({ providedIn: 'root' })
export class RecipeService {

  private api = `${environment.apiUrl}/receitas`;

  constructor(private http: HttpClient) {}

  listar(): Observable<Recipe[]> {
    return this.http.get<Recipe[]>(this.api);
  }

  buscarPorId(id: number): Observable<Recipe> {
    return this.http.get<Recipe>(`${this.api}/${id}`);
  }

  salvar(recipe: Recipe): Observable<Recipe> {
    return this.http.post<Recipe>(this.api, recipe);
  }

  excluir(id: number): Observable<void> {
    return this.http.delete<void>(`${this.api}/${id}`);
  }
}