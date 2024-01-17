package com.example.demo.business.product.app;
// package com.example.demo.controller;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.model.bondmanage.BondRegistInfo;
// import com.example.demo.service.BondSevice;

// @RestController
// @RequestMapping("/ebond_manage/v1")
// public class BondRegistController {
// S
//     private final Bondevice service;

//     public BondRegistController(BondSevice bondRegistService) {
//         this.service = bondRegistService;
//     }

//     @PostMapping("/bonds/register")
//     public ResponseEntity<String> registerBond(@RequestBody BondRegistInfo bondRegistInfo) {
//         if (service.registBond(bondRegistInfo)) {
//             return new ResponseEntity<>("Bond registered successfully", HttpStatus.OK);
//         } else {
//             return new ResponseEntity<>("Bond registered failed", HttpStatus.BAD_REQUEST);

//         }

//     }
// }
