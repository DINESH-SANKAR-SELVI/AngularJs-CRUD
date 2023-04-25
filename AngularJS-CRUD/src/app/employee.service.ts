import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private BaseURL = "http://localhost:8080/API/Value/employees";
  UpdateEmployee: any;

  constructor(private httpClient:HttpClient) { }

    getEmployeesList(): Observable <Employee[]>{  
      return this.httpClient.get<Employee[]>(`${this.BaseURL}`);
    }

    createEmployee(employee:Employee):Observable<Object>{
      return this.httpClient.post(`${this.BaseURL}`,employee);
    }

    getEmployeeById(id:number){
      return this.httpClient.get<Employee>(`${this.BaseURL}/${id}`);
    }

    updateEmployee(id:number,employee:Employee){
      return this.httpClient.put(`${this.BaseURL}/${id}`,employee);
    }

    deleteEmployee(id:number):Observable<Object>{
      return this.httpClient.delete(`${this.BaseURL}/${id}`);
    }
}
