package com.example.quanlycacloaitramdo.service;

import com.example.quanlycacloaitramdo.entity.Device;
import com.example.quanlycacloaitramdo.entity.DeviceValidator;
import com.example.quanlycacloaitramdo.repository.DeviceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private DeviceValidator validator;

    public ResponseEntity<List<Device>> getDevices(String code, String names, String type) {
        try {
            List<Device> devices = new ArrayList<Device>();

            if (code == null && names == null && type == null)
                deviceRepository.findAll().forEach(devices::add);
            else {
                switch (type) {
                    case "0":
                        type = "Thủ công";
                        deviceRepository.findByContain(code, names, type).forEach(devices::add);
                        break;
                    case "1":
                        type = "Tự động đo";
                        deviceRepository.findByContain(code, names, type).forEach(devices::add);
                        break;
                    default:
                        deviceRepository.findByContain(code, names, type).forEach(devices::add);
                }
            }
            if (devices.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(devices, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Device> addDevice(Device device) {
        try {
            Device _device;
            if (validator.isValid(device)) {
                _device = deviceRepository
                        .save(new Device(device.getTag(), device.getAction(), device.getStatus(), device.getCode(), device.getName(), device.getType()));
                return new ResponseEntity<>(_device, HttpStatus.CREATED);
            } else {
                return null;
            }

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
