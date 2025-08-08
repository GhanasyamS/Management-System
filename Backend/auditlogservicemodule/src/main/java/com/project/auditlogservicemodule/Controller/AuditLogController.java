package com.project.auditlogservicemodule.Controller;

import com.project.auditlogservicemodule.Domain.AuditEvent;
import com.project.auditlogservicemodule.Domain.AuditEventDTO;
import com.project.auditlogservicemodule.Service.IAuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.auditlogservicemodule.Domain.Module;

import java.util.List;

@RestController
@RequestMapping("/audit")
public class AuditLogController
{
    private final IAuditLogService auditLogService;

    @Autowired
    public AuditLogController(IAuditLogService auditLogService) {
        this.auditLogService = auditLogService;
    }

    @PostMapping("/log")
    public String logEvent(@RequestBody AuditEventDTO log)
    {
        auditLogService.saveAuditEvent(log);
        return "Event logged: " + log.getAction();

    }

    @GetMapping("/findbymodule/{moduleName}")
    public ResponseEntity<List<AuditEvent>> getEventsByModule(@PathVariable("moduleName") String moduleName)
    {

            Module module = Module.valueOf(moduleName.toUpperCase());
            List<AuditEvent> events = auditLogService.getEventByModule(module);
            return ResponseEntity.ok(events);



    }

}
