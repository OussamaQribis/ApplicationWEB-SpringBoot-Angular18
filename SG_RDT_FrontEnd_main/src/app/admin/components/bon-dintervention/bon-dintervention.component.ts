import { Component } from '@angular/core';
import { ConfirmationService, MenuItem, MessageService, SelectItem } from 'primeng/api';
import { BonDiterventionService } from './bon-ditervention.service';
import { Table } from 'primeng/table';
import { UserDTO } from '../model/suiviInterface';
import { BonDTO, Detail } from '../model/bonDinterventionClasses';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-bon-dintervention',
  templateUrl: './bon-dintervention.component.html',
  styleUrl: './bon-dintervention.component.scss',
  providers:[ConfirmationService, MessageService]
})
export class BonDinterventionComponent {
filter: any;

constructor(private bon:BonDiterventionService,private confirmationService: ConfirmationService, private messageService: MessageService){

}

visible2=false;
visible=false;
users :UserDTO[] =[] ; 
zones:any[]=[];
typeBonDintervention:any[] =[]
typefamilles:any[]=[]
bonDintervention:any[]=[]
detail:Detail=new Detail()
userId:any
bonDTO:BonDTO={
  id: undefined,
  userName: undefined,
  idUser: undefined,
  date: undefined,
  shift: undefined,
  code: undefined,
  TachesEffecuees: undefined,
  typeBonDintervention: undefined
}
materials:any|undefined
shifts = [
  {  name: '1er Shift',value:'1er Shift'},
  {  name: '2émé Shift',value:'2émé Shift' },
  {  name: '3émé Shift',value:'3émé Shift'}
];

ngOnInit(){
this.userId=localStorage.getItem('userId')
this.bon.fingAll().subscribe(res=>{
  this.bonDintervention=res
  this.bonDintervention.forEach(b=>{
    b.date=new Date(b.date)
  })
  
})
this.myTable();
this.getUsers();
this.findAllZones();
this.findAllTypeDeFamilles();
this.getAllMaterial();
this.typeBonDintervention=[{name:"CURATIF(intervention)",value:"CURATIF"},
                           {name:"PREVONTIF(EPS)",value:"PREVONTIF"}]


}



/* posters all bonDintervention  */

formatCurrency(value: number) {
  return value.toLocaleString('en-US', { style: 'currency', currency: 'USD' });
}

onGlobalFilter(table: Table, event: Event) {
  table.filterGlobal((event.target as HTMLInputElement).value, 'contains');
}

clear(table: Table) {
  table.clear();
  this.filter.nativeElement.value = '';
}



myTable()
{
  this.bon.fingAll().subscribe(res=>{
    this.bonDintervention=res
    this.bonDintervention.forEach(b=>{
      b.date=new Date(b.date)
    })
    
  })
}
getUsers(){
    this.bon.getAllUser().subscribe( (response) => {
        response.forEach(e=>{this.users.push(e)})
      })
}
findAllZones(){
  this.bon.findAllZones().subscribe( (response) => {
    response.forEach(e=>{this.zones.push(e)})
  })
}
findAllTypeDeFamilles(){
  this.bon.findAllTypeDeFamilles().subscribe( (response) => {
    response.forEach(e=>{this.typefamilles.push(e)})
  })
}
getAllMaterial(){
  this.bon.getAllMaterial().subscribe((res)=>{
    this.materials=res
  })
}
date(event:any){
  let d = new Date(event);
  let d2=d.toISOString().split('.')[0]
return d2.toString().split('T')[0]+" "+d.getHours()+":"+d2.toString().split(':')[1]
}
confirm3(){
  this.visible=false
}
/* add BonDintervention  */

showDialog2(){
  this.visible=true
  this.bonDTO=new BonDTO()

}
onSubmitForm(addBon: NgForm){
  addBon.value.date=this.date(addBon.value.date)
  
  this.bon.create(addBon.value).subscribe(res=>{
    this.visible=false
    this.myTable();
    if(addBon.value.id!=null){
      this.messageService.add({ severity: 'success', summary: 'Confirmed', detail: 'updated successfully' });
    }else{
      this.messageService.add({ severity: 'success', summary: 'Confirmed', detail: 'added successfully' });
    }

  })
  
}
/* update BonDintervention */

showDialog(bon:any){
  this.visible=true
  this.bonDTO.id=bon.id
  this.bonDTO.code=bon.material?.code
  this.bonDTO.userName=bon.user?.name
  this.bonDTO.date=new Date(bon.date)
  this.bonDTO.TachesEffecuees=bon.tachesEffecuees
  this.bonDTO.idUser=bon.user?.id
  this.bonDTO.shift=bon.shift
  this.bonDTO.typeBonDintervention=bon.typeBonDintervention

}



/* Delete BonDitervention */

deleteById(event: Event,id:any) {
  this.confirmationService.confirm({
      key: 'confirm2',
      target: event.target || new EventTarget,
      message: 'Are you sure that you want to delete?',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.bon.deleteById(id).subscribe(res=>{
          this.messageService.add({ severity: 'success', summary: 'Confirmed', detail:  "Deleted Successfully"});
          this.myTable();
        })
      },
      reject: () => {
          this.messageService.add({ severity: 'error', summary: 'Rejected', detail: 'You have rejected' });
      }
  });
}

/* Detail  */

detailF(bon:any){
  this.visible2=true;
  this.detail.code=bon.material.code;
  this.detail.marque=bon.material.marque;
  this.detail.model=bon.material.model;
  this.detail.numeroDeSerie=bon.material.numeroDeSerie;
  this.detail.observation=bon.material.emplacemant.observation;
  this.detail.zone=bon.material.emplacemant.zone.zonNom;
  this.detail.type=bon.material.typeDeFamille.type;
  this.detail.tachesEffecuees=bon.tachesEffecuees;


  console.log(this.detail)
}


}
