export class Course {
    id?: number=1;
    description: string="";
    name: string="";
    students?: any[]=[];
    marks?: any[]=[];
    prof?: any | null=null;
}