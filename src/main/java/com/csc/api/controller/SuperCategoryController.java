package com.csc.api.controller;

import com.csc.api.model.entity.SuperCategory;
import com.csc.api.model.request.SuperCategoryRequest;
import com.csc.api.model.response.SuperCategoryResponse;
import com.csc.api.service.SuperCategoryService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/super")
@SecurityRequirement(name = "bearer")
@AllArgsConstructor
public class SuperCategoryController {
private final SuperCategoryService service;
@PostMapping("/add")
    public ResponseEntity<SuperCategoryResponse<SuperCategory>> addNewSuperCategory(@RequestBody SuperCategoryRequest superCategoryRequest){

    UUID addId = service.addNewSuper(superCategoryRequest);

    if(addId != null){
        SuperCategoryResponse<SuperCategory> response = SuperCategoryResponse.<SuperCategory>builder()
                .message("Add Success")
                .payload(service.getSuperCategoryById(addId))
                .build();
                return ResponseEntity.ok(response);
    }
    return null;
}
@GetMapping("/all")
    public ResponseEntity<SuperCategoryResponse<List<SuperCategory>>> getAllSuper(){
    if(service.getAllSuper() !=null){
       SuperCategoryResponse<List<SuperCategory>> response = SuperCategoryResponse.<List<SuperCategory>>builder()
                .message("get")
                .payload(service.getAllSuper())
                .build();
        return ResponseEntity.ok(response);

    }
    return null;
}
@GetMapping("/get-by-Id/{id}")
public ResponseEntity<SuperCategoryResponse<SuperCategory>> getSuperCategoryById(@PathVariable ("id") UUID categoryId){
    if(service.getSuperCategoryById(categoryId) != null){
        SuperCategoryResponse<SuperCategory> response = SuperCategoryResponse.<SuperCategory>builder()
                .message("getById success")
                .payload(service.getSuperCategoryById(categoryId))
                .build();
        return ResponseEntity.ok(response);

    }
    return null;
}

@DeleteMapping("/delete/{id}")
public ResponseEntity<SuperCategoryResponse<SuperCategory>> deleteById(@PathVariable ("id") UUID categoryId){
    if(service.deleteSuperCategoryId(categoryId) != null){
//        System.out.println("NOT WORKING");
        SuperCategoryResponse<SuperCategory> response = SuperCategoryResponse.<SuperCategory>builder()
                .message("getById success")
                .payload(service.deleteSuperCategoryId(categoryId))
                .build();
        return ResponseEntity.ok(response);
    }
//    System.out.println("workiing");
    return null;
}
@PutMapping("/update/{id}")
    public ResponseEntity<SuperCategoryResponse<SuperCategory>> updatedById(@PathVariable ("id") UUID categoryId, SuperCategoryRequest superCategoryRequest){
    SuperCategory updatedId = service.updateSuperCategory(categoryId, superCategoryRequest);
    if(updatedId != null){
        SuperCategoryResponse<SuperCategory> response = SuperCategoryResponse.<SuperCategory>builder()
                .message("Update success")
                .payload(service.getSuperCategoryById(categoryId))
                .build();
        return ResponseEntity.ok(response);
    }

   return null;
}


}
