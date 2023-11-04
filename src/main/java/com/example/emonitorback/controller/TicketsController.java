package com.example.emonitorback.controller;

import com.example.emonitorback.domain.entities.Report;
import com.example.emonitorback.domain.entities.Ticket;
import com.example.emonitorback.dto.*;
import com.example.emonitorback.service.MessageService;
import com.example.emonitorback.service.ReportService;
import com.example.emonitorback.service.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.AlreadyBoundException;
import java.util.List;

@RequestMapping("/api/v1/tickets")
@RestController
@Tag(name = "Tickets Controller", description = "Endpoints para gerenciamento de tickets. " +
        "O usuário precisa estar autenticado para acessar.")
public class TicketsController {
    private final TicketService ticketService;
    private final MessageService messageService;
    private final ReportService reportService;

    public TicketsController(TicketService ticketService, MessageService messageService, ReportService reportService) {
        this.ticketService = ticketService;
        this.messageService = messageService;
        this.reportService = reportService;
    }

    @GetMapping("/get-tickets")
    @Operation(summary = "Retorna os tickets, faz a diferenciação de um monitor e um aluno," +
            " para o aluno retorna seus tickets e para o monitor retorna também os tickets em aberto.")
    public List<Ticket> getTickets() {
        return ticketService.findTickets();
    }

    @PostMapping("/insert-ticket")
    @Operation(summary = "Aluno abre um ticket.")
    public ResponseEntity<Long> insertTicket(@RequestBody TicketDto ticketDto) {
        return new ResponseEntity<>(ticketService.insertTicket(ticketDto), HttpStatus.CREATED);
    }

    @PatchMapping("/rename-ticket")
    @Operation(summary = "Aluno renomeia um ticket.")
    public ResponseEntity<Long> renameTicket(@RequestBody EditTicketDto editTicketDto){
        return new ResponseEntity<>(ticketService.editTicket(editTicketDto), HttpStatus.OK);
    }

    @PostMapping("/claim-ticket")
    @Operation(summary = "Monitor pega um ticket para si.")
    public ResponseEntity<Long> claimTicket(@RequestParam Long ticketId) throws AlreadyBoundException {
        return new ResponseEntity<>(ticketService.claimTicket(ticketId), HttpStatus.CREATED);
    }

    @PostMapping("/close-ticket")
    @Operation(summary = "Monitor fecha um ticket.")
    public ResponseEntity<Long> closeTicket(@RequestParam Long ticketId) {
        return new ResponseEntity<>(ticketService.closeTicket(ticketId), HttpStatus.OK);
    }

    @PostMapping("/pass-ticket")
    @Operation(summary = "Monitor passa um ticket, na prática ele perde o assign e o ticket volta a ficar aberto.")
    public ResponseEntity<Long> passTicket(@RequestParam Long ticketId) {
        return new ResponseEntity<>(ticketService.passTicket(ticketId), HttpStatus.OK);
    }

    @PostMapping("/report-ticket")
    @Operation(summary = "Usuário denuncia um ticket, o ticket é fechado.")
    public ResponseEntity<Long> reportTicket(@RequestBody ReportDto reportDto) {
        return new ResponseEntity<>(reportService.reportTicket(reportDto), HttpStatus.OK);
    }

    @GetMapping("/get-messages")
    @Operation(summary = "Retorna todas as mensagens de um determinado ticket.")
    public List<GetMessageDto> getMessages(@RequestParam Long ticketId) {
        return messageService.getTicketMessages(ticketId);
    }

    @PostMapping("/insert-message")
    @Operation(summary = "Envia uma mensagem no chat de um ticket.")
    public ResponseEntity<Long> insertMessage(@RequestBody MessageDto messageDto) {
        return new ResponseEntity<>(messageService.insertMessage(messageDto), HttpStatus.CREATED);
    }
}
