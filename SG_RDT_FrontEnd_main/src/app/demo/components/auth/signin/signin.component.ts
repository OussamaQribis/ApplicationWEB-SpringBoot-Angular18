import { Component } from '@angular/core';
import { FormBuilder, NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { LayoutService } from 'src/app/layout/service/app.layout.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-signin',
  providers: [MessageService],
  templateUrl: './signin.component.html',
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
export class SigninComponent {

  valCheck: string[] = ['remember'];
    

  name:any
  email:any
  password:any;
  userRole:any;
  valRadio: string = '';
  confirmPassword:any

  constructor(public layoutService: LayoutService,
      private router: Router,
      private mess:MessageService,
      private service:AuthService) {

          
       }



      

       
       onSubmitForm(form: NgForm) {
         if(this.password===this.confirmPassword){
          this.service.register(form.value).subscribe((response) => {
            console.log(response)
            if (response!= null) {
              this.mess.add({ key: 'tst', severity: 'success', summary: 'Success Message', detail: 'Hi '+response.name });
              this.router.navigateByUrl("/auth/login");
             
            }else{
              this.mess.add({ key: 'tst', severity: 'error', summary: 'Error Message', detail: 'This user already exists!!!' });
             }
          })
         }else{
          this.mess.add({ key: 'tst', severity: 'error', summary: 'Error Message', detail: 'Incorrect  password!!!' });
         }
         
      }

}
