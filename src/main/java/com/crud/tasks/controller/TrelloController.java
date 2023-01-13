package com.crud.tasks.controller;

import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.domain.TrelloListDto;
import com.crud.tasks.service.TrelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/trello")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class TrelloController {

    private final TrelloService trelloService;

    @GetMapping("getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {
        return List.of(new TrelloBoardDto("6194104d074dab0ef50427a1", "Kodilla Application", List.of(
                new TrelloListDto("6194104d074dab0ef50427a2", "Do zrobienia", false),
                new TrelloListDto("6194104d074dab0ef50427a3", "W trakcie", false),
                new TrelloListDto("6194104d074dab0ef50427a4", "Zrobione", false)) ));
    }

    @PostMapping("createTrelloCard")
    public CreatedTrelloCardDto createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloService.createTrelloCard(trelloCardDto);
    }
}