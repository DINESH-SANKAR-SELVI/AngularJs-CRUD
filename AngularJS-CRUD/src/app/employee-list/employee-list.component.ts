import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee'
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';
 
@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  tableDesign:String = "table table-striped";

  employees: Employee[];

  constructor(private employeeServices:EmployeeService,private router:Router){   }

  ngOnInit():void{
    this.getEmployees();
  }

  getEmployees(){
    this.employeeServices.getEmployeesList().subscribe(data=>{
      this.employees= data;
    });
  }

  updateEmployee(id:number){
    this.router.navigate(['update-employee',id]);
  }

  deleteEmployee(id:number){
      
    return this.employeeServices.deleteEmployee(id).subscribe(data=>{
        console.log(data);
        this.getEmployees();
    });
  }

  employeeDetail(id:number){

    this.router.navigate(['/employee-detail',id])
  }
}
