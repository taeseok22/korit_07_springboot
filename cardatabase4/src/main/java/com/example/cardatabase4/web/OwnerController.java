package com.example.cardatabase4.web;

import com.example.cardatabase4.domain.Owner;
import com.example.cardatabase4.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OwnerController {
    private final OwnerService ownerService;

    // 전체 조회
    @GetMapping("/owners")
    public List<Owner> findAllOwners() {
        return ownerService.findAllOwners();
    }
    // id 별 조회
    @PostMapping("/owners/{id}")
    public ResponseEntity<Owner> findOwnerById(@PathVariable Long id) {
        return ownerService.findOwnerById(id)
                .map(owner -> ResponseEntity.ok().body(owner))
                .orElse(ResponseEntity.notFound().build());
    }
    // 추가
    @PostMapping("/owners")
    public ResponseEntity<Owner> addOwner(@RequestBody Owner owner) {
        Owner savedOwner = ownerService.addOwner(owner);
        return new ResponseEntity<>(savedOwner, HttpStatus.CREATED);
    }
    // 삭제
    @DeleteMapping("/owners/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable Long id) {
        if (ownerService.deleteOwner(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // 수정
    @PutMapping("/owners/{id}")
    public ResponseEntity<Owner> updateOwner(@PathVariable Long id, @RequestBody Owner ownerDetails) {
        return ownerService.updateOwner(id, ownerDetails)
                .map(updateOwner -> ResponseEntity.ok().body(updateOwner))
                .orElse(ResponseEntity.notFound().build());
    }
}
