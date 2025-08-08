package com.project.employeeservicemodule.Clients;

import com.project.employeeservicemodule.DTO.AuditEventDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "auditlogservicemodule")
public interface ReportTrackingClient
{

    @PostMapping("/audit/log")
    void sendAuditEvent(@RequestBody AuditEventDTO auditEventDTO);

}
