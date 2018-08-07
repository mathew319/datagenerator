package sk.mh.shopping.datagenerator;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShoppingCartEvent {
    private String id;
    private String storeId;
    private String customerId;
    private String sensorId;
    private String sensorMetadata;
    private long timestamp;

    @Override
    public String toString() {
        return String.join(",", id, storeId, customerId, sensorId, sensorMetadata, Long.toString(timestamp));
    }
}
