package one.goranson.itemservice.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import one.goranson.itemservice.dto.Item;

@Service
@RequiredArgsConstructor
public class ItemGateway {

  private final ItemRepository itemRepository;

  public Optional<Item> getItem(long id) {
    return itemRepository.findById(id).map(this::toItem);
  }

  public List<Item> getAllItems() {
    return StreamSupport.stream(itemRepository.findAll().spliterator(), false)
        .map(this::toItem).toList();
  }

  public void createItem(Item item) {
    itemRepository.save(toEntity(item));
  }

  private ItemEntity toEntity(Item item) {
    return ItemEntity.builder()
        .id(item.getId())
        .name(item.getName())
        .price(item.getPrice())
        .build();
  }

  private Item toItem(ItemEntity itemEntity) {
    return Item.builder()
        .id(itemEntity.getId())
        .name(itemEntity.getName())
        .price(itemEntity.getPrice())
        .build();
  }
}
