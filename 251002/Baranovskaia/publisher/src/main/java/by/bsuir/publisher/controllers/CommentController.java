package by.bsuir.publisher.controllers;

import by.bsuir.publisher.dto.requests.CommentRequestDto;
import by.bsuir.publisher.dto.responses.CommentResponseDto;
import by.bsuir.publisher.exceptions.EntityExistsException;
import by.bsuir.publisher.exceptions.Messages;
import by.bsuir.publisher.exceptions.NoEntityExistsException;
import by.bsuir.publisher.exceptions.ServiceException;
import by.bsuir.publisher.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentResponseDto> create(@RequestBody CommentRequestDto comment) throws EntityExistsException, ServiceException, NoEntityExistsException {
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.create(comment));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentResponseDto> read(@PathVariable("id") Long id) throws NoEntityExistsException {
        return ResponseEntity.status(HttpStatus.OK).body(commentService.read(id).orElseThrow(() ->
                new NoEntityExistsException(Messages.NoEntityExistsException)));
    }

    @GetMapping
    public ResponseEntity<List<CommentResponseDto>> read() {
        return ResponseEntity.status(HttpStatus.OK).body(commentService.readAll());
    }

    @PutMapping
    public ResponseEntity<CommentResponseDto> update(@RequestBody CommentRequestDto comment) throws NoEntityExistsException, ServiceException {
        return ResponseEntity.status(HttpStatus.OK).body(commentService.update(comment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) throws NoEntityExistsException, ServiceException {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(commentService.delete(id));
    }
}
