package com.project.auditlogservicemodule.Repository;

import com.project.auditlogservicemodule.Domain.AuditEvent;
import com.project.auditlogservicemodule.Domain.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AuditEventRepository extends JpaRepository<AuditEvent, UUID>
{
    List<AuditEvent> findByModule(Module module);
}
