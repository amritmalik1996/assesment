package com.accenture.assesment.updateProduct;

import com.accenture.assesment.updateProduct.binding.RequestType;
import com.accenture.assesment.updateProduct.binding.ResponseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateProductController {

    @Autowired
    UpdateProductService productService;
    @PutMapping("/update-product")
    public ResponseEntity<ResponseType> addProduct(@RequestBody RequestType requestType){
        ResponseType responseType = productService.updateProduct(requestType) ;
        return new ResponseEntity<ResponseType>(responseType, HttpStatus.OK);
    }
}
