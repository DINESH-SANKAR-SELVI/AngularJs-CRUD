import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { ActivatedRoute, Route, Router } from '@angular/router';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  constructor(private employeeservice:EmployeeService,private activatedRoute:ActivatedRoute,private router:Router){ }
  
  id:number;

  employee:Employee = new Employee();

  ngOnInit(): void { 
    this.id = this.activatedRoute.snapshot.params['id'];
    this.employeeservice.getEmployeeById(this.id).subscribe(data=>{
      this.employee=data;
      console.log(data);
    })
   }
  onSubmit(){
    this.employeeservice.updateEmployee(this.id,this.employee).subscribe(data=>{
      this.goToList();
    });

  }

  goToList(){
    this.router.navigate(['/employees']);
  }
}
