import { User } from "./User";

export class SearchResponse{
    public students: Array<User>=[];
    public admins: Array<User>=[];
    public profs: Array<User>=[];

    constructor(){
        this.students=[];
        this.admins=[];
        this.profs=[];
    }
}