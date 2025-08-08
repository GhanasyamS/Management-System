package com.project.auditlogservicemodule.Service;

import com.project.auditlogservicemodule.Domain.AuditEvent;
import com.project.auditlogservicemodule.Domain.AuditEventDTO;
import com.project.auditlogservicemodule.Domain.Module;

import java.util.List;

public interface IAuditLogService
{
    AuditEvent saveAuditEvent(AuditEventDTO dto);
    List<AuditEvent> getEventByModule(Module module);
}
