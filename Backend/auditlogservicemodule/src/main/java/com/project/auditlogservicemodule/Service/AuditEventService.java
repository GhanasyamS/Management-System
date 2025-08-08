package com.project.auditlogservicemodule.Service;

import com.project.auditlogservicemodule.Domain.Module;
import com.project.auditlogservicemodule.Domain.Action;
import com.project.auditlogservicemodule.Domain.AuditEvent;
import com.project.auditlogservicemodule.Domain.AuditEventDTO;
import com.project.auditlogservicemodule.Repository.AuditEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuditEventService implements IAuditLogService
{

    private final AuditEventRepository repository;

    public AuditEventService(AuditEventRepository repository) {
        this.repository = repository;
    }

    public AuditEvent saveAuditEvent(AuditEventDTO dto)
    {
        AuditEvent event = new AuditEvent();
        event.setId(dto.getId() != null ? dto.getId() : UUID.randomUUID());
        event.setModule(Module.valueOf(dto.getModule().toUpperCase()));
        event.setAction(Action.valueOf(dto.getAction().toUpperCase()));
        event.setUserId(dto.getUserId());
        event.setUserName(dto.getUserName());
        event.setModifiedAt(dto.getModifiedAt());
        event.setChangedFieldsJson(dto.getChangedFieldsJson());

        return repository.save(event);
    }

    public List<AuditEvent> getEventByModule(Module module)
    {
        return repository.findByModule(module);

    }
}
