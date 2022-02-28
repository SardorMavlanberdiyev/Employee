package com.example.demo.service;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.entity.EmployeeModel;
import com.example.demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<EmployeeModel> read() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<EmployeeModel> employeeModels = new ArrayList<>();
        for (EmployeeEntity entity : employeeEntities) {
            EmployeeModel model = new EmployeeModel();
            model.setId(entity.getId());
            model.setFirstName(entity.getFirstName());
            model.setLastName(entity.getLastName());
            model.setEmail(entity.getEmail());
            model.setPosition(entity.getPosition());
            model.setPhoneNumber(entity.getPhoneNumber());
            employeeModels.add(model);
        }
        return employeeModels;
    }

    public String save(EmployeeModel employeeModel) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(employeeModel.getId());
        employeeEntity.setEmail(employeeModel.getEmail());
        employeeEntity.setFirstName(employeeModel.getFirstName());
        employeeEntity.setLastName(employeeModel.getLastName());
        employeeEntity.setPosition(employeeModel.getPosition());
        employeeEntity.setPhoneNumber(employeeModel.getPhoneNumber());
        employeeRepository.save(employeeEntity);
        return "Muofaqqiyatli qo`shildi!";
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }


    public EmployeeModel getById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.getById(id);
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setId(employeeEntity.getId());
        employeeModel.setPosition(employeeEntity.getPosition());
        employeeModel.setEmail(employeeEntity.getEmail());
        employeeModel.setFirstName(employeeEntity.getFirstName());
        employeeModel.setLastName(employeeEntity.getLastName());
        employeeModel.setPhoneNumber(employeeEntity.getPhoneNumber());
        return employeeModel;

    }
}
