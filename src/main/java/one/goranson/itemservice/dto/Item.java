package one.goranson.itemservice.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Builder
@Getter
public class Item {
  private long id;
  private String name;
  private BigDecimal price;
}
