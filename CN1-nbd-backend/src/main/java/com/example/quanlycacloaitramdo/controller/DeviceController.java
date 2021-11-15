package com.example.quanlycacloaitramdo.controller;

import com.example.quanlycacloaitramdo.entity.Device;
import com.example.quanlycacloaitramdo.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:8081/")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping("/devices")
    public ResponseEntity<List<Device>> getAllDevices(@RequestParam(name = "code", required = false) String code, @RequestParam(name = "names", required = false) String names, @RequestParam(name = "type", required = false) String type) {
        return deviceService.getDevices(code, names, type);
    }

    @PostMapping("/devices")
    public ResponseEntity<Device> createDevice(@RequestBody Device device) {
        return deviceService.addDevice(device);
    }

}
