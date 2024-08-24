import { Component, ElementRef, ViewChild } from '@angular/core';
import { MegaMenuItem, MenuItem } from 'primeng/api';
import { LayoutService } from "./service/app.layout.service";

@Component({
    selector: 'app-topbar',
    templateUrl: './app.topbar.component.html'
})
export class AppTopBarComponent {

    items!: MegaMenuItem[];

    @ViewChild('menubutton') menuButton!: ElementRef;

    @ViewChild('topbarmenubutton') topbarMenuButton!: ElementRef;

    @ViewChild('topbarmenu') menu!: ElementRef;
   user:any
  
    constructor(public layoutService: LayoutService) { 
     this.user=localStorage.getItem('username')
     console.log(localStorage.getItem('username'))
    }
    ngOnInit() {
        this.items = [
            {
                label: this.user, icon: 'pi pi-fw pi-users',
                items: [
                    [
                        {
                            label: '',
                            items: [{label: 'User 1.1',routerLink: ['/pages/crud']}, 
                                    {label: 'User 1.2'}]
                        },
                        
                    ]
                    
                ]
            },
            {
                label: '', icon: 'pi pi-fw pi-cog',
                items: [
                    [
                        {
                            label: 'Setting 1',
                            items: [{label: 'Setting 1.1'}, {label: 'Setting 1.2'}]
                        },
                        {
                            label: 'Setting 2',
                            items: [{label: 'Setting 2.1'}, {label: 'Setting 2.2'}]
                        },
                        {
                            label: 'Setting 3',
                            items: [{label: 'Setting 3.1'}, {label: 'Setting 3.2'}]
                        }
                    ],
                  
                ]
            }
        ];
    }
}
