package one.goranson.itemservice;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import one.goranson.itemservice.dao.ItemGateway;
import one.goranson.itemservice.dto.Item;

@Service
@RequiredArgsConstructor
public class ItemService {

  private final ItemGateway itemGateway;

  public Optional<Item> getItem(long id) {
    return itemGateway.getItem(id);
  }

  public List<Item> getAllItems() {
    return itemGateway.getAllItems();
  }

  public void createItem(Item item) {
    itemGateway.createItem(item);
  }
}
