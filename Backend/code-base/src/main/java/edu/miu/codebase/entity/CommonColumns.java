package edu.miu.codebase.entity;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class CommonColumns {
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
