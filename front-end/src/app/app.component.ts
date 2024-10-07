import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ConnectBackService } from './ConnectBackService';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  message: string = '';

  constructor(private connectBackService: ConnectBackService) { }

  ngOnInit() {
    this.connectBackService.getHelloMessage().subscribe({
      next: (message) => {
        this.message = message;
        console.log('Message reçu : ' + message);
      },
      error: (error) => {
        console.log('Erreur : ' + error);
      },
      complete: () => {
        console.log('L\'appel à l\'API est terminé.');
      }
    });
  }
}
