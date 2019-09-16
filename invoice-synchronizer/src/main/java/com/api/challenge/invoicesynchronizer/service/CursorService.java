package com.api.challenge.invoicesynchronizer.service;

import com.api.challenge.invoicesynchronizer.repository.CursorRepository;
import com.api.challenge.invoicesynchronizer.entity.CursorEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CursorService {

    private Long cursor;
    private CursorRepository cursorRepository;

    public CursorService(CursorRepository cursorRepository,
                         @Value("${arquivei.api.cursor}") Long cursor) {
        this.cursorRepository = cursorRepository;
        this.cursor = cursor;
    }

    public Long getCurrent() {
        return cursorRepository.findFirstByOrderByIdDesc()
                .orElseGet(() -> cursorRepository.save(new CursorEntity(cursor)))
                .getCursor();
    }

    public void updateCursor(Long cursor) {
        if(cursor > getCurrent()) {
            cursorRepository.save(new CursorEntity(cursor));
        }
    }
}
