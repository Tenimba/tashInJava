import { Component } from '@angular/core';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  user = { lastName: '', firstName: '', password: '', email: '' };

  constructor(private userService: UserService) { }

  register() {
    this.userService.register(this.user).subscribe({
      next: response => {
        console.log('User created successfully', response);
      },
      error: error => {
        console.error('Error creating user', error);
      },
      complete: () => {
        console.log('User creation completed');
      }
    });
  }
}
