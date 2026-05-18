import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RecipeService } from '../../services/recipe.service';

@Component({
  selector: 'app-recipe-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './recipe-form.component.html'
})
export class RecipeFormComponent {

  form: FormGroup;

  constructor(
    private fb: FormBuilder,
    private service: RecipeService,
    private router: Router
  ) {
    this.form = this.fb.group({
      nome: ['', Validators.required],
      categoria: ['DOCE'],
      tempoPreparo: [0, Validators.required],
      porcoes: [1, Validators.required],
      ingredientes: ['', Validators.required],
      modoPreparo: ['', Validators.required]
    });
  }

  submit() {
    const data = {
      ...this.form.value,
      ingredientes: this.form.value.ingredientes.split(',')
    };

    this.service.salvar(data).subscribe(() => {
      this.router.navigate(['/']);
    });
  }
}