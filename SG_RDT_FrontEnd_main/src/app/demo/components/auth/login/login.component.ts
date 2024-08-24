import { Component } from '@angular/core';
import { FormBuilder, NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { LayoutService } from 'src/app/layout/service/app.layout.service';
import { AuthService } from '../auth.service';
import { Message, MessageService } from 'primeng/api';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    providers: [MessageService],
    styles: [`
        :host ::ng-deep .p-password input {
            width: 100%;
            padding:1rem;
        }

        :host ::ng-deep .pi-eye{
            transform:scale(1.6);
            margin-right: 1rem;
            color: var(--primary-color) !important;
        }

        :host ::ng-deep .pi-eye-slash{
            transform:scale(1.6);
            margin-right: 1rem;
            color: var(--primary-color) !important;
        }
    `]
})
export class LoginComponent {

    valCheck: string[] = ['remember'];
    

    email:any
    password:any;

    constructor(public layoutService: LayoutService,
        private fb: FormBuilder,
        private router: Router,
        private service:AuthService,private mess:MessageService) {

          
            
         }



        

         
         onSubmitForm(form: NgForm) {
            this.service.login(form.value).subscribe(
                (response) => {
                  if (response.jwt != null) {
                    const jwtToken = response.jwt;
                    localStorage.setItem('jwt', jwtToken);
                    localStorage.setItem('userId', response.user.id);
                    localStorage.setItem('username', response.user.name);
                    this.mess.add({ key: 'tst', severity: 'success', summary: 'Success Message', detail: 'Hi '+response.user.name });
                    this.router.navigateByUrl("/");
                    
                  }else{
                    this.mess.add({ key: 'tst', severity: 'error', summary: 'Error Message', detail: 'Incorrect email or password!!!' });
                  }
                }
              )
        }

        
}
