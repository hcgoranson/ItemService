package one.goranson.itemservice;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import one.goranson.itemservice.dto.Item;

@RestController
@RequestMapping("/rest/item")
@RequiredArgsConstructor
public class ItemController {

  private final ItemService itemService;

  @GetMapping("")
  public ResponseEntity<List<Item>> getItems() {
    return ResponseEntity.ok(itemService.getAllItems());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Item> getItem(@PathVariable("id") Long id) {
    var item = itemService.getItem(id);
    if (item.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(item.get());
  }

  @PostMapping("")
  public ResponseEntity<Void> createItems(@RequestBody Item item) {
    itemService.createItem(item);
    return ResponseEntity.ok().build();
  }
}
