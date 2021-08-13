package com.zahariaca.learnreactivespring.controller.v1;

import com.zahariaca.learnreactivespring.document.ItemCapped;
import com.zahariaca.learnreactivespring.repository.ItemCappedReactiveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import static com.zahariaca.learnreactivespring.constants.ItemConstants.ITEM_STREAM_END_POINT_V1;

@RestController
@RequiredArgsConstructor
public class ItemStreamController {

    private final ItemCappedReactiveRepository itemCappedReactiveRepository;

    @GetMapping(value = ITEM_STREAM_END_POINT_V1, produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<ItemCapped> getItemsStream() {
        return itemCappedReactiveRepository.findItemsBy();
    }
}
