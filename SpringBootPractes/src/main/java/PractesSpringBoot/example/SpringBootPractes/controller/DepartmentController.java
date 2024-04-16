package PractesSpringBoot.example.SpringBootPractes.controller;


import PractesSpringBoot.example.SpringBootPractes.entity.Department;
import PractesSpringBoot.example.SpringBootPractes.service.DepartmentServiceImplementaion;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class DepartmentController {

private final DepartmentServiceImplementaion departmentServiceImplementaion;

    public DepartmentController(DepartmentServiceImplementaion departmentServiceImplementaion) {
        this.departmentServiceImplementaion = departmentServiceImplementaion;
    }


    @PostMapping ("/saveDep")
    public Department SaveDep(@RequestBody Department department){
        departmentServiceImplementaion.SaveDepartment(department);

        return department;

    }



    @GetMapping("/GetDep")
    public ArrayList<Department> getAll(){

        return departmentServiceImplementaion.getAllDepartments();
    }



    @GetMapping("GetDep/{id}")
    public Department findDepyId(@PathVariable("id") Long IdDepartment){


        return departmentServiceImplementaion.findDepartmentbyID(IdDepartment);
    }


    @DeleteMapping("/Delete")
    public void DeleteAll(){

        departmentServiceImplementaion.DeletAll();
    }


    @DeleteMapping("/Delete/{id}")
    public void DeletebyID(@PathVariable("id") Long id){

        departmentServiceImplementaion.DeletbyID(id);
    }

    @PutMapping ("/update/{id}")
    public Department updateDep(@PathVariable("id") Long id , @RequestBody Department department){

        departmentServiceImplementaion.Update(id , department);

        return department;
    }

    @GetMapping("/GetDepbyname/{name}")
    public Department getDepartmentByName( @PathVariable("name") String name){

        return departmentServiceImplementaion.findDepartmentByName(name);
    }

    @GetMapping("/GetDepbyCode/{code}")
    public Department getDepbycode(@PathVariable("code") String code){
        return departmentServiceImplementaion.findDepartmenByCode(code);
    }
}
