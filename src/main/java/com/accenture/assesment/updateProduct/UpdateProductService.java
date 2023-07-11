package com.accenture.assesment.updateProduct;

import com.accenture.assesment.updateProduct.binding.ProductType;
import com.accenture.assesment.updateProduct.binding.RequestType;
import com.accenture.assesment.updateProduct.binding.ResponseType;

import com.accenture.assesment.updateProduct.binding.StatusType;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Service
public final class UpdateProductService {
    @Autowired
    UpdateProductRepo updateProductRepo;
    @Autowired
    ReentrantLock reentrantLock;
    @Transactional
    public ResponseType updateProduct(RequestType requestType){
        ResponseType responseType = new ResponseType();
        reentrantLock.lock();
        List<ProductType> productTypeList = requestType.getProductTypeList();
        List<StatusType> statusTypeList = new ArrayList<StatusType>();
        for(ProductType productType: productTypeList){
            StatusType statusType = updateProductRepo.updateProduct(productType);
            statusTypeList.add(statusType);
        }
        reentrantLock.unlock();
        responseType.setStatusTypeList(statusTypeList);
        return responseType;
    }
}
