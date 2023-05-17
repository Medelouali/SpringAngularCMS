
export class User{
    id?: number;
    username: string;
    email: string;
    description: string;
    role?: string;
    profs?: any[]; // Assuming the type is an array of any objects
    courses?: any[]; // Assuming the type is an array of any objects
    marks?: any[]; // Assuming the type is an array of any objects

    constructor() {
        this.id = 0;
        this.username = '';
        this.email = '';
        this.description = '';
        this.role = '';
        this.profs = [];
        this.courses = [];
        this.marks = [];
    }
}