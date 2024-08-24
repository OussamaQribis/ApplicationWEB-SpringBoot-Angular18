import { Component, ElementRef, ViewChild } from '@angular/core';
import { Table } from 'primeng/table';
import { SuivATService } from './suiv-at.service';
import { MaterialDTO, suiviDTO, UserDTO } from '../model/suiviInterface';
import {
    ConfirmationService,
    MenuItem,
    MessageService,
    SelectItem,
} from 'primeng/api';
import { ButtonModule } from 'primeng/button';
import { NgForm } from '@angular/forms';
export interface Country {
    name?: string;
    code?: string;
}

export interface Change {
    id: any;
    ronduNoRondu: any;
}
export interface nomUtilisateur {
    name?: string;
}
export interface Representative {
    name?: string;
    image?: string;
}
export interface Code {
    code?: string;
}

export interface Customer {
    id?: number;
    name?: string;
    country?: Country;
    company?: string;
    date?: string;
    status?: string;
    activity?: number;
    representative?: Representative;
    imports: [ButtonModule];
}

@Component({
    selector: 'app-suivi-at',
    templateUrl: './suivi-at.component.html',
    styleUrl: './suivi-at.component.scss',
    providers: [ConfirmationService, MessageService],
})
export class SuiviATComponent {
    /////////////////////////////////
    users: UserDTO[] = [];
    suiviAT: any[] = [];
    change: Change | undefined;
    selectedCustomers1: suiviDTO[] = [];
    userName!: SelectItem[];
    items: MenuItem[] | undefined;
    codes!: SelectItem[];
    materials: MaterialDTO[] = [];
    userId: any;
    @ViewChild('filter') filter!: ElementRef;

    constructor(
        private customerService: SuivATService,
        private confirmationService: ConfirmationService,
        private messageService: MessageService
    ) {}
    
    ngOnInit() {
        this.userId = localStorage.getItem('userId');
        this.myTable();
        this.getAllUser();
        this.getAllMaterials()
        
    }

    onGlobalFilter(table: Table, event: Event) {
        table.filterGlobal(
            (event.target as HTMLInputElement).value,
            'contains'
        );
    }
    clear(table: Table) {
        table.clear();
        this.filter.nativeElement.value = '';
    }
/* affichage */
getAllMaterials(){
    this.customerService.getAllMaterial().subscribe(res=>{
        this.materials=res
    })
}
getAllUser(){
    this.userName = [];
    this.customerService.getAllUser().subscribe((response) => {
        response.forEach((e) => {
            this.users.push(e);
        });
    });
}
    //////////////////////////////////////////////////////

    visible: boolean = false;

    showDialog(suiviAT: suiviDTO) {
        this.id = suiviAT.id;
        this.visible = true;
        this.nomUtilisateur = suiviAT.utilisateur?.nom;
        this.code = suiviAT.material?.code;
        this.shift = suiviAT.shift;
        if (suiviAT.ronduNoRondu == true) {
            this.renduNoRondu = 1;
        } else if (suiviAT.ronduNoRondu == false) {
            this.renduNoRondu = 0;
        } else {
            this.renduNoRondu = suiviAT.ronduNoRondu;
        }
        this.observation = suiviAT.observation;
        this.dateDaffictation = new Date(suiviAT.dateDaffictation + '');
        if (suiviAT.dateDretour + '' !== 'Invalid Date') {
            this.dateDretour = new Date(suiviAT.dateDretour + '');
        }
    }

    showDialog2() {
        this.id = null;
        this.visible = true;
        this.nomUtilisateur = '';
        this.code = '';
        this.shift = '';
        this.renduNoRondu = 0;
        this.observation = '';
        this.dateDaffictation = new Date();
        this.dateDretour = '';
    }

    id: any;
    nomUtilisateur: string | undefined;
    code: string | undefined;
    shift: string | undefined;
    observation: any;
    renduNoRondu: any | undefined;
    dateDaffictation: any | undefined;
    dateDretour: any;
    dateDaffictation1: any;
    shifts = [
        { name: '1er Shift', value: '1er Shift' },
        { name: '2émé Shift', value: '2émé Shift' },
        { name: '3émé Shift', value: '3émé Shift' },
    ];

    onSubmitForm(form: NgForm) {
        console.log(form.value)
        form.value.dateDaffictation = this.date(form.value.dateDaffictation);
        if (form.value.dateDretour != '') {
            form.value.dateDretour = this.date(form.value.dateDretour);
        }

        console.log(form.value);
        this.customerService.addSuiviAT(form.value).subscribe((res) => {
            this.messageService.add({
                severity: 'success',
                summary: 'Confirmed',
                detail: 'added successfully',
            });
            this.dateDretour = '';
            this.visible = false;
            this.myTable();
        });
    }

    confirm3() {
        this.visible = false;
        this.visible2 = false;
    }
    deleteById(event: Event, id: any) {
        this.confirmationService.confirm({
            key: 'confirm2',
            target: event.target || new EventTarget(),
            message: 'Are you sure that you want to delete?',
            icon: 'pi pi-exclamation-triangle',
            accept: () => {
                    this.customerService.deleteById(id).subscribe((res) => {
                    this.messageService.add({ severity: 'success',summary: 'Confirmed',detail: 'Deleted Successfully', });
                    this.myTable();
                });
            },
            reject: () => {
                this.messageService.add({
                    severity: 'error',
                    summary: 'Rejected',
                    detail: 'You have rejected',
                });
            },
        });
    }

    myTable() {
        this.customerService.getAllSuivi().subscribe((response) => {
            this.suiviAT = response;
            this.suiviAT.forEach((b) => {
                b.dateDaffictation = new Date(b.dateDaffictation + '');
                b.dateDretour = new Date(b.dateDretour + '');
            });
        });
    }

    changeEtat(suiviAT: suiviDTO) {
        if (suiviAT.ronduNoRondu == false) {
            suiviAT.ronduNoRondu = 0;
            this.customerService.changeEtat(suiviAT).subscribe();
        } else if (suiviAT.ronduNoRondu == true) {
            suiviAT.ronduNoRondu = 1;
            this.customerService.changeEtat(suiviAT).subscribe();
        }
        this.myTable();
    }

    date(event: any) {
        let d = new Date(event);
        let d2 = d.toISOString().split('.')[0];
        return (
            d2.toString().split('T')[0] +
            ' ' +
            d.getHours() +
            ':' +
            d2.toString().split(':')[1]
        );
    }
    visible2 = false;
    detait() {
        this.visible2 = true;
    }
}
