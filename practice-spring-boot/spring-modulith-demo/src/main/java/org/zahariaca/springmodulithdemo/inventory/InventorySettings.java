package org.zahariaca.springmodulithdemo.inventory;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("modulith.inventory")
public record InventorySettings(int stockThreshold) {

}
