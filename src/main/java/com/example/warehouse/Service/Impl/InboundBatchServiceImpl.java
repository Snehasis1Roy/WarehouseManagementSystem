package com.example.warehouse.Service.Impl;

import com.example.warehouse.Mapper.InboundBatchMapper;
import com.example.warehouse.Repositery.InboundBatchRepo;
import com.example.warehouse.Repositery.InboundShipmentRepo;
import com.example.warehouse.Repositery.ProductUnitRepository;
import com.example.warehouse.Service.contract.InboundBatchService;
import com.example.warehouse.dto.request.InboundBatchRequest;
import com.example.warehouse.dto.response.InboundBatchResponse;
import com.example.warehouse.exception.InboundShipmentNotFoundByIdException;
import com.example.warehouse.model.InboundBatch;
import com.example.warehouse.model.InboundShipment;
import com.example.warehouse.model.Product;
import com.example.warehouse.model.ProductUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class InboundBatchServiceImpl implements InboundBatchService {
    @Autowired
    private InboundShipmentRepo inboundShipment;

    @Autowired
    private InboundBatchRepo inboundBatchRepo;

    @Autowired
    private InboundBatchMapper inboundBatchMapper;

    @Autowired
    private ProductUnitRepository productUnitRepository;

    @Transactional
    @Override
    public InboundBatchResponse createBatch(InboundBatchRequest request,String shipmentId) {
        InboundShipment shipment = inboundShipment.findById(shipmentId).orElseThrow(() -> new InboundShipmentNotFoundByIdException("Shipment details with thi id is not present in the DB"));
        Product product = shipment.getProduct();
        InboundBatch inboundBatch = inboundBatchMapper.toEntity(request,new InboundBatch());

        List<ProductUnit> productUnits = new ArrayList<ProductUnit>();
        for (int i=0;i< inboundBatch.getCountOfAcceptedUnit();i++){
            ProductUnit unit = new ProductUnit();
            unit.setInboundShipment(shipment);
            unit.setProduct(product);
            unit.setInboundBatch(inboundBatch);

            productUnits.add(unit);
        }
        productUnitRepository.saveAll(productUnits);
        inboundBatch.setProductUnit(productUnits);
        inboundBatchRepo.save(inboundBatch);
        return inboundBatchMapper.toResponse(inboundBatch);

    }
}
