package com.example.quanlycacloaitramdo.repository;

import com.example.quanlycacloaitramdo.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    @Query(value = "SELECT * FROM Device d WHERE (d.code like %:code% and d.names like %:names% and d.type like %:type%)", nativeQuery = true)
    List<Device> findByContain(String code, String names, String type);
}
