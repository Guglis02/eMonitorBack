package com.example.emonitorback.domain.repo;

import com.example.emonitorback.domain.entities.Attachment;
import com.example.emonitorback.domain.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AttachmentRepo extends JpaRepository<Attachment, Long>
{
    @Query("FROM Attachment a WHERE a.messageId = :messageId")
    List<Attachment> findByMessageId(@Param("messageId") Long messageId);
}
