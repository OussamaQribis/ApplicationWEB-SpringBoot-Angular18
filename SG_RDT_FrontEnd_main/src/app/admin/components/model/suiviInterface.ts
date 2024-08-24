export interface Country {
    name?: string;
    code?: string;
}

export interface Representative {
    name?: string;
    image?: string;
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
}
export interface SuiviATAdd {
    
    dateDaffictation:any;
    dateDretour: any;
    ronduNoRondu: any;
    shift: any;
    userId: any;
    code: any;
    nomUtilisateur: any;
    observation: any;
}


export class UtilisateurDTO {
    id: number| undefined;
    nom: string| undefined;
}
export class UserDTO {
    id: number| undefined;
    name: string| undefined;
    password:string| undefined;
    email:string| undefined;
    userRole:string| undefined;
}
export class suiviDTO1{
       
    dateDaffictation:Date| undefined;
    dateDretour: Date | undefined;
    ronduNoRondu: boolean| undefined;
    observation: string| undefined;
    code: string| undefined;
    shift: string| undefined;
    userName: string| undefined;
    userId: number| undefined;
    nomUtilisateur: string| undefined;
}
export class suiviDTO{
       
    id: number | undefined
    dateDaffictation: Date | undefined
    dateDretour: Date | undefined
    user:UserDTO| undefined
    ronduNoRondu: any | undefined
    shift: string | undefined
    userId: number | undefined
    material: MaterialDTO | undefined
    utilisateur:UtilisateurDTO | undefined
    observation : string | undefined
}
export class MaterialDTO {
    
    id: number | undefined
    code: string | undefined
    marque: string | undefined
    model: string | undefined
    numeroDeMarche: string | undefined
    numeroDeSerie: string | undefined
    dateDacquisition: Date | undefined
    dateDeMiseEnService: Date | undefined
}
