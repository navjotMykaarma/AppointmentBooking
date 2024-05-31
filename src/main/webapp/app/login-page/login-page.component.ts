import {Component, inject} from '@angular/core';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {InputRowComponent} from "../common/input-row/input-row.component";
import {Router, RouterLink} from "@angular/router";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-login-page',
  standalone: true,
  imports: [
    FormsModule,
    InputRowComponent,
    RouterLink,
    ReactiveFormsModule
  ],
  templateUrl: './login-page.component.html',
  styleUrl: './login-page.component.css'
})
export class LoginPageComponent {
  http = inject(HttpClient);
  router = inject(Router);
  addForm: FormGroup = new FormGroup(
    {
      username: new FormControl(null),
      password: new FormControl(null),
    }
  );

  handleSubmit() {
    let formData = new FormData()
    formData.append("username", this.addForm.value.username);
    formData.append("password", this.addForm.value.password);
    this.http.post<any>("/login", formData)
      .subscribe({
        next: () => this.router.navigate(['/appointments'], {
          state: {}
        }),
        error: (error) => {
        }
      })

  }
}
