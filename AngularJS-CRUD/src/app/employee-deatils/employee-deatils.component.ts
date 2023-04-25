import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { ActivatedRoute } from '@angular/router';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-deatils',
  templateUrl: './employee-deatils.component.html',
  styleUrls: ['./employee-deatils.component.css']
})
export class EmployeeDeatilsComponent implements OnInit {

  id:number;
  
  employee:Employee;

  constructor(private router:ActivatedRoute,private employeeService:EmployeeService){ }

  ngOnInit(): void {
    
    this.id= this.router.snapshot.params['id'];
    this.employee=new Employee();

    this.employeeService.getEmployeeById(this.id).subscribe(data=>{
      this.employee=data;
    })
  }
}
